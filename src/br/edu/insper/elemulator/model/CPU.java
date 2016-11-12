package br.edu.insper.elemulator.model;

public class CPU {
	
	private boolean[] outM, addressM, pcOut, muxAM; //outs
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
		id.execute(instruction, alu.getZr(), alu.getNg());
		registerA.loadRegister(mux.execute(alu.getOut(), instruction, id.isMuxIOsel()), id.isLoadA());
		
		//---------------------------------
		System.out.println("valor do REG-A:");
		for (int i = 15; i>=0;i--) {
			if (registerA.getRegister()[i]) System.out.print("1");
			else System.out.print("0");
		}
		System.out.println("");
		//---------------------------------
		
		muxAM = mux.execute(inM, registerA.getRegister(), id.isMuxAMsel());
		alu.execute (registerD.getRegister(), muxAM, id.isZx(), id.isNx(), id.isZy(), id.isNy(), id.isF(), id.isNo());
		
		//---------------------------------
				System.out.println("na saída da ALU:");
				for (int i = 15; i>=0;i--) {
					if (alu.getOut()[i]) System.out.print("1");
					else System.out.print("0");
				}
				System.out.println("");
				//---------------------------------
		registerD.loadRegister(alu.getOut(), id.isLoadD());
		
		//---------------------------------
		System.out.println("valor do REG-D:");
		for (int i = 15; i>=0;i--) {
			if (registerD.getRegister()[i]) System.out.print("1");
			else System.out.print("0");
		}
		System.out.println("");
		//---------------------------------
		
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
