package com.example.configuration;

import java.io.*;
import java.net.*;
import java.util.List;

import jdk.internal.util.xml.impl.Input;

public class Thread_S extends Thread {

	private int N_client;
	private Socket server;
	
	public Thread_S(Socket server,int n_client) {
		super();
		N_client = n_client;
		this.server = server;
	}
	
	public void run() {
		
		System.out.print("Le client : "+N_client+"\t L'@ : "+server.getInetAddress()+"\t Port : "+server.getPort()+"\n");
	      /* BufferedReader in = null;
	       BufferedWriter out=null;
	       
		// Open input and output streams
        try {
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			out = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ObjectOutputStream out=null;
		ObjectInputStream in=null;
		String line=null;
        List<String> T=null;
		try {
			out=new ObjectOutputStream(server.getOutputStream());
			in = new ObjectInputStream(server.getInputStream());
			
			T=(List<String>) in.readObject();
			
			 //affecte a chaque client un consummateur ou un producteur
	        String client;
	        if(T.get(0).equals("C\n")||T.get(0).equals("c\n"))
	        {
	        	System.out.println("salut consommateur\n");
	        	client="consommateur";
	        	consommateur.consome(out, server);
	        		        	
	        }
	        else { 
	        	System.out.println("salut producteur\n");
	        	client="producteur";
	        	producteur.produce(in,server);
	        	}
			
		} catch (ClassNotFoundException | IOException | InterruptedException  e) {
			// TODO Auto-generated catch block
			System.out.println("il ya un probleme au niveau de : run");
			e.printStackTrace();
	
		}
      
          
	}
	
	
}
