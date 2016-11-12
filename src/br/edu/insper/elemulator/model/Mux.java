package br.edu.insper.elemulator.model;

public class Mux {
	public boolean[] execute (boolean[] a, boolean[] b, boolean load) {
		if(load) { //checar ordem
			System.out.println("mux escolheu primeiro parametro:");
			return a;
		}
		
		else {
			System.out.println("mux escolheu segundo parametro:");
			return  b;
		}
	}
}
