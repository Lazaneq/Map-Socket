import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Socketserver {
    public static void main(String[] args)
    throws Exception{
        ServerSocket server = new ServerSocket(300);
        Socket socket = server.accept();
        PrintWriter printWriter= new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("HTTP/1.1 200 OK");
        printWriter.println("Content-Type: text/html; charset=utf-8");
        printWriter.println("Connection: Keep-Alive"+"\n");
        System.out.println("Tekst:");
        Scanner scanner=new Scanner(System.in);

        String str= null;
        while(!(str = scanner.nextLine()).equals("exit")){
            printWriter.println(str);
        }

        scanner.close();
        socket.close();
    }
}
