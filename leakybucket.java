import java.util.*;
public class Main{
    public static void main(String args[]){
        int current=0,rem;
        Scanner in = new Scanner(System.in);
        System.out.println("enter the bucket capacity"
        int capacity = in.nextInt();
        System.out.println("enter the rate");
        int rate =in.nextInt();
        System.out.println("enter the number of packets");
        int n = in.nextInt();
        System.out.println("enter the packet size");
        int pkt = in.nextInt();
        rem = capacity - current;
        if(rem <= rem){
            current += pkt;
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
 enter the packet size
2
enter the packet size
4
enter the packet size
6
buffer full
dropped
enter the packet size
3
current size 9
after outgoing8

 */
