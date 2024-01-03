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
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestADDAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestADDBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestADDDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestANDAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestANDBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestANDCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestASLAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestASLBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestASLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestASRAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestASRBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestASRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBCSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBEQInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBGEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBGTInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBHIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBHSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBITAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestBITBInstruction;
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
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCLRAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCLRBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCLRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCMPAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCMPBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCMPDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCMPSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCMPUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCMPXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCOMAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCOMBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCOMInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestCWAIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestDAAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestDECAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestDECBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestDECInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestEORAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestEORBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestEXGInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestINCAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestINCBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestINCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestJMPInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestJSRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLBCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLBCSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLBEQInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLBGEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLBGTInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLBHIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLDAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLDBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLDDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLDSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLDUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLDXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLDYInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLEASInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLEAUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLEAXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLSLAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLSLBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLSLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLSRAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLSRBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestLSRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestMULInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestNEGAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestNEGBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestNOPInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestORAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestORBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestORCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestPSHSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestPSHUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestPULSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestPULUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestROLAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestROLBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestROLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestRORAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestRORBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestRORInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestRTIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestRTSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSBCAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSBCBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSEXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSTAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSTBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSTDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSTSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSTUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSTXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSTYInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSUBAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSUBBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSUBDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSWI2Instruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSWI3Instruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSWIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestSYNCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestTFRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestTSTAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.instructions.TestTSTBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.samples.SorekSamples;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CheckNumberValidation.class, TestComment.class, TestBszDirective.class, TestEndDirective.class, TestEquDirective.class, TestFailDirective.class, TestFcbDirective.class, TestFccDirective.class, TestFdbDirective.class, TestFillDirective.class, TestNamDirective.class, TestOptDirective.class, TestOrgDirective.class, TestPagDirective.class, TestRegDirective.class, TestRmbDirective.class, TestSetDirective.class, TestSpcDirective.class, TestSetDirective.class, TestSetDPDirective.class, TestADCAInstruction.class, TestADDAInstruction.class, TestADDBInstruction.class, TestADDDInstruction.class, TestANDCCInstruction.class, TestANDAInstruction.class, TestANDBInstruction.class, TestASLAInstruction.class, TestASLBInstruction.class, TestASLInstruction.class, TestASRAInstruction.class, TestASRBInstruction.class, TestASRInstruction.class, TestBCCInstruction.class, TestLBCCInstruction.class, TestBCSInstruction.class, TestLBCSInstruction.class, TestBEQInstruction.class, TestLBEQInstruction.class, TestBGEInstruction.class, TestLBGEInstruction.class, TestBGTInstruction.class, TestLBGTInstruction.class, TestBHIInstruction.class, TestLBHIInstruction.class, TestBHSInstruction.class, TestBITAInstruction.class, TestBITBInstruction.class, TestBLEInstruction.class, TestBLOInstruction.class, TestBLSInstruction.class, TestBLTInstruction.class, TestBMIInstruction.class, TestBNEInstruction.class, TestBPLInstruction.class, TestBRAInstruction.class, TestBRNInstruction.class, TestBSRInstruction.class, TestBVCInstruction.class, TestBVSInstruction.class, TestCLRAInstruction.class, TestCLRBInstruction.class, TestCLRInstruction.class, TestCMPAInstruction.class, TestCMPBInstruction.class, TestCMPDInstruction.class, TestCMPSInstruction.class, TestCMPUInstruction.class, TestCMPXInstruction.class, TestCOMAInstruction.class, TestCOMBInstruction.class, TestCOMInstruction.class, TestCWAIInstruction.class, TestDAAInstruction.class, TestDECAInstruction.class, TestDECBInstruction.class, TestDECInstruction.class, TestEORAInstruction.class, TestEORBInstruction.class, TestEXGInstruction.class, TestINCAInstruction.class, TestINCBInstruction.class, TestINCInstruction.class, TestJMPInstruction.class, TestJSRInstruction.class, TestLDAInstruction.class, TestLDBInstruction.class, TestLDDInstruction.class, TestLDSInstruction.class, TestLDUInstruction.class, TestLDXInstruction.class, TestLDYInstruction.class, TestLEASInstruction.class, TestLEAUInstruction.class, TestLEAXInstruction.class, TestLSLAInstruction.class, TestLSLBInstruction.class, TestLSLInstruction.class, TestLSRAInstruction.class, TestLSRBInstruction.class, TestLSRInstruction.class, TestMULInstruction.class, TestNEGAInstruction.class, TestNEGBInstruction.class, TestNOPInstruction.class, TestORAInstruction.class, TestORBInstruction.class, TestORCCInstruction.class, TestPSHSInstruction.class, TestPSHUInstruction.class, TestPULSInstruction.class, TestPULUInstruction.class, TestROLAInstruction.class, TestROLBInstruction.class, TestROLInstruction.class, TestRORAInstruction.class, TestRORBInstruction.class, TestRORInstruction.class, TestRTIInstruction.class, TestRTSInstruction.class, TestSBCAInstruction.class, TestSBCBInstruction.class, TestSEXInstruction.class, TestSTAInstruction.class, TestSTBInstruction.class, TestSTDInstruction.class, TestSTSInstruction.class, TestSTUInstruction.class, TestSTXInstruction.class, TestSTYInstruction.class, TestSUBAInstruction.class, TestSUBBInstruction.class, TestSUBDInstruction.class, TestSWIInstruction.class, TestSWI2Instruction.class, TestSWI3Instruction.class, TestSYNCInstruction.class, TestTFRInstruction.class, TestTSTAInstruction.class, TestTSTBInstruction.class, SorekSamples.class })
@SuppressWarnings("all")
public class AssemblerParsingTest {
}
