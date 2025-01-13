import java.util.*;
public class TokenBucket{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
Random random=new Random();
System.out.println("Enter the number of Packets ");
int n = sc.nextInt();
int tokens=0, bsize;
System.out.print("Enter the Bucket size : ");
bsize=sc.nextInt();
tokens=bsize;
int outrate=random.nextInt(bsize-1)+1;
int [] packets = new int[n];
System.out.println("Enter the packets in order");
for(int i=0; i<n; i++){
packets[i]=sc.nextInt();
}
int i=0, cycle=0,remains=0, sent=0;
boolean flag=false;
System.out.println("Cycle\t Packets\t Sent\t Remains");
while(true){
cycle++;
tokens=bsize-remains;
if(remains + packets[i]<=outrate){
sent=remains + packets[i];
remains=0;
}
else{
remains=bsize;
if(remains<=outrate){
sent=remains;
remains=0;
}
else{
remains=outrate;
sent=outrate;
}
if(!flag){
System.out.println(cycle+"\t" +packets[i]+"\t"+sent+"\t"+remains);
packets[i]=tokens;
}
else
System.out.println(cycle+"\t----\t" +sent+"\t"+remains);
}
if(packets[i]!=0)
continue;
else if(i==(packets.length-1)){
flag=true;
if(remains==0){
break;
}
else
i++;
}
sc.close();
}
}
}

