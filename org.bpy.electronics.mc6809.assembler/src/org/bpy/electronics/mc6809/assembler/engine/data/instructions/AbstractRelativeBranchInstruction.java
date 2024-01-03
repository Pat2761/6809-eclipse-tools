package org.bpy.electronics.mc6809.assembler.engine.data.instructions;

import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerWarningDescription;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class AbstractRelativeBranchInstruction extends AbstractInstructionAssemblyLine {

	public static final int BYTE_MODE = 0;
	public static final int WORD_MODE = 1;
	
	abstract protected Object getLocalInstruction();
	
	public void computeOperand(int targetPcAddress, int mode, EStructuralFeature eReference) {
		int offset;
		int currentAddress = pcAddress+2;
		if (mode == WORD_MODE) {
			currentAddress = pcAddress+4;
		}
		
		if (targetPcAddress >= currentAddress) {
			offset = targetPcAddress-currentAddress; 
		} else {
			offset = (currentAddress-targetPcAddress)*(-1); 
		}

		if (mode == BYTE_MODE) {
			if (offset<-128 || offset>127) {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Overflow error, you should use long branch",
						eReference,
						OVERFLOW_ERROR);
				AssemblerErrorManager.getInstance().addProblem(getLocalInstruction(), problemDescription );
				opcodeBytes[0] = 0x3F;
				operandBytes = new int[] {0xFF};
			} else {
				operandBytes = new int[] {offset & 0xFF};
			}
			
		} else {
				
			if (offset>-129 && offset<128) {
				AssemblerWarningDescription warningDescription = new AssemblerWarningDescription("You can use a short branch",
						eReference,
						RELATIVE_SHORT_BRANCH);
				AssemblerErrorManager.getInstance().addWarning(getLocalInstruction(), warningDescription );
			}
			operandBytes = new int[] {(offset>>8) & 0xFF  , offset & 0xFF};
		}
	}
}
