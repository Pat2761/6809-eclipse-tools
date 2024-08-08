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

	/** Example  : NOP */
	INHERENT,
	/** *example : LDA #25 */
	IMMEDIATE,
	/** example : LDA $1254 */
	EXTENDED,
	/** *example : LDA S25 */
	DIRECT,
	/** example : LDA +,X */
	INDEXED_AUTO_DEC_INC_MODE,
	/** example : LDA 25,X */
	INDEXED_CONSTANT_MODE,
	/** example : LDA A,X */
	INDEXED_ACCUMULATOR_MOVING_MODE,
	/** example : LDA 25,PCR */
	INDEXED_RELATIF_TO_PC,
	/** example : LDA [25,X] */
	INDEXED_CONSTANT_INDIRECT_MODE,
	/** example : LDA [+,X] */
	INDEXED_AUTO_DEC_INC_INDIRECT_MODE,
	/** example : LDA [A,X] */
	INDEXED_ACCUMULATOR_MOVING_INDIRECT_MODE,
	/** example : [LDA 25,PCR] */
	INDEXED_RELATIF_TO_PC_INDIRECT_MODE,
	/** example : [LDA $1254] */
	EXTENDED_INDIRECT,
	/** example : BCC  label */
	RELATIVE
}
