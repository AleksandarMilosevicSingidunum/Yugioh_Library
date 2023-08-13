package Program;

public class SpellCard extends Card{
	public String STType;

	public SpellCard(String name, String type, String sTType, String description, long serialNumber) {
		super(name, type, description, serialNumber);
		STType = sTType;
	}
	@Override
	public String toString() 
	{
		return Name +","+ Type +","+ STType+ "," + Description +","+SerialNumber;
		
	}
	@Override
	public String toString2() 
	{
		return "Card Name: "+ Name+ "\n" +"Card Type: " + Type + "\n" +"Spell Type: "+STType+"\n"+ "Spell Effect: "+ Description+ "\n" +"Card Serial Number: "+ +SerialNumber + "\n";
		
	};

}
