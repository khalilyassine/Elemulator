package br.edu.insper.elemulator.model;

public class ALU {
	private boolean[] out;
	private boolean zr = true;
	private boolean ng = true;

	public void execute(boolean[] x, boolean[] y, boolean zx, boolean nx, boolean zy, boolean ny, boolean f, boolean no) {
		
		if (zx) x = clear(x);
		if (nx) x = negate(x);
		if (zy) y = clear(y);
		if (ny) y = negate(y);

		if (f) {
			out = and(x,y);
		}
		
		else {
			out = adder(x,y);
		}
		
		if (no) {
			out = negate(out);;
		}
		
		compareZr(out);
		compareNg(out);
	}
	
	private boolean[] clear (boolean[] a) {
		for (int i = 0; i<a.length; i++) {
			a[i] = false;
		}
		return a;
	}
	
	private boolean[] negate (boolean[] a) {
		for (int i = 0; i<a.length; i++) {
			if (a[i]) a[i] = false;
			else a[i] = true;
		}
		return a;
	}
	
	private boolean[] and (boolean[] x, boolean[] y) {
		boolean[] result = new boolean[16];
		for (int i = 0; i<x.length; i++) {
			result[i] = x[i] && y[i];
		}
		return result;	
	}
	
	private boolean[] adder (boolean[] x, boolean[] y) {
		boolean[] result = new boolean[16];
		for (int i = 0; i<x.length; i++) {
			int count = 0;
			if (x[i]) count++;
			if (y[i]) count++;
			if (result[i]) count++;
			if (count == 0) result[i] = false;
			else if (count == 1) result[i] = true;
			else if (count == 2) {
				result[i] = false;
				if(i != 15) {
					result[i+1] = true;
				}
			}
			else if (count == 3) {
				result[i] = true;
				if(i != 15) {
					result[i+1] = true;
				}
			}	
		}
		return result;	
	}
	
	private void compareNg (boolean[] a) {   //todo
		for  (int i = 0; i<a.length; i++) {
			if (!a[i]){
				ng = false;
				break;
			}
		}
	}
	
	private void compareZr (boolean[] a) {
		for  (int i = 0; i<a.length; i++) {
			if (a[i]){
				zr = false;
				break;
			}
		}
	}
	
	public boolean[] getOut () {
		return out;
	}
	
	public boolean getNg() {
		return ng;
	}
	
	public boolean getZr() {
		return zr;
	}
}
