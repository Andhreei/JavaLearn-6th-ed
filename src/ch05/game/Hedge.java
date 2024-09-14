package ch05.game;

import java.awt.*;

public class Hedge implements GamePiece
{
	int x, y;

	// Drawing helpers
	private Color hedgeColor  = Color.GREEN.darker();
	private int   hedgeWidth  = (int) (Field.HEDGE_WIDTH_IN_PIXELS);
	private int   hedgeHeight = (int) (Field.HEDGE_HEIGHT_IN_PIXELS);

	//Boundary helpers
	private Rectangle boundingBox;

	@Override
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public int getPositionX()
	{
		return x;
	}

	@Override
	public int getPositionY()
	{
		return y;
	}

	@Override
	public Rectangle getBoundingBox()
	{
		return boundingBox;
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(hedgeColor);
		g.fillRoundRect(x, y, Field.HEDGE_WIDTH_IN_PIXELS, Field.HEDGE_HEIGHT_IN_PIXELS, 10, 10);
	}

	@Override
	public boolean isTouching(GamePiece otherPiece)
	{
		return false;
	}
}
