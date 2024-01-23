import java.util.*;
public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of vertices");
		int n=sc.nextInt();
		System.out.println("Enter the edges in form of matrix");
		int a[][]=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(a[i][j]>a[i][k]+a[k][j])
						a[i][j]=a[i][k]+a[k][j];
		System.out.println("Enter the Source to start");
		int s=sc.nextInt();
		System.out.println("Vertex\tDistance from Source Vertex");
		for(int i=0;i<n;i++)
			System.out.println(i+"\t"+a[i][s]);
	}
}
