package views;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;




public class PropertyView implements Observer 
{
	private GameController player;
	 
	
	
	   public static void main(String[] args) {
		   // creates watched and watcher objects
		   Property watched = new Property("Original Value");
		   	GameControlle
		   }	
		   
		   public void update(Observable obj, Object arg) {
		   System.out.println("Update Property "+arg);
		   }
		}



				public ArrayList<Property> getProperty()
				{
					return property;
				}

			public void initializingPropertyTest()
			{
				
				
				property = new ArrayList<Property>();
				
				Property bank = new Property(1,"BANK", 0);
				Property jail = new Property(2,"Jail", 1500);
				Property salon = new Property(3,"Salon", 40);
				Property partyStore = new Property(5,"Party Store", 12);
				Property playboyMansion = new Property(6,"Playboy Mansion", 800);
				Property localBar = new Property(7,"Local Bar", 25);
				
				
				Property operaHouse = new Property(8,"Opera House", 300);
				Property discoClub = new Property(9,"Disco Club", 200);
				Property hospital = new Property(10,"Hospital", 1000);
				Property halfwayHouse = new Property(11,"Halfway House", 70);
				Property dayCare = new Property(12,"Daycare", 60);
				Property policeStation = new Property(13,"Police Station", 900);
				Property burgerJoint = new Property(14,"Burger Joint", 10);
				
				
				
				property.add(bank);
				property.add(jail);
				property.add(salon);
				property.add(partyStore);
				property.add(playboyMansion);
				
				property.add(localBar);
				property.add(operaHouse);
				property.add(discoClub);
				property.add(hospital);
				
				property.add(halfwayHouse);
				property.add(dayCare);
				property.add(policeStation);
				property.add(burgerJoint);
				
				
				
				
			}
				
				   
	   
	   
	   
}
	
