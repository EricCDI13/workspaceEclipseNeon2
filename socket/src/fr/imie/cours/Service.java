package fr.imie.cours;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

class Service extends Thread
{
    Socket socket;
    boolean serviceActif;
    String message;
 
 
    public Service(Socket pSocketNouveauClient)
    {
        socket = pSocketNouveauClient;
        serviceActif = true;
        message = "";
    }
 
 
    public void run()
    {
        try
        {

 
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
            );
 
            while (serviceActif)
            {
                message = in.readLine();
                System.out.println("in thread");
                System.out.println(message);
                out.write(message);
                out.newLine();
                out.flush();
 
                if (message.equals("quit"))
                    serviceActif = false;
            }
 
            socket.close();
        }
        catch (IOException e)
        {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}