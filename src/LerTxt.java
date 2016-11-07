import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;
 
public class LerTxt {
 
  public static void main(String[] args) throws IOException {
    
	  String line;
	  try (
	      InputStream fis = new FileInputStream("Elemulator.txt");
	      InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
	      BufferedReader br = new BufferedReader(isr);
	  ) {
	      while ((line = br.readLine()) != null) {
	          System.out.println(line);
	      }
	  }
}}
