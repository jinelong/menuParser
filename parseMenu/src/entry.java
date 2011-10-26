import java.util.ArrayList;


public class entry {
	
		public String name;
		public boolean isLunch;
		public ArrayList <String> dishes = new ArrayList<String>();
		
		public entry(String n, boolean lunch){
			
			isLunch = lunch;
			name = n;
		}
}
