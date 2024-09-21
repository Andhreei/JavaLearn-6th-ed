package ch05.game;

import javax.swing.*;

/**
 * Our apple tossing game. This class extends JFrame to create our
 * main application window. We'll be filling this out along the way,
 * but for now we can setup a field with some trees and our player.
 */
public class AppleToss extends JFrame
{

	Field     field   = new Field();
	Physicist player1 = new Physicist();

	public AppleToss()
	{
		// Create our frame
		super("Apple Toss Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Field.FIELD_WIDTH_IN_PIXELS, Field.FIELD_HEIGHT_IN_PIXELS);
		setResizable(false);

		// Build the field with our player and some trees
		setupFieldForOnePlayer();
	}

	private int goodX()
	{
		// at least half the width of the tree plus a few pixels
		int leftMargin = Field.TREE_WIDTH_IN_PIXELS / 2 + 5;
		// now find a random number between a left and right margin
		int rightMargin = field.FIELD_WIDTH_IN_PIXELS - leftMargin;

		// And return a random number starting at the left margin
		return leftMargin + (int) (Math.random() * (rightMargin - leftMargin));
	}

	private int goodY()
	{
		// at least half the height of the tree plus a few pixels
		int leftMargin = Field.TREE_HEIGHT_IN_PIXELS / 2 + 5;
		// now find a random number between a left and right margin
		int rightMargin = field.FIELD_HEIGHT_IN_PIXELS - leftMargin;

		// And return a random number starting at the left margin
		return leftMargin + (int) (Math.random() * (rightMargin - leftMargin));
	}

	public void addApples(int size)
	{
		for (int i = field.apples.size(); i < Field.MAX_APPLES; i++)
		{
			Apple a = new Apple(size);
			a.setPosition(goodX(), goodY());

			// Trees can be close to each other and overlap,
			// but they shouldn't intersect our physicist
			while (player1.isTouching(a))
			{
				// We do intersect this apple, so let's try again
				System.err.println("Repositioning an intersecting apple...");
				a.setPosition(goodX(), goodY());
			}
			field.addApple(a.x, a.y, size);
		}
	}

	public void addTrees()
	{
		for (int i = field.trees.size(); i < Field.MAX_TREES; i++)
		{
			Tree t = new Tree();
			t.setPosition(goodX(), goodY());

			// Trees can be close to each other and overlap,
			// but they shouldn't intersect our physicist
			while (player1.isTouching(t))
			{
				// We do intersect this tree, so let's try again
				System.err.println("Repositioning an intersecting tree...");
				t.setPosition(goodX(), goodY());
			}
			field.addTree(t.x, t.y);
		}
	}

	public void addHedges()
	{
		for (int i = field.hedges.size(); i < Field.MAX_HEDGES; i++)
		{
			Hedge h = new Hedge();
			h.setPosition(goodX(), goodY());

			// Trees can be close to each other and overlap,
			// but they shouldn't intersect our physicist
			while (player1.isTouching(h))
			{
				// We do intersect this hedge, so let's try again
				System.err.println("Repositioning an intersecting hedge...");
				h.setPosition(goodX(), goodY());
			}
			field.addHedge(h.x, h.y);
		}
	}

	public void AddPhysicistApple(int size)
	{
		Apple apple = new Apple(player1,size);
		apple.setPosition(player1.x,player1.y);
		field.addApple(apple.x,apple.y,size);
	}

	/**
	 * A helper method to populate a one player field with target trees.
	 */
	private void setupFieldForOnePlayer()
	{
		// Place our (new) physicist in the lower left corner and connect them to the field
		player1.setPosition(100, 510);
		field.setPlayer(player1);
		player1.setField(field);
		addApples(Apple.SMALL);
		AddPhysicistApple(Apple.SMALL);
		addTrees();
		addHedges();
		add(field);
	}

	public static void main(String args[])
	{
		AppleToss game = new AppleToss();
		game.setVisible(true);
	}
}
