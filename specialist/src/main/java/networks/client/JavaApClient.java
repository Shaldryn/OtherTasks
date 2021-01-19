package networks.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class JavaApClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 30333);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            str = scan.nextLine();
            writer.write(str);
            writer.write("\n");
            writer.flush();
            if ("close".equals(str)) {
                break;
            }

            str = reader.readLine();
            System.out.println("Server sent: " + str);
        }

        System.out.println("Client closed connection");
    }
}
