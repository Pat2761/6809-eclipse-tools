/**
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
 */
package org.bpy.electronics.mc6809.assembler.tests;

import org.bpy.electronics.mc6809.assembler.tests.directives.TestBszDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestComment;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestEndDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestEquDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestFailDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestFcbDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestFccDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestFdbDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestFillDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestNamDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestOptDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestOrgDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestPagDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestRegDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestRmbDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestSetDPDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestSetDirective;
import org.bpy.electronics.mc6809.assembler.tests.directives.TestSpcDirective;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestADCAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestADDDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestADDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestANDCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestANDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestASLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestASRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBCSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBEQInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBGEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBGTInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBHIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBHSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBITInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBLEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBLOInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBLSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBLTInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBMIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBNEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBPLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBRAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBRNInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBSRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBVCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBVSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCLRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCMPInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCOMInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCWAIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestDAAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestDECInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestEORInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestEXGInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestINCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestJMPInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestJSRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLD16Instruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLD8Instruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLEAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLSLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLSRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestMULInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestNOPInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestNegInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestORCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestORInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestPSHSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestPSHUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestPULSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestPULUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestROLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestRORInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestRTIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestRTSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSBCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSEXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestST16Instruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestST8Instruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSUBDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSUBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSWI2Instruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSWI3Instruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSWIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSYNCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestTFRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestTSTInstruction;
import org.bpy.electronics.mc6809.assembler.tests.samples.SorekSamples;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CheckNumberValidation.class, TestComment.class, TestBszDirective.class, TestEndDirective.class, TestEquDirective.class, TestFailDirective.class, TestFcbDirective.class, TestFccDirective.class, TestFdbDirective.class, TestFillDirective.class, TestNamDirective.class, TestOptDirective.class, TestOrgDirective.class, TestPagDirective.class, TestRegDirective.class, TestRmbDirective.class, TestSetDirective.class, TestSpcDirective.class, TestSetDirective.class, TestSetDPDirective.class, TestADCAInstruction.class, TestADDDInstruction.class, TestADDInstruction.class, TestANDCCInstruction.class, TestANDInstruction.class, TestASLInstruction.class, TestASRInstruction.class, TestBCCInstruction.class, TestBCSInstruction.class, TestBEQInstruction.class, TestBGEInstruction.class, TestBGTInstruction.class, TestBHIInstruction.class, TestBHSInstruction.class, TestBITInstruction.class, TestBLEInstruction.class, TestBLOInstruction.class, TestBLSInstruction.class, TestBLTInstruction.class, TestBMIInstruction.class, TestBNEInstruction.class, TestBPLInstruction.class, TestBRAInstruction.class, TestBRNInstruction.class, TestBSRInstruction.class, TestBVCInstruction.class, TestBVSInstruction.class, TestCLRInstruction.class, TestCMPInstruction.class, TestCOMInstruction.class, TestCWAIInstruction.class, TestDAAInstruction.class, TestDECInstruction.class, TestEORInstruction.class, TestEXGInstruction.class, TestINCInstruction.class, TestJMPInstruction.class, TestJSRInstruction.class, TestLD8Instruction.class, TestLD16Instruction.class, TestLEAInstruction.class, TestLSLInstruction.class, TestLSRInstruction.class, TestMULInstruction.class, TestNegInstruction.class, TestNOPInstruction.class, TestORInstruction.class, TestORCCInstruction.class, TestPSHSInstruction.class, TestPSHUInstruction.class, TestPULSInstruction.class, TestPULUInstruction.class, TestROLInstruction.class, TestRORInstruction.class, TestRTIInstruction.class, TestRTSInstruction.class, TestSBCInstruction.class, TestSEXInstruction.class, TestST8Instruction.class, TestST16Instruction.class, TestSUBInstruction.class, TestSUBDInstruction.class, TestSWIInstruction.class, TestSWI2Instruction.class, TestSWI3Instruction.class, TestSYNCInstruction.class, TestTFRInstruction.class, TestTSTInstruction.class, SorekSamples.class })
@SuppressWarnings("all")
public class AssemblerParsingTest {
}
