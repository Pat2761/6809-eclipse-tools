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
package org.bpy.electronics.mc6809.assembler.engine.data.comment;

import org.bpy.electronics.mc6809.assembler.assembler.CommentLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;

public class AssembledCommentLine extends AbstractAssemblyLine {
	
	private String comment;
	private boolean isSpaceBefore;
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public boolean isSpaceBefore() {
		return isSpaceBefore;
	}
	
	public void setSpaceBefore(boolean isSpaceBefore) {
		this.isSpaceBefore = isSpaceBefore;
	}

	public void parse(CommentLine commentLine, int currentPcValue, int lineNumber) {
		this.lineNumber = lineNumber;
		pcAddress = currentPcValue;
		comment = commentLine.getComment();
		isSpaceBefore =commentLine.getStartingSpace()!= null;
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}
}
