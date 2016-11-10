package br.edu.insper.elemulator.model;

public class RAM {
	private Register[] ram;
	
	public RAM () {
		this.ram = new Register[32768];
	}
	
	public boolean[] getSelectedValue (int index) {
		return this.ram[index].getRegister();
	}

	public void setSelectedValue(boolean[] register, int index, boolean load) {
		this.ram[index].loadRegister(register, load);
	}
	
}
