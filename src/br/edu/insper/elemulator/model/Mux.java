package br.edu.insper.elemulator.model;

public class Mux {
	public boolean[] execute (boolean[] a, boolean[] b, boolean load) {
		if(load) { //checar ordem
			return a;
		}
		
		else {
			return  b;
		}
	}
}
