package com.carrie_reed.handson6;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class HandsOn {

	public static void main(String[] args) {
		
		// array
		String songs[] = {"Rock With You", "Smooth Criminal", "Wanna Be Startin' Something", "Thriller", "Beat It"};
		
		StringBuilder sb = new StringBuilder();
		
		//make sure the array contains data
		if(songs.length == 0 || songs == null) {
			throw new IllegalArgumentException("EMPTY");
		}
		else {
			for(int i = 0; i < songs.length; i++) {
				sb.append(songs[i] + ", ");
			}
			System.out.println(sb);
		}
		
		Scanner input = new Scanner(System.in);
		
		try {
			//create a new file
			File myFile = new File("songs.txt");
			if (myFile.createNewFile()) {
				System.out.println("File created " + myFile.getName());
			}
			else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			System.out.println("error creating file");
			e.printStackTrace();
		}
			
			try {
			//create a file writer
			FileWriter writer = new FileWriter("songs.txt");
			writer.append(sb);
			writer.close();
			System.out.println("Write Success");
			} catch (IOException e) {
				System.out.println("error writing to file");
			}
			
			//read from file
			try {
				File myFile = new File("songs.txt");
				Scanner myReader = new Scanner(myFile);
				while(myReader.hasNextLine()) {
					String data = myReader.nextLine();
					System.out.println(data);
			}
			} catch (FileNotFoundException e) {
				System.out.println("could not read file");
				e.printStackTrace();
			}
	}
}
