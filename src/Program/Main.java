package Program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
;public class Main implements MenuUI{
	public static void main(String[] args) {
		startProgram();
	}
	
	public static boolean writeToFile(String filename,String[] lines) //Write lines from writeCard method to file
	{
		try 
		{
			File file = new File(filename);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (String line : lines) 
			{
				writer.write(line);
				writer.newLine();
			}
		
			writer.close();
			return true;
		}
		catch(Exception e) 
		{
			return false;
		}
	}
	//Save data to Lines array list to be used in writeToFile method
	public static void writeCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards)
	{
		String filename = "src\\Program\\Database.txt";
		List<String> lines = new ArrayList<String>();
		for(MonsterCard card : monsterCards) 
		{
			String line = "Monster"+ "_"+ card.Name + "_" + card.Type + "_" + card.Level + "_" + card.Description + "_"+ card.Attack + "_" + card.Defence + "_" + card.SerialNumber;
			lines.add(line);
		}
		if(!Main.writeToFile(filename, lines.toArray(new String[lines.size()]))) 
		{
			System.out.println("Something went Wrong!");
		}
		for(SpellCard card : spellCards) 
		{
			String line = "Spell"+ "_"+ card.Name + "_" + card.Type + "_"+ card.STType+"_" + card.Description +"_" +card.SerialNumber;
			lines.add(line);
		}
		if(!Main.writeToFile(filename, lines.toArray(new String[lines.size()]))) 
		{
			System.out.println("Something went Wrong!");
		}
		for(TrapCard card : trapCards) 
		{
			String line = "Trap"+ "_"+ card.Name + "_" + card.Type + "_"+ card.STType+"_" + card.Description +"_" +card.SerialNumber;
			lines.add(line);
		}
		if(!Main.writeToFile(filename, lines.toArray(new String[lines.size()]))) 
		{
			System.out.println("Something went Wrong!");
		}
	}

	public static void startProgram() //Initializing arrays and start Program
	{	
		CardFactory reader = new CardFactory();
		ArrayList<SpellCard> spellCards = new ArrayList<SpellCard>();
		ArrayList<TrapCard> trapCards = new ArrayList<TrapCard>();
		ArrayList<MonsterCard> monsterCards = new ArrayList<MonsterCard>();
		reader.reader(null, monsterCards, spellCards, trapCards);
		mainmenu(monsterCards, spellCards, trapCards, reader);
	}
	//This is where program start for user(Program needs user input)
	public static void mainmenu(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards,CardFactory reader) 
	{
		Scanner sc = new Scanner(System.in);
		String Option;
		int option = 0;
		do{
		
		System.out.println("Hello to Yu-Gi-Oh! Libary.");
		System.out.println("1. Add new Card");
		System.out.println("2. Remove existing Card");
		System.out.println("3. Search Card By ID(Serial Number)");
		System.out.println("4. Show Cards");
		System.out.println("5. Exit");
		Option = sc.next();
		if(!Option.matches("[0-9]+")) {
			System.out.println("Must input Numbers!");
		}else {
		option = Integer.parseInt(Option);
		switch(option) {
		case 1:
			addCard(monsterCards, spellCards, trapCards, reader);
			break;
		case 2:
			removeCard(monsterCards, spellCards, trapCards, reader);
			break;
		case 3:
			searchCard(monsterCards, spellCards, trapCards);
			break;
		case 4:
			showCardsMenu(monsterCards, spellCards, trapCards, reader);
			break;
		case 5:
			System.out.println("Goodbye See you next time!");
			System.exit(0);
			break;
		default:
			System.out.println("Please Try Again!");
			break;
		
		}}
		}while(option < 1 || option > 4);
		}
	
	
	//Method used for choosing what kind of card user wants to add
	public static void addCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards,CardFactory reader) 
	{	Scanner sc = new Scanner(System.in);
		String Option;
		int option = 0;
		do {
		System.out.println("1. Monter card");
		System.out.println("2. Spell Card");
		System.out.println("3. Trap Card");
		System.out.println("4. Go back");
		Option = sc.next();
		if(!Option.matches("[0-9]+")) {
			System.out.println("Must input Numbers!");
		}else {
		option = Integer.parseInt(Option);
		switch(option){
			case 1:
				addMonsterCard(monsterCards);
				writeCard(monsterCards, spellCards, trapCards);
				option = 0;
				break;
			case 2:
				addSpellCard(spellCards);
				writeCard(monsterCards, spellCards, trapCards);
				option = 0;
				break;
			case 3:
				addTrapCard(trapCards);
				writeCard(monsterCards, spellCards, trapCards);
				option = 0;
				break;
			case 4: 
				writeToFile(null, null);
				mainmenu(monsterCards, spellCards, trapCards, reader);
				return;
			default:
				System.out.println("Please Try Again!");
				break;
		}
		}
		}while(option < 1 || option > 4);
}

	//User can add Monster card with This method
	public static void addMonsterCard(ArrayList<MonsterCard> monsterCards) 
	{	
		Scanner s = new Scanner(System.in).useDelimiter(".");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Data for Monster Card.");
		System.out.println("Card Name is: ");
		String name = sc.nextLine();
		System.out.println("Card Type is: ");
		String type = sc.nextLine();
		System.out.println("Card Level is: ");
		int level =  sc.nextInt();
		System.out.println("What is card Description");
		String description = s.nextLine();
		System.out.println("Card Attack Power is: ");
		int attack = sc.nextInt();
		System.out.println("Card Defence is:");
		int defence = sc.nextInt();
		System.out.println("Card ID/Serial Number is :");
		int serialNumber = sc.nextInt();
		MonsterCard card = new MonsterCard(name,type,level,description,attack,defence,serialNumber);
		monsterCards.add(card);
		writeToFile(null, null);
		
		
	}
	//User can add Spell card with This method
	public static void addSpellCard(ArrayList<SpellCard> spellCards) 
	{
		Scanner s = new Scanner(System.in).useDelimiter(".");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Data for Spell/Trap Card.");
		System.out.println("Card Name is: ");
		String name = s.nextLine();
		System.out.println("Card Type is: ");
		String type = sc.next();
		System.out.println("Spell Type: ");
		String sTType = sc.next();
		System.out.println("What is card Description:");
		String description = s.nextLine();
		System.out.println("Card ID/Serial Number is:");
		int serialNumber = sc.nextInt();
		SpellCard card = new SpellCard(name,type,sTType,description,serialNumber);
		spellCards.add(card);
		writeToFile(null, null);

	}
	//User can add Trap card with This method
	public static void addTrapCard(ArrayList<TrapCard> trapCards) 
	{
		Scanner s = new Scanner(System.in).useDelimiter(".");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Data for Spell/Trap Card.");
		System.out.println("Card Name is: ");
		String name = s.nextLine();
		System.out.println("Card Type is: ");
		String type = sc.next();
		System.out.println("Trap Type: ");
		String sTType = sc.next();
		System.out.println("What is card Description: ");
		String description = s.nextLine();
		System.out.println("Card ID/Serial Number is:");
		int serialNumber = sc.nextInt();
		TrapCard card = new TrapCard(name,type,sTType,description,serialNumber);
		trapCards.add(card);
		writeToFile(null, null);

	}
	
	//Choosing what type of card user wants to remove from database
	public static void removeCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards,CardFactory reader) 
	{
		Scanner sc = new Scanner(System.in);
		String Option;
		int option = 0;
		do {
		System.out.println("1. Remove Monter card");
		System.out.println("2. Remove Spell Card");
		System.out.println("3. Remove Trap Card");
		System.out.println("4. Go back");
		Option = sc.next();
		if(!Option.matches("[0-9]+")) {
			System.out.println("Must input Numbers!");
		}else {
		option = Integer.parseInt(Option);
		switch(option){
			case 1:
				removeMonsterCard(monsterCards, spellCards, trapCards);
				writeCard(monsterCards, spellCards, trapCards);
				writeToFile(null, null);
				option = 0;
				break;
			case 2:
				removeSpellCard(monsterCards, spellCards, trapCards);
				writeCard(monsterCards, spellCards, trapCards);
				writeToFile(null, null);
				option = 0;
				break;
			case 3:
				removeTrapCard(monsterCards, spellCards, trapCards);
				writeCard(monsterCards, spellCards, trapCards);
				writeToFile(null, null);
				option = 0;
				break;
			case 4: 
				mainmenu(monsterCards, spellCards, trapCards, reader);
				return;
			default:
				System.out.println("Please Try Again!");
				break;
		}
		}
		}while(option < 1 || option > 4);
}

	//Removing Monster Card from database
	public static void removeMonsterCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{	if(findMonsterCard(monsterCards, spellCards, trapCards)!=null) {
		System.out.println("Are you sure you want to Delete, \nPress:\n1. Yes\n2. No");
		Scanner sc = new Scanner(System.in);
		String Option = sc.next();
		int option = 0;
		if(!Option.matches("[0-9]+")) {
			System.out.println("Must input Numbers!");
		}else {
		option = Integer.parseInt(Option);
		if(option == 1) {
				System.out.println("Please Confirm By Entering ID once Again!");
				monsterCards.remove(findMonsterCard(monsterCards, spellCards, trapCards));
		}else if(option == 2) 
		{
			removeCard(monsterCards, spellCards, trapCards, null);
		}else
		{
			System.out.println("Try Again!");
			removeCard(monsterCards, spellCards, trapCards, null);
		}}}
		
	}
	//Removing Spell Card from database
	public static void removeSpellCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{	if(findSpellCard(monsterCards, spellCards, trapCards)!=null) {
		System.out.println("Are you sure you want to Delete, \nPress:\n1. Yes\n2. No");
		Scanner sc = new Scanner(System.in);
		String Option = sc.next();
		int option = 0;
		if(!Option.matches("[0-9]+")) {
			System.out.println("Must input Numbers!");
		}else {
		option = Integer.parseInt(Option);
		if(option == 1) {
				System.out.println("Please Confirm By Entering ID once Again!");
				spellCards.remove(findSpellCard(monsterCards, spellCards, trapCards));
		}else if(option == 2) 
		{
			removeCard(monsterCards, spellCards, trapCards, null);
		}else
		{
			System.out.println("Try Again!");
			removeCard(monsterCards, spellCards, trapCards, null);
		}}}
		
	}
	//Removing Trap Card from database
	public static void removeTrapCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{	if(findTrapCard(monsterCards, spellCards, trapCards)!=null) {
		System.out.println("Are you sure you want to Delete, \nPress:\n1. Yes\n2. No");
		Scanner sc = new Scanner(System.in);
		String Option = sc.next();
		int option = 0;
		if(!Option.matches("[0-9]+")) {
			System.out.println("Must input Numbers!");
		}else {
		option = Integer.parseInt(Option);
		if(option == 1) {
				System.out.println("Please Confirm By Entering ID once Again!");
				trapCards.remove(findTrapCard(monsterCards, spellCards, trapCards));
		}else if(option == 2) 
		{
			removeCard(monsterCards, spellCards, trapCards, null);
		}else
		{
			System.out.println("Try Again!");
			removeCard(monsterCards, spellCards, trapCards, null);
		}}}

	}
	//Method used to find Monster card in array and return that Monster card
	@SuppressWarnings("resource")
	static MonsterCard findMonsterCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{	do {
		System.out.println("Enter Card Serial Number");
		Scanner sc = new Scanner(System.in);
		String index = sc.next();
		if(!index.matches("[0-9]+")) {
			System.out.println("Must input Numbers!");
		}else {
		for( MonsterCard card : monsterCards) 
		{	long index1 = Long.parseLong(index);
			if(card.SerialNumber == index1)
			{	
			
				return card;
			}
			
		}
		System.out.println("Monster Card Don't Exist!");
		}
		}while(monsterCards != null);
	
	return null;
	

		
	}
	//Method used to find Spell card in array and return that Spell card
	@SuppressWarnings("resource")
	static SpellCard findSpellCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{	do {
		System.out.println("Enter Card Serial Number");
		Scanner sc = new Scanner(System.in);
		String index = sc.next();
		if(!index.matches("[0-9]+")) {
			System.out.println("Must input Numbers!");
		}else {
		for( SpellCard card : spellCards) 
		{	long index1 = Long.parseLong(index);
			if(card.SerialNumber == index1)
			{	
			
				return card;
			}
			
		}
		System.out.println("Spell Card Don't Exist!");
		}
		}while(spellCards != null);
	
	return null;
	

		
	}
	//Method used to find Trap card in array and return that Trap card
	@SuppressWarnings("resource")
	static TrapCard  findTrapCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{		do {
		System.out.println("Enter Card Serial Number");
		Scanner sc = new Scanner(System.in);
		String index = sc.next();
		if(!index.matches("[0-9]+")) {
			System.out.println("Must input Numbers!");
		}else {
		for( TrapCard card : trapCards) 
		{	long index1 = Long.parseLong(index);
			if(card.SerialNumber == index1)
			{	
			
				return card;
			}
			
		}
		System.out.println("Trap Card Don't Exist!");
		}
		}while(trapCards != null);
	
	return null;
	}
	//Method Menu for choosing what type of card user wants to search by id 
	public static void searchCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{	
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Do u Want to search\n1. Monster Card \n2. Spell Card\n3. Trap Card\n4. Go Back");
		String Choice = sc.next();
		if(!Choice.matches("[0-9]+")) {
			System.out.println("Must input Numbers!");
		}else {
			choice = Integer.parseInt(Choice);
		switch(choice){
			case 1:
				displayMonsterCardByID(monsterCards, spellCards, trapCards);
				choice = 0;
				break;
			case 2:
				displaySpellByID(monsterCards, spellCards, trapCards);
				choice = 0;
				break;
			case 3:
				displayTrapByID(monsterCards, spellCards, trapCards);
				choice = 0;
				break;
			case 4: 
				mainmenu(null, null, trapCards, null);
				return;
			default:
				System.out.println("Please Try Again!");
		}
		}}while(choice < 1 || choice > 4);

	}
	
	//Display Monster Card
	public static void displayMonsterCardByID(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{
		MonsterCard tempCard = findMonsterCard(monsterCards, spellCards, trapCards);
		if(tempCard !=null) {
		System.out.println(tempCard.toString2());
		searchCard(monsterCards, spellCards, trapCards);}
	}
	//Display Spell Card
	public static void displaySpellByID(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{
		SpellCard tempCard = findSpellCard(monsterCards, spellCards, trapCards);
		if(tempCard !=null) {
		System.out.println(tempCard.toString2());
		searchCard(monsterCards, spellCards, trapCards);}
	}
	
	//Display Trap card
	public static void displayTrapByID(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{
		TrapCard tempCard = findTrapCard(monsterCards, spellCards, trapCards);
		if(tempCard !=null) {
		System.out.println(tempCard.toString2());
		searchCard(monsterCards, spellCards, trapCards);}
	}
	//Menu for choosing what group of card user want to see
	public static void showCardsMenu(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards,CardFactory reader) 
	{
		Scanner sc = new Scanner(System.in);
		String Option;
		int option = 0;
		do {
			System.out.println("1. Show All Monster Cards");
			System.out.println("2. Show All Spell Cards");
			System.out.println("3. Show All Trap Cards");
			System.out.println("4. Show All Cards");
			System.out.println("5. Go Back");
			Option = sc.next();
			if(!Option.matches("[0-9]+")) {
				System.out.println("Must input Numbers!");
			}else {
			option = Integer.parseInt(Option);
		switch(option){
			case 1:
				showMonsterCards(monsterCards, spellCards, trapCards);
				option = 0;
				break;
			case 2:
				showSpellCards(monsterCards, spellCards, trapCards, reader);
				option = 0;
				break;
			case 3: 
				showTrapCards(monsterCards, spellCards, trapCards, reader);
				option = 0;
				break;
			case 4: 
				showAllCard(monsterCards, spellCards, trapCards, reader);
				option = 0;
				break;
			case 5:
				mainmenu(monsterCards, spellCards, trapCards, reader);
				return;
			default:
				System.out.println("Please Try Again!");
		}
		}}while(option < 1 || option > 5);

		
	}
	//Show all Monster Cards
	public static void showMonsterCards(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) 
	{	if(monsterCards != null) {
		for( MonsterCard card : monsterCards) 
		{	
			
			System.out.println(card.toString2() +"\n");
		}}else 
		{	CardFactory reader = new CardFactory();
			spellCards = new ArrayList<SpellCard>();
			trapCards = new ArrayList<TrapCard>();
			monsterCards = new ArrayList<MonsterCard>();
			reader.reader(null, monsterCards, spellCards, trapCards);
		}
		
	}
	//Show all Spell Cards
	public static void showSpellCards(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards,CardFactory reader) 
	{	if(spellCards != null) {
		for( SpellCard card : spellCards) 
		{	
			
			System.out.println(card.toString2() +"\n");
		}}else 
		{
			spellCards = new ArrayList<SpellCard>();
			trapCards = new ArrayList<TrapCard>();
			monsterCards = new ArrayList<MonsterCard>();
			reader.reader(null, monsterCards, spellCards, trapCards);
		}
		
		
	}
	//Show All Trap Cards
	public static void showTrapCards(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards,CardFactory reader) 
	{	if(trapCards != null) {
		for( TrapCard card : trapCards) 
		{	
			
			System.out.println(card.toString2() +"\n");
		}}else 
		{	
			spellCards = new ArrayList<SpellCard>();
			trapCards = new ArrayList<TrapCard>();
			monsterCards = new ArrayList<MonsterCard>();
			reader.reader(null, monsterCards, spellCards, trapCards);
		}
		
	}
	//Show all cards from database
	public static void showAllCard(ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards,CardFactory reader) 
	{
		if(monsterCards !=null && spellCards!=null && trapCards != null) {
		System.out.println("\n*********All Monster Cards*********\n");
		for( MonsterCard card : monsterCards) 
		{	
			
			System.out.println(card.toString2() +"\n");
		}
		System.out.println("\n*********All Spell Cards*********\n");
		for( SpellCard card : spellCards) 
		{	
			
			System.out.println(card.toString2() +"\n");
		}
		System.out.println("\n*********All Trap Cards*********\n");
		for( TrapCard card : trapCards) 
		{	
			
			System.out.println(card.toString2() +"\n");
		}
		}else 
		{
			spellCards = new ArrayList<SpellCard>();
			trapCards = new ArrayList<TrapCard>();
			monsterCards = new ArrayList<MonsterCard>();
			reader.reader(null, monsterCards, spellCards, trapCards);
		}
	}
	/*Thanks For Reading This Program
	Aleksandar Milosevic 2020230378 */
}

	
	
	
	

