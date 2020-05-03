import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {

    public void run(Socket clientSocket) throws IOException {
        System.out.println("Running");
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
        while (true) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String command = in.readLine();
            System.out.println(command);
            if (command.equals("stop")) {
                out.println("Server stopped");
                clientSocket.close();
                break;
            } else
                out.println("received " + command);
        }

    }
}
