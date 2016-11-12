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
	
	public boolean[] getSelectedInstruction(boolean[] index) {
		int decIndex = booleanToInt(index);
		return this.rom[decIndex].getRegister();
	}
	
	private int booleanToInt(boolean[] a) {
		String s = "";
		for (int i = a.length-1; i>=0; i--) {
			if (a[i] == false) s+='0';
      	  	else if (a[i] == true) s+='1';
		}
		int decimal = Integer.parseInt(s, 2);
		return decimal;
	}
}
