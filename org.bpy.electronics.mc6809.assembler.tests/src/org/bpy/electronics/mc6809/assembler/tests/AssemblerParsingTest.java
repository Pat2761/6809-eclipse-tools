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
package org.bpy.electronics.mc6809.assembler.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.bpy.electronics.mc6809.assembler.tests.language.CheckNumberValidation;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestComment;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestBszDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestEndDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestEquDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestFailDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestFcbDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestFccDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestFdbDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestFillDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestNamDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestOptDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestOrgDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestPagDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestRegDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestRmbDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestSetDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestSpcDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.*;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestSetDPDirective;
import org.bpy.electronics.mc6809.assembler.tests.formatter.instructions.TestAbxInstructionFormatter;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
	
	 /* general */
	 CheckNumberValidation.class,	

	 // -----------------------------------------------	
	 // Test the language and the validation 
	 // -----------------------------------------------	
	
	 /* Directives */
	 TestComment.class,
	 TestBszDirective.class,
	 TestEndDirective.class,
	 TestEquDirective.class,
	 TestFailDirective.class,
	 TestFcbDirective.class,
	 TestFccDirective.class,
	 TestFdbDirective.class,
	 TestFillDirective.class,
	 TestNamDirective.class,
	 TestOptDirective.class,
	 TestOrgDirective.class,
	 TestPagDirective.class,
	 TestRegDirective.class,
	 TestRmbDirective.class,
	 TestSetDirective.class,
	 TestSpcDirective.class,
	 TestSetDPDirective.class,
	 
	 /* Instructions  */
	 TestADCAInstruction.class,
	 TestADDAInstruction.class,
	 TestADDBInstruction.class,
	 TestADDDInstruction.class,
	 TestANDCCInstruction.class,
	 TestANDAInstruction.class,
	 TestANDBInstruction.class,
	 TestASLAInstruction.class,
	 TestASLBInstruction.class,
	 TestASLInstruction.class,
	 TestASRAInstruction.class,
	 TestASRBInstruction.class,
	 TestASRInstruction.class,
	 TestBCCInstruction.class,
	 TestLBCCInstruction.class,
	 TestBCSInstruction.class,
	 TestLBCSInstruction.class,
	 TestBEQInstruction.class,
	 TestLBEQInstruction.class,
	 TestBGEInstruction.class,
	 TestLBGEInstruction.class,
	 TestBGTInstruction.class,
	 TestLBGTInstruction.class,
	 TestBHIInstruction.class,
	 TestLBHIInstruction.class,
	 TestBHSInstruction.class,
	 TestLBHSInstruction.class,
	 TestBITAInstruction.class,
	 TestBITBInstruction.class,
	 TestBLEInstruction.class,
	 TestLBLEInstruction.class,
	 TestBLOInstruction.class,
	 TestLBLOInstruction.class,
	 TestBLSInstruction.class,
	 TestLBLSInstruction.class,
	 TestBLTInstruction.class,
	 TestLBLTInstruction.class,
	 TestBMIInstruction.class,
	 TestLBMIInstruction.class,
	 TestBNEInstruction.class,
	 TestLBNEInstruction.class,
	 TestBPLInstruction.class,
	 TestLBPLInstruction.class,
	 TestBRAInstruction.class,
	 TestLBRAInstruction.class,
	 TestBRNInstruction.class,
	 TestLBRNInstruction.class,
	 TestBSRInstruction.class,
	 TestLBSRInstruction.class,
	 TestBVCInstruction.class,
	 TestLBVCInstruction.class,
	 TestBVSInstruction.class,
	 TestLBVSInstruction.class,
	 TestCLRAInstruction.class,
	 TestCLRBInstruction.class,
	 TestCLRInstruction.class,
	 TestCMPAInstruction.class,
	 TestCMPBInstruction.class,
	 TestCMPDInstruction.class,
	 TestCMPSInstruction.class,
	 TestCMPUInstruction.class,
	 TestCMPXInstruction.class,
	 TestCOMAInstruction.class,
	 TestCOMBInstruction.class,
	 TestCOMInstruction.class,
	 TestCWAIInstruction.class,
	 TestDAAInstruction.class,
	 TestDECAInstruction.class,
	 TestDECBInstruction.class,
	 TestDECInstruction.class,
	 TestEORAInstruction.class,	
	 TestEORBInstruction.class,
	 TestEXGInstruction.class,
	 TestINCAInstruction.class,
	 TestINCBInstruction.class,
	 TestINCInstruction.class,
	 TestJMPInstruction.class,
	 TestJSRInstruction.class,
	 TestLDAInstruction.class,
	 TestLDBInstruction.class,
	 TestLDDInstruction.class,
	 TestLDSInstruction.class,
	 TestLDUInstruction.class,
	 TestLDXInstruction.class,
	 TestLDYInstruction.class,
	 TestLEASInstruction.class,
	 TestLEAUInstruction.class,
	 TestLEAXInstruction.class,
	 TestLSLAInstruction.class,
	 TestLSLBInstruction.class,
	 TestLSLInstruction.class,
	 TestLSRAInstruction.class,
	 TestLSRBInstruction.class,
	 TestLSRInstruction.class,
	 TestMULInstruction.class,
	 TestNEGAInstruction.class,
	 TestNEGBInstruction.class,
	 TestNOPInstruction.class,
	 TestORAInstruction.class,
	 TestORBInstruction.class,
	 TestORCCInstruction.class,
	 TestPSHSInstruction.class,
	 TestPSHUInstruction.class,
	 TestPULSInstruction.class,
	 TestPULUInstruction.class,
	 TestROLAInstruction.class,
	 TestROLBInstruction.class,
	 TestROLInstruction.class,
	 TestRORAInstruction.class,
	 TestRORBInstruction.class,
	 TestRORInstruction.class,
	 TestRTIInstruction.class,
	 TestRTSInstruction.class,
	 TestSBCAInstruction.class,
	 TestSBCBInstruction.class,
	 TestSEXInstruction.class,
	 TestSTAInstruction.class,
	 TestSTBInstruction.class,
	 TestSTDInstruction.class,
	 TestSTSInstruction.class,
	 TestSTUInstruction.class,
	 TestSTXInstruction.class,
	 TestSTYInstruction.class,
	 TestSUBAInstruction.class,
	 TestSUBBInstruction.class,
	 TestSUBDInstruction.class,
	 TestSWIInstruction.class,
	 TestSWI2Instruction.class,
	 TestSWI3Instruction.class,
	 TestSYNCInstruction.class,
	 TestTFRInstruction.class,
	 TestTSTAInstruction.class,
	 TestTSTBInstruction.class,
	 TestTSTInstruction.class,
	 
	 // -----------------------------------------------	
	 // Test the formatter 
	 // -----------------------------------------------	
	 TestAbxInstructionFormatter.class	
	 /* Examples  */
//	 SorekSamples
	}
)
    
public class AssemblerParsingTest {
}
