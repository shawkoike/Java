import java.io.*;
import java.net.*;
import java.util.Scanner;

public class My_server {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    try{
      // connect server
      InetAddress local = InetAddress.getLocalHost();
      String localAdr = local.getHostAddress();
      System.out.println(localAdr);

      // create server socket on port 80
      ServerSocket server_socket = new ServerSocket(8080);

      // waiting connection and get the information of client
      Socket client = server_socket.accept();
      // close socket
      server_socket.close();

      while(true){
        InputStream sok_in = client.getInputStream();
        InputStreamReader sok_is = new InputStreamReader(sok_in);
        BufferedReader sok_br = new BufferedReader(sok_is);
        String message = sok_br.readLine();
        System.out.println(message);
      }
    }catch(Exception e){
      System.out.println(e);
    }
  }
}
