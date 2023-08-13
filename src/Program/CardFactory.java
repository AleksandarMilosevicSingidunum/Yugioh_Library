package Program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CardFactory {
	//Read Data form file and create new object and save that objects to arraylist
	public Card reader(String data[],ArrayList<MonsterCard> monsterCards,ArrayList<SpellCard> spellCards,ArrayList<TrapCard> trapCards) {
		try {

			BufferedReader br = new BufferedReader(new FileReader("src\\Program\\Database.txt"));
			String s;
			try {
				while((s = br.readLine()) !=null) 
				{
					data = s.split("_");
					if(data[0].equals("Monster")) 
					{
						String name = data[1];
						String type = data[2];
						int level = Integer.parseInt(data[3]);
						String description = data[4];
						int attack = Integer.parseInt(data[5]);
						int defence = Integer.parseInt(data[6]);
						long serialNumber = Long.parseLong(data[7]);
						MonsterCard card = new MonsterCard(name,type,level,description,attack,defence,serialNumber);
						monsterCards.add(card);
					}
					else if (data[0].equals("Spell")) 
					{
						String name = data[1];
						String type = data[2];
						String sTType = data[3];
						String description = data[4];
						long serialNumber = Long.parseLong(data[5]);
						SpellCard card = new SpellCard(name,type,sTType,description,serialNumber);
						spellCards.add(card);
					}else if(data[0].equals("Trap"))
					{
						String name = data[1];
						String type = data[2];
						String sTType = data[3];
						String description = data[4];
						long serialNumber = Long.parseLong(data[5]);
						TrapCard card = new TrapCard(name,type,sTType,description,serialNumber);
						trapCards.add(card);
					}
					else
						System.out.println("We got error");
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
}
