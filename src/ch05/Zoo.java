package ch05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zoo
{

	abstract class Animal
	{
		public abstract void speak();
		public abstract String getSpecies();
	}

	class Lion extends Animal
	{
		@Override
		public void speak()
		{
			System.out.print("roar");
		}

		@Override
		public String getSpecies()
		{
			return "Lion";
		}
	}

	class Gibbon extends Animal
	{
		@Override
		public void speak()
		{
			System.out.print("hoot");
		}

		@Override
		public String getSpecies()
		{
			return "Gibbon";
		}
	}

	class Cat extends Animal
	{
		@Override
		public void speak()
		{
			System.out.print("meow");
		}

		@Override
		public String getSpecies()
		{
			return "Cat";
		}
	}

	public void listen()
	{
		List <Animal> animals = new ArrayList <>(Arrays.asList(new Lion(), new Gibbon(), new Cat()));
		for (Animal animal: animals)
		{
			System.out.print("The " + animal.getSpecies() + " goes \"");
			animal.speak();
			System.out.println("\"");
		}
	}

	public static void main(String[] args)
	{
		Zoo myZoo = new Zoo();
		myZoo.listen();
	}
}


