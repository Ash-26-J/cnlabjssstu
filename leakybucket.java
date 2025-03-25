import java.util.*;
public class Main{
    public static void main(String args[]){
        int current=0,rem;
        Scanner in = new Scanner(System.in);
        System.out.println("enter the bucket capacity");
        int capacity = in.nextInt();
        System.out.println("enter the rate");
        int rate =in.nextInt();
        System.out.println("enter the number of packets");
        int n = in.nextInt();
        System.out.println("enter the packet size");
        int pkt = in.nextInt();
        rem = capacity - current;
        if(rem <= pkt){
            current -= pkt;
        }else{
            System.out.println("buffer full");
            System.out.println(" packet dropped");
        }
        System.out.println("current bucket size"+current);
        current -=rate;
        System.out.println("after outing"+current);
        
    }
}
/* o/p
 enter the bucket capacity
10
enter the rate
1
enter the number of packets
4
enter the packet size
20
current bucket size-20
after outing-21
 */
