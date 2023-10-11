package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       System.out.println("server partito");

       try{

        ServerSocket server = new ServerSocket(3000);
        Socket s =server.accept();

        System.out.println("client collegato");


        BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        int num=(int)(Math.random()*101);
        String stringaRicevuta;
        int c= 0;

        do{

            stringaRicevuta=in.readLine();

            if(Integer.parseInt(stringaRicevuta)<num){

                out.writeBytes("1"+"\n");
            }

            else if(Integer.parseInt(stringaRicevuta)>num){

                out.writeBytes("2"+ '\n');

            }

            c++;
        }while(Integer.parseInt(stringaRicevuta)!=num);

        System.out.println("Stringa indovinata");

        out.writeBytes("3 "+'\n');

        s.close();
        server.close();

        }
        catch(Exception e){


        }
    }
}
