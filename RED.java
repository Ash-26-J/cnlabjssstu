import java.util.*;
import java.math.*;
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        System.out.println("enter the maximum packet\n");
        int maxpkt = in.nextInt();
        System.out.println("enter the queue size \n");
        int quesize = in.nextInt();
        System.out.println("enter the max probablity \n");
        Double maxpro = in.nextDouble();
        System.out.println("enter the min probablity \n");
        Double minpro = in.nextDouble();
        Double droppro = minpro;
        int n = maxpkt;
        int quelen =0;
        for(int i=0;i<n;i++){
            if(quelen == quesize){
                System.out.println("the packet is dropped(queue full\n");
                droppro =minpro;
            }else if(Math.random()< droppro){
                System.out.println("the packet is dropped(random)\n");
                droppro += (maxpro-minpro)/(n-1);
            }else{
                System.out.println("packet accepted\n");
                quelen++;
            }
        }
    }
}
/*o/p
enter the maximum picket

20
enter the queue size 

10
enter the max probablity 

0.7
enter the min probablity 

0.3
packet accepted

packet accepted

packet accepted

packet accepted

packet accepted

packet accepted

packet accepted

packet accepted

the packet is dropped(random)

packet accepted

packet accepted

the packet is dropped(queue full)

the packet is dropped(queue full)

the packet is dropped(queue full)

the packet is dropped(queue full)

the packet is dropped(queue full)

the packet is dropped(queue full)

the packet is dropped(queue full)

the packet is dropped(queue full)

the packet is dropped(queue full)
 */
