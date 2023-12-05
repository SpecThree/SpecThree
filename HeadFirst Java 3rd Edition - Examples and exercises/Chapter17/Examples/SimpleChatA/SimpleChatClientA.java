import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChatClientA
{
	private JTextField outgoing;
	private PrintWriter writer;
	
	public void go()
	{
		setUpNetworking();
		
		outgoing = new JTextField(20);
		
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(event -> sendMessage());
		
		JPanel mainPanel = new JPanel();
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 100);
		frame.setVisible(true);
	}
	
	private void sendMessage()
	{	
		if (outgoing.getText().equals(""))
		{
			return;
		}
		writer.println(outgoing.getText());
		writer.flush();
		outgoing.setText("");
		outgoing.requestFocus();
	}
	
	private void setUpNetworking()
	{
		try {
			InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
			SocketChannel socketChannel = SocketChannel.open(serverAddress);
			writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
			System.out.println("Networking established.");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		new SimpleChatClientA().go();
	}
}