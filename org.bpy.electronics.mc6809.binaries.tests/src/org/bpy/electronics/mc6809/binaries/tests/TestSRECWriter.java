package org.bpy.electronics.mc6809.binaries.tests;

import java.io.IOException;
import java.io.StringWriter;

import org.bpy.electronics.mc6809.binaries.srecord.SRECAddressType;
import org.bpy.electronics.mc6809.binaries.srecord.SRECData;
import org.bpy.electronics.mc6809.binaries.srecord.SRECWriter;
import org.junit.Assert;
import org.junit.Test;

public class TestSRECWriter {

	@Test
	public void testHeader01() {
		StringWriter stringWriter = new StringWriter();
		SRECData data = new SRECData();
		data.setToolName("68KPROG   11CREATED BY EASY68K");
		data.setStartingAddress(0x1234, SRECAddressType.ADDRESS_16BITS);
		
		try {
			SRECWriter srecWriter = new SRECWriter();
			srecWriter.createSRECFile(stringWriter);
			srecWriter.exportSRECData(data);
			srecWriter.closeWriter();
			
			String[] strings = stringWriter.getBuffer().toString().split("\n");
			Assert.assertEquals("Only two line", 2, strings.length);
			Assert.assertEquals("Check first line", 
					"S021000036384B50524F47202020313143524541544544204259204541535936384B6D",
					strings[0]);
			
		} catch (IOException e) {
			Assert.assertTrue("Exception detected", false);
		}
	}

	@Test
	public void testTerminationRecord01() {
		StringWriter stringWriter = new StringWriter();
		SRECData data = new SRECData();
		data.setToolName("68KPROG   11CREATED BY EASY68K");
		data.setStartingAddress(0x1000, SRECAddressType.ADDRESS_24BITS);
		
		try {
			SRECWriter srecWriter = new SRECWriter();
			srecWriter.createSRECFile(stringWriter);
			srecWriter.exportSRECData(data);
			srecWriter.closeWriter();
			
			String[] strings = stringWriter.getBuffer().toString().split("\n");
			Assert.assertEquals("Only two line", 2, strings.length);
			Assert.assertEquals("Check second line", 
					"S804001000EB",
					strings[1]);
			
		} catch (IOException e) {
			Assert.assertTrue("Exception detected", false);
		}
	}

	@Test
	public void testTerminationRecord02() {
		StringWriter stringWriter = new StringWriter();
		SRECData data = new SRECData();
		data.setToolName("68KPROG   11CREATED BY EASY68K");
		data.setStartingAddress(0x1000, SRECAddressType.ADDRESS_16BITS);
		
		try {
			SRECWriter srecWriter = new SRECWriter();
			srecWriter.createSRECFile(stringWriter);
			srecWriter.exportSRECData(data);
			srecWriter.closeWriter();
			
			String[] strings = stringWriter.getBuffer().toString().split("\n");
			Assert.assertEquals("Only two line", 2, strings.length);
			Assert.assertEquals("Check second line", 
					"S9031000EC",
					strings[1]);
			
		} catch (IOException e) {
			Assert.assertTrue("Exception detected", false);
		}
	}

	@Test
	public void testTerminationRecord03() {
		StringWriter stringWriter = new StringWriter();
		SRECData data = new SRECData();
		data.setToolName("68KPROG   11CREATED BY EASY68K");
		data.setStartingAddress(0x1000, SRECAddressType.ADDRESS_32BITS);
		
		try {
			SRECWriter srecWriter = new SRECWriter();
			srecWriter.createSRECFile(stringWriter);
			srecWriter.exportSRECData(data);
			srecWriter.closeWriter();
			
			String[] strings = stringWriter.getBuffer().toString().split("\n");
			Assert.assertEquals("Only two line", 2, strings.length);
			Assert.assertEquals("Check second line", 
					"S70500001000EA",
					strings[1]);
			
		} catch (IOException e) {
			Assert.assertTrue("Exception detected", false);
		}
	}
	
	@Test
	public void testWriteFile01() {
		byte[] data = new byte[] {
				(byte)0xED,(byte)0x01,(byte)0x2A,(byte)0x05,(byte)0xCC,(byte)0x00,(byte)0x00,
				(byte)0xA3,(byte)0x01,(byte)0x6F,(byte)0x84,(byte)0x10,(byte)0x8E,(byte)0xFC,
				(byte)0x18,(byte)0x31,(byte)0xA9,(byte)0x03,(byte)0xE8,(byte)0x83,(byte)0x27,
				(byte)0x10,(byte)0x24,(byte)0xF7,(byte)0xC3,(byte)0x27,(byte)0x10,(byte)0x31,
				(byte)0xA8,(byte)0x9C,(byte)0x31,(byte)0xA8,
				
				(byte)0x64,(byte)0x83,(byte)0x03,(byte)0xE8,(byte)0x24,(byte)0xF8,(byte)0xC3,
				(byte)0x03,(byte)0xE8,(byte)0x31,(byte)0x36,(byte)0x31,(byte)0x2A,(byte)0x83,
				(byte)0x00,(byte)0x64,(byte)0x24,(byte)0xF9,(byte)0xC3,(byte)0x00,(byte)0x64,
				(byte)0x31,(byte)0x3F,(byte)0x31,(byte)0x21,(byte)0x83,(byte)0x00,(byte)0x0A,
				(byte)0x24,(byte)0xED,(byte)0xC3,(byte)0x00,
				
				(byte)0x0A,(byte)0xE7,(byte)0xE2,(byte)0x6C,(byte)0x84,(byte)0x1F,(byte)0x20,
				(byte)0x10,(byte)0x83,(byte)0x00,(byte)0x00,(byte)0x26,(byte)0xBE,(byte)0xA6,
				(byte)0x80,(byte)0xE6,(byte)0x84,(byte)0x2A,(byte)0x06,(byte)0xC6,(byte)0x2D,
				(byte)0xE7,(byte)0x80,(byte)0x6C,(byte)0x1E,(byte)0xE6,(byte)0xE0,(byte)0xCB,
				(byte)0x30,(byte)0xE7,(byte)0x80,(byte)0x4A,
				
				(byte)0x26,(byte)0xF7,(byte)0x39,(byte)0xCC,(byte)0x00,(byte)0x00,(byte)0x8E,
				(byte)0x00,(byte)0x7E,(byte)0xBD,(byte)0x00,(byte)0x00,(byte)0xCC,(byte)0x7F,
				(byte)0xFF,(byte)0x8E,(byte)0x00,(byte)0x7E,(byte)0xBD,(byte)0x00,(byte)0x00,
				(byte)0xCC,(byte)0x7F,(byte)0xFF,(byte)0x8E,(byte)0x00,(byte)0x7E,(byte)0xBD,
				(byte)0x00,(byte)0x00
		};
		
		SRECData srecData = new SRECData();
		srecData.setToolName("MC6809 toolkit");
		srecData.setStartingAddress(0, SRECAddressType.ADDRESS_16BITS);
		srecData.setData(0x0000, data, SRECAddressType.ADDRESS_16BITS);
		
		try {
			StringWriter stringWriter = new StringWriter();
			SRECWriter srecWriter = new SRECWriter();
			srecWriter.createSRECFile(stringWriter);
			srecWriter.exportSRECData(srecData);
			srecWriter.closeWriter();
			
			String[] strings = stringWriter.getBuffer().toString().split("\n");
			Assert.assertEquals("Coontains 6 line", 6, strings.length);
			Assert.assertEquals("Line 0", "S01100004D433638303920746F6F6C6B697461" , strings[0]); 
			Assert.assertEquals("Line 1", "S1230000ED012A05CC0000A3016F84108EFC1831A903E883271024F7C3271031A89C31A8C8" , strings[1]); 
			Assert.assertEquals("Line 2", "S1230020648303E824F8C303E83136312A83006424F9C30064313F312183000A24EDC30010" , strings[2]); 
			Assert.assertEquals("Line 3", "S12300400AE7E26C841F201083000026BEA680E6842A06C62DE7806C1EE6E0CB30E7804A0D" , strings[3]); 
			Assert.assertEquals("Line 4", "S121006026F739CC00008E007EBD0000CC7FFF8E007EBD0000CC7FFF8E007EBD00006D" , strings[4]); 
			Assert.assertEquals("Line 5", "S9030000FC" , strings[5]); 
			
		} catch (IOException e) {
			Assert.assertTrue("Exception detected", false);
		}
	}
}
