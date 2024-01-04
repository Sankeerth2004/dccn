import java.util.*;
public class Dijkstra
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of vertices");
        int n=sc.nextInt();
        int g[][]=new int[n][n];
        System.out.println("Enter the edges of the graph");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                g[i][j]=sc.nextInt();
        System.out.println("Enter the source to start");
        dijkstra(g,n,sc.nextInt());
    }
    static void dijkstra(int g[][],int n,int s)
    {
        int path[]=new int[n];
        boolean v[]=new boolean[n];
        for(int i=0;i<n;i++)
            path[i]=Integer.MAX_VALUE;
        path[s]=0;
        for(int i=0;i<n;i++)
        {
            int x=minDistance(path,v);
            v[x]=true;
                for(int j=0;j<n;j++)
                    if(!v[j]&&g[x][j]!=0&&path[x]+g[x][j]<path[j])
                        path[j]=path[x]+g[x][j];
        }
        System.out.println("Vertex\tDistance from Source vertex");
        for(int i=0;i<n;i++)
            System.out.println(i+"\t\t"+path[i]);
    }
    static int minDistance(int path[],boolean v[])
    {
        int min=Integer.MAX_VALUE,idx=-1;
        for(int i=0;i<path.length;i++)
            if(!v[i]&&path[i]<=min)
            {
                min=path[i];
                idx=i;
            }
        return idx;
    }
}

