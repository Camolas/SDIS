import java.io.*;
import java.net.*;



public class UDPClient {

	private static String serviceAddressStr;
	private static int servicePort;

	private static String multicastAddressStr;
	private static int multicastPort;

	private static RequestType oper;
	private static String plate, owner;


	public static void main(String args[]) throws Exception
	   {
	      BufferedReader inFromUser =
	         new BufferedReader(new InputStreamReader(System.in));
	      DatagramSocket clientSocket = new DatagramSocket();
	      InetAddress IPAddress = InetAddress.getByName("localhost");
	      byte[] sendData = new byte[256];
	      byte[] receiveData = new byte[256];
	      String sentence = inFromUser.readLine();
	      sendData = sentence.getBytes();
	      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 4445);
	      clientSocket.send(sendPacket);
	      System.out.println("Packet Send!");
	      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	      clientSocket.receive(receivePacket);
	      String modifiedSentence = new String(receivePacket.getData());
	      System.out.println("FROM SERVER:" + modifiedSentence);
	      clientSocket.close();
	   }
}

