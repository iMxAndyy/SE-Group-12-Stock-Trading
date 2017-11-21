package com.company;
        import java.io.*;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.net.Socket;
        import java.nio.file.Files;
        import java.nio.file.Paths;



public class Main
{
    public static void main(String[] args) throws IOException {

        float wallet; //Variables for the wallet and stock amounts
        int ibm,
            microsoft,
            gsk,
            bt,
            talktalk,
            itv,
            apple,
            ea,
            tesco,
            google;
        String filename = "inventory.txt"; //inventory file
        String line = null;

        //try  //don't remember what this try was for... help
        //{
         //FileReader fileReader = new FileReader(filename);
         //BufferedReader bufferedReader = new BufferedReader(fileReader);

         //while((line = bufferedReader.readline()) != null)
         //{
         //
         //}
        //}
        //catch (Exception e)
        //{
        //
        //}

        try
        {

            Socket socket = new Socket("10.5.35.152", 5000); //IP of the server
            System.out.println("Success"); //print success when connected

            new File(filename).isFile(); //define the file
            boolean f = new File(filename).exists(); //check if it exists

            if (f) //if the file exists read all the values into the variables
            {
                String  walletString = Files.readAllLines(Paths.get(filename)).get(0),
                        ibmString = Files.readAllLines(Paths.get(filename)).get(2),
                        microsoftString = Files.readAllLines(Paths.get(filename)).get(5),
                        gskString =Files.readAllLines(Paths.get(filename)).get(8),
                        btString =Files.readAllLines(Paths.get(filename)).get(11),
                        talktalkString =Files.readAllLines(Paths.get(filename)).get(14),
                        itvString =Files.readAllLines(Paths.get(filename)).get(17),
                        appleString =Files.readAllLines(Paths.get(filename)).get(20),
                        eaString =Files.readAllLines(Paths.get(filename)).get(23),
                        tescoString =Files.readAllLines(Paths.get(filename)).get(26),
                        googleString =Files.readAllLines(Paths.get(filename)).get(29);
                wallet = Float.parseFloat(walletString);
                ibm = Integer.parseInt(ibmString);
                microsoft = Integer.parseInt(microsoftString);
                gsk = Integer.parseInt(gskString);
                bt = Integer.parseInt(btString);
                talktalk = Integer.parseInt(talktalkString);
                itv = Integer.parseInt(itvString);
                apple = Integer.parseInt(appleString);
                ea = Integer.parseInt(eaString);
                tesco = Integer.parseInt(tescoString);
                google = Integer.parseInt(googleString);

                //print values to console to test
                System.out.println("File exists (values imported)");
                System.out.println("wallet:" + wallet);
                System.out.println("IBM:" + ibm);
                System.out.println("Microsoft:" + microsoft);
                System.out.println("GSK:" + gsk);
                System.out.println("TalkTalk:" + talktalk);
                System.out.println("ITV:" + itv);
                System.out.println("Apple:" + apple);
                System.out.println("EA:" + ea);
                System.out.println("Tesco:" + tesco);
                System.out.println("Google:" + google);

                }
            else //if file doesn't exist. create it.
            {
                System.out.println("Inventory doesn't exist");
                //Add some code to create the file when it doesn't exist.
            }


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter write = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String readline;
            readline = br.readLine();
            while (!readline.equals("end"))//type end to close the program
            {
                write.println(readline);
                write.flush();
                System.out.println("Client:" + readline);
                System.out.println("Server:" + in.readLine());
                readline = br.readLine();
            }
            while (!readline.equals("helo")) //call the appropriate function when we enter each of these
            {

            }
            while (!readline.equals("exit"))
            {

            }
            while (!readline.equals("regi"))
            {

            }
            while (!readline.equals("disp"))
            {

            }
            while (!readline.equals("buy"))
            {

            }
            while (!readline.equals("sell"))
            {

            }
            while (!readline.equals("help"))
            {

            }
            write.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("can not listen to:" + e);
        }
    }
}