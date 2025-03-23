import java.util.*;
public class Main {
static int n;
static int cost[][];
public void bell(int src)
{
    int dist[]=new int[n];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[src]=0;
    for(int i=0;i<n-1;i++)
    {
        for(int v=0;v<n;v++)
        {
            for(int u=0;u<n;u++)
            {
                if(cost[u][v] != Integer.MAX_VALUE && dist[u] + cost[u][v]< dist[v])
                {
                  dist[v]=dist[u]+cost[u][v];
                }
            }
        }
    }
    for(int u=0;u<n;u++){
        for(int v=0;v<n;v++)
        {
            if(cost[u][v]!=Integer.MAX_VALUE && dist[u]+cost[u][v]< dist[v])
            {
                System.out.println("the negative weigth is present \n");
            }
        }
    }
    System.out.println("vertices distance from source\n");
    for(int i=0;i<n;i++)
    {
        System.out.println(i+"\t"+dist[i]);
    }
}
public static void main(String[] args) {

        Main nm = new Main();
        Scanner in = new Scanner(System.in);
        System.out.println("enter the number of vertices for the graph\n");
        n = in.nextInt();
        System.out.println("enter the weight of the graph ");
        cost = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                cost[i][j]=in.nextInt();
            }
        }
        System.out.println("enter the source of the vertices\n");
        int src = in.nextInt();
        nm.bell(src);
    }
}
/* 
enter the number of vertices for the graph

3
enter the weight of the graph 
-1 2 0
4 5 3
3 2 1
enter the source of the vertices

0
the negative weigth is present 

vertices distance from source

0	-2147483647
1	-2147483647
2	-2147483647 
*/


