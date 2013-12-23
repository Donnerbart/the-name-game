public class TheNameGame
{
	private final String[] baseNames;
	private final String[] fillIns;
	private final String[] characters;
	
	private final char[] baseFirstChars;
	private final String[] baseWords;
	
	private final StringBuilder song;

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
		add("But a ").baseFirstChar(0).add(" or an ").baseFirstChar(1).nl();
		add("or an ").baseFirstChar(2).add(" will appear.").np();
		
		add("And then I say ").baseWord(0).add(" add a ").baseFirstChar(0).add(" then I say the name and ").add(fillIns[0]).add(" and a ").baseWord(1).add(".").nl();
		add("And then I say the name again with an ").baseFirstChar(1).add(" very plain and a ").add(fillIns[1]).add(" and a ").baseWord(2).add(".").nl();
		add("And then I say the name again with an ").baseFirstChar(2).add(" this time").nl();
		add("and there isn't any name I can't rhyme.").np();
		
		theNameGame(2).np();
		
		add("But if the first two letters are ever the same,").nl();
		add("I drop them both and say the name like:").nl();
		add(baseNames[0]).add(", ").add(baseNames[0]).add(" drop the ").baseFirstChar(0).add("'s ").baseWord(0).add(" ").baseSubName(0).add(".").nl();
		add("For ").add(baseNames[1]).add(", ").add(baseNames[1]).add(" drop the ").baseFirstChar(1).add("'s ").baseWord(1).add(" ").baseSubName(1).add(".").nl();
		add("For ").add(baseNames[2]).add(", ").add(baseNames[2]).add(" drop the ").baseFirstChar(2).add("'s ").baseWord(2).add(" ").baseSubName(2).add(".").nl();
		add("That's the only rule that is contrary.").np();
		
		final String fullName = characters[3];
		final char firstChar = fullName.charAt(0);
		final String subName = getSubName(firstChar, fullName);
		add("Okay? Now say ").baseWord(0).add(": ").baseWord(0).add("!").nl();
		add("Now ").add(fullName).add(" with a ").baseFirstChar(0).add(": ");
		subName(baseFirstChars[0], firstChar, subName).add("!").nl();
		add("Then ").add(fillIns[0]).add(" ").baseWord(1).add(": ").add(fillIns[0]).add(" ").baseWord(1).add("!").nl();
		add("Then you say the name again with an ").baseFirstChar(1).add(" very plain: ");
		subName(baseFirstChars[1], firstChar, subName).add("!").nl();
		add("Then a ").add(fillIns[1]).add(" and a ").baseWord(2).add(": ").add(fillIns[1]).add(" ").baseWord(2).add("!").nl();
		add("Then say the name again with an ").baseFirstChar(2).add(" this time: ");
		subName(baseFirstChars[2], firstChar, subName).add("!").nl();
		add("And there isn't any name that you can't rhyme.").np();
		
		theNameGame(4).np();
		
		add("The name game!");
	}
	
	private TheNameGame theNameGame(final int baseNameIndex)
	{
		final String fullName = characters[baseNameIndex];
		final char firstChar = fullName.charAt(0);
		final String subName = getSubName(firstChar, fullName);

		add(fullName).add("! ").add(fullName).add(", ").add(fullName).add(" ").baseWord(0).nl();
		subName(baseFirstChars[0], firstChar, subName).add(" ").add(fillIns[0]).add(" ").baseWord(1).nl();
		subName(baseFirstChars[1], firstChar, subName).add(" ").add(fillIns[1]).add(" ").baseWord(2).nl();
		subName(baseFirstChars[2], firstChar, subName).add(", ").add(fullName).add("!");
		return this;
	}
	
	private TheNameGame subName(final char newFirstChar, final char firstChar, final String subName)
	{
		song.append(firstChar == newFirstChar ? "" : newFirstChar).append(subName);
		return this;
	}
	
	private TheNameGame baseFirstChar(final int baseNameIndex)
	{
		song.append(baseFirstChars[baseNameIndex]);
		return this;
	}
	
	private TheNameGame baseWord(final int baseNameIndex)
	{
		song.append(baseWords[baseNameIndex]);
		return this;
	}

	private TheNameGame add(final String text)
	{
		song.append(text);
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
	
	private TheNameGame baseSubName(final int baseNameIndex)
	{
		song.append(getSubName(baseFirstChars[baseNameIndex], baseNames[baseNameIndex]));
		return this;
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
