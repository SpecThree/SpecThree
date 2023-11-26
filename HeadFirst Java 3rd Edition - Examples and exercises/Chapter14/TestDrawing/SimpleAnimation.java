import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.concurrent.*;

public class SimpleAnimation
{	
	private JFrame frame;
	private int x = 10, y = 10;

	public static void main(String[] args)
	{
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}
	
	public void go()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		int steps = 220;
		while (steps > 0)
		{
			try
			{
				TimeUnit.MILLISECONDS.sleep(40);
				frame.repaint();
				x++;
				y++;
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				steps--;
			}
		}
	}

	class MyDrawPanel extends JPanel
	{
		private int redStart, greenStart, blueStart,
					redEnd, greenEnd, blueEnd;
		
		public MyDrawPanel()
		{
			Random random = new	Random();
			redStart = random.nextInt(256);
			greenStart = random.nextInt(256);
			blueStart = random.nextInt(256);
			redEnd = random.nextInt(256);
			greenEnd = random.nextInt(256);
			blueEnd = random.nextInt(256);
		}
		
		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D) g;
			
			Color startColor = new Color(redStart, greenStart, blueStart);
			Color endColor = new Color(redEnd, greenEnd, blueEnd);
			
			GradientPaint gradient = new GradientPaint(x, y, startColor, x + 20, y + 20, endColor);
			g2d.setPaint(gradient);
			g2d.fillOval(x, y, 20, 20);
		}
	}
}