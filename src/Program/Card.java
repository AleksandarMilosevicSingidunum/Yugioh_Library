package Program;

public abstract class Card {
	public String Name;
	public String Type;
	public String Description;
	public long SerialNumber;
	public Card(String name, String type, String description, long serialNumber) {
		super();
		Name = name;
		Type = type;
		Description = description;
		SerialNumber = serialNumber;
	}

	public abstract String toString();
	
	public abstract String toString2();
}
