import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * github addr:
 * 	
 * 
 */

public class parse {
	
	
	static ArrayList<entry> menu = new ArrayList<entry>();
	
	public static void main(String args[]){
		
		final String newStand = "<div id=\"mealStation\" class=\"meal\">";
		final String endStand = "</div>";
		final String newDish = "<li>";
		final String newDishEnd = "</li>";
		
		int counter = 0;
		
	  try{

		  FileInputStream fstream = new FileInputStream("menu1");
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  //Read File Line By Line
		  
		  int olde= 0;
		  int oldd = 0;
		  
		  boolean entryStart = false;
		  
		  while ((strLine = br.readLine()) != null)   {
			  counter ++;
	
			  String buffer = new String(strLine);
			  
			 int  s=buffer.indexOf(newStand, olde);
			 int ds = buffer.indexOf(newDish,olde);
			 
			 int e,de;
			 
			 while(s!=-1 && ds!=-1 || entryStart){
				// System.out.println(counter);
				 entryStart = true;
				 //System.out.println("s: "+ s + " ds: " + ds);
				 if(s<ds && s!=-1){
					 e=buffer.indexOf(endStand, s);
					 String standName = strLine.substring(s+newStand.length(), e);
					 
					 System.out.println(standName);
					 
					 olde = e+1;
					 s=buffer.indexOf(newStand, olde);
					 
				 }else if (s==-1 && ds != -1){
					 entryStart = false;
					 while(ds!=-1){
						 de=buffer.indexOf(newDishEnd, ds);
						 String dishName = strLine.substring(ds+newDish.length(), de);
						
						 System.out.println("\t"+dishName);
						 
						 oldd = de+1;
						 ds=buffer.indexOf(newDish, oldd);
					 }
					 
				 }//else if
				 else{
					 de=buffer.indexOf(newDishEnd, ds);
					 String dishName = strLine.substring(ds+newDish.length(), de);
					
					 System.out.println("\t"+dishName);
					 
					 oldd = de+1;
					 ds=buffer.indexOf(newDish, oldd);
					 
				 }
			 
			 }
			 olde = 0;
			 oldd= 0;
			 }//while
		  
			  //Close the input stream
			  in.close();
	   }catch (Exception e){//Catch exception if any
		   	System.err.println("Error: " + e.getMessage());
	
	   }
	  
	  System.out.println(counter);
	  
	  }//main
}
