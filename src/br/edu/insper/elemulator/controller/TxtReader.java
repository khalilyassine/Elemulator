package br.edu.insper.elemulator.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import br.edu.insper.elemulator.model.*;

public class TxtReader {
	ROM rom;
	
	public void sendToRom (ROM rom) throws FileNotFoundException, IOException {
		this.rom = rom;
		int line_index = 0;
		String line;
		boolean[] tempi= new boolean[16];
		
		try (
		    InputStream fis = new FileInputStream("Elemulator.txt");
		    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		    BufferedReader br = new BufferedReader(isr);
		  ) {
		      while ((line = br.readLine()) != null) {
		          for (int i = line.length()-1; i>=0;i--) {
		        	  if (line.charAt(Math.abs(i-(line.length()-1)))=='0') tempi[i] = false;
		        	  else if (line.charAt(Math.abs(i-(line.length()-1)))=='1') tempi[i] = true;
		          }
		          System.out.println(line);
		          System.out.println(line_index);
		          rom.setSelectedInstruction(tempi, line_index);
		          line_index++;
		      }
		}	
	}
}
