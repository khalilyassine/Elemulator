package br.edu.insper.elemulator.model;

public class Register {
	protected boolean[] register;
	
	public Register() {
		this.register = new boolean[16];
	}
	
	public boolean[] getRegister () {
		return this.register;
	}

	public void loadRegister(boolean[] register, boolean load) {
		if (load) {
			System.out.println("guardando boolean no reg");
			this.register = register;
		}
	}
}
