import java.net.*;
import java.util.*;
public class DNS
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        int n;
        do
        {
            System.out.println("1.DNS\n2.Exit\nEnter your choice");
            n=sc.nextInt();
            if(n==1)
            {
                System.out.println("Enter the hostname ");
                String h=sc.next();
                InetAddress a=InetAddress.getByName(h);
                System.out.println("Host Name : "+a.getHostName()+"\nIP Address : "+a.getHostAddress());
            }
        }while(n==1);
    }
}

