import java.io.*;

public class GameSaverTest
{
	public static void main(String[] args)
	{
		GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
		GameCharacter two = new GameCharacter(200, "Troll", new String[] {"bare hands", "big axe"});
		GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells", "invisibility"});
	
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/Java/Chapter16/Examples/Game.sav"));
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		one = two = three = null;
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/Java/Chapter16/Examples/Game.sav"));
			GameCharacter oneRestore = (GameCharacter) is.readObject();
			GameCharacter twoRestore = (GameCharacter) is.readObject();
			GameCharacter threeRestore = (GameCharacter) is.readObject();
			is.close();
			
			System.out.println("One's type: " + oneRestore.getType());
			System.out.println("Two's type: " + twoRestore.getType());
			System.out.println("Three's type: " + threeRestore.getType());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

