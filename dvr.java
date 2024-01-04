import java.util.*;
public class DVR
{
    static int v,e,graph[][],via[][],rt[][];
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of Vertices");
        v=sc.nextInt();
        graph=new int[v][v];
        via=new int[v][v];
        rt=new int[v][v];
        System.out.println("Enter the no of Edges");
        e=sc.nextInt();
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                if(i==j)
                    graph[i][j]=0;
                else
                    graph[i][j]=9999;
                   
        for(int i=0;i<e;i++)
        {
            System.out.println("Please enter the data of edge: "+(i+1)+"\nSource: ");
            int s=sc.nextInt();
            System.out.println("Destination: ");
            int d=sc.nextInt();
            System.out.println("Cost");
            int c=sc.nextInt();
            graph[s-1][d-1]=graph[d-1][s-1]=c;
        }
        init_tables();
        update_tables();
        System.out.println("Initial routing tables are");
        print_tables();
        System.out.println("Enter the Source for which cost is changed");
        int s=sc.nextInt();
        System.out.println("Enter the Destination for which cost is changed");
        int d=sc.nextInt();
        System.out.println("Enter the changed cost");
        int c=sc.nextInt();
        graph[s-1][d-1]=graph[d-1][s-1]=c;
        init_tables();
        update_tables();
        System.out.println("New Routing tables are");
        print_tables();
    }
    static void print_tables()
    {
        for(int i[]:rt)
        {
            for(int j:i)
                System.out.print("Dist: "+j+"\t");
            System.out.println();
        }
    }
    static void init_tables()
    {
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
            {
                if(i==j)
                {
                    rt[i][j]=0;via[i][j]=i;
                }
                else
                {
                    rt[i][j]=via[i][j]=9999;
                }
            }
    }
    static void update_tables()
    {
        for(int i=0;i<4*v;i++)
            updatetable(i%v);
    }
    static void updatetable(int s)
    {
        for(int i=0;i<v;i++)
        {
            if(graph[s][i]!=9999)
            {
                int dist=graph[s][i];
                for(int j=0;j<v;j++)
                {
                    int idist=rt[i][j];
                    if(via[i][j]==s)
                        idist=9999;
                    if(dist+idist<rt[s][j])
                    {
                        via[s][j]=i;
                        rt[s][j]=dist+idist;
                    }
                }
            }
        }
    }
}
