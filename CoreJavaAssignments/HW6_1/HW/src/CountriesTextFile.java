

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {
	ArrayList<String> countries = null;
	// for Reader & Writer
	private Path countriesPath = null;
	private File countriesFile = null;
	private final String FIELD_SEP = "\t";
	// for InputStream & OutputStream
	private String filename = "../HW/src/hw6_1/countries.txt";
	// Testing create a new file if not already exist
	//private String filename = "../HW/src/hw6_1/countries.txt";
	File file = new File(filename);

	
	CountriesTextFile() {
		// for Reader & Writer
		//countriesPath = Paths.get("src/countries.txt");
		countriesPath = Paths.get("../HW/src/hw6_1/countries.txt");
		countriesFile = countriesPath.toFile();
		// for InputStream & OutputStream
		file = new File(filename);
		
		countries = this.getCountries();
	}
	
	@SuppressWarnings("deprecation")
	public ArrayList<String> getCountries() {
		// if the countries file has already been read, don't read it again
		if (countries != null) {
			return countries;
		}
		
		countries = new ArrayList<>();
		
		// for InputStream & OutputStream
		if (file.exists()) { 
			try (DataInputStream in = new DataInputStream (
					  new BufferedInputStream (
					  new FileInputStream(file)))) {

		/*
		// for Reader & Writer
		if(Files.exists(countriesPath)) { 
			try (BufferedReader in = new BufferedReader(
									 new FileReader(countriesFile))) {
		*/						 
				// read countries from file into array list
				String line = in.readLine();
				while (line != null) {
					String[] fields = line.split(FIELD_SEP);
					String country = fields[0];
					
					countries.add(country);
					
					line = in.readLine();
				} // end while
			} catch (IOException e) {
				System.out.println(e);
				return null;
			} // end try catch	
		}
		else {
			// for Reader & Writer
			//System.out.println(countriesPath.toAbsolutePath() + " doesn't exist.");
			
			// for InputStream & OutputStream
			System.out.println(file.getAbsolutePath() + " doesn't exist.");
			file = new File(file.getAbsolutePath());
			// Create a new file if input file NOT already exist
			try {
				if (file.createNewFile()) {
					System.out.println(file.getAbsoluteFile() + " file created"); 
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return countries; 

	} // end getCountries
	
	public boolean saveCountries(ArrayList<String> countries) {
		
		try (PrintWriter out = new PrintWriter(
							   new BufferedWriter(
							   new FileWriter(countriesFile)))) {
		
		/*
		try (DataOutputStream out = new DataOutputStream (
				new BufferedOutputStream(
				new FileOutputStream(file)))) { 
		 */
			// write all countries in the list to the file
			for (String c : countries) {
				out.println(c.toString()); // for PrintWriter
				//out.writeUTF(c); // for DataOutputStream
			}
			return true; 
		} catch (IOException e) {
			System.out.println(e);
			return false; 
		}
		
	}
	
	public boolean add(String country) {
		countries.add(country);
		return this.saveCountries(countries);
	}

}
