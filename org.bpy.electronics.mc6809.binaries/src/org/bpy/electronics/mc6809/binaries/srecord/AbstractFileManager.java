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

import java.util.List;

/**
 * Abstract class which supplty comme resources for SRECReader and SRECWriter
 * 
 * @author Patrick BRIAND
 *
 */
public abstract class AbstractFileManager {

	/**
	 * Compute the checksum of a line
	 * 
	 * @param nbBytes number of byte of the line
	 * @param address Address defined in the line
	 * @param bytesToExport Bytes in the line
	 * 
	 * @return checksum of the line
	 */
	protected byte computeChecksum(int maxDataInLine, String address, List<Byte> bytesToExport) {
		byte[] bytes = new byte[bytesToExport.size()];
		for (int i=0 ; i<bytesToExport.size() ; i++) {
			bytes[i] = bytesToExport.get(i);
		}
		return computeChecksum(maxDataInLine, address, bytes);
	}

	/**
	 * Compute the checksum of a line
	 * 
	 * @param nbBytes number of byte of the line
	 * @param address Address defined in the line
	 * @param bytes Bytes in the line
	 * 
	 * @return checksum of the line
	 */
	protected byte computeChecksum(int nbBytes, String address, byte[] bytes) {

		byte checksum = (byte) (nbBytes&0xFF);
		
		int intAddress = Integer.parseInt(address,16);
		if (address.length() == 4) {
			checksum += intAddress>>8 & 0xFF;
			checksum += intAddress&0xFF;
		
		} else if (address.length() == 6) {
			checksum += intAddress>>16 & 0xFF;
			checksum += intAddress>>8 & 0xFF;
			checksum += intAddress & 0xFF;
		
		} else {
			checksum += intAddress>>24 & 0xFF;
			checksum += intAddress>>16 & 0xFF;
			checksum += intAddress>>8 & 0xFF;
			checksum += intAddress & 0xFF;
		}
		
		for (int byteData : bytes) {
			checksum += byteData&0xFF;
		}
		return (byte)( (checksum^0xFF) & 0xFF);
	}

}
