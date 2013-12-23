public class Main
{
	public static void main(String[] args)
	{
		final String[] baseNames = new String[] { "Bob", "Fred", "Mary" };
		final String[] fillIns = new String[] { "Banana fanna", "fee fy" };
		final String[] characterNames = new String[] { "Judy", "Lana", "Pepper", "Tony", "Kit" };

		System.out.println(new TheNameGame(baseNames, fillIns, characterNames));
	}
}
