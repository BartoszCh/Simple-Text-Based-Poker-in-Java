package pl.edu.agh.kis.pz1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",6897);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            System.out.println("Enter your name:");
            Scanner scan = new Scanner(System.in);
            String imie = scan.nextLine();

            dout.writeUTF(imie);
            DataInputStream din = new DataInputStream(s.getInputStream());
            System.out.println(din.readUTF());
            for(int i=0; i<5; i++){
                System.out.println(din.readUTF());
            }

            System.out.println(din.readUTF());
            int answerNumber = 0;

            System.out.println(din.readUTF());
            for(int i=0; i<5; i++){
                System.out.println(din.readUTF());
                scan = new Scanner(System.in);
                String answer = scan.nextLine();
                if (answer.equals("Y") ||answer.equals("y")) answerNumber++;
                dout.writeUTF(answer);
                din = new DataInputStream(s.getInputStream());
                if(answerNumber == 4) break;
            }
            System.out.println(din.readUTF());
            for(int i=0; i<5; i++){
                System.out.println(din.readUTF());
            }
            System.out.println(din.readUTF());
            System.out.println(din.readUTF());
            dout.flush();
            dout.close();
            s.close();
        }catch(Exception e){System.out.println(e);}
    }
}  