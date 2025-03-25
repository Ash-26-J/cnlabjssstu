import java.util.*;
import java.math.*;
class Main {
    public static void main(String[] args) {
        int token =0;
        Scanner in = new  Scanner(System.in);
        System.out.println("enter the bucket capacity\n");
        int capacity = in.nextInt();
        System.out.println("enter the rate\n");
        int rate = in.nextInt();
        System.out.println("enter the number of packets\n");
        int n =in.nextInt();
        System.out.println("enter the packet\n");
        int pkt[] = new int[n];
        for(int i=0;i<n;i++)
        {
         pkt[i] = in.nextInt();       
        }
        for(int i=0;i<n;i++){
            token = Math.min(token+rate,capacity) ;
            if(pkt[i] <= token)
            {
                token -= pkt[i];
                System.out.println("packet"+(i+1)+ "is transmitted\n");
            }else{
                System.out.println("packet"+(i+1)+"is discarded\n");
                System.out.println("current tokens are"+token);
            }
        }
    }
}
/* o/p
  enter the bucket capcity 

5
enter the token rate 

2
enter the number of request 

6
enter the packets

1
2
0
2
7
3
packet1is transmited
packet2is transmited
packet3is transmited
packet4is transmited
packet5is discarded
current token is5
packet6is transmited
  */
