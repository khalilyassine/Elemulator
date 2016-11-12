package br.edu.insper.elemulator.model;

public class CPU {
	
	private boolean[] outM, addressM, pcOut; //outs
	private boolean writeM; //outs
	private ALU alu;
	
	private Register registerA, registerD;
	private ProgramCounter pc;
	private InstruDec id;
	private Mux mux;
	
	public CPU () {
		this.alu = new ALU();
		this.id = new InstruDec();
		this.registerA = new Register();
		this.registerD = new Register();
		this.mux = new Mux();
		this.pc = new ProgramCounter();
		
		this.addressM = registerA.getRegister();
		this.pcOut = pc.getRegister();
		this.writeM = id.isLoadM();
		this.outM = alu.getOut();
	}
	
	public void execute (boolean[] inM, boolean[] instruction, boolean reset) {
		System.out.println("executando id");
		id.execute(instruction, alu.getZr(), alu.getNg());
		System.out.println("executando rega");
		System.out.print("valor no rega sendo que ");
		registerA.loadRegister(mux.execute(alu.getOut(), instruction, id.isMuxIOsel()), id.isLoadA());
		for (int i = 15; i>=0;i--) {
			if (registerA.getRegister()[i]) System.out.print("1");
			else System.out.print("0");
		}
		System.out.println("");
		System.out.println("executando alu");
		alu.execute (registerD.getRegister(), mux.execute(inM, registerA.getRegister(), id.isMuxAMsel()), id.isZx(), id.isNx(), id.isZy(), id.isNy(), id.isF(), id.isNo());
		System.out.println("executando regd");
		System.out.println("valor no regd:");
		registerD.loadRegister(alu.getOut(), id.isLoadD());
		for (int i = 15; i>=0;i--) {
			if (registerA.getRegister()[i]) System.out.print("1");
			else System.out.print("0");
		}
		System.out.println("");
		System.out.println("exeutando pc");
		pc.execute(reset);
		pc.loadRegister(registerA.getRegister(), id.isLoadPC());
		
		this.addressM = registerA.getRegister();
		this.outM = alu.getOut();
		this.writeM = id.isLoadM();
		this.pcOut = pc.getRegister();
	}

	public boolean[] getOutM() {
		return outM;
	}

	public boolean[] getAddressM() {
		return addressM;
	}

	public boolean[] getPcOut() {
		return pcOut;
	}

	public boolean isWriteM() {
		return writeM;
	}	
}
