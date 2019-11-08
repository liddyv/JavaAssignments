

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/*  
 * @HomeWork #6-3: MusicArtistsApp.java
 * @Author: WanLing Hsieh
 * @Description: 
 * This app read xml file and display it's elements
 */
public class MusicArtistsApp {
	static String fileName = "../HW/src/hw6_3/music_artists.xml";
	
	public static void main (String[] args) {
		
		System.out.println("Artist and Album Listing");
		
		// print list of artists
		System.out.println("");
		System.out.println("Artists");
		System.out.println("-------");
		// print artist
		readArtists();
		
		System.out.println("");
		System.out.println("Albums");
		System.out.println("-------");
		// print Albums
		readAlbums();
		
		System.out.println("");
		System.out.println("Artists and Albums");
		System.out.println("------------------");
		// print Artists and Albums
		readArtistAlbums();
	}

	private static void readArtists() {
		
		try {
			ArrayList<String> list = new ArrayList<String>();			
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			
			FileReader fileReader = new FileReader(fileName);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
			while(reader.hasNext()) {
				int eventType = reader.getEventType();
				switch (eventType) {
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					if (elementName.equals("Name")) {
						String artist = reader.getElementText();
						list.add(artist);
					}
					break;
				default: 
					break;
				} // end switch
				reader.next();
			} // end while
			
			for (String s: list) {
				System.out.println(s);
			}		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void readAlbums() {
		
		try {
			ArrayList<String> list = new ArrayList<String>();			
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			
			FileReader fileReader = new FileReader(fileName);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
			while(reader.hasNext()) {
				int eventType = reader.getEventType();
				switch (eventType) {
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					if (elementName.equals("Album")) {
						String album = reader.getElementText();
						list.add(album);
					}
					break;
				default: 
					break;
				} // end switch
				reader.next();
			} // end while
			
			for (String s: list) {
				System.out.println(s);
			}		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private static void readArtistAlbums() {
		
		try {
			ArrayList<String> list = new ArrayList<String>();	
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			
			FileReader fileReader = new FileReader(fileName);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
			while(reader.hasNext()) {
				int eventType = reader.getEventType();
				switch (eventType) {
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					if (elementName.equals("Name")) {
						String artist = reader.getElementText();
						list.add(artist);
					}
					else if (elementName.equals("Album")) {
						String album = reader.getElementText();
						list.add("	" +album);
					}
					break;
				default: 
					break;
				} // end switch
				reader.next();
			} // end while
		
			for (String s: list) {
				System.out.println(s);
			}	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
