/*
 * MC6809 Toolkit
 * Copyright (C) 2023  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.electronics.mc6809.binaries.srecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Write of SREC file.
 * 
 * @author Patrick BRIAND
 *
 */
public class SRECWriter extends AbstractFileManager {

	/** reference on the writer */
	private BufferedWriter writer;

	/**
	 * Create a SREC file.
	 * 
	 * @param absolutePath Path of the file
	 * @throws IOException In case on file error
	 */
	public void createSRECFile(String absolutePath) throws IOException {
		writer  = new BufferedWriter(new FileWriter(new File(absolutePath)));
	}

	/**
	 * Create a SREC file.
	 * 
	 * @param stringWriter reference on a String Writer object
	 * @throws IOException In case on file error
	 */
	public void createSRECFile(Writer writer) throws IOException {
		this.writer = new BufferedWriter(writer);
	}

	/**
	 * Export a SREC data definition in a SREC file.
	 * 
	 * @param srecData reference on SREC data to export
	 * @throws IOException In case on file error
	 */
	public void exportSRECData(SRECData srecData) throws IOException {
		if (srecData.getToolName() != null) {
			setToolDescription(srecData.getToolName());
		}
		
		for (SRECBlocOfCodeDescriptor blockData : srecData.getBlocDescriptors()) {
			exportBlocOfData(blockData);
		}
		
		setStartingAddress(srecData.getStartingAddress(), srecData.getAddressType());
	}
	
	/**
	 *	Export a block of data. 
	 * 
	 * @param blockData reference on the bloc of data
	 * @throws IOException In case on file error
	 */
	private void exportBlocOfData(SRECBlocOfCodeDescriptor blockData) throws IOException {
		switch (blockData.getAddressType()) {
		case ADDRESS_16BITS:
			export16BitsStartingAddressData(blockData);
			break;
		case ADDRESS_24BITS:
			export24BitsStartingAddressData(blockData);
			break;
		case ADDRESS_32BITS:
			export32BitsStartingAddressData(blockData);
			break;
		}
	}

	/**
	 * Export a block of data with a 16 bits address.
	 * 
	 * @param blockData reference on the bloc of data
	 * @throws IOException In case on file error
	 */
	private void export16BitsStartingAddressData(SRECBlocOfCodeDescriptor blockData) throws IOException {
		int dataPointer = 0;
		int maxDataInLine = 32;
		
		
		while (dataPointer < blockData.getData().length) {
			List<Byte> bytesToExport = extractBytes(blockData.getData(), dataPointer, maxDataInLine);
			
			StringBuilder strBuilder = new StringBuilder("S1");
			int numberOfBytesInLine = bytesToExport.size()+2+1;
			
			String address = String.format("%04X", blockData.getStartAddress()+dataPointer);
			strBuilder.append(String.format("%02X",numberOfBytesInLine));
			strBuilder.append(address);
			for (Byte byteToExport : bytesToExport) {
				strBuilder.append(String.format("%02X",byteToExport));
			}
			
			byte checkSum = computeChecksum(numberOfBytesInLine, address, bytesToExport);
			strBuilder.append(String.format("%02X",checkSum&0xFF));
			writer.write(strBuilder.toString() + "\n");
			
			dataPointer += bytesToExport.size();
		}
	}

	/**
	 * Export a block of data with a 24 bits address.
	 * 
	 * @param blockData reference on the bloc of data
	 * @throws IOException In case on file error
	 */
	private void export24BitsStartingAddressData(SRECBlocOfCodeDescriptor blockData) throws IOException {
		int dataPointer = 0;
		int maxDataInLine = 32;
		
		
		while (dataPointer < blockData.getData().length) {
			List<Byte> bytesToExport = extractBytes(blockData.getData(), dataPointer, maxDataInLine);
			
			StringBuilder strBuilder = new StringBuilder("S2");
			int numberOfBytesInLine = bytesToExport.size()+2+1;
			
			String address = String.format("%06X", blockData.getStartAddress()+dataPointer);
			strBuilder.append(String.format("%02X",numberOfBytesInLine));
			strBuilder.append(address);
			for (Byte byteToExport : bytesToExport) {
				strBuilder.append(String.format("%02X",byteToExport));
			}
			
			byte checkSum = computeChecksum(numberOfBytesInLine, address, bytesToExport);
			strBuilder.append(String.format("%02X",checkSum&0xFF));
			writer.write(strBuilder.toString() + "\n");
			
			dataPointer += bytesToExport.size();
		}
	}

	/**
	 * Export a block of data with a 32 bits address.
	 * 
	 * @param blockData reference on the bloc of data
	 * @throws IOException In case on file error
	 */
	private void export32BitsStartingAddressData(SRECBlocOfCodeDescriptor blockData) throws IOException {
		int dataPointer = 0;
		int maxDataInLine = 32;
		
		
		while (dataPointer < blockData.getData().length) {
			List<Byte> bytesToExport = extractBytes(blockData.getData(), dataPointer, maxDataInLine);
			
			StringBuilder strBuilder = new StringBuilder("S3");
			int numberOfBytesInLine = bytesToExport.size()+2+1;
			
			String address = String.format("%08X", blockData.getStartAddress()+dataPointer);
			strBuilder.append(String.format("%02X",numberOfBytesInLine));
			strBuilder.append(address);
			for (Byte byteToExport : bytesToExport) {
				strBuilder.append(String.format("%02X",byteToExport));
			}
			
			byte checkSum = computeChecksum(numberOfBytesInLine, address, bytesToExport);
			strBuilder.append(String.format("%02X",checkSum&0xFF));
			writer.write(strBuilder.toString() + "\n");
			
			dataPointer += bytesToExport.size();
		}
	}

	/**
	 * Add starting address in the file
	 * 
	 * @param startingAddress Starting address value
	 * @param addressType Size of the address
	 * @throws IOException in case of error
	 */
	private void setStartingAddress(int startingAddress, SRECAddressType addressType) throws IOException {
		switch (addressType) {
		case ADDRESS_16BITS:
			add16BitsStartingAddress(startingAddress);
			break;
		case ADDRESS_24BITS:
			add24BitsStartingAddress(startingAddress);
			break;
		case ADDRESS_32BITS:
			add32BitsStartingAddress(startingAddress);
			break;
		}
	}

	/**
	 * Add 16 bits starting address in the file
	 * 
	 * @param startingAddress Starting address value
	 * @throws IOException in case of error
	 */
	private void add16BitsStartingAddress(int startingAddress) throws IOException {
		StringBuilder strBuilder = new StringBuilder("S903");
		String addressStr = String.format("%04X", startingAddress);
		strBuilder.append(addressStr);
		
		byte checksum = computeChecksum(3, addressStr, "".getBytes() );
		
		strBuilder.append(String.format("%02X", checksum));
		strBuilder.append("\n");
		writer.write(strBuilder.toString());
	}

	/**
	 * Add 24 bits starting address in the file
	 * 
	 * @param startingAddress Starting address value
	 * @throws IOException in case of error
	 */
	private void add24BitsStartingAddress(int startingAddress) throws IOException {
		StringBuilder strBuilder = new StringBuilder("S804");
		String addressStr = String.format("%06X", startingAddress);
		strBuilder.append(addressStr);
		
		byte checksum = computeChecksum(4, addressStr, "".getBytes() );
		
		strBuilder.append(String.format("%02X", checksum));
		strBuilder.append("\n");
		writer.write(strBuilder.toString());
	}

	/**
	 * Add 32 bits starting address in the file
	 * 
	 * @param startingAddress Starting address value
	 * @throws IOException in case of error
	 */
	private void add32BitsStartingAddress(int startingAddress) throws IOException {
		StringBuilder strBuilder = new StringBuilder("S705");
		String addressStr = String.format("%08X", startingAddress);
		strBuilder.append(addressStr);
		
		byte checksum = computeChecksum(5, addressStr, "".getBytes() );
		
		strBuilder.append(String.format("%02X", checksum));
		strBuilder.append("\n");
		writer.write(strBuilder.toString());
	}

	/**
	 * Set tool description (record S0).
	 * 
	 * @param toolDescription String which define a tool description
	 * @throws IOException  In case on file error
	 */
	private void setToolDescription(String toolDescription) throws IOException {
		StringBuilder strBuilder = new StringBuilder("S0");

		// add length 
		int nbBytes = toolDescription.length() + 3; // 2 for address + 1 for count
 		strBuilder.append(String.format("%02X", nbBytes));

		// add address
		strBuilder.append("0000");

		// add data
		for (byte character : toolDescription.getBytes()) {
			strBuilder.append(String.format("%02X", character&0xFF));
		}
		
		// add checksum
		byte checksum = computeChecksum(nbBytes, "0000", toolDescription.getBytes() );
		
		strBuilder.append(String.format("%02X", checksum));
		strBuilder.append("\n");
		writer.write(strBuilder.toString());
	}
	
	/**
	 * Close the writer.
	 * 
	 * @throws IOException in case of error
	 */
	public void closeWriter() throws IOException {
		writer.flush();
		writer.close();
	}

	/**
	 * Get a list of n bytes extraction at a pointed address.
	 * 
	 * @param data buffer of data
	 * @param dataPointer Pointer on the first element to extract
	 * @param maxDataInLine maximum number of byte to extract
	 * @return List which contains the extract bytes
	 */
	private List<Byte> extractBytes(byte[] data, int dataPointer, int maxDataInLine) {
		List<Byte> bytes = new ArrayList<>();
		for (int i=0; i<maxDataInLine; i++) {
			if ((dataPointer+i) < data.length) {
				bytes.add(data[dataPointer+i]);
			} else {
				break;
			}
		}
		return bytes;
	}
}
