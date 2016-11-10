package br.edu.insper.elemulator.model;

public class ProgramCounter extends Register{
	private int count = 0;
	
	public void execute (boolean reset) {
		if (reset) reset();
		else count++;
	}
	
	public void reset () {
		for  (int i = 0; i<= register.length; i++) {
			register[i] = false;
		}
	}
	
	public int getCount() {
		return this.count;
	}
}
