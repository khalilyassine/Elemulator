package br.edu.insper.elemulator.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import br.edu.insper.elemulator.model.*;

public class MainController {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ROM rom = new ROM();
		RAM ram = new RAM();
		CPU cpu = new CPU();
		Scanner s = new Scanner(new File("teste2.txt"));
		int current_line = 0;
		
		while (s.hasNext()){
			rom.setSelectedInstruction(s.next(), current_line);
			current_line++;
		}
		s.close(); 
		
		
		int commands = 0;
		while (commands < 20) {
			//---------------------------------
			System.out.println("Instrução:");
			for (int i = 15; i>=0;i--) {
				if (rom.getSelectedInstruction(cpu.getPcOut())[i]) System.out.print("1");
				else System.out.print("0");
			}
			System.out.println("");
			//---------------------------------
			
			cpu.execute(ram.getSelectedValue(cpu.getAddressM()), rom.getSelectedInstruction(cpu.getPcOut()), false);
			ram.setSelectedValue(cpu.getOutM(), cpu.getAddressM(), cpu.isWriteM());
			
			System.out.println("");
			System.out.println("");
			commands++;
		}
	}
}
