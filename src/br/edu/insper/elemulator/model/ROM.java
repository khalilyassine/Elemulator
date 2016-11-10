package br.edu.insper.elemulator.model;
public class ROM {
	private Register[] rom;
	
	public ROM () {
		this.rom = new Register[32768];
	}
	
	
	public void setSelectedInstruction(boolean[] instruction, int index) {
		this.rom[index] = new Register();
		this.rom[index].loadRegister(instruction, true);
	}
	
	public boolean[] getSelectedInstruction(int index) {
		return this.rom[index].getRegister();
	}
}
