import java.io.*;
import java.net.*;
import java.util.HashMap;

public class UDPServer {

	final public int BUF_SIZE = 512;
	final public int TYPE = 0;
	final public int PLATE = 1;
	final public int OWNER = 2;
	private HashMap<String, String> database;
	private DatagramSocket socket;

	private static String serviceAddressStr;
	private static int servicePort;

	private static String multicastAddressStr;
	private static int multicastPort;

	public static void main(String args[]) throws Exception {

		if (args.length != 1) {
			System.out.println("Usage: Wrong number of arguments.\n");
		}

		// open multicast socket
		MulticastSocket multicastSocket = new MulticastSocket();
		multicastSocket.setTimeToLive(1);

		InetAddress multicastAddress = InetAddress.getByName(multicastAddressStr);
		int multicastPort = 4447;

		// 1s interval advertisement control variables
		long elapsedTime = 1000;
		long prevTime = System.currentTimeMillis();

		byte[] buf = new byte[256];
		DatagramPacket advertisementPacket = new DatagramPacket(buf, buf.length,multicastAddress, multicastPort );

		DatagramSocket serverSocket = new DatagramSocket(4445); // usualmente livre o 4445
		serverSocket.setSoTimeout(1000);
		byte[] receiveData = new byte[256];
		byte[] sendData = new byte[256];
		while (true) // o ciclo que esta sempre à escuta do Cliente
		{
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			multicastSocket.send(advertisementPacket);
			serverSocket.receive(receivePacket); //get Time do Receive senão avaça para a frente e continue para o while
			String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println("RECEIVED: " + sentence);
			// process req

			// build response

			// BEGIN --- service advertisement every 1 second
			long currentTime = System.currentTimeMillis();

			elapsedTime += currentTime - prevTime;
			prevTime = currentTime;

			if (elapsedTime >= 1000) {
				elapsedTime -= 1000;

				String advertisement = serviceAddressStr + ":" + Integer.toString(servicePort);
				advertisementPacket = new DatagramPacket(advertisement.getBytes(), advertisement.getBytes().length, multicastAddress,
						multicastPort);
				

				System.out.println("multicast: " + multicastAddressStr + " " + multicastPort + ": " + serviceAddressStr
						+ " " + servicePort);
			}
			// END ---service advertisement

			// build response datagram
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String spacedSentence = sentence.trim(); // adaptar
			sendData = spacedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

			// send response
			serverSocket.send(sendPacket);
			serverSocket.close(); // close server socket
			multicastSocket.close(); // close multicast socket
		}

	}
}
