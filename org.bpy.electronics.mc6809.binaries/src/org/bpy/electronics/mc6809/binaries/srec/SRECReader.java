package org.bpy.electronics.mc6809.binaries.srec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.bpy.electronics.mc6809.binaries.exceptions.BadSRECFileFormat;

public class SRECReader {

	public SRECData readFile(String fullPathName) throws IOException, BadSRECFileFormat {
		FileReader fileReader = new FileReader(new File(fullPathName));
		return readFile(fileReader);
	}

	public SRECData readFile(Reader stringReader) throws IOException, BadSRECFileFormat {

		BufferedReader reader = new BufferedReader(stringReader);
		SRECData srecData = new SRECData();
		
		String line = reader.readLine();
		if (line != null) {
			parseLine(line, srecData);
			line = reader.readLine();
		}
		
		reader.close();
		return srecData;
	}

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
				twoBytesAddressData(line);
				break;
			case "S2" : 
				threeBytesAddressData(line);
				break;
			case "S3" :
				fourBytesAddressData(line);
				break;
			case "S5" :
				twoBytesAddressStart(line);
				break;
			case "S7" :
				threeBytesAddressStart(line);
				break;
			case "S8" :
				fourBytesAddressStart(line);
				break;
			case "S9" :
				startingExecutionAddress(line);
				break;
			default:
				throw new BadSRECFileFormat("Unexpected line of type " + consumedValues[0]);
			}
			
		}
	}

	private void parseSRECheader(String line, SRECData srecData) throws BadSRECFileFormat {
		String[] consumedValues = consumBytes(line, 2); 
		line = consumedValues[1];
		int nbBytes = Integer.parseInt(consumedValues[0],16);

		String[] removedAddress = consumBytes(line, 4);
		line = removedAddress[1];
		
		String[] consumedData = consumBytes(line, nbBytes*2-6); // -6 = 4 bytes for address and 2 bytes for checksum
		String strData = consumedData[0];
		int[] data = convertedData(strData);
		line = consumedData[1];
		
		String[] checkSumData = consumBytes(line, 2);
		String checkSum = checkSumData[0];
		if (verifyChecksum(Integer.parseInt(checkSum,16), nbBytes, 0, data)) {
			StringBuilder toolName = new StringBuilder();
			for (int dataByte : data) {
				toolName.append((char)dataByte);
			}
			srecData.setToolName(toolName.toString());
			
		} else {
			throw new BadSRECFileFormat("Check sum error in file");
		}
		System.out.println();
		
	}

	private int[] convertedData(String strData) {
		
		int nbValues = strData.length()/2;
		int[] convertedData = new int[nbValues]; 
		
		for (int i=0 ; i<nbValues ; i++) {
			String[] consumedData = consumBytes(strData, 2);
			strData = consumedData[1];
			String value = consumedData[0];
			convertedData[i] = Integer.parseInt(value,16);
			
		}
		return convertedData;
	}

	private boolean verifyChecksum(int expectedChecksum, int nbBytes, int address,  int[] data) {
		int checksum = nbBytes;
		checksum += address/16;
		checksum += address&0xFF;
		for (int byteData : data) {
			checksum += byteData;
		}
		checksum = 0xFF - (checksum & 0xFF);
		return expectedChecksum == checksum;
	}

	private String[] consumBytes(String line, int length) throws IndexOutOfBoundsException  {
		String[] consumedValues = new String[2];	
		consumedValues[0] = line.substring(0,length);
		consumedValues[1] = line.substring(length);
		return consumedValues;
	}

	private void twoBytesAddressData(String line) {
		// TODO Auto-generated method stub
		
	}

	private void threeBytesAddressData(String line) {
		// TODO Auto-generated method stub
		
	}

	private void fourBytesAddressData(String line) {
		// TODO Auto-generated method stub
		
	}

	private void twoBytesAddressStart(String line) {
		// TODO Auto-generated method stub
		
	}

	private void threeBytesAddressStart(String line) {
		// TODO Auto-generated method stub
		
	}

	private void fourBytesAddressStart(String line) {
		// TODO Auto-generated method stub
		
	}

	private void startingExecutionAddress(String line) {
		// TODO Auto-generated method stub
		
	}
}
