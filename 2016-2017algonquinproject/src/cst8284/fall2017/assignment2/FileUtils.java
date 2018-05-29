package cst8284.fall2017.assignment2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.Menu;

public class FileUtils {

	public static boolean fileExists(File f) {
		return (f != null && f.exists() && f.isFile() && f.canRead() && (f.length()>2));
	}

	public static boolean fileExists(String s) {
		return (fileExists(new File(s)));
	}

	public static ArrayList<String> getURLsFromFile(String fileName) {
		ArrayList<String> al = new ArrayList<>();
		try {
			File f = new File(fileName);
			Scanner URLString = new Scanner(f);
			while (URLString.hasNext())
				al.add(URLString.next());
			URLString.close();
		} catch (FileNotFoundException e) {
		}
		return al;
	}

	public static File storeURLsToFile(ArrayList<String> al, String fileName) {
		File f = new File(fileName);
		if (FileUtils.fileExists(f)) f.delete();  // remove old bookmarks file
		try {
			PrintWriter pw = new PrintWriter(f);
			for (String s : al)	pw.println(s);
			pw.flush(); pw.close();
		} catch (FileNotFoundException e) {	}
		return f;
	}
	
	//the method which get the arraylist and remove the requested row and save to the file
	public static File removeURLFromFile(String fileName,String url, Menu mnu) {
		
		ArrayList<String> theList = getURLsFromFile(fileName);
		for (int i =0;i<theList.size();i++) {
			String temp = theList.get(i);
			if(temp.equals(url)) {
				//System.out.println(theList.get(i));
				//System.out.println("mnu"+mnu.getItems().size());
				
				theList.remove(i);
			}
		}
		Menus.setBookmarks(theList);

		File f = storeURLsToFile(theList,fileName);
		return f;
		
	}

}
