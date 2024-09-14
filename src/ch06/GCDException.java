package ch06;

public class GCDException extends Exception
{
	public int getLineNumber()
	{
		return lineNumber;
	}

	int lineNumber;

	public int getaFromPair()
	{
		return aFromPair;
	}

	int aFromPair;

	public int getbFromPair()
	{
		return bFromPair;
	}

	int bFromPair;

	GCDException()
	{
		super();
		lineNumber = -1;
	}

	GCDException(String desc, int a, int b, int lineNr)
	{
		super(desc);
		aFromPair  = a;
		bFromPair  = b;
		lineNumber = lineNr;
	}
}
