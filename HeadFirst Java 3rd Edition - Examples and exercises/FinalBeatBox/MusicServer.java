import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.*;

public class MusicServer
{
	final List<ObjectOutputStream> clientOutputStreams = new ArrayList<>();
	
	public static void main(String[] args)
	{
		new MusicServer().go();
	}
	
	public void go()
	{
		try {
			ServerSocket server = new ServerSocket(4242);
			ExecutorService threadPool = Executors.newCachedThreadPool();
			
			while(!server.isClosed())
			{
				Socket clientSocket = server.accept();
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
				clientOutputStreams.add(out);
				
				threadPool.execute(new ClientHandler(clientSocket));
				System.out.println("Got a connection");
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void tellEveryone(Object one, Object two)
	{
		for(ObjectOutputStream clientOutputStream : clientOutputStreams)
		{
			try {
				clientOutputStream.writeObject(one);
				clientOutputStream.writeObject(two);
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private class ClientHandler implements Runnable
	{
		private ObjectInputStream in;
		
		public ClientHandler(Socket socket)
		{
			try {
				in = new ObjectInputStream(socket.getInputStream());
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
		public void run()
		{
			Object userName;
			Object beatSequence;
			
			try {
				while ((userName = in.readObject()) != null)
				{
					beatSequence = in.readObject();
					System.out.println("read two objects");
					tellEveryone(userName, beatSequence);
				}
			} catch(IOException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}
	}
}