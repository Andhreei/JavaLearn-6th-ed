package ch06;

// NOTE: Be sure to rename this file to Pause.java when you want to
// work on the exercise. We had to supply this "bad" file extension to
// keep IDEs such as IntelliJ IDEA from failing. Many IDEs compile
// every class in the project. If one fails, you can't run any of the
// classes with main() methods. This is a quirk of our project that we
// really have dozens and dozens of "projects" under one umbrella.

public class Pause
{
	public static void main(String args[])
	{
		System.out.print("Starting... ");
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}
		System.out.println("done");
	}
}
