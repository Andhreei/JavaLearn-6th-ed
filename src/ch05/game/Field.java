package ch05.game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The playing field for our game. This class will be undergoing quite a few
 * changes as we learn about more of Java's features in coming chapters.
 * For now, we can demonstrate how to work with member variables like a1 and a2
 * as well as how to create new methods like setupApples() and detectCollisions().
 */
public class Field extends JComponent
{
	public static final float GRAVITY                  = 9.8f;
	public static final int   STEP                     = 40;   // duration of an animation frame in
	// milliseconds
	public static final int   APPLE_SIZE_IN_PIXELS     = 30;
	public static final int   TREE_WIDTH_IN_PIXELS     = 60;
	public static final int   TREE_HEIGHT_IN_PIXELS    = 2 * TREE_WIDTH_IN_PIXELS;
	public static final int   HEDGE_WIDTH_IN_PIXELS    = 60;
	public static final int   HEDGE_HEIGHT_IN_PIXELS   = HEDGE_WIDTH_IN_PIXELS / 2;
	public static final int   PHYSICIST_SIZE_IN_PIXELS = 75;
	public static final int   MAX_TREES                = 12;
	public static final int   MAX_APPLES               = 3;
	public static final int   MAX_HEDGES               = 6;
	public static final int   FIELD_WIDTH_IN_PIXELS    = 800;
	public static final int   FIELD_HEIGHT_IN_PIXELS   = 600;

	Color fieldColor = Color.LIGHT_GRAY;

	List <Apple> apples = new ArrayList <>();
	List <Tree>  trees  = new ArrayList <>();
	List <Hedge> hedges = new ArrayList <>();
	Physicist    physicist;


	/**
	 * @deprecated Migarating to Containers
	 */
	public void setupApples()
	{
		/*
 For now, just play with our apple attributes directly
		a1.diameter = 3.0f;
		a1.mass     = 5.0f;
		a1.x        = 20;
		a1.y        = 40;
		a2.diameter = 8.0f;
		a2.mass     = 10.0f;
		a2.x        = 70;
		a2.y        = 200;
*/
	}

	public void addApple(int x, int y, int size)
	{
		Apple apple = new Apple(size);
		apple.setPosition(x, y);
		apples.add(apple);
	}

	/**
	 * @deprecated Replaced in ch7 with adding tree in List
	 */
	public void setupTree()
	{
		// Unlike apples, we'll use the setPosition() method from our
		// GamePiece interface to setup our lonely tree
		//		tree.setPosition(500, 200);
	}

	public void addTree(int x, int y)
	{
		Tree tree = new Tree();
		tree.setPosition(x, y);
		trees.add(tree);
	}

	/**
	 * @deprecated Replaced in ch7 with adding hedges in List
	 */
	public void setupHedge()
	{
		//		hedge.setPosition(300, 100);
	}

	public void addHedge(int x, int y)
	{
		Hedge hedge = new Hedge();
		hedge.setPosition(x, y);
		hedges.add(hedge);
	}

	public void setPlayer(Physicist p)
	{
		physicist = p;
	}

	protected void paintComponent(Graphics g)
	{
		g.setColor(fieldColor);
		g.fillRect(0, 0, getWidth(), getHeight());
		physicist.draw(g);
		for (Tree tree : trees)
		{
			tree.draw(g);
		}
		for (Hedge hedge : hedges)
		{
			hedge.draw(g);
		}
		for (Apple apple : apples)
		{
			apple.draw(g);
		}
	}

	public void detectCollisions(Apple a1, Apple a2)
	{
		if (a1.isTouching(a2))
		{
			System.out.println("Collision detected!");
		}
		else
		{
			System.out.println("Apples are not touching.");
		}
	}
}
