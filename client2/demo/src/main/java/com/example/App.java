package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

      Scanner scan=new Scanner(System.in);

      String userName = scan.nextLine();

      try{

        Socket s = new Socket("localhost",3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringaRicevuta=null;
        int num=0;
        out.writeBytes(String.valueOf(num)+'\n');

        do{

            stringaRicevuta = in.readLine();

            if(stringaRicevuta=="2"){

                System.out.println("numero troppo grande");

                System.out.println("inserisci un numero");
                num=scan.nextInt();
            }

            if(stringaRicevuta =="1"){

                System.out.println("numero troppo piccolo");

                System.out.println("inserisci un numero");

                num=scan.nextInt();
            }
        }while(stringaRicevuta!="3");

        s.close();
      }
      catch(UnknownHostException e){

        e.printStackTrace();
      }
      catch(IOException e ){

      }
        
    }
}
