package br.edu.insper.elemulator.model;

public class RAM {
	private Register[] ram;
	
	public RAM () {
		this.ram = new Register[32768];
	}
	
	public boolean[] getSelectedValue (boolean[] index) {
		int decIndex = booleanToInt(index);
		return this.ram[decIndex].getRegister();
	}

	public void setSelectedValue(boolean[] register, boolean[] index, boolean load) {
		int decIndex = booleanToInt(index);
		this.ram[decIndex].loadRegister(register, load);
	}
	
	public int booleanToInt(boolean[] a) {
		String s = "";
		for (int i = a.length-1; i>=0; i--) {
			if (a[i] == false) s+='0';
      	  	else if (a[i] == true) s+='1';
		}
		System.out.println(s);
		int decimal = Integer.parseInt(s, 2);
		return decimal;
	}
	
}
