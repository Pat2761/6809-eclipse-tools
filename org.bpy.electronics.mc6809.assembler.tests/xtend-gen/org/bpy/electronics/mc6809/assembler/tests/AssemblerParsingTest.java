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
import org.bpy.electronics.mc6809.assembler.tests.samples.SorekSamples;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CheckNumberValidation.class, TestComment.class, TestBszDirective.class, TestEndDirective.class, TestEquDirective.class, TestFailDirective.class, TestFcbDirective.class, TestFccDirective.class, TestFdbDirective.class, TestFillDirective.class, TestNamDirective.class, TestOptDirective.class, TestOrgDirective.class, TestPagDirective.class, TestRegDirective.class, TestRmbDirective.class, TestSetDirective.class, TestSpcDirective.class, TestSetDirective.class, TestSetDPDirective.class, TestADCAInstruction.class, TestADDAInstruction.class, TestADDBInstruction.class, TestADDDInstruction.class, TestANDCCInstruction.class, TestANDAInstruction.class, TestANDBInstruction.class, TestASLAInstruction.class, TestASLBInstruction.class, TestASRInstruction.class, TestBCCInstruction.class, TestBCSInstruction.class, TestBEQInstruction.class, TestBGEInstruction.class, TestBGTInstruction.class, TestBHIInstruction.class, TestBHSInstruction.class, TestBITAInstruction.class, TestBITBInstruction.class, TestBLEInstruction.class, TestBLOInstruction.class, TestBLSInstruction.class, TestBLTInstruction.class, TestBMIInstruction.class, TestBNEInstruction.class, TestBPLInstruction.class, TestBRAInstruction.class, TestBRNInstruction.class, TestBSRInstruction.class, TestBVCInstruction.class, TestBVSInstruction.class, TestCLRAInstruction.class, TestCLRBInstruction.class, TestCLRInstruction.class, TestCMPAInstruction.class, TestCMPBInstruction.class, TestCMPDInstruction.class, TestCMPSInstruction.class, TestCMPUInstruction.class, TestCMPXInstruction.class, TestCOMAInstruction.class, TestCOMBInstruction.class, TestCOMInstruction.class, TestCWAIInstruction.class, TestDAAInstruction.class, TestDECAInstruction.class, TestDECBInstruction.class, TestDECInstruction.class, TestEORAInstruction.class, TestEORBInstruction.class, TestEXGInstruction.class, TestINCAInstruction.class, TestINCBInstruction.class, TestINCInstruction.class, TestJMPInstruction.class, TestJSRInstruction.class, TestLDAInstruction.class, TestLDBInstruction.class, TestLDDInstruction.class, TestLDSInstruction.class, TestLDUInstruction.class, TestLDXInstruction.class, TestLDYInstruction.class, TestLEASInstruction.class, TestLEAUInstruction.class, TestLEAXInstruction.class, TestLSLAInstruction.class, TestLSLBInstruction.class, TestLSLInstruction.class, SorekSamples.class })
@SuppressWarnings("all")
public class AssemblerParsingTest {
}
