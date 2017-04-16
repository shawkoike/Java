import java.io.*;
import java.net.*;
import java.util.Scanner;

public class My_client {
  public static void main(String[] args){
    // Socket
    Socket socket;

    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

    try {
      System.out.println("Server address : ");
      String server_address = buf.readLine();
      // try connection
      socket = new Socket(server_address, 8080);

      OutputStream output = socket.getOutputStream();
      while(true){
        String message = buf.readLine();
        // sending
        output.write(message.getBytes());
        output.write('\n');
      }
    } catch(Exception e){
      System.out.println(e);
    }
  }
}
