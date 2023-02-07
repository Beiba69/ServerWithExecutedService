import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(1000);
            ServerSocket serverSock = new ServerSocket(1000);
            System.out.println("the server started");
            while (true) {
                Socket s = serverSock.accept();
                ClientHandler client=new ClientHandler(s);
                executor.execute(client);
                System.out.println("new client connected");
            }
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }



    }



}