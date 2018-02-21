import java.io.*;
import java.net.*;
import java.util.HashMap;
  
    
public class UDPServer
{
	
    final public int BUF_SIZE=512;
    final public int TYPE=0;
    final public int PLATE=1;
    final public int OWNER=2;  
    private HashMap<String,String> database;
    private DatagramSocket socket;

   public static void main(String args[]) throws Exception
      {
	   
	   if(args.length!=1)
	    {
	        System.out.println("Usage: Wrong number of arguments.\n");
	    }
      
         DatagramSocket serverSocket = new DatagramSocket(41343); //usualmente livre o 4445
            byte[] receiveData = new byte[256];
            byte[] sendData = new byte[256];
            while(true) // o ciclo que esta sempre à escuta do Cliente
               {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData(),0, receivePacket.getLength() );
                  System.out.println("RECEIVED: " + sentence);
                  //process req
                  
                  //build response
                  
                  
                  //build response datagram
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  String spacedSentence = sentence.trim(); // adaptar
                  sendData = spacedSentence.getBytes();
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  
                  //send response
                  serverSocket.send(sendPacket);
               }	
      }
}