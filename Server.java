import java.net.*;
import java.io.*;
class Server
{
	private Socket socket=null;
	private ServerSocket server=null;
	private DataInputStream in=null;
	public Server(int port)
	{
		try
		{
			server=new ServerSocket(port);
			System.out.println("Server Started");
			System.out.println("Waiting for client...");
			socket=server.accept();
			System.out.println("Client Accepted");
			in =new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			String s="";
			while(!s.equals("Over"))
			{
				try
				{
					s=in.readUTF();
					System.out.println(s);
				}
				catch(Exception e)
				{}
			}
			System.out.println("Closing Connection");
			socket.close();
			in.close();
		}
		catch(Exception e)
		{}
	}
	public static void main(String args[])
	{
		Server server=new Server(5000);
	}
}
