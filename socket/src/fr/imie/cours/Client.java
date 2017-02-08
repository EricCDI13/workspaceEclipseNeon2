package fr.imie.cours;

import java.io.*;
import java.net.*;
 
 
public class Client
{
    public static void main(String[] args) throws IOException
    {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s, reponse, nomDuFichier, hote;
            int port;
            boolean encore;
 
        // On initialise nos variables
            reponse = nomDuFichier = hote = "";
            port = 0;
            encore = true;
 
 
 
        // On affiche un message de bienvenue
            System.out.println("##################################################");
            System.out.println("#                 TCHAT EN LIGNE                 #");
            System.out.println("##################################################");
 
 
        // On demande à l'utilisateur s'il possède un fichier de session
        while (!reponse.equals("o") && !reponse.equals("n"))
        {
            System.out.print("Avez-vous un fichier de session [o/n] ? ");
            reponse = br.readLine();
        }
 
 
 
        // On adapte le comportement du programme à la réponse du client
        if (reponse.equals("o"))
        {
            // On affiche la réponse de l'utilisateur
            System.out.println("Vous avez répondu oui !");
 
            // On demande le nom du fichier de session
            System.out.print("Nom du fichier de session : ");
            nomDuFichier = br.readLine();
 
            // On vérifie l'existence de ce dernier
            try
            {
                FileInputStream fis = new FileInputStream(nomDuFichier);
                System.out.println("Le fichier existe bien !");
 
                InputStreamReader isr2 = new InputStreamReader(fis);
                BufferedReader br2 = new BufferedReader(isr2);
                 
                hote = br2.readLine();
                port = Integer.parseInt(br2.readLine());
                System.out.println("L'hôte récupéré est : " + hote);
                System.out.println("Le port récupéré est : " + port);
            }
            catch (IOException e)
            {
                System.err.println("Le fichier n'existe pas !");
            }
        }
        else
        {
        	// On affiche la réponse de l'utilisateur
            System.out.println("Vous avez répondu non !");
 
            // On lui demande de saisir les informations de connexion à un serveur
            System.out.print("Hote : ");
            hote = br.readLine();
 
            System.out.print("Port : ");
            s = br.readLine();
            port = Integer.parseInt(s);
            s = "";
        }
 
 
 
        // On crée un socket en s'appuyant sur les données récupérées
        try
        {
            Socket sckt0 = new Socket(hote, port);
 
            BufferedReader in = new BufferedReader(
                new InputStreamReader(sckt0.getInputStream())
            );
            BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(sckt0.getOutputStream())
            );
 
            while (encore)
            {
                s = br.readLine();
                out.write(s);
                out.newLine();
                out.flush();
                s = in.readLine();
                if (s.equals("quit"))
                    encore = false;
                else
                    System.out.println("Client reçoit : " + s);
            }
 
            //System.out.print("Enregistrer un fichier de session pour une connexion future ? [o/n] : ")
             
             
            sckt0.close();
        }
        catch (IOException e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}