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
package org.bpy.electronics.mc6809.assembler.engine.data.instructions;

/**
 * Define all addressing mode of the 6809
 * 
 * @author briand
 *
 */
public enum AddressingMode {

	/** Inherent mode */
	INHERENT,
	IMMEDIATE,
	EXTENDED,
	DIRECT,
	INDEXED_AUTO_DEC_INC_MODE,
	INDEXED_CONSTANT_MODE,
	INDEXED_ACCUMULATOR_MOVING_MODE,
	INDEXED_RELATIF_TO_PC,
	INDEXED_CONSTANT_MOVING_INDIRECT_MODE,
	INDEXED_AUTO_DEC_INC_INDIRECT_MODE,
	INDEXED_ACCUMULATOR_MOVING_INDIRECT_MODE,
	INDEXED_RELATIF_TO_PC_INDIRECT_MODE,
	EXTENDED_INDIRECT,
	RELATIVE
}
