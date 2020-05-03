import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",5000);
        while(true){
            BufferedReader console = new BufferedReader(new InputStreamReader((System.in)));
            System.out.println("Enter command:");
            String command = console.readLine();
            PrintWriter pr = new PrintWriter((s.getOutputStream()));
            pr.println(command);
            pr.flush();
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String response = br.readLine();
            System.out.println(response);
            if(response.equals("Server stopped"))
               break;
        }

    }
}
