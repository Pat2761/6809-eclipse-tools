/*
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.ui.outline;

import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
public class AssemblerOutlineTreeProvider extends DefaultOutlineTreeProvider {

	@Override
	protected void _createChildren(DocumentRootNode parentNode, EObject modelElement) {

		if (modelElement instanceof Model) {
			
			for (SourceLine sourceLine : ((Model) modelElement).getSourceLines()) {
				EObject line = sourceLine.getLineContent();
				
				if (line instanceof InstructionLine) {
					
					String label = getLabel((InstructionLine)line);
					if (label != null) {
						createNode(parentNode, (InstructionLine)line);
					}
					
				} else if (sourceLine instanceof DirectiveLine) {
					
				}
			}
		}
	}

	private String getLabel(InstructionLine line) {
		if (line.getLabel()!= null && line.getLabel().getName() != null) {
			return line.getLabel().getName().getValue();
		} else {
			return null;
		}
	}

	public Object _text(Model model) {
		return "file";
	}

	public Object _text(InstructionLine instructionLine) {
		if ((instructionLine.getLabel() != null) && 
			(instructionLine.getLabel().getName() != null)	) {
			System.out.println(instructionLine.getLabel().getName().getValue());
			return instructionLine.getLabel().getName().getValue();
		} else {
			return "vide";
		}
	}
	
}
