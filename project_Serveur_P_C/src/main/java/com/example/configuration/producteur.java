package com.example.configuration;
/*cette classe pour les client producteur donc elle va stocker dans une liste*/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.example.model.data;

public class producteur {
	
	static void produce(ObjectInputStream in,Socket server) throws ClassNotFoundException, IOException, InterruptedException {
		String line;
		String client="producteur";	
		//List<String> T=new ArrayList<String>();
		int i=0;
		
	while (true) {
		
        // send to client (consommateur)
        Thread.sleep(3000);
        line=(String) in.readObject();
        System.out.print("client : "+server.getInetAddress()+":"+server.getPort()+">>"+line+"\n");
		data.setT(line);
		// If server send QUIT (To end conversation).
        if (data.getT(i).equals("QUIT\n")) break;
        i++;
        
			}    	
	}
}