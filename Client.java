import java.net.*;
import java.io.*;
class Client
{
	private Socket socket=null;
	private DataInputStream input=null;
	private DataOutputStream out=null;
	public Client(String address,int port)
	{
		try
		{
			socket=new Socket(address,port);
			System.out.println("Connected");
			input=new DataInputStream(System.in);
			out=new DataOutputStream(socket.getOutputStream());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		String s="";
		while(!s.equals("Over"))
		{
			try
			{
				s=input.readLine();
				out.writeUTF(s);
			}
			catch(Exception e)
			{}
		}
		try
		{
			input.close();out.close();socket.close();
		}
		catch(Exception e)
		{}
	}
	public static void main(String args[])
	{
		Client client = new Client("127.0.0.1",5000);
	}
}
