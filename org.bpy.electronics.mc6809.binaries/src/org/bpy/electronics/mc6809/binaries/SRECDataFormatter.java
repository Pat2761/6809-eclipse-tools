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
package org.bpy.electronics.mc6809.binaries;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AbstractAssembledDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledBszDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledEndDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFcbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFccDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFdbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFillDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledOrgDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledRmbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.ui.internal.AssemblerActivator;
import org.bpy.electronics.mc6809.binaries.srecord.SRECAddressType;
import org.bpy.electronics.mc6809.binaries.srecord.SRECData;
import org.bpy.electronics.mc6809.binaries.srecord.SRECWriter;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Injector;

/**
 * Create a data structure for the exportation of binaires data
 * 
 * @author Patrick BRIAND
 *
 */
public class SRECDataFormatter {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(SRECDataFormatter.class.getSimpleName());
	
	private SRECData data;

	private int startingAddress;

	private int currentAddress;

	/** Injector on the Game parser */
	private static final Injector injector = AssemblerActivator.getInstance().getInjector("org.bpy.electronics.mc6809.assembler.Assembler"); //$NON-NLS-1$

	public SRECDataFormatter() {
		// nothing to do
	}
	
	public void initiateSRECData(String toolchainName) {
		data = new SRECData();
		data.setToolName(toolchainName);
	}
	
	public void fillData(IFile fileToDo) throws IOException {
		IFolder folder = getOrCreateDocumentFolder(fileToDo);
		File srecFile = new File(folder.getLocation().toOSString(), fileToDo.getName().replace(".as9", "") + ".s19");
		
		XtextResourceSet resourceSet = (XtextResourceSet) injector.getInstance(XtextResourceSetProvider.class).get(fileToDo.getProject());
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.getResource(URI.createURI(fileToDo.getLocationURI().toString()), true);

		AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(fileToDo);

		startingAddress = 0;
		currentAddress = 0;
		extractInformation(engine);
		data.setStartingAddress(startingAddress, SRECAddressType.ADDRESS_16BITS);
		
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(srecFile));
		SRECWriter writer = new SRECWriter();
		writer.createSRECFile(fileWriter);
		writer.exportSRECData(data);
		writer.closeWriter();
	}

	private void extractInformation(AssemblerEngine engine) {
		for (AbstractAssemblyLine assemblyLine : engine.getAssembledLine()) {
			if (assemblyLine instanceof AbstractInstructionAssemblyLine assemblyInstruction) {
				fillDataFromInstruction(assemblyInstruction);

			} else if (assemblyLine instanceof AssembledOrgDirectiveLine orgDirective) {
				startingAddress = orgDirective.getPcAddress();

			} else if (assemblyLine instanceof AssembledEndDirectiveLine endDirective) {
				startingAddress = endDirective.getTargetAddress();
			
			} else if (assemblyLine instanceof AssembledBszDirectiveLine bszDirective) {
				fillDataFromInstruction(bszDirective.getValues());
			
			} else if (assemblyLine instanceof AssembledFcbDirectiveLine fcbDirective) {
				fillDataFromInstruction(fcbDirective.getValues());
			
			} else if (assemblyLine instanceof AssembledFccDirectiveLine fccDirective) {
				fillDataFromInstruction(fccDirective.getValues());
			
			} else if (assemblyLine instanceof AssembledFdbDirectiveLine fdbDirective) {
//				fillDataFromInstruction(fccDirective.getValues());
			
			} else if (assemblyLine instanceof AssembledFillDirectiveLine fillDirective) {
				fillDataFromInstruction(fillDirective.getValues());
			
			} else if (assemblyLine instanceof AssembledRmbDirectiveLine rmbDirective) {
//				fillDataFromInstruction(rmbDirective.get);
			
			}
		}
	}

	private void fillDataFromInstruction(int[] values) {
		byte[] code = new byte[values.length];
		int index = 0;
		for (int currentByte : values) {
			code[index++] =  (byte)(currentByte&0xFF);
		}
	}

	private void fillDataFromInstruction(AbstractInstructionAssemblyLine assemblyInstruction) {
		byte[] code = new byte[assemblyInstruction.getOpcode().length + assemblyInstruction.getOperand().length];
		int index = 0;
		for (int currentByte : assemblyInstruction.getOpcode()) {
			code[index++] =  (byte)(currentByte&0xFF);
		}
		for (int currentByte : assemblyInstruction.getOperand()) {
			code[index++] =  (byte)(currentByte&0xFF);
		}
		
		data.addData(code, assemblyInstruction.getPcAddress(), SRECAddressType.ADDRESS_16BITS);
	}

	/**
	 * Retrieve or create a document folder in the project.
	 * 
	 * @param fileToDo reference on the file in the project
	 * @return reference on the document folder
	 */
	private IFolder getOrCreateDocumentFolder(IFile fileToDo) {
		IProject project = fileToDo.getProject();
		IFolder folder = project.getFolder("bin");
		if (!folder.exists()) {
			try {
				folder.create(true, true, new NullProgressMonitor());
			} catch (CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
		return folder;
	}

}
