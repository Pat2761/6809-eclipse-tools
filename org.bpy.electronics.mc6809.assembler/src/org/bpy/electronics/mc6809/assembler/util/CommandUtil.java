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
package org.bpy.electronics.mc6809.assembler.util;

import java.util.ArrayList;
import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.AbxInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AdddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AndCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AndInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BitInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BszDirective;
import org.bpy.electronics.mc6809.assembler.assembler.ClrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.CmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ComInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.CwaiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DaaInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DecInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.EorInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FccDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.JsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LdInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LeaInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.MulInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.NamDirective;
import org.bpy.electronics.mc6809.assembler.assembler.NegInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.NopInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.PagDirective;
import org.bpy.electronics.mc6809.assembler.assembler.PshsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PshuInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PulsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PuluInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Register;
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RolInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RorInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RtiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RtsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SbcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SetDPDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SexInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective;
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;

/**
 * Utility class for get informations about instructions or directives
 * 
 * @author Patrick
 *
 */
public class CommandUtil {

	/**
	 * Return the label associated to a directive line.
	 * 
	 * @param directive reference on the directive line
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(DirectiveLine directive) {
		if ( directive.getName() != null) {
			return directive.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to a directive line.
	 * 
	 * @param directive reference on the directive line
	 */
	public static String getComment(DirectiveLine directive) {
		if ( directive.getComment() != null) {
			return directive.getComment();
		} else {
			return null;
		}
	}

	/**
	 * Return the label associated to an instruction line.
	 * 
	 * @param directive reference on the instruction line
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(InstructionLine directive) {
		if ( directive.getName() != null) {
			return directive.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an instruction line.
	 * 
	 * @param directive reference on the instruction line
	 */
	public static String getComment(InstructionLine directive) {
		if ( directive.getComment() != null) {
			return directive.getComment();
		} else {
			return null;
		}
	}

	/**
	 * Return the label associated to an EQU directive.
	 * 
	 * @param equDirective reference on the EQU directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(EquDirective equDirective) {
		return getLabel((DirectiveLine)equDirective.eContainer());
	}
	
	/**
	 * Return the comment associated to an EQU directive.
	 * 
	 * @param equDirective reference on the EQU directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(EquDirective equDirective) {
		return getComment((DirectiveLine)equDirective.eContainer());
	}

	/**
	 * Return the label associated to an SET directive.
	 * 
	 * @param setDirective reference on the SET directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(SetDirective setDirective) {
		return getLabel((DirectiveLine)setDirective.eContainer());
	}

	/**
	 * Return the comment associated to an SET directive.
	 * 
	 * @param setDirective reference on the SET directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(SetDirective setDirective) {
		return getComment((DirectiveLine)setDirective.eContainer());
	}
	
	/**
	 * Return the label associated to an ORG directive.
	 * 
	 * @param orgDirective reference on the ORG directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(OrgDirective orgDirective) {
		return getLabel((DirectiveLine)orgDirective.eContainer());
	}

	/**
	 * Return the comment associated to an ORG directive.
	 * 
	 * @param orgDirective reference on the ORG directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(OrgDirective orgDirective) {
		return getComment((DirectiveLine)orgDirective.eContainer());
	}
	
	/**
	 * Return the label associated to an BSZ directive.
	 * 
	 * @param directive reference on the BSZ directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(BszDirective directive) {
		return getLabel((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the comment associated to an BSZ directive.
	 * 
	 * @param directive reference on the BSZ directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(BszDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the label associated to an RMB directive.
	 * 
	 * @param rmbDirective reference on the RMB directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(RmbDirective rmbDirective) {
		return getLabel((DirectiveLine)rmbDirective.eContainer());
	}

	/**
	 * Return the comment associated to an RMB directive.
	 * 
	 * @param rmbDirective reference on the RMB directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(RmbDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the label associated to an FCB directive.
	 * 
	 * @param fcbDirective reference on the FCB directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(FcbDirective fcbDirective) {
		return getLabel((DirectiveLine)fcbDirective.eContainer());
	}

	/**
	 * Return the comment associated to an FCB directive.
	 * 
	 * @param directive reference on the FCB directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(FcbDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}
	
	/**
	 * Return the label associated to an FDB directive.
	 * 
	 * @param fdbDirective reference on the FDB directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(FdbDirective fdbDirective) {
		return getLabel((DirectiveLine)fdbDirective.eContainer());
	}

	/**
	 * Return the comment associated to an FDB directive.
	 * 
	 * @param directive reference on the FDB directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(FdbDirective fdbDirective) {
		return getComment((DirectiveLine)fdbDirective.eContainer());
	}
	
	/**
	 * Return the label associated to an FCC directive.
	 * 
	 * @param fccDirective reference on the FCC directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(FccDirective fccDirective) {
		return getLabel((DirectiveLine)fccDirective.eContainer());
	}

	/**
	 * Return the comment associated to an FCC directive.
	 * 
	 * @param fccDirective reference on the FCC directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(FccDirective fccDirective) {
		return getComment((DirectiveLine)fccDirective.eContainer());
	}
	/**
	 * Return the label associated to an END directive.
	 * 
	 * @param endDirective reference on the END directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(EndDirective endDirective) {
		return getLabel((DirectiveLine)endDirective.eContainer());
	}

	/**
	 * Return the comment associated to an END directive.
	 * 
	 * @param endDirective reference on the END directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(EndDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the label associated to an FILL directive.
	 * 
	 * @param directive reference on the FILL directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(FillDirective directive) {
		return getLabel((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the comment associated to an FILL directive.
	 * 
	 * @param directive reference on the FILL directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(FillDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the label associated to an OPT directive.
	 * 
	 * @param directive reference on the OPT directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(OptDirective directive) {
		return getLabel((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the comment associated to an OPT directive.
	 * 
	 * @param directive reference on the OPT directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(OptDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the label associated to an PAG directive.
	 * 
	 * @param directive reference on the PAG directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(PagDirective directive) {
		return getLabel((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the comment associated to an PAG directive.
	 * 
	 * @param directive reference on the PAG directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(PagDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the label associated to an NAM directive.
	 * 
	 * @param directive reference on the NAM directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(NamDirective directive) {
		return getLabel((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the comment associated to an NAM directive.
	 * 
	 * @param directive reference on the NAM directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(NamDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the label associated to an SPC directive.
	 * 
	 * @param directive reference on the SPC directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(SpcDirective directive) {
		return getLabel((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the comment associated to an SPC directive.
	 * 
	 * @param directive reference on the SPC directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(SpcDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the label associated to an REG directive.
	 * 
	 * @param directive reference on the REG directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(RegDirective directive) {
		return getLabel((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the comment associated to an REG directive.
	 * 
	 * @param directive reference on the REG directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(RegDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the label associated to an SETDP directive.
	 * 
	 * @param directive reference on the SETDP directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(SetDPDirective directive) {
		return getLabel((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the comment associated to an SETDP directive.
	 * 
	 * @param directive reference on the SETDP directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(SetDPDirective directive) {
		return getComment((DirectiveLine)directive.eContainer());
	}

	/**
	 * Return the label associated to an ABX instruction.
	 * 
	 * @param instruction reference on the ABX instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(AbxInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an ABX instruction.
	 * 
	 * @param instruction reference on the ABX instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(AbxInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}
	
	/**
	 * Return the label associated to an ADC instruction.
	 * 
	 * @param instruction reference on the ADC instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(AdcInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an ADC instruction.
	 * 
	 * @param instruction reference on the ADC instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(AdcInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a 8 bits ADD instruction.
	 * 
	 * @param instruction reference on the 8 bits ADD instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(AddInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a 8 bits ADD instruction.
	 * 
	 * @param instruction reference on the 8 bits ADD instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(AddInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a 16 bits ADD instruction.
	 * 
	 * @param instruction reference on the 16 bits ADD instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(AdddInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a 16 bits ADD instruction.
	 * 
	 * @param instruction reference on the 16 bits ADD instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(AdddInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a AND instruction.
	 * 
	 * @param instruction reference on the AND instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(AndInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a AND instruction.
	 * 
	 * @param instruction reference on the AND instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(AndInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a ANDCC instruction.
	 * 
	 * @param instruction reference on the ANDCC instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(AndCCInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a ANDCC instruction.
	 * 
	 * @param instruction reference on the ANDCC instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(AndCCInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a ASL instruction.
	 * 
	 * @param instruction reference on the ASL instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(AslInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a ASL instruction.
	 * 
	 * @param instruction reference on the ASL instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(AslInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a ASR instruction.
	 * 
	 * @param instruction reference on the ASR instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(AsrInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a ASR instruction.
	 * 
	 * @param instruction reference on the ASR instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(AsrInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a BIT instruction.
	 * 
	 * @param instruction reference on the BIT instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(BitInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a BIT instruction.
	 * 
	 * @param instruction reference on the BIT instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(BitInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a CLR instruction.
	 * 
	 * @param instruction reference on the CLR instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(ClrInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a CLR instruction.
	 * 
	 * @param instruction reference on the CLR instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(ClrInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a CMP instruction.
	 * 
	 * @param instruction reference on the CMP instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(CmpInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a CMP instruction.
	 * 
	 * @param instruction reference on the CMP instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(CmpInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a COM instruction.
	 * 
	 * @param instruction reference on the COM instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(ComInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a COM instruction.
	 * 
	 * @param instruction reference on the COM instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(ComInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a CWAI instruction.
	 * 
	 * @param instruction reference on the CWAI instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(CwaiInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a COM instruction.
	 * 
	 * @param instruction reference on the COM instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(CwaiInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a DAA instruction.
	 * 
	 * @param instruction reference on the DAA instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(DaaInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a DAA instruction.
	 * 
	 * @param instruction reference on the DAA instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(DaaInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a DEC instruction.
	 * 
	 * @param instruction reference on the DEC instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(DecInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a DEC instruction.
	 * 
	 * @param instruction reference on the DEC instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(DecInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a EOR instruction.
	 * 
	 * @param instruction reference on the EOR instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(EorInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a EOR instruction.
	 * 
	 * @param instruction reference on the EOR instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(EorInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a EXG instruction.
	 * 
	 * @param instruction reference on the EXG instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(ExgInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a EXG instruction.
	 * 
	 * @param instruction reference on the EXG instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(ExgInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a INC instruction.
	 * 
	 * @param instruction reference on the INC instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(IncInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a INC instruction.
	 * 
	 * @param instruction reference on the INC instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(IncInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a JMP instruction.
	 * 
	 * @param instruction reference on the JMP instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(JmpInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a JMP instruction.
	 * 
	 * @param instruction reference on the JMP instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(JmpInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a JSR instruction.
	 * 
	 * @param instruction reference on the JSR instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(JsrInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a JSR instruction.
	 * 
	 * @param instruction reference on the JSR instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(JsrInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a LD instruction.
	 * 
	 * @param instruction reference on the LD instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(LdInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a LD instruction.
	 * 
	 * @param instruction reference on the LD instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(LdInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a LEA instruction.
	 * 
	 * @param instruction reference on the LEA instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(LeaInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a LEA instruction.
	 * 
	 * @param instruction reference on the LEA instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(LeaInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a LSL instruction.
	 * 
	 * @param instruction reference on the LSL instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(LslInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a LSL instruction.
	 * 
	 * @param instruction reference on the LSL instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(LslInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a LSR instruction.
	 * 
	 * @param instruction reference on the LSR instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(LsrInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a LSR instruction.
	 * 
	 * @param instruction reference on the LSR instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(LsrInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to a MUL instruction.
	 * 
	 * @param instruction reference on the MUL instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(MulInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to a MUL instruction.
	 * 
	 * @param instruction reference on the MUL instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(MulInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an NOP instruction.
	 * 
	 * @param instruction reference on the NOP instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(NopInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an NOP instruction.
	 * 
	 * @param instruction reference on the NOP instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(NopInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an NEG instruction.
	 * 
	 * @param instruction reference on the NEG instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(NegInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an NEG instruction.
	 * 
	 * @param instruction reference on the NEG instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(NegInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an OR instruction.
	 * 
	 * @param instruction reference on the OR instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(OrInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an OR instruction.
	 * 
	 * @param instruction reference on the OR instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(OrInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an ORCC instruction.
	 * 
	 * @param instruction reference on the ORCC instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(OrCCInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an ORCC instruction.
	 * 
	 * @param instruction reference on the ORCC instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(OrCCInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an PSHS instruction.
	 * 
	 * @param instruction reference on the PSHS instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(PshsInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an PSHS instruction.
	 * 
	 * @param instruction reference on the PSHS instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(PshsInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an PSHU instruction.
	 * 
	 * @param instruction reference on the PSHU instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(PshuInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an PSHU instruction.
	 * 
	 * @param instruction reference on the PSHU instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(PshuInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an PULS instruction.
	 * 
	 * @param instruction reference on the PULS instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(PulsInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an PULS instruction.
	 * 
	 * @param instruction reference on the PULS instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(PulsInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an PULU instruction.
	 * 
	 * @param instruction reference on the PULU instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(PuluInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an PULU instruction.
	 * 
	 * @param instruction reference on the PULU instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(PuluInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an ROL instruction.
	 * 
	 * @param instruction reference on the ROL instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(RolInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an ROL instruction.
	 * 
	 * @param instruction reference on the ROL instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(RolInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an ROR instruction.
	 * 
	 * @param instruction reference on the ROR instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(RorInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an ROR instruction.
	 * 
	 * @param instruction reference on the ROR instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(RorInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an RTI instruction.
	 * 
	 * @param instruction reference on the RTI instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(RtiInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an RTI instruction.
	 * 
	 * @param instruction reference on the RTI instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(RtiInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an RTS instruction.
	 * 
	 * @param instruction reference on the RTS instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(RtsInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an RTS instruction.
	 * 
	 * @param instruction reference on the RTS instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(RtsInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an SBC instruction.
	 * 
	 * @param instruction reference on the SBC instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(SbcInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an SBC instruction.
	 * 
	 * @param instruction reference on the SBC instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(SbcInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an SEX instruction.
	 * 
	 * @param instruction reference on the SEX instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(SexInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an SEX instruction.
	 * 
	 * @param instruction reference on the SEX instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(SexInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the label associated to an TFR instruction.
	 * 
	 * @param instruction reference on the TFR instruction
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(TfrInstruction instruction) {
		return getLabel((InstructionLine)instruction.eContainer());
	}

	/**
	 * Return the comment associated to an TFR instruction.
	 * 
	 * @param instruction reference on the TFR instruction
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(TfrInstruction instruction) {
		return getComment((InstructionLine)instruction.eContainer());
	}

	public static int getByteToSet(FillDirective fillDirective, EReference currentReference) {
		Expression value = fillDirective.getValue().getOperand();
		return ExpressionParser.resolveExpression(value, fillDirective, currentReference);
	}

	public static int getQuantity(FillDirective fillDirective, EReference currentReference) {
		Expression value = fillDirective.getNumber().getOperand();
		return ExpressionParser.resolveExpression(value, fillDirective, currentReference);
	}

	/*
	 * Get name defined by a NAM directive
	 */
	public static String getName(NamDirective namDirective) {
		return namDirective.getOperand().getValue();
	}

	/**
	 * Get the list of registers in a REG directive
	 * 
	 * @param regDirective reference on the REG Directive
	 * @return List of registers name
	 */
	public static List<String> getRegisters(RegDirective regDirective) {
		List<String> registers = new ArrayList<>();
		EList<Register> options = regDirective.getOptions();
		for (Register option : options) {
			registers.add(option.getLiteral());
		}
		return registers;
	}

	public static List<String> getRegisters(PshsInstruction instruction) {
		List<String> registers = new ArrayList<>();
		EList<Register> options = instruction.getRegisters();
		for (Register option : options) {
			registers.add(option.getLiteral());
		}
		return registers;
	}

	public static List<String> getRegisters(PshuInstruction instruction) {
		List<String> registers = new ArrayList<>();
		EList<Register> options = instruction.getRegisters();
		for (Register option : options) {
			registers.add(option.getLiteral());
		}
		return registers;
	}

	public static List<String> getRegisters(PulsInstruction instruction) {
		List<String> registers = new ArrayList<>();
		EList<Register> options = instruction.getRegisters();
		for (Register option : options) {
			registers.add(option.getLiteral());
		}
		return registers;
	}

	public static List<String> getRegisters(PuluInstruction instruction) {
		List<String> registers = new ArrayList<>();
		EList<Register> options = instruction.getRegisters();
		for (Register option : options) {
			registers.add(option.getLiteral());
		}
		return registers;
	}
}
