package com.example.configuration;

import java.beans.BeanProperty;
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class server {

   public void lancer()   {

       ServerSocket server=null ;
       String line;

       Socket socketOfServer;
       
       try {
           server = new ServerSocket(8085);}
       catch(Exception e) {}
           int nombreClient=0; 
           
           Scanner buff = new Scanner(System.in); 
           
         //cree un tableau de thread
           System.out.print("Rentrer votre nombre de thread :\n");
           int nThread=Integer.parseInt(buff.nextLine());
           Thread_S threadS[] = new Thread_S[nThread+1];
           
           while(nombreClient<nThread) {
          
           System.out.println("Server is waiting to accept user...");
           
           try {
        	   socketOfServer = server.accept();
        	   threadS[nombreClient]=new Thread_S(socketOfServer,nombreClient);
               threadS[nombreClient].start();}
           catch(Exception e) {}
          
           
           
           nombreClient++;
          
           }

           if(threadS[0].activeCount()>1) {
        	   for(int i=0;i<nombreClient-1;i++) {
        	   System.out.print(threadS[nombreClient]);
        	   threadS[nombreClient].stop();
        	   }
        	   }



       System.out.println("Sever stopped!");
   }
}
