import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by mahmoud on 5/4/2017.
 */
public class ClientTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8080);
            OutputStream os = socket.getOutputStream();
            os.write("GET /image.jpg".getBytes());
            InputStream inputStream = socket.getInputStream();
            int a;
            StringBuilder builder = new StringBuilder();
            while ((a = inputStream.read()) > -1){
                builder.append((char) a);
            }
            System.out.println(builder.toString());
            inputStream.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
