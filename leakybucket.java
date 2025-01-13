import java.util.Scanner;
public class LeakyBucket{
 public static void main(String args[]){
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter number of packets");
  int n=sc.nextInt();
  System.out.println("Enter output rate:");
  int outrate=sc.nextInt();
  System.out.println("Enter bucket size:");
  int bsize=sc.nextInt();
  int [] packets=new int[n];
  System.out.println("Enter packets sizes in order");
  for(int i=0;i<n;i++)
   packets[i]=sc.nextInt();
  int i=0,cycle=0,remains=0,sent=0,dropped=0;
  boolean flag=false;
  System.out.println("Cycle\tPacket\tBucketLimit\tSent\tRemaining");
  while(true){
   cycle++;
   if(packets[i]<=(bsize-remains)){
    if(remains+packets[i]<=outrate){
     sent=remains+packets[i];
     remains=0;
    }
    else{
     remains+=(packets[i]-outrate);
     if(packets[i]+remains > bsize)
      dropped=-1;
     else
      dropped=packets[i]+remains; 
     sent=outrate; 
    }
    if(!flag)
     System.out.println(cycle+"\t"+packets[i]+"\t"+dropped+"\t"+sent+"\t"+remains);
    else
     System.out.println(cycle+"\t"+packets[i]+"\t------\t"+sent+"\t"+remains);
   }
   if(i==(n-1)){
    flag=true;
   if(remains==0)
    break;
   else{
    if(remains<=(bsize)){
     if(remains<=outrate){
      sent=remains;
      remains=0;
     }
     else{
      System.out.println(cycle+"\t----\t drop \t 0 \t" +remains);
      break;
     }
   }        
  }
 } 
  else
  {
  // System.out.println(cycle+"\t"+packets[i]+"\tDrop\t"+sent+"\t"+remains);
   i++;
  }
 }
}
}     
