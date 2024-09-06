package ch04;

/**
 * A basic implementation of Euclid's greatest common denominator
 * algorithm.
 * <p>
 * https://en.wikipedia.org/wiki/Algorithm
 */
public class Euclid
{
	public static void main(String[] args)
	{
		// For now, just "hard code" the two numbers to compare
		int a          = 2701;
		int original_a = a;
		int b          = 222;
		int original_b = b;
		// Exercise 1, fill in the algorithm from Chapter 4
		while(b != 0)
		{
			if(a > b)
			{
				a = a - b;
			}
			else
			{
				b = b - a;
			}
		}
		// Can you include the original numbers in the output?
		System.out.println("The GCD between " + original_a + " and " + original_b + " is " + a);
	}
}
