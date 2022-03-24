/*cette classe est un consommateur qui consomme les donnes(T) */

package com.example.configuration;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client2 {

	public static void lancer() throws IOException, ClassNotFoundException {

		InetAddress adrLocale = InetAddress.getLocalHost(); 
	    System.out.println("Adresse locale = "+adrLocale.getHostAddress()+"\n");
       // Server Host
       final String serverHost = "localhost";

       Socket socketOfClient = null;
       BufferedWriter os = null;
       BufferedReader is = null;
       	
           socketOfClient = new Socket(serverHost, 8085);
           System.out.print("Le client a bien ete accepte comme un Consommateur\n");
     
           ObjectOutputStream out=new ObjectOutputStream(socketOfClient.getOutputStream());
           ObjectInputStream in=new ObjectInputStream(socketOfClient.getInputStream());
     
           String line;
           //envoi la cle dés la connexion
           out.writeObject("123");
           List<String> T=new ArrayList<String>();
           T.add("C\n");
           out.writeObject(T);
           
           while(true) {
        	   
           line=(String) in.readObject();
           System.out.print("client >> serveur "+socketOfClient.getInetAddress()+":"+socketOfClient.getPort()+">>"+line+"\n");
           if(line.equals("QUIT\n")) break;//il faut definir la facon de quitter la boucle
           }
      
           out.close();
           in.close();
           socketOfClient.close();
       
   }

}