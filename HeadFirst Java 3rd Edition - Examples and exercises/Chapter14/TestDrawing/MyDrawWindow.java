import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MyDrawWindow
{
	public static void main(String[] args)
	{
		MyDrawWindow window = new MyDrawWindow();
		window.go();
	}
	
	void go()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		
		JPanel panel = new MyDrawPanel();
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
	}
}

class MyDrawPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		Random random = new	Random();
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		Color startColor = new Color(red, green, blue);
		
		red = random.nextInt(256);
		green = random.nextInt(256);
		blue = random.nextInt(256);
		Color endColor = new Color(red, green, blue);
		
		GradientPaint gradient = new GradientPaint(10, 10, startColor, 240, 240, endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(10, 10, 240, 240);
	}
}