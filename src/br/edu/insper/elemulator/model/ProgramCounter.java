package br.edu.insper.elemulator.model;

public class ProgramCounter{
	private int count = 0;
	private boolean[] register;
	
	public ProgramCounter() {
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
	
	public void execute (boolean reset) {
		if (reset) reset();
		else {
			count++;
			String temp = Integer.toBinaryString(count);
			for (int i = temp.length()-1; i>=0;i--) {
	    		if (temp.charAt(Math.abs(i-(temp.length()-1)))=='0') register[i] = false;
	    		else if (temp.charAt(Math.abs(i-(temp.length()-1)))=='1') register[i] = true;
	    		}
		}
	}
	
	private void reset () {
		/*for  (int i = 0; i<= register.length; i++) {
			register[i] = false;
		}*/
	}
	
	public int getCount() {
		return this.count;
	}
}
