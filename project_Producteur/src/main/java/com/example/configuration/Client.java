package com.example.configuration;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*cette classe est un producteur qui produisse les donnes(T) and send to server*/
public class Client {

	public static void lancer() throws IOException, ClassNotFoundException, InterruptedException {

		InetAddress adrLocale = InetAddress.getLocalHost(); 
	    System.out.println("Adresse locale = "+adrLocale.getHostAddress()+"\n");
       // Server Host
       final String serverHost = "localhost";

       Socket socketOfClient = null;
     
           socketOfClient = new Socket(serverHost, 8085);
           System.out.print("Le client a bien ete accepte comme un producteur\n");
           
           /*seulement pour envoyer de text
           os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
           is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
			*/
           ObjectOutputStream out=new ObjectOutputStream(socketOfClient.getOutputStream());
           ObjectInputStream in=new ObjectInputStream(socketOfClient.getInputStream());
     
           String line;
           //envoi la cle 
           out.writeObject("13");
           Scanner buff = new Scanner(System.in);
           
           List<String> T=new ArrayList<String>();
           T.add("P\n");//pour signaler comme un producteur
           out.writeObject(T);
           T.add("salut producteur islem \n");T.add("salut producteur hichem \n");T.add("zsalut producteur zaki \n");
   		   T.add("QUIT");

           int i=0;

   		   while (true) {
   		
           // send to client (consommateur)
           Thread.sleep(3000);
   		   out.writeObject(T.get(i));
   		
   		// If server send QUIT (To end conversation).
           if (i==T.size()) break;
           i++;
           
   			} 
   		   System.out.println("le producteur est bien fini");
       
   }

}