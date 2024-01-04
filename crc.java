import java.util.Scanner;
class crc {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Generator");
        String gen = sc.next();
        System.out.println("Enter the Data");
        String data =sc.next();
        String code=data;
        for(int i=1;i<gen.length();i++)
            code+="0";
        code=div(code,gen);
        System.out.println("The transmitted data is : "+data+code+"\nEnter the Received Code Word");
        String rec=sc.next();
        if(Integer.parseInt(div(rec,gen))==0)
            System.out.println("The Received data has no errors");
        else
            System.out.println("The Received data has errors");
    }
    static String div(String div,String d)
    {
        int p=d.length();
        String rem="",r=div.substring(0,p);
        for(int i=0;i<p;i++)
            if(div.charAt(i)==d.charAt(i))
                rem+="0";
            else 
                rem+="1";
        while(p<div.length())
        {
            while(rem.charAt(0)=='0')
            {
                rem=rem.substring(1,rem.length());
                rem+=div.substring(p,p+1);
                p++;
            }
            r=rem;
            rem="";
            for(int i=0;i<d.length();i++)
                if(r.charAt(i)==d.charAt(i))
                    rem+="0";
                else
                    rem+="1";
        }
        return rem.substring(1,rem.length());
    }
}
