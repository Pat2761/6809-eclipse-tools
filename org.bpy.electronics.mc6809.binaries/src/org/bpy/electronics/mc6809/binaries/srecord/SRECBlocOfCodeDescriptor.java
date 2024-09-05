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

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Describe of bloc of code.
 * 
 * @author Patrick BRIAND
 *
 */
public class SRECBlocOfCodeDescriptor {

	/** define the type of address (16,24 or 32) */
	private SRECAddressType addressType;
	
	/** Start address */
	private int startAddress;
	
	/** data store in this bloc */
	private byte[] data;

	/** Next start address */
	private int nextStartAddress;
	
	/**
	 * Get type of address.
	 * 
	 * @return type of address (ADDRESS_16BITS, ADDRESS_24BITS or ADDRESS_32BITS)
	 */
	public SRECAddressType getAddressType() {
		return addressType;
	}

	/**
	 * Set type of address.
	 * 
	 * @param addressType type of address (ADDRESS_16BITS, ADDRESS_24BITS or ADDRESS_32BITS)
	 */
	public void setAddressType(SRECAddressType addressType) {
		this.addressType = addressType;
	}

	/**
	 * Get start address of the bloc. 
	 * 
	 * @return start address of the bloc
	 */
	public int getStartAddress() {
		return startAddress;
	}

	/**
	 * Set start address of the bloc.
	 * 
	 * @param startAddress start address of the bloc.
	 */
	public void setStartAddress(int startAddress) {
		this.startAddress = startAddress;
	}

	/**
	 * Get bloc of data.
	 *  
	 * @return array of byte which define the data
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * Set bloc of data.
	 * 
	 * @param data array of byte which define the data
	 */
	public void setData(byte[] data) {
		this.data = data;
	}

	/**
	 * Add data to existing data
	 * 
	 * @param data moreData data to add 
	 */
	public void addData(byte[] moreData) {
		data = ArrayUtils.addAll(data, moreData);
	}

	/**
	 * Get the next start address.
	 * 
	 * @return next start address
	 */
	public int getNextStartAddress() {
		return nextStartAddress;
	}

	/**
	 * Set the next start address.
	 * 
	 * @param nextStartAddress next start address
	 */
	public void setNextStartAddress(int nextStartAddress) {
		this.nextStartAddress = nextStartAddress;
	}
}
