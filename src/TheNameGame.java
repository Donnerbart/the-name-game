import java.util.Formatter;
import java.util.Locale;

public class TheNameGame
{
	private final String[] baseNames;
	private final String[] fillIns;
	private final String[] characters;
	
	private final char[] baseFirstChars;
	private final String[] baseWords;
	
	private final StringBuilder song;
	private final Formatter formatter;

	/**
	 * Generates the name game song with the gives parameters.
	 * 
	 * @param baseNames e.g. "Bob", "Fred" and "Mary"
	 * @param fillIns e.g. "Banana fanna" and "fee fy"
	 * @param characterNames e.g. "Judy", "Lana", "Pepper", "Tony" and "Kit"
	 */
	public TheNameGame(final String[] baseNames, final String[] fillIns, final String[] characterNames)
	{
		final int baseNameLength = baseNames.length;
		if (baseNameLength != 3)
		{
			throw new RuntimeException("We need 3 base names!");
		}
		if (fillIns.length != 2)
		{
			throw new RuntimeException("We need 2 fill ins!");
		}
		if (characterNames.length != 5)
		{
			throw new RuntimeException("We need 5 character names!");
		}
		
		this.baseNames = baseNames;
		this.fillIns = fillIns;
		this.characters = characterNames;
		
		this.baseFirstChars = new char[baseNameLength];
		this.baseWords = new String[baseNameLength];
		
		for (int i = 0; i < baseNameLength; i++)
		{
			baseFirstChars[i] = baseNames[i].charAt(0);
			baseWords[i] = new String(baseFirstChars[i] + "o").toLowerCase();
		}
		
		song = new StringBuilder();
		formatter = new Formatter(song, Locale.ENGLISH);
		
		doTheNameGame();
	}
	
	public String toString()
	{
		return song.toString();
	}
	
	private void doTheNameGame()
	{
		add("The name game!").np();
		
		theNameGame(0).np();
		theNameGame(1).np();
		
		add("Come on everybody!").nl();
		add("I say now let's play a game.").nl();
		add("I betcha I can make a rhyme").nl();
		add("out of anybody's name.").np();
		
		add("The first letter of the name,").nl();
		add("I treat it like it wasn't there").nl();
		add("But a %s or an %s", baseFirstChars[0], baseFirstChars[1]).nl();
		add("or an %s will appear.", baseFirstChars[2]).np();
		
		add("And then I say %s add a %s then I say the name and %s and a %s.", baseWords[0], baseFirstChars[0], fillIns[0], baseWords[1]).nl();
		add("And then I say the name again with an %s very plain and a %s and a %s.", baseFirstChars[1], fillIns[1], baseWords[2]).nl();
		add("And then I say the name again with an %s this time", baseFirstChars[2]).nl();
		add("and there isn't any name I can't rhyme.").np();
		
		theNameGame(2).np();
		
		add("But if the first two letters are ever the same,").nl();
		add("I drop them both and say the name like:").nl();
		add("%s, %s drop the %s's %s %s.", baseNames[0], baseNames[0], baseFirstChars[0], baseWords[0], getSubName(baseFirstChars[0], baseNames[0])).nl();
		add("For %s, %s drop the %s's %s %s.", baseNames[1], baseNames[1], baseFirstChars[1], baseWords[1], getSubName(baseFirstChars[1], baseNames[1])).nl();
		add("For %s, %s drop the %s's %s %s.", baseNames[2], baseNames[2], baseFirstChars[2], baseWords[2], getSubName(baseFirstChars[2], baseNames[2])).nl();
		add("That's the only rule that is contrary.").np();
		
		final String fullName = characters[3];
		final char firstChar = fullName.charAt(0);
		final String subName = getSubName(firstChar, fullName);
		add("Okay? Now say %s: %s!", baseWords[0], baseWords[0]).nl();
		add("Now %s with a %s: %s!", fullName, baseFirstChars[0], getNewName(baseFirstChars[0], firstChar, subName)).nl();
		add("Then %s %s: %s %s!", fillIns[0], baseWords[1], fillIns[0], baseWords[1]).nl();
		add("Then you say the name again with an %s very plain: %s!", baseFirstChars[1], getNewName(baseFirstChars[1], firstChar, subName)).nl();
		add("Then a %s and a %s: %s %s!", fillIns[1], baseWords[2], fillIns[1], baseWords[2]).nl();
		add("Then say the name again with an %s this time: %s!", baseFirstChars[2], getNewName(baseFirstChars[2], firstChar, subName)).nl();
		add("And there isn't any name that you can't rhyme.").np();
		
		theNameGame(4).np();
		
		add("The name game!");
	}
	
	private TheNameGame theNameGame(final int baseNameIndex)
	{
		final String fullName = characters[baseNameIndex];
		final char firstChar = fullName.charAt(0);
		final String subName = getSubName(firstChar, fullName);
		
		add("%s! %s, %s %s", fullName, fullName, fullName, baseWords[0]).nl();
		add("%s %s %s", getNewName(baseFirstChars[0], firstChar, subName), fillIns[0], baseWords[1]).nl();
		add("%s %s %s", getNewName(baseFirstChars[1], firstChar, subName), fillIns[1], baseWords[2]).nl();
		add("%s, %s!", getNewName(baseFirstChars[2], firstChar, subName), fullName);
		return this;
	}
	
	private TheNameGame add(final String text)
	{
		song.append(text);
		return this;
	}
	
	private TheNameGame add(final String text, final Object... args)
	{
		formatter.format(text, args);
		return this;
	}
	
	private TheNameGame nl()
	{
		song.append("\n");
		return this;
	}
	
	private TheNameGame np()
	{
		song.append("\n\n");
		return this;
	}
	
	private String getNewName(final char newFirstChar, final char firstChar, final String subName)
	{
		return (firstChar == newFirstChar ? "" : newFirstChar) + subName;
	}
	
	private String getSubName(final char firstChar, final String fullName)
	{
		return fullName.substring(getSubNameIndex(firstChar, fullName)).toLowerCase();
	}
	
	private int getSubNameIndex(final char firstChar, final String fullName)
	{
		int pos = -1;
		do
		{
			if (++pos == fullName.length())
			{
				pos = 1;
				break;
			}
		}
		while (!isValidStartCharacter(Character.toUpperCase(fullName.charAt(pos))));
		return pos;
	}
	
	private boolean isValidStartCharacter(final char character)
	{
		final char[] validStartCharacters = {'A', 'E', 'I', 'O', 'U', 'Ä', 'Ö', 'Ü', 'Y'};
		for (char validStartCharacter : validStartCharacters)
		{
			if (character == validStartCharacter)
			{
				return true;
			}
		}
		return false;
	}
}
