package askhsh2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		try {
			 Scanner scan= new Scanner(System.in);
			 System.out.println("give name of file e.g. linear2.txt");
			 String name = scan.nextLine();
			String Text = new Scanner(new File(name)).useDelimiter("\\A").next();
			Text = Text.replaceAll("(?m)^[ \t]*\r?\n", "");
			Text = Text.replaceAll(" ","");
			String MinMax = Text.substring(0,3);
			String MinMax2;
			if(MinMax.toLowerCase().equals("min")) MinMax2 = "max";
			else MinMax2 = "min";
			String[] lines =  Text.split("\\n");
			int i=0;
			int count = 0;
			for(i=0;i<lines[2].length();i++) {
				if(lines[2].charAt(i) == ',') count++; //gia na dw to mege8os tou pinaka
			}
			int c[] = new int[count+1];
			for(i=0;i<count+1;i++) c[i] = 0;
			int start = 0;
			i=0;
			while(start<lines[2].length()-1) {//diavasma tou c
				int locationOfSymbol = start;
				boolean flag = false;
				while(locationOfSymbol<lines[2].length()-1 && flag == false) {
					if(lines[2].charAt(locationOfSymbol)== ',' ) flag = true;
					else locationOfSymbol++;
				}
				if(!Character.isDigit(lines[2].charAt(start))) c[i] = -Integer.parseInt(lines[2].substring(start + 1 , locationOfSymbol));
				else c[i] = Integer.parseInt(lines[2].substring(start , locationOfSymbol));
				i++;
				start = locationOfSymbol + 1;	
			}
			//for(i=0; i<c.length; i++) System.out.println(c[i]);
			
			int j=4;
			while(Character.isDigit(lines[j].charAt(0)) || lines[j].charAt(0) == '-') { //gia na dv ti mege8os 8a exei o  pinakas a
				j++;
			}
			int size = j - 4;
			j = 4;
			int a [][] = new int [size][count+1];
			while(Character.isDigit(lines[j].charAt(0)) || lines[j].charAt(0) == '-') {//diavasma tou a
				start = 0;
				i = 0;
				while(start<lines[j].length()-1) {
					int locationOfSymbol = start;
					boolean flag = false;
					while(locationOfSymbol < lines[j].length()-1 && flag == false ) {
						if(lines[j].charAt(locationOfSymbol)== ',' ) flag = true;
						else locationOfSymbol++;
						
					}
					if(!Character.isDigit(lines[j].charAt(start))) a[j-4][i] = -Integer.parseInt(lines[j].substring(start + 1 , locationOfSymbol));
					else a[j-4][i] = Integer.parseInt(lines[j].substring(start , locationOfSymbol));
					i++;
					start = locationOfSymbol + 1;	
				}
				j++;
			}
			/*for(i=0;i<size;i++)
				for(j=0;j<lines[2].length();j++)
					System.out.println(a[i][j]);*/
			start = j + 1;
			j=j+1;
			while(Character.isDigit(lines[j].charAt(0)) || lines[j].charAt(0) == '-') {//ypologismos tou equin
				j++;
			}
			int Equin[] = new int [j-start];
			i = 0;
			while(start<j) {
				Equin[i] = Integer.parseInt(lines[start].substring(0, lines[start].length()-1));
				start++;
				i++;
			}
			//for(i=0;i<Equin.length;i++) System.out.println(Equin[i]);
			int b [] = new int [Equin.length];
			j=0;
			for(i = start+1;i<Equin.length+start+1;i++) {
				b[j] = Integer.parseInt(lines[i].substring(0, lines[i].length()-1));
				j++;
			}
			//for(i=0;i<b.length;i++) System.out.println(b[i]);
			
			int c2[] = new int [b.length] ;
			c2 = b;
			int b2[] = new int [c.length] ;
			b2 = c;
			int Equin2[] = new int [Equin.length];
			for(i=0;i<Equin.length;i++) {
				 Equin2[i] = -1;
				
			}
			
			 File fout = new File("output.txt");
			 FileOutputStream fos = new FileOutputStream(fout);
			 
			 BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(fos));
			 pw.write(MinMax2);
			 pw.newLine();
			 pw.newLine();
			 pw.write("c");
			 pw.newLine();
			 for ( i = 0; i < c2.length; i++) {
				 pw.write(Integer.toString(c2[i]));
				 pw.write(",");
			 }
			 pw.newLine();
			 pw.newLine();
			 pw.write("a");
			
			 for(i=0; i<count+1; i++) {	 
				 pw.newLine();
				 for( j = 0; j<Equin2.length; j++ ) {
					 pw.write(Integer.toString(a[j][i]));
					 pw.write(",");
				 }
			 }
			 pw.newLine();
			 pw.newLine();
			 pw.write("Equin");
			 pw.newLine();
			 for(i = 0; i <Equin2.length;i++) {
				 pw.write(Integer.toString(Equin2[i]));
				 pw.newLine();
			 }
			 
			 pw.newLine();
			 pw.newLine();
			 pw.write("b");
			 pw.newLine();
			 for(i=0;i<b2.length;i++) {
				 pw.write(Integer.toString(b2[i]));
				 pw.newLine();
			 }
					 
			 
			 pw.close();
			 System.out.println("output.txt created");
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
