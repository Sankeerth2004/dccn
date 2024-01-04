import java.util.*;
public class LeakyBucket
{
    public static void main(String args[]) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of queries ");
        int q=sc.nextInt();
        System.out.println("Enter the size of bucket");
        int bs=sc.nextInt();
        System.out.println("Enter the sizes of input and output packets");
        int input=sc.nextInt(),output=sc.nextInt();
        int storage=0,left=0;
        for(int i=0;i<q;i++)
        {
            left=bs-storage;
            if(input<=left)
                storage+=input;
            else
                System.out.println("Packet loss = "+input);
            System.out.println("Buffer size = "+storage+" Out of Bucket size = "+bs);
            storage-=output;
        }
    }
}
