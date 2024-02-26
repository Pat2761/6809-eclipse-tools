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
package org.bpy.electronics.mc6809.assembler.ui.outline;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

/**
 * Add filter on macro line line
 */
public class FilterMacroContribution extends AbstractFilterOutlineContribution {

	/** preference key for filter */
	public static final String PREFERENCE_KEY = "ui.outline.filterSpecials";
	
	@Override
	protected boolean apply(IOutlineNode node) {
		return !(node instanceof EObjectNode)
		        || !((EObjectNode) node).getEClass()
		          .equals(AssemblerPackage.Literals.SPECIAL_FUNCTIONS);
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

	@Override
	protected void configureAction(Action action) {
		action.setText("Specials");
	    action.setDescription("Specials");
	    action.setToolTipText("Specials");
		ImageDescriptor crossedIcon = AbstractUIPlugin.imageDescriptorFromPlugin("org.bpy.electronics.mc6809.assembler.ui", "icons/M-gold.16-Crossed.png");
	    action.setImageDescriptor(crossedIcon);
	}
}
