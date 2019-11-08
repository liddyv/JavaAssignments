

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ConversionTextFile {

	ArrayList<Conversion> conversions = null;
	private String filename = "../HW/src/hw6_2/conversions.txt";
	File file = new File(filename);
	
	private Path conversionsPath = null;
	private File conversionsFile = null;
	private final String FIELD_SEP = "\t";
	/*
	FileInputStream fileIn = new FileInputStream("conversions.txt");
	BufferedInputStream bufferIn = new BufferedInputStream(fileIn);
	DataInputStream dataIn = new DataInputStream(bufferIn);
	
	DataInputStream in = new DataInputStream(
						 new BufferedInputStream(
						 new FileInputStream(filename)));
	
	*/
	ConversionTextFile() {
		// for Reader & Writer
		//countriesPath = Paths.get("src/countries.txt");
		conversionsPath = Paths.get("../HW/src/hw6_2/conversions.txt");
		conversionsFile = conversionsPath.toFile();
		// for InputStream & OutputStream
		file = new File(filename);
		
		conversions = this.getConversions();
	}
	
	Conversion get(String from) {
		for (Conversion c : conversions) {
			if (c.getFromUnit().equals(from)) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * This method reads an array list of Conversion object from a file 
	 * @return array list of Conversion objects
	 */
	ArrayList<Conversion> getConversions() {
		if (conversions != null) {
			return conversions;
		}
		
		conversions = new ArrayList<>();
		if (file.exists()) {
			try (DataInputStream in = new DataInputStream (
										  new BufferedInputStream (
										  new FileInputStream(file)))) {
				String line = in.readLine();
				while (line != null) {
					String[] fields = line.split(FIELD_SEP);
					String from = fields[0];
					String to = fields[1];
					String ratio = fields[2];
					
					Conversion c = new Conversion(from, to, Double.parseDouble(ratio));
					conversions.add(c);
					
					line = in.readLine();
					
			/*
			 * try (DataInputStream in =
					new DataInputStream(
	                new BufferedInputStream(
	                new FileInputStream(filename)))) {
	   File file = new File("C:/ReadFile.txt");
    FileInputStream fin = new FileInputStream(file);
    BufferedInputStream bin = new BufferedInputStream(fin);
			 */
				} // end while
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} // end try catch
		else {
				System.out.println(file.getAbsolutePath() + " doesn't exist.");
				file = new File(file.getAbsolutePath());
				
				// create a new file if input file doesn't already exist
				try {
					if (file.createNewFile()) {
						System.out.println(file.getAbsolutePath() + " file created");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
			return conversions; 
	} // end getConversions
	
	// 
	/**
	 * This method writes an array list of Conversion objects to a file
	 * @param typesList Array List of Conversion objects
	 * @return True if write to a file, otherwise return false
	 */
	boolean saveConversions(ArrayList<Conversion> typesList) {
		try (PrintWriter out = new PrintWriter(
				   new BufferedWriter(
				   new FileWriter(conversionsFile)))) {
			for (Conversion c : typesList) {
				out.print(c.toString()); // for PrintWriter
				//out.writeUTF(c); // for DataOutputStream
			}
			return true; 
		} catch (IOException e) {
			System.out.println(e);
			return false; 
		}
	}
	
	boolean add(Conversion c) {
		conversions.add(c);
		return this.saveConversions(conversions);
	}
	
	boolean delete(Conversion c) {
		conversions.remove(c);
		return this.saveConversions(conversions);
	}
	
	boolean update(Conversion newConversion) {
		// get the old conversion and remove it
		Conversion oldConversion = this.get(newConversion.getFromUnit());
		int i = conversions.indexOf(oldConversion);
		conversions.remove(i);
		
		// add the updated conversion
		conversions.add(i, newConversion);
		
		return this.saveConversions(conversions);
	}
}
