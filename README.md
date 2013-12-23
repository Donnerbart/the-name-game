The name game
=============

This happens after some days of illness and watching youtube videos like:
* http://www.youtube.com/watch?v=GOgNkrQBrdU
* http://www.youtube.com/watch?v=NeF7jqf0GU4

So here comes a little abstraction of the name game algorithms for your next karaoke night!

With the default parameters from the original song...
````java
final String[] baseNames = new String[] { "Bob", "Fred", "Mary" };
final String[] fillIns = new String[] { "Banana fanna", "fee fy" };
final String[] characterNames = new String[] { "Judy", "Lana", "Pepper", "Tony", "Kit" };
System.out.println(new TheNameGame(baseNames, fillIns, characterNames));
````

... you will create an output like this:

`The name game!

Judy! Judy, Judy bo
Budy Banana fanna fo
Fudy fee fy mo
Mudy, Judy!

Lana! Lana, Lana bo
Bana Banana fanna fo
Fana fee fy mo
Mana, Lana!

Come on everybody!
I say now let's play a game.
I betcha I can make a rhyme
out of anybody's name.

The first letter of the name,
I treat it like it wasn't there
But a B or an F
or an M will appear.

And then I say bo add a B then I say the name and Banana fanna and a fo.
And then I say the name again with an F very plain and a fee fy and a mo.
And then I say the name again with an M this time
and there isn't any name I can't rhyme.

Pepper! Pepper, Pepper bo
Bepper Banana fanna fo
Fepper fee fy mo
Mepper, Pepper!

But if the first two letters are ever the same,
I drop them both and say the name like:
Bob, Bob drop the B's bo ob.
For Fred, Fred drop the F's fo ed.
For Mary, Mary drop the M's mo ary.
That's the only rule that is contrary.

Okay? Now say bo: bo!
Now Tony with a B: Bony!
Then Banana fanna fo: Banana fanna fo!
Then you say the name again with an F very plain: Fony!
Then a fee fy and a mo: fee fy mo!
Then say the name again with an M this time: Mony!
And there isn't any name that you can't rhyme.

Kit! Kit, Kit bo
Bit Banana fanna fo
Fit fee fy mo
Mit, Kit!

The name game!`