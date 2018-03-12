/**
 * ---------------------------------------------------------------------------
 * File name: TCPServer.java
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

class TCPServer {
    public static void main(String argv[]) throws Exception {
		boolean quit = false;
		
		System.out.println("------ Server Terminal ---------");
		System.out.println("--------- Version 1.0 ----------");
		System.out.println("---- Created by: John Ayers ----");
		System.out.println("\n\n");
		System.out.println("Server Ready!");
		System.out.println("-- Waiting for New Connection --");
		
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {

            try {
				quit = false;
				String clientSentence;
						
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				
				System.out.println("Client Connected from: " + connectionSocket.getRemoteSocketAddress().toString() + ":" + connectionSocket.getPort());
				
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                while (!quit) {

                    clientSentence = inFromClient.readLine();
					
                    if (clientSentence.toUpperCase().equals("NAME") || clientSentence.toUpperCase().equals("N")) {
                        outToClient.writeBytes("The Programmers Name is: John David Ayers" + "\n");
                        System.out.println("CLIENT: (" + connectionSocket.getRemoteSocketAddress().toString() + ":" + connectionSocket.getPort() + ") Command: /SIA " + connectionSocket.getRemoteSocketAddress().toString());
                    } else if (clientSentence.toUpperCase().equals("SERVER IP ADDRESS") || clientSentence.toUpperCase().equals("SIA")) {
                        outToClient.writeBytes("Server's IP is: " + connectionSocket.getRemoteSocketAddress().toString() + "\n");
                        System.out.println("CLIENT: (" + connectionSocket.getRemoteSocketAddress().toString() + ":" + connectionSocket.getPort() + ") Command: /SIA " + connectionSocket.getRemoteSocketAddress().toString());
                    } else if (clientSentence.toUpperCase().equals("SERVER PORT") || clientSentence.toUpperCase().equals("SP")) {
                        outToClient.writeBytes("Server Port is: " + connectionSocket.getLocalPort() + "\n");
                        System.out.println("CLIENT: (" + connectionSocket.getRemoteSocketAddress().toString() + ":" + connectionSocket.getPort() + ") Command: /SP " + connectionSocket.getLocalPort());
                    } else if (clientSentence.toUpperCase().equals("CLIENT IP ADDRESS") || clientSentence.toUpperCase().equals("CIA")) {
                        outToClient.writeBytes("Client's IP is: " + connectionSocket.getLocalAddress().toString() + "\n");
                        System.out.println("CLIENT: (" + connectionSocket.getRemoteSocketAddress().toString() + ":" + connectionSocket.getPort() + ") Command: /CIA " + connectionSocket.getLocalAddress().toString());
                    } else if (clientSentence.toUpperCase().equals("CLIENT PORT") || clientSentence.toUpperCase().equals("CP")) {
                        outToClient.writeBytes("Client Port is: " + connectionSocket.getPort() + "\n");
                        System.out.println("CLIENT: (" + connectionSocket.getRemoteSocketAddress().toString() + ":" + connectionSocket.getPort() + ") Command: /CP " + connectionSocket.getPort());
                    } else if (clientSentence.toUpperCase().equals("HELP") || clientSentence.toUpperCase().equals("H")) {
                        outToClient.writeBytes("Accepted Server Commands: \n");
                        System.out.println("CLIENT: (" + connectionSocket.getRemoteSocketAddress().toString() + ":" + connectionSocket.getPort() + ") Command: /HELP \n");
                    } else if (clientSentence.toUpperCase().equals("QUIT") || clientSentence.toUpperCase().equals("Q")) {
                        System.out.println("CLIENT: (" + connectionSocket.getRemoteSocketAddress().toString() + ":" + connectionSocket.getPort() + ") Command: /Quit");
						outToClient.writeBytes("SHUTDOWN");
						System.exit(0);
                    } else {
						outToClient.writeBytes("Unknown Command: " + clientSentence.toUpperCase() + "\n");
                        System.out.println("CLIENT: (" + connectionSocket.getRemoteSocketAddress().toString() + ":" + connectionSocket.getPort() + ") Unknown Command: " + clientSentence.toUpperCase());
					}
                }
				
            } catch (Exception e) {
                quit = true;
                System.out.println("ERROR: Client Lost Connection!");
				System.out.println("-- Waiting for New Connection --");
            }
        }
    }
}
