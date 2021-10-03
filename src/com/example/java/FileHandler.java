package com.example.java;

import java.util.LinkedList;
import java.io.*;
import java.lang.*;

public class FileHandler {

    public LinkedList<Member> readFile () {

        LinkedList<Member> memberList = new LinkedList<>();
        String lineRead;
        String [] splitLine;
        Member mem;

        try(BufferedReader reader = new BufferedReader(new FileReader("members.txt"))){
            lineRead = reader.readLine();
            while(lineRead != null){

                splitLine = lineRead.split(", ");

                if (splitLine[0].equals("S")){
                    mem = new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine [2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                }
                else{
                    mem = new MultiClubMember('M',Integer.parseInt(splitLine[1]),splitLine [2],Double.parseDouble(splitLine[3]),Integer.parseInt(splitLine[4]));
                }
                memberList.add(mem);
                lineRead = reader.readLine();
            }
        }
        catch   (IOException e){

            System.out.println(e.getMessage());
        }
        return memberList;
    }

    public void appendFile(String mem){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("members.txt",true))){

            writer.write(mem + "\n");
            writer.newLine();
        }
        catch   (IOException e){

            System.out.println(e.getMessage());
        }
    }

    public void overwriteFile (LinkedList<Member> memberList){
        String s;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("memberstemp.txt",false))){
            for(int i=0; i<memberList.size();i++){
                s = memberList.get(i).toString();
                writer.write(s+"\n");
            }
        }
        catch   (IOException e){

            System.out.println(e.getMessage());
        }

        try{
            File f= new File ("members.txt");
            File tf = new File("memberstemp.txt");

            f.delete();
            tf.renameTo(f);

        }
        catch   (Exception e){

            System.out.println(e.getMessage());
        }
    }

}
