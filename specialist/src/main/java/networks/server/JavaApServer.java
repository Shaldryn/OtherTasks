package networks.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaApServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(30333); //создание пассивного сокета

        Socket socket = server.accept(); //останавливает исполнение сервера до тех пор пока кто-то не подключится и не выйдем из accept()
        System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String str;

        while (true) {
            str = reader.readLine();
            if ("close".equals(str)) {
                break;
            }
            System.out.println("Client sent: " + str);

            writer.write(str);
            writer.write(" - accepted\n");
            writer.flush();
        }

        System.out.println("Client closed connection");

    }
}
