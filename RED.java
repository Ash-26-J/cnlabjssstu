import java.util.*;
public class RED{
 private static final int MIN_THRESHOLD=10;
 private static final int MAX_THRESHOLD=50;
 private static final double MAX_PROBABILITY=1.0;
 private static class Queue{
  private int length;
  private int[] packets;
  public Queue(int capacity){
   packets=new int[capacity];
   length=0;
  }
  public void addPacket(int packet){
   if(length<packets.length){
    packets[length]=packet;
    length++;
   }
  }
  public int getLength(){
   return length;
  }
 }
 private static double CalculateDropProbability(int queueLength){
  double dropProbability;
  if(queueLength<MIN_THRESHOLD){
   dropProbability=0.0;
  }
  else if(queueLength>MAX_THRESHOLD){
   dropProbability=MAX_PROBABILITY;
  }
  else{
   dropProbability=(double)(queueLength-MIN_THRESHOLD)/(MAX_THRESHOLD-MIN_THRESHOLD);
  }
  return dropProbability;
 }
 private static void simulateREDGateway(Queue queue){
  Random random=new Random();
  int packet;
  for(int i=0;i<20;i++){
   packet=random.nextInt(20);
   double dropProbability=CalculateDropProbability(queue.getLength());
   if(random.nextDouble()<dropProbability){
    System.out.println("Packet " +packet+" dropped");
   }else{
    queue.addPacket(packet);
    System.out.println("Packet "+packet+" added to queue");
   }
  }
 }
 public static void main(String [] args){
  Queue queue=new Queue(15);
  simulateREDGateway(queue);
 }
}              
