package com.example.configuration;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import com.example.model.*;


/* cette classe pour les consommateur donc il faut preparer les donnees*/
public class consommateur {
	
	static void consome(ObjectOutputStream out,Socket server) throws ClassNotFoundException, IOException, InterruptedException {
		String line;
		String client="consommateur";	
		
		int i=0;
		/*data.setT("salut consommateur islem \n");data.setT("salut consommateur hichem \n");data.setT("zsalut consommateur zaki \n");
		data.setT("QUIT");*/
	while (true) {
		
        // send to client (consommateur)
        Thread.sleep(3000);
		out.writeObject(data.getT(i));
		
		// If server send QUIT (To end conversation).
        if (data.getT(i).equals("QUIT\n")) break;
        i++;
        
			}    	
	}
}
