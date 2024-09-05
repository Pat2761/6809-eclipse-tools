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

import java.util.ArrayList;
import java.util.List;

/**
 * Manage data description for binary files.
 * 
 * @author Patrick BRIAND
 *
 */
public class SRECData {

	/** Tool name */
	private String toolName;
	
	/** Collection of bloc of memory */
	private List<SRECBlocOfCodeDescriptor> blocDescriptors;

	/** Starting address */
	private int startingAddress;

	/** Type of starting address */
	private SRECAddressType addressType;
	
	/**
	 * Constructor of the class
	 */
	public SRECData() {
		toolName = "";
		blocDescriptors = new ArrayList<>();
		startingAddress = 0;
		addressType = SRECAddressType.ADDRESS_16BITS;
	}

	/**
	 * Get the tool name.
	 * 
	 * @return tool name
	 */
	public String getToolName() {
		return toolName;
	}

	/**
	 * Set the tool name.
	 * 
	 * @param toolName tool name
	 */
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	/**
	 * Set the starting address
	 * 
	 * @param startingAddress starting address
	 * @param addressType Type of address (16, 24 or 32 bits)
	 */
	public void setStartingAddress(int startingAddress, SRECAddressType addressType) {
		this.startingAddress = startingAddress;
		this.addressType = addressType;
		
	}

	/**
	 * Get the starting address.
	 * 
	 * @return starting address
	 */
	public int getStartingAddress() {
		return startingAddress;
	}

	/**
	 * Get the address type
	 * @return address type
	 */
	public SRECAddressType getAddressType() {
		return addressType;
	}

	/**
	 * get the list of block descriptor.
	 * 
	 * @return list of block descriptor
	 */
	public List<SRECBlocOfCodeDescriptor> getBlocDescriptors() {
		return blocDescriptors;
	}

	/**
	 * Set the description of bloc of data
	 * 
	 * @param address Starting address of the bloc
	 * @param data data in the bloc
	 * @param blocAddressType type of Address for this bloc 
	 */
	public void setData(int address, byte[] data, SRECAddressType blocAddressType) {
		SRECBlocOfCodeDescriptor blockDescriptor = new SRECBlocOfCodeDescriptor();
		blockDescriptor.setData(data);
		blockDescriptor.setStartAddress(address);
		blockDescriptor.setAddressType(blocAddressType);
		blocDescriptors.add(blockDescriptor );
	}

	public void addData(byte[] data, int address, SRECAddressType address16bits) {
		SRECBlocOfCodeDescriptor blocDescriptor = null;
		for (SRECBlocOfCodeDescriptor targetBlocDescriptor : blocDescriptors) {

			// try to get a continuous bloc
			if ( (targetBlocDescriptor.getNextStartAddress() == address) && 
					(targetBlocDescriptor.getAddressType().equals(address16bits))) {
				blocDescriptor = targetBlocDescriptor;
			}
		}
		
		// No bloc found, so need to create one
		if (blocDescriptor == null) {
			blocDescriptor = new SRECBlocOfCodeDescriptor();
			blocDescriptor.setAddressType(address16bits);
			blocDescriptor.setStartAddress(address);
			blocDescriptor.setNextStartAddress(address+data.length);
			blocDescriptor.setData(data);
			blocDescriptors.add(blocDescriptor);
		} else {
			blocDescriptor.setNextStartAddress(blocDescriptor.getNextStartAddress()+data.length);
			blocDescriptor.addData(data);
		}
	}
}
