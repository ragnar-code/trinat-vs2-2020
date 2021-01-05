package ch.trinat.edu.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TippDesTagesServer {

    String[] tips = {"Prenez de petites bouchées.","Prenez ces jeans serrés. Non, vous n'avez PAS l'air gros dedans.", "En un mot: impossible!", "Soyez honnête, juste aujourd'hui. Dites à votre patron ce que vous pensez * vraiment *.","Peut-être que vous voulez repenser à cette coupe de cheveux après tout."};

    public void los() {

        try (ServerSocket serverSock = new ServerSocket(4242)) {

            while(true) {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String tipp = getTipp();
                writer.println(tipp);
                writer.close();
                System.out.println(tipp);
            }

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    } // los() schliessen

    private String getTipp() {
        int random = (int) (Math.random() * tips.length);
        return tips[random];
    }

    public static void main(String[] args) {
        TippDesTagesServer server = new TippDesTagesServer();
        server.los();
    }
}