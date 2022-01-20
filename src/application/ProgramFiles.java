package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

public class ProgramFiles {

	public static void main(String[] args) {
		
		String path = "C:\\temp\\origin\\sale.cvs";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path) ) ){
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage() );
		}
		
		boolean success = new File("C:\\temp\\origin\\out").mkdir();
		System.out.println("Directory created Sucessfully: ");
		
	}
}