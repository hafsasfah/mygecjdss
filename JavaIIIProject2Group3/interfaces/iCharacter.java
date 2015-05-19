import javax.swing.JPanel;


public interface iCharacter {
	
	String getCharName();
	int getStrength();
	int getIntelligence();
	int getDexterity();
	int getHitPoints();
	boolean isAlive();
	String attack( iCharacter target );
	iItem getWeapon();
	iItem getArmor();
	JPanel getPanel();
	
	
	//public void pickUpItem(String item);
	//public void drinkPotion(double potion);
	//public void addArmor(double armor);
	public Character createCharacter();
	public int[] getCharLocation();
	
	// Movement methods
	public void generateMvmtUp();
	public void generateMvmtDown();
	public void generateMvmtLeft();
	public void generateMvmtRight();
	public String getCharLocationString();
	
}

