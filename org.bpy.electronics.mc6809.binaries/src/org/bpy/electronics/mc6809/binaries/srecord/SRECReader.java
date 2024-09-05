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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.bpy.electronics.mc6809.binaries.exceptions.BadSRECFileFormat;

/**
 * Class for read a SREC file.
 * 
 * @author Patrick BRIAND
 *
 */
public class SRECReader extends AbstractFileManager {

	/**
	 * Read a file defined by its full path name.
	 * 
	 * @param fullPathName full path name of the file
	 * 
	 * @return Data representation of the file
	 * 
	 * @throws IOException In case of file error
	 * @throws BadSRECFileFormat in case of error on SREC format
	 */
	public SRECData readFile(String fullPathName) throws IOException, BadSRECFileFormat {
		FileReader fileReader = new FileReader(new File(fullPathName));
		return readFile(fileReader);
	}

	/**
	 * Read a file defined by a String reader.
	 * 
	 * @param stringReader reference on the String reader
	 * 
	 * @return Data representation of the file
	 * 
	 * @throws IOException In case of file error
	 * @throws BadSRECFileFormat in case of error on SREC format
	 */
	public SRECData readFile(Reader stringReader) throws IOException, BadSRECFileFormat {

		BufferedReader reader = new BufferedReader(stringReader);
		SRECData srecData = new SRECData();
		
		String line = reader.readLine();
		while (line != null) {
			parseLine(line, srecData);
			line = reader.readLine();
		}
		
		reader.close();
		return srecData;
	}

	/**
	 * Parse a line in the SREC file.
	 * 
	 * @param line reference on the line
	 * @param srecData reference on the SRECData object
	 * 
	 * @throws BadSRECFileFormat in case of error on SREC format
	 */
	private void parseLine(String line, SRECData srecData) throws BadSRECFileFormat {
		if (line.length()<10) {
			throw new BadSRECFileFormat("bad line size " + line.length() + " for line " + line);
		} else {
			String[] consumedValues = consumBytes(line, 2);
			switch(consumedValues[0]) {
			case "S0":
				parseSRECheader(consumedValues[1], srecData);
				break;
			case "S1" : 
				dataFieldFrom16bitsAddress(consumedValues[1], srecData);
				break;
			case "S2" : 
				dataFieldFrom24bitsAddress(consumedValues[1], srecData);
				break;
			case "S3" :
				dataFieldFrom32bitsAddress(consumedValues[1], srecData);
				break;
			case "S5" :
				twoBytesAddressStart(line, srecData);
				break;
			case "S7" :
				address32BitsStartAddress(line, srecData);
				break;
			case "S8" :
				address24BitsStartAddress(line, srecData);
				break;
			case "S9" :
				address16BitsStartAddress(line, srecData);
				break;
			default:
				throw new BadSRECFileFormat("Unexpected line of type " + consumedValues[0]);
			}
			
		}
	}

	/**
	 * Parse the line of type S0 (informative line).
	 * 
	 * @param line reference on the line
	 * @param srecData reference on the SRECData object
	 * 
	 * @throws BadSRECFileFormat in case of error on SREC format
	 */
	private void parseSRECheader(String line, SRECData srecData) throws BadSRECFileFormat {
		String[] consumedValues = consumBytes(line, 2); 
		line = consumedValues[1];
		int nbBytes = Integer.parseInt(consumedValues[0],16);

		String[] removedAddress = consumBytes(line, 4);
		line = removedAddress[1];
		
		String[] consumedData = consumBytes(line, nbBytes*2-6); // -6 = 4 bytes for address and 2 bytes for checksum
		String strData = consumedData[0];
		byte[] data = convertedData(strData);
		line = consumedData[1];
		
		String[] checkSumData = consumBytes(line, 2);
		String checkSum = checkSumData[0];
		if (verifyChecksum(Byte.parseByte(checkSum,16), nbBytes, "0000", data)) {
			StringBuilder toolName = new StringBuilder();
			for (int dataByte : data) {
				toolName.append((char)dataByte);
			}
			srecData.setToolName(toolName.toString());
			
		} else {
			throw new BadSRECFileFormat("Check sum error in file");
		}
	}

	/**
	 * parse data line with a 16 bits address (Code S1). 
	 * 
	 * @param line Line to parse
	 * @param srecData Reference on the data container
	 * @throws BadSRECFileFormat In case of error
	 */
	private void dataFieldFrom16bitsAddress(String line, SRECData srecData) throws BadSRECFileFormat {
		String[] consumedValues = consumBytes(line, 2); 
		line = consumedValues[1];
		int nbBytes = Integer.parseInt(consumedValues[0],16);

		String[] removedAddress = consumBytes(line, 4);
		line = removedAddress[1];

		String[] consumedData = consumBytes(line, nbBytes*2-6); // -6 = 4 bytes for address and 2 bytes for checksum
		String strData = consumedData[0];
		byte[] data = convertedData(strData);
		line = consumedData[1];
		
		String[] checkSumData = consumBytes(line, 2);
		String checkSum = checkSumData[0];
		if (verifyChecksum((byte)(Integer.parseInt(checkSum,16)&0xFF), nbBytes, removedAddress[0], data)) {
			
			srecData.addData(data, Integer.parseInt(removedAddress[0],16), SRECAddressType.ADDRESS_16BITS);
			
		} else {
			throw new BadSRECFileFormat("Check sum error in line: " + line);
		}
	}

	/**
	 * parse data line with a 24 bits address (Code S2). 
	 * 
	 * @param line Line to parse
	 * @param srecData Reference on the data container
	 * @throws BadSRECFileFormat In case of error
	 */
	private void dataFieldFrom24bitsAddress(String line, SRECData srecData) throws BadSRECFileFormat {
		String[] consumedValues = consumBytes(line, 2); 
		line = consumedValues[1];
		int nbBytes = Integer.parseInt(consumedValues[0],16);

		String[] removedAddress = consumBytes(line, 6);
		line = removedAddress[1];

		String[] consumedData = consumBytes(line, nbBytes*2-8); // -6 = 4 bytes for address and 2 bytes for checksum
		String strData = consumedData[0];
		byte[] data = convertedData(strData);
		line = consumedData[1];
		
		String[] checkSumData = consumBytes(line, 2);
		String checkSum = checkSumData[0];
		if (verifyChecksum((byte)(Integer.parseInt(checkSum,16)&0xFF), nbBytes, removedAddress[0], data)) {
			
			srecData.addData(data, Integer.parseInt(removedAddress[0],16), SRECAddressType.ADDRESS_24BITS);
			
		} else {
			throw new BadSRECFileFormat("Check sum error in line: " + line);
		}
	}

	/**
	 * parse data line with a 32 bits address (Code S3). 
	 * 
	 * @param line Line to parse
	 * @param srecData Reference on the data container
	 * @throws BadSRECFileFormat In case of error
	 */
	private void dataFieldFrom32bitsAddress(String line, SRECData srecData) throws BadSRECFileFormat {
		String[] consumedValues = consumBytes(line, 2); 
		line = consumedValues[1];
		int nbBytes = Integer.parseInt(consumedValues[0],16);

		String[] removedAddress = consumBytes(line, 8);
		line = removedAddress[1];

		String[] consumedData = consumBytes(line, nbBytes*2-10); // -6 = 4 bytes for address and 2 bytes for checksum
		String strData = consumedData[0];
		byte[] data = convertedData(strData);
		line = consumedData[1];
		
		String[] checkSumData = consumBytes(line, 2);
		String checkSum = checkSumData[0];
		if (verifyChecksum((byte)(Integer.parseInt(checkSum,16)&0xFF), nbBytes, removedAddress[0], data)) {
			
			srecData.addData(data, Integer.parseInt(removedAddress[0],16), SRECAddressType.ADDRESS_32BITS);
			
		} else {
			throw new BadSRECFileFormat("Check sum error in line: " + line);
		}
	}

	private void twoBytesAddressStart(String line, SRECData srecData) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Define a 32 starting address (Code S7).
	 * 
	 * @param line Line to parse
	 * @param srecData Reference on the data container
	 * @throws BadSRECFileFormat In case of error
	 */
	private void address32BitsStartAddress(String line, SRECData srecData) throws BadSRECFileFormat {
		String strCount = line.substring(2, 4);
		String strAddress = line.substring(4, 10);
		String strChecksum = line.substring(10, 12);
		
		byte count = (byte)(Integer.parseInt(strCount,16) & 0xFF);
		byte checksum = (byte)(Integer.parseInt(strChecksum,16) & 0xFF);
		
		byte expectedChecksum = computeChecksum(count, strAddress, "".getBytes());
		if (checksum == expectedChecksum) {
			srecData.setStartingAddress(Integer.parseInt(strAddress,16), SRECAddressType.ADDRESS_24BITS);
			
		} else {
			throw new BadSRECFileFormat("Checksum error on line " + line);
		}
	}

	/**
	 * Define a 24 starting address (Code S8).
	 * 
	 * @param line Line to parse
	 * @param srecData Reference on the data container
	 * @throws BadSRECFileFormat In case of error
	 */
	private void address24BitsStartAddress(String line, SRECData srecData) throws BadSRECFileFormat {
		String strCount = line.substring(2, 4);
		String strAddress = line.substring(4, 10);
		String strChecksum = line.substring(10, 12);
		
		byte count = (byte)(Integer.parseInt(strCount,16) & 0xFF);
		byte checksum = (byte)(Integer.parseInt(strChecksum,16) & 0xFF);
		
		byte expectedChecksum = computeChecksum(count, strAddress, "".getBytes());
		if (checksum == expectedChecksum) {
			srecData.setStartingAddress(Integer.parseInt(strAddress,16), SRECAddressType.ADDRESS_24BITS);
			
		} else {
			throw new BadSRECFileFormat("Checksum error on line " + line);
		}
	}

	/**
	 * Define a 16 starting address (code S9).
	 * 
	 * @param line Line to parse
	 * @param srecData Reference on the data container
	 * @throws BadSRECFileFormat In case of error
	 */
	private void address16BitsStartAddress(String line, SRECData srecData) throws BadSRECFileFormat {
		String strCount = line.substring(2, 4);
		String strAddress = line.substring(4, 8);
		String strChecksum = line.substring(8, 10);
		
		byte count = (byte)(Integer.parseInt(strCount,16) & 0xFF);
		byte checksum = (byte)(Integer.parseInt(strChecksum,16) & 0xFF);
		
		byte expectedChecksum = computeChecksum(count, strAddress, "".getBytes());
		if (checksum == expectedChecksum) {
			srecData.setStartingAddress(Integer.parseInt(strAddress,16), SRECAddressType.ADDRESS_16BITS);
			
		} else {
			throw new BadSRECFileFormat("Checksum error on line " + line);
		}
	}

	/**
	 * Consume the first number of bytes in a string
	 * 
	 * @param line Line to consume
	 * @param length number of bytes to consume
	 * 
	 * @return String[0] : Line without consumed bytes, String[1]: Consumed bytes
	 * @throws IndexOutOfBoundsException exception in case of error
	 */
	private String[] consumBytes(String line, int length) throws IndexOutOfBoundsException  {
		String[] consumedValues = new String[2];	
		consumedValues[0] = line.substring(0,length);
		consumedValues[1] = line.substring(length);
		return consumedValues;
	}
	
	/**
	 * Convert a String in an array of bytes.  
	 * 
	 * @param strData String to convert
	 * @return array of byte
	 */
	private byte[] convertedData(String strData) {
		
		int nbValues = strData.length()/2;
		byte[] convertedData = new byte[nbValues]; 
		
		for (int i=0 ; i<nbValues ; i++) {
			String[] consumedData = consumBytes(strData, 2);
			strData = consumedData[1];
			String value = consumedData[0];
			int intValue = Integer.parseInt(value,16);
			convertedData[i] = (byte) (intValue & 0xFF);
		}
		return convertedData;
	}

	/** 
	 * Verify the checksum of a line
	 * 
	 * @param expectedChecksum expected checksum
	 * @param nbBytes Number of bytes field
	 * @param address address value
	 * @param data data
	 * 
	 * @return <b>true</b> checksum is valid, <b<false</b> otherwise
	 */
	private boolean verifyChecksum(byte expectedChecksum, int nbBytes, String address,  byte[] data) {
		byte computedChecksum = computeChecksum(nbBytes, address, data);
		return expectedChecksum == computedChecksum;
	}

}
