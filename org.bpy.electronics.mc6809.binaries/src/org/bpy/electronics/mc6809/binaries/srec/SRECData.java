package org.bpy.electronics.mc6809.binaries.srec;

public class SRECData {

	private String toolName;
	private int	startingAddresse;
	private int[] data;
	
	public SRECData() {
		toolName = "";
		startingAddresse = 0;
		data = new int[0];
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public int getStartingAddresse() {
		return startingAddresse;
	}

	public void setStartingAddresse(int startingAddresse) {
		this.startingAddresse = startingAddresse;
	}
	

}
