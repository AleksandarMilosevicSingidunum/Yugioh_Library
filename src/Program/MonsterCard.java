package Program;

public class MonsterCard extends Card{
	
	
	public int Level;
	public int Attack;
	public int Defence;
	public MonsterCard(String name, String type, int level, String description, int attack,int defence, long serialNumber) {
		super(name, type, description, serialNumber);
		Level = level;
		Attack = attack;
		Defence = defence;
	}
	
	@Override
	public String toString() 
	{
		return Name +","+ Type + "," + Level +","+ Description +","+ Attack+","+Defence+","+SerialNumber;
		
	}
	@Override
	public String toString2() 
	{
		return "Monster Name: "+ Name+ "\n" +"Monster Type: " + Type + "\n" + "Monster Level: " + Level+ "\n" +"Monster Effect: "+ Description+ "\n" +"Monster Attack:"+ Attack+ "\n"+"Monster Defence: "+Defence+ "\n"+"Card Serial Number: "+ +SerialNumber + "\n";
		
	};
	

}
