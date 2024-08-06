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

/**
 * Exception in case of expression parser error.
 * 
 * @author Patrick BRIAND
 *
 */
public class UnresolvedException extends Exception {

	/** Serial ID */
	private static final long serialVersionUID = -9137761702085156258L;

	private UnresolvedExceptionDescriptor descriptor;

	
	public UnresolvedException(UnresolvedExceptionDescriptor descriptor) {
		super(descriptor.getMessage());
		this.descriptor = descriptor;
	}

	public UnresolvedExceptionDescriptor getDescriptor() {
		return descriptor;
		
	}
 }
