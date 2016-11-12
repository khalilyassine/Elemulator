package br.edu.insper.elemulator.model;

public class ProgramCounter extends Register{
	private int count = 0;
	
	public void execute (boolean reset) {
		if (reset) reset();
		else {
			System.out.println("add+1 no program counter");
			count++;
			String temp = Integer.toBinaryString(count);
			for (int i = temp.length()-1; i>=0;i--) {
	    		if (temp.charAt(Math.abs(i-(temp.length()-1)))=='0') register[i] = false;
	    		else if (temp.charAt(Math.abs(i-(temp.length()-1)))=='1') register[i] = true;
	    		}
		}
	}
	
	private void reset () {
		for  (int i = 0; i<= register.length; i++) {
			register[i] = false;
		}
	}
	
	public int getCount() {
		return this.count;
	}
}
