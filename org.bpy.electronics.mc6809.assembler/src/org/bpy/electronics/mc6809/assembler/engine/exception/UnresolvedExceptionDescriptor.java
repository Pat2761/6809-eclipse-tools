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
package org.bpy.electronics.mc6809.assembler.engine.exception;

import org.eclipse.emf.ecore.EReference;

/**
 * Descriptor of the missing label exception
 * 
 * @author Patrick BRIAND
 *
 */
public class UnresolvedExceptionDescriptor {
	
	/** Error message */
	private String message;
	/** Reference of assembler element in error */
	private EReference reference;
	/** Missing label */
	private String missingLabel;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param missingLabel missing label
	 * @param message Error message
	 * @param reference Reference of assembler element in error
	 */
	public UnresolvedExceptionDescriptor(String missingLabel, String message, EReference reference)  {
		this.message = message;
		this.reference = reference;
		this.missingLabel = missingLabel;
	}

	/**
	 * Get the Error message
	 * 
	 * @return Error message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * get the Reference of assembler element in error
	 * 
	 * @return Reference of assembler element in error
	 */
	public EReference getReference() {
		return reference;
	}

	/**
	 * Get the missing label.
	 * 
	 * @return Missing label
	 */
	public String getMissingLabel() {
		return missingLabel;
	}
}
