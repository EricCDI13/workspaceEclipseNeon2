package fr.imie.cours;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;


public class ServeurTchat
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serveur = new ServerSocket(1234);
        boolean serveurActif = true;
 
        // On accepte les connexions de tous les nouveaux clients, qu'on gère dans un nouveau thread (une instance de la classe Service)
        while (serveurActif)
        {
            Socket socketNouveauClient = serveur.accept();
            System.out.println("New client connexion");
            new Service(socketNouveauClient);
        }
 
        serveur.close();
        System.out.println("Au revoir !");
    }
}