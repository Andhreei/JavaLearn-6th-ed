package ch02;

import javax.swing.*;

public class GoodbyeJava
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Chapter 2 exercise");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);
		JLabel label = new JLabel("Goodbye Java", JLabel.CENTER);
		frame.add(label);
	}
}
