
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

    public class ClientHandler implements Runnable {

        Socket s;

        public ClientHandler(Socket s) {
            super();
            this.s = s;
            //start();
                }
            public void run() { byte[] byteArr = new byte[1000];
            int num;
            InputStream is;
            OutputStream os;
            try {
                is = s.getInputStream();
                os=s.getOutputStream();
                while ((num = is.read(byteArr)) > 0) {
                    System.out.println("\rClient sent:");
                    System.out.write(byteArr, 0, num);
                    os.write("\r\n You sent:".getBytes());
                    os.write(byteArr, 0, num);
                }
                System.out.println("\r\nClient disconnected@\n ");

            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }



