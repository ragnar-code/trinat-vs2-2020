package ch.trinat.edu.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TippDesTagesClient {

    public void los() {
        try (Socket s = new Socket("localhost", 4242)) {

            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("Conseils pour aujourd'hui: " + advice);

            reader.close();

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TippDesTagesClient client = new TippDesTagesClient();
        client.los();
    }
}
