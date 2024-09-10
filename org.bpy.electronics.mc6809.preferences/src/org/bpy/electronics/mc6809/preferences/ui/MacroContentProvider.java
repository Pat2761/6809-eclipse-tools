package org.bpy.electronics.mc6809.preferences.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bpy.electronics.mc6809.preferences.ui.data.MacroInstructionData;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class MacroContentProvider implements IStructuredContentProvider  {

	private Map<String, MacroInstructionData> macroInstructionCollection;
	
	@Override
	public Object[] getElements(Object inputElement) {
		if (macroInstructionCollection != null) {
			MacroInstructionData[] macros = new MacroInstructionData[macroInstructionCollection.size()];
			
			List<String> keys = new ArrayList<>(macroInstructionCollection.keySet());
			for (int i=0 ; i<keys.size() ; i++) {
				macros[i] = macroInstructionCollection.get(keys.get(i));
			}
			return macros;
		}		
		return new MacroInstructionData[0];
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof Map)	 {
			macroInstructionCollection = (Map<String, MacroInstructionData>) newInput;
		}
	}
}
