/**
 * ---------------------------------------------------------------------------
 * File name: TCPClient.java
 * Project name: SocketProgramming
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Feb 29, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Feb 29, 2016
 * <hr>
 * @author Allison Ivey
 */
import java.io.*;
import java.net.*;
public class TCPClient
{
	
	    public static void main(String argv[]) throws Exception
	    {
	        String sentence;
	        String modifiedSentence;
	        
	        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	        
	        Socket clientSocket = new Socket("localhost", 6789);
	        
	        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	        
	        System.out.println("CONNECTED TO SERVER: (Type HELP for list of Commands)");

			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
			while (true) {
				try {
					 System.out.print("\nSERVER> ");
					
					sentence = inFromUser.readLine();

					outToServer.writeBytes(sentence + '\n');
					
					modifiedSentence = inFromServer.readLine();
					
					System.out.println("FROM SERVER: " + modifiedSentence);
					if (sentence.toUpperCase().equals("HELP"))
					{
						System.out.println("NAME (N) - Prints the programmers name.");
						System.out.println("SERVER IP ADDRESS (SIA) - Prints the server IP address.");
						System.out.println("SERVER PORT (SP) - Prints the servers port.");
						System.out.println("CLIENT IP ADDRESS (CIA) - Prints the clients IP address.");
						System.out.println("CLIENT PORT (CP) - Prints the clients port.");
						System.out.println("QUIT (Q) - Shuts the server down.");
					}
				} catch (Exception e) {
	                System.out.println("Server has been Shut down. Client will now close.");
					break;
	            }
			}
			System.exit(0);
	    }
}

