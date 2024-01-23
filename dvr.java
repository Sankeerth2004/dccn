import java.util.*;
public class DVR {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of vertices");
		int v=sc.nextInt();
		int cost[][]=new int[v][v];
		for(int i[]:cost)
			Arrays.fill(i, 99999);
		for(int i=0;i<cost.length;i++)
			cost[i][i]=0;
		System.out.println("Enter the no of edges");
		int e=sc.nextInt();
		for(int i=0;i<e;i++)
		{
			System.out.println("Enter the data for edge "+(i+1));
			System.out.print("Source: ");
			int s=sc.nextInt();
			System.out.print("Destination: ");
			int d=sc.nextInt();
			System.out.print("Cost:");
			int c=sc.nextInt();
			cost[s-1][d-1]=cost[d-1][s-1]=c;
		}
		System.out.println("Initial routing table :-");
		dvr(cost.clone());
		System.out.print("Enter the Source for which cost is changed: ");
		int s=sc.nextInt();
		System.out.print("Enter the Destination for which cost is changed: ");
		int d=sc.nextInt();
		System.out.print("Enter the changed Cost:");
		int c=sc.nextInt();
		cost[s-1][d-1]=cost[d-1][s-1]=c;
		System.out.println("New Routing table :-");
		dvr(cost.clone());
	}
	static void dvr(int cost[][])
	{
		int n=cost.length;
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(cost[i][j]>cost[i][k]+cost[k][j])
						cost[i][j]=cost[i][k]+cost[k][j];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print("Dist : "+cost[i][j]+"\t");
			System.out.println();
		}
	}
}
