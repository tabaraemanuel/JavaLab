import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(5000);
                Socket clientSocket = serverSocket.accept();
        ) {
            ClientThread thread = new ClientThread();
            thread.run(clientSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
