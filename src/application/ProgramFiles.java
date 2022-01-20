package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entity.Product;

public class ProgramFiles {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();
		
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		
		boolean success = new  File(sourceFolderStr + "\\out").mkdir();
		
		String targetFileStr = sourceFolderStr + "\\out\\sumary.cvs";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr) ) ){
			
			String itemCvs = br.readLine();
			while(itemCvs != null) {
				
				String[] fields = itemCvs.split(", ");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quantity) );
				
				itemCvs = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr) ) ){
				
				for(Product item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.total() ) );
					bw.newLine();
				}
				System.out.println(targetFileStr + "\nCREATED! ");
				
			} catch (IOException e ) {
				System.out.println("Error writing file: " + e.getMessage() );
			}
			
		}catch(IOException e) {
			System.out.println("Error reading file: " + e.getMessage() );
		}
		
		sc.close();
	}
}	
