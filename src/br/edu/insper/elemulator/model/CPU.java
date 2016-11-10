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
	}
	
	public void execute (boolean[] inM, boolean[] instruction, boolean reset) {
		id.execute(instruction, alu.getZr(), alu.getNg());
		registerA.loadRegister(mux.execute(instruction, alu.getOut(), id.isMuxIOsel()), id.isLoadA());
		alu.execute(mux.execute(inM, registerA.getRegister(), id.isMuxAMsel()), registerD.getRegister(), id.isZx(), id.isNx(), id.isZy(), id.isNy(), id.isF(), id.isNo());
		registerD.loadRegister(alu.getOut(), id.isLoadD());
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
