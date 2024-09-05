package org.bpy.electronics.mc6809.binaries.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import org.bpy.electronics.mc6809.binaries.exceptions.BadSRECFileFormat;
import org.bpy.electronics.mc6809.binaries.srecord.SRECAddressType;
import org.bpy.electronics.mc6809.binaries.srecord.SRECBlocOfCodeDescriptor;
import org.bpy.electronics.mc6809.binaries.srecord.SRECData;
import org.bpy.electronics.mc6809.binaries.srecord.SRECReader;
import org.junit.Assert;
import org.junit.Test;

public class TestSRECReader {

	@Test
	public void checkFileReader01() {
		String test = "S021000036384B50524F47202020313143524541544544204259204541535936384B6D";
		
		
		SRECReader srecReader = new SRECReader();
		StringReader reader = new StringReader(test);
		try {
			SRECData data = srecReader.readFile(reader);
			System.out.println(data.getToolName());
		} catch (IOException | BadSRECFileFormat e) {
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@Test
	public void checkFileReader02() {
		String test = "S1251000123C00035A01303C000E43F9000444464E4F303C00034E4F4EB9000222224E72200004";
		
		SRECReader srecReader = new SRECReader();
		StringReader reader = new StringReader(test);
		try {
			SRECData data = srecReader.readFile(reader);
		} catch (IOException | BadSRECFileFormat e) {
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void checkCompleteFile01() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("S01100004D433638303920746F6F6C6B697461\n");
		strBuilder.append("S1230000ED012A05CC0000A3016F84108EFC1831A903E883271024F7C3271031A89C31A8C8\n");
		strBuilder.append("S1230020648303E824F8C303E83136312A83006424F9C30064313F312183000A24EDC30010\n");
		strBuilder.append("S12300400AE7E26C841F201083000026BEA680E6842A06C62DE7806C1EE6E0CB30E7804A0D\n");
		strBuilder.append("S121006026F739CC00008E007EBD0000CC7FFF8E007EBD0000CC7FFF8E007EBD00006D\n");
		strBuilder.append("S9030000FC");
		
		SRECReader srecReader = new SRECReader();
		StringReader reader = new StringReader(strBuilder.toString());
		
		try {
			SRECData data = srecReader.readFile(reader);
			Assert.assertEquals("Check tool name","MC6809 toolkit", data.getToolName());
			Assert.assertEquals("Check address type", SRECAddressType.ADDRESS_16BITS, data.getAddressType());
			Assert.assertEquals("Check starting address", 0, data.getStartingAddress());
			
			Assert.assertEquals("Check bloc number", 1, data.getBlocDescriptors().size());
			SRECBlocOfCodeDescriptor bloc = data.getBlocDescriptors().get(0);
			Assert.assertEquals("Check bloc address type", SRECAddressType.ADDRESS_16BITS, bloc.getAddressType());
			Assert.assertEquals("Bloc size", 126, bloc.getData().length);
			Assert.assertEquals("Bloc value", 0xED, bloc.getData()[0]&0xFF);
			Assert.assertEquals("Bloc value", 0xA8, bloc.getData()[31]&0xFF);
			Assert.assertEquals("Bloc value", 0x64, bloc.getData()[32]&0xFF);
			Assert.assertEquals("Bloc value", 0x00, bloc.getData()[63]&0xFF);
			Assert.assertEquals("Bloc value", 0x0A, bloc.getData()[64]&0xFF);
			Assert.assertEquals("Bloc value", 0x4A, bloc.getData()[95]&0xFF);
			Assert.assertEquals("Bloc value", 0x26, bloc.getData()[96]&0xFF);
			Assert.assertEquals("Bloc value", 0x00, bloc.getData()[125]&0xFF);
			
		} catch (IOException | BadSRECFileFormat e) {
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void checkCompleteFile02() {
		InputStream file = this.getClass().getResourceAsStream("./resources/example01.s19");
		BufferedReader reader = new BufferedReader(new InputStreamReader(file));
		
		SRECReader srecReader = new SRECReader();
		try {
			SRECData data = srecReader.readFile(reader);

			Assert.assertEquals("Check tool name","68KPROG   11CREATED BY EASY68K", data.getToolName());
			Assert.assertEquals("Check address type", SRECAddressType.ADDRESS_24BITS, data.getAddressType());
			Assert.assertEquals("Check starting address", 0x1000, data.getStartingAddress());

			Assert.assertEquals("Check bloc number", 4, data.getBlocDescriptors().size());
		
			SRECBlocOfCodeDescriptor bloc0 = data.getBlocDescriptors().get(0);
			Assert.assertEquals("Check address type bloc 0", SRECAddressType.ADDRESS_16BITS, bloc0.getAddressType());
			Assert.assertEquals("Check address bloc 0", 0x1000, bloc0.getStartAddress());
			Assert.assertEquals("Check data bloc 0", 0x12, bloc0.getData()[0]&0xFF);
			Assert.assertEquals("Check data bloc 0", 0x00, bloc0.getData()[bloc0.getData().length-1]&0xFF);
			
			SRECBlocOfCodeDescriptor bloc1 = data.getBlocDescriptors().get(1);
			Assert.assertEquals("Check address type bloc 1", SRECAddressType.ADDRESS_24BITS, bloc1.getAddressType());
			Assert.assertEquals("Check address bloc 1", 0x022222, bloc1.getStartAddress());
			Assert.assertEquals("Check data bloc 1", 0x48, bloc1.getData()[0]&0xFF);
			Assert.assertEquals("Check data bloc 1", 0x75, bloc1.getData()[bloc1.getData().length-1]&0xFF);
			
			SRECBlocOfCodeDescriptor bloc2 = data.getBlocDescriptors().get(2);
			Assert.assertEquals("Check address type bloc 2", SRECAddressType.ADDRESS_24BITS, bloc2.getAddressType());
			Assert.assertEquals("Check address bloc 2", 0x044446, bloc2.getStartAddress());
			Assert.assertEquals("Check data bloc 2", 0x44, bloc2.getData()[0]&0xFF);
			Assert.assertEquals("Check data bloc 2", 0x00, bloc2.getData()[bloc2.getData().length-1]&0xFF);
			
			
			SRECBlocOfCodeDescriptor bloc3 = data.getBlocDescriptors().get(3);
			Assert.assertEquals("Check address type bloc 3", SRECAddressType.ADDRESS_32BITS, bloc3.getAddressType());
			Assert.assertEquals("Check address bloc 3", 0x12345678, bloc3.getStartAddress());
			Assert.assertEquals("Check data bloc 3", 0x69, bloc3.getData()[0]&0xFF);
			Assert.assertEquals("Check data bloc 3", 0x73, bloc3.getData()[bloc3.getData().length-1]&0xFF);
		} catch (IOException|BadSRECFileFormat e) {
			Assert.assertTrue(e.getMessage(), false);
		}
	}
}
