package br.edu.insper.elemulator.model;

public class Register {
	private boolean[] register;
	
	public Register() {
		this.register = new boolean[16];
	}
	
	public boolean[] getRegister () {
		return this.register;
	}

	public void loadRegister(boolean[] register, boolean load) {
		if (load) {
			this.register = register;
		}
	}
}
