package org.bpy.electronics.mc6809.binaries.srec;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SRECWriter {

	private BufferedWriter writer;

	public SRECWriter() {
	}
	
	public void createSRECFile(String absolutePath) throws IOException {
		writer  = new BufferedWriter(new FileWriter(new File(absolutePath)));
	}
	
	public void closeWriter() throws IOException {
		writer.flush();
		writer.close();
	}
	
	public void writeData(int address, int[] data) {
		
	}
}
