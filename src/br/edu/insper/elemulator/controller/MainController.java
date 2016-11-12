package br.edu.insper.elemulator.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.edu.insper.elemulator.model.*;

public class MainController {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ROM rom = new ROM();
		RAM ram = new RAM();
		CPU cpu = new CPU();
		
		boolean[] i0 = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
		boolean[] i1 = new boolean[]{false,false,false,false,true,false,false,false,false,false,true,true,true,true,true,true};
		boolean[] i2 = new boolean[]{true,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false};
		boolean[] i3 = new boolean[]{false,false,false,true,false,false,false,true,false,false,false,false,false,true,true,true};
		rom.setSelectedInstruction(i0, 0);
		rom.setSelectedInstruction(i1, 1);
		rom.setSelectedInstruction(i2, 2);
		rom.setSelectedInstruction(i3, 3);
		
		boolean check = true;
		while (check) {
			System.out.println("instrucao:");
			for (int i = 15; i>=0;i--) {
				if (rom.getSelectedInstruction(cpu.getPcOut())[i]) System.out.print("1");
				else System.out.print("0");
			}
			
			System.out.println("");
			
			cpu.execute(ram.getSelectedValue(cpu.getAddressM()), rom.getSelectedInstruction(cpu.getPcOut()), false);
			ram.setSelectedValue(cpu.getOutM(), cpu.getAddressM(), cpu.isWriteM());
			
			System.out.println("");
			
			if (cpu.isWriteM()) {
				for (int j = 15; j>=0;j--) {
					if (ram.getSelectedValue(cpu.getAddressM())[j]) System.out.print("1");
					else System.out.print("0");
				}
			}
			
			System.out.println("rodoua");
			}
		
	}
}
