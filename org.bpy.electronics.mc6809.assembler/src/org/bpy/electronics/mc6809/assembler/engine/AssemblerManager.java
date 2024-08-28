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
package org.bpy.electronics.mc6809.assembler.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.bpy.electronics.mc6809.assembler.AssemblerStandaloneSetup;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.eclipse.core.resources.IFile;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * manager of assembly resources.
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblerManager {

	/** collection of assembly resources */
	private Map<Model, AssemblerEngine> engines;
	
	/** instance on the assembler manager */
	private static AssemblerManager instance;

	/** Caret Listener */
	private CaretListener caretListener;

	 @Inject
    private IParser parser;
	 
	/**
	 * Constructor of the class
	 */
	private AssemblerManager() {
      Injector injector = new AssemblerStandaloneSetup().createInjectorAndDoEMFRegistration();
      injector.injectMembers(this);
		
		engines = new HashMap<>();
		initializeListener();
	}
	
	/** 
	 * Initialize the listener needed by this view. 
	 */
	private void initializeListener() {
		caretListener = event -> manageEditorModification();
		
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(new IPartListener() {

			@Override
			public void partOpened(IWorkbenchPart part) {

				IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				//assembleCurrent
				if (currentEditor != null) {
					Control control = currentEditor.getAdapter(Control.class);
					if (control instanceof StyledText text) {
						text.addCaretListener(caretListener);
					}
				}
			}

			@Override
			public void partDeactivated(IWorkbenchPart part) {
				// nothing to do
			}

			@Override
			public void partClosed(IWorkbenchPart part) {
				IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if (currentEditor != null) {
					Control control = currentEditor.getAdapter(Control.class);
					if (control instanceof StyledText text) {
						text.removeCaretListener(caretListener);
					}
				}
			}

			@Override
			public void partBroughtToTop(IWorkbenchPart part) {
			}

			@Override
			public void partActivated(IWorkbenchPart part) {
			}
		});
	}
	
	private void manageEditorModification() {
		System.out.println("BPY:AssemblerManger:partOpened");
		IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if ((currentEditor instanceof XtextEditor xtextEditor) &&
			 ("org.bpy.electronics.mc6809.assembler.Assembler".equals(xtextEditor.getLanguageName())))  {
			System.out.println(currentEditor);
		}
	}

	/**
	 * Get the instance on the assembler manager.
	 * 
	 * @return instance on the assembler manager.
	 */
	public static AssemblerManager getInstance() {
		if (instance == null) {
			instance = new AssemblerManager();
		}
		return instance;
	}

	public AssemblerEngine getAssemblyModel(IFile assemblyFile) {
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(assemblyFile.getLocation().toOSString())));
			IParseResult parsingResult = parser.parse(reader);
			AssemblerEngine engine = new AssemblerEngine();
			Model model = (Model)parsingResult.getRootNode().getSemanticElement();
			engine.engine(model);
			engines.put(model, engine);
			return engine;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param model reference on the model
	 * @param forceAssembly <b>true</b> force assembly, <b>false</b> otherwise
	 * 
	 * @return reference on the assembly result
	 */
	public AssemblerEngine getAssemblyModel(Model model, boolean forceAssembly) {
		AssemblerEngine assemblerEngine = null; 
		if (engines.containsKey(model)) {
			 assemblerEngine = engines.get(model);
		} else {
			assemblerEngine = new AssemblerEngine();
			assemblerEngine.engine(model);
			engines.put(model, assemblerEngine);
			return assemblerEngine;
		}
		
		if (forceAssembly) {
			assemblerEngine.engine(model);
		}
		return assemblerEngine;
	}
}
