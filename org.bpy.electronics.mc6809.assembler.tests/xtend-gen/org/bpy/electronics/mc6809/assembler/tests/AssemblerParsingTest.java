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

import org.bpy.electronics.mc6809.assembler.tests.language.CheckNumberValidation;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestBszDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestComment;
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
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestSetDPDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestSetDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.directives.TestSpcDirective;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestADCAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestADDAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestADDBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestADDDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestANDAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestANDBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestANDCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestASLAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestASLBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestASLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestASRAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestASRBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestASRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBCSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBEQInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBGEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBGTInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBHIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBHSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBITAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBITBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBLEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBLOInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBLSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBLTInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBMIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBNEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBPLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBRAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBRNInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBSRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBVCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestBVSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCLRAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCLRBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCLRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCMPAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCMPBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCMPDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCMPSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCMPUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCMPXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCOMAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCOMBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCOMInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestCWAIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestDAAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestDECAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestDECBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestDECInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestEORAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestEORBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestEXGInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestINCAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestINCBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestINCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestJMPInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestJSRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBCSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBEQInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBGEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBGTInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBHIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBHSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBLEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBLOInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBLSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBLTInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBMIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBNEInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBPLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBRAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBRNInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBSRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBVCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLBVSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLDAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLDBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLDDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLDSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLDUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLDXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLDYInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLEASInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLEAUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLEAXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLSLAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLSLBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLSLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLSRAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLSRBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestLSRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestMULInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestNEGAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestNEGBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestNOPInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestORAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestORBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestORCCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestPSHSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestPSHUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestPULSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestPULUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestROLAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestROLBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestROLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestRORAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestRORBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestRORInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestRTIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestRTSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSBCAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSBCBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSEXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSTAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSTBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSTDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSTSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSTUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSTXInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSTYInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSUBAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSUBBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSUBDInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSWI2Instruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSWI3Instruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSWIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestSYNCInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestTFRInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestTSTAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestTSTBInstruction;
import org.bpy.electronics.mc6809.assembler.tests.language.instructions.TestTSTInstruction;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CheckNumberValidation.class, TestComment.class, TestBszDirective.class, TestEndDirective.class, TestEquDirective.class, TestFailDirective.class, TestFcbDirective.class, TestFccDirective.class, TestFdbDirective.class, TestFillDirective.class, TestNamDirective.class, TestOptDirective.class, TestOrgDirective.class, TestPagDirective.class, TestRegDirective.class, TestRmbDirective.class, TestSetDirective.class, TestSpcDirective.class, TestSetDPDirective.class, TestADCAInstruction.class, TestADDAInstruction.class, TestADDBInstruction.class, TestADDDInstruction.class, TestANDCCInstruction.class, TestANDAInstruction.class, TestANDBInstruction.class, TestASLAInstruction.class, TestASLBInstruction.class, TestASLInstruction.class, TestASRAInstruction.class, TestASRBInstruction.class, TestASRInstruction.class, TestBCCInstruction.class, TestLBCCInstruction.class, TestBCSInstruction.class, TestLBCSInstruction.class, TestBEQInstruction.class, TestLBEQInstruction.class, TestBGEInstruction.class, TestLBGEInstruction.class, TestBGTInstruction.class, TestLBGTInstruction.class, TestBHIInstruction.class, TestLBHIInstruction.class, TestBHSInstruction.class, TestLBHSInstruction.class, TestBITAInstruction.class, TestBITBInstruction.class, TestBLEInstruction.class, TestLBLEInstruction.class, TestBLOInstruction.class, TestLBLOInstruction.class, TestBLSInstruction.class, TestLBLSInstruction.class, TestBLTInstruction.class, TestLBLTInstruction.class, TestBMIInstruction.class, TestLBMIInstruction.class, TestBNEInstruction.class, TestLBNEInstruction.class, TestBPLInstruction.class, TestLBPLInstruction.class, TestBRAInstruction.class, TestLBRAInstruction.class, TestBRNInstruction.class, TestLBRNInstruction.class, TestBSRInstruction.class, TestLBSRInstruction.class, TestBVCInstruction.class, TestLBVCInstruction.class, TestBVSInstruction.class, TestLBVSInstruction.class, TestCLRAInstruction.class, TestCLRBInstruction.class, TestCLRInstruction.class, TestCMPAInstruction.class, TestCMPBInstruction.class, TestCMPDInstruction.class, TestCMPSInstruction.class, TestCMPUInstruction.class, TestCMPXInstruction.class, TestCOMAInstruction.class, TestCOMBInstruction.class, TestCOMInstruction.class, TestCWAIInstruction.class, TestDAAInstruction.class, TestDECAInstruction.class, TestDECBInstruction.class, TestDECInstruction.class, TestEORAInstruction.class, TestEORBInstruction.class, TestEXGInstruction.class, TestINCAInstruction.class, TestINCBInstruction.class, TestINCInstruction.class, TestJMPInstruction.class, TestJSRInstruction.class, TestLDAInstruction.class, TestLDBInstruction.class, TestLDDInstruction.class, TestLDSInstruction.class, TestLDUInstruction.class, TestLDXInstruction.class, TestLDYInstruction.class, TestLEASInstruction.class, TestLEAUInstruction.class, TestLEAXInstruction.class, TestLSLAInstruction.class, TestLSLBInstruction.class, TestLSLInstruction.class, TestLSRAInstruction.class, TestLSRBInstruction.class, TestLSRInstruction.class, TestMULInstruction.class, TestNEGAInstruction.class, TestNEGBInstruction.class, TestNOPInstruction.class, TestORAInstruction.class, TestORBInstruction.class, TestORCCInstruction.class, TestPSHSInstruction.class, TestPSHUInstruction.class, TestPULSInstruction.class, TestPULUInstruction.class, TestROLAInstruction.class, TestROLBInstruction.class, TestROLInstruction.class, TestRORAInstruction.class, TestRORBInstruction.class, TestRORInstruction.class, TestRTIInstruction.class, TestRTSInstruction.class, TestSBCAInstruction.class, TestSBCBInstruction.class, TestSEXInstruction.class, TestSTAInstruction.class, TestSTBInstruction.class, TestSTDInstruction.class, TestSTSInstruction.class, TestSTUInstruction.class, TestSTXInstruction.class, TestSTYInstruction.class, TestSUBAInstruction.class, TestSUBBInstruction.class, TestSUBDInstruction.class, TestSWIInstruction.class, TestSWI2Instruction.class, TestSWI3Instruction.class, TestSYNCInstruction.class, TestTFRInstruction.class, TestTSTAInstruction.class, TestTSTBInstruction.class, TestTSTInstruction.class })
@SuppressWarnings("all")
public class AssemblerParsingTest {
}
