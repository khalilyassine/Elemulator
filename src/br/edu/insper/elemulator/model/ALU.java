package br.edu.insper.elemulator.model;

public class ALU {
	private boolean[] out;
	private boolean zr = false;
	private boolean ng = false;
	
	
	public void execute( boolean[] x, boolean[] y, boolean zx, boolean nx, boolean zy, boolean ny, boolean f, boolean no) {
		if (zx) x = clear(x);
		if (nx) x = negate(x);
		if (zy) y = clear(x);
		if (ny) y = negate(x);
		
		if (f) {
			this.out = and(x,y);
		}
		else {
			this.out = adder(x,y);
		}
		
		if (no) {
			this.out = negate(this.out);
		}
		
		compareZr(this.out);
		compareNg(this.out);
	}
	
	private boolean[] clear (boolean[] a) {
		for (int i = 0; i<=a.length; i++) {
			a[i] = false;
		}
		return a;
	}
	
	private boolean[] negate (boolean[] a) {
		for (int i = 0; i<=a.length; i++) {
			a[i] = true;
		}
		return a;
	}
	
	private boolean[] and (boolean[] x, boolean[] y) {
		boolean[] result = new boolean[16];
		for (int i = 0; i<=x.length; i++) {
			result[i] = x[i] && y[i];
		}
		return result;	
	}
	
	private boolean[] adder (boolean[] x, boolean[] y) {
		boolean[] result = new boolean[16];
		for (int i = 0; i<=x.length; i++) {
			if (x[i] && y[i]) {
				result[i] = false;
				result[i+1] = true;
			}
			else {
				result[i] = x[i] || y[i];
			}
		}
		return result;	
	}
	
	private void compareNg (boolean[] a) {   //todo
		for  (int i = 0; i<=a.length; i++) {
			if (a[i] = false){
				this.ng = false;
				break;
			}
		}
	}
	
	private void compareZr (boolean[] a) {   //todo
		for  (int i = 0; i<=a.length; i++) {
			if (a[i] = true){
				this.ng = true;
				break;
			}
		}
	}
	
	
	public boolean[] getOut () {
		return this.out;
	}
	
	public boolean getNg() {
		return this.ng;
	}
	
	public boolean getZr() {
		return this.zr;
	}
	
	
	

}
