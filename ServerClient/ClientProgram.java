import java.io.*;
import java.net.*;

class ClientProgram {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 1111); // Connect to server at localhost on port 1111
        System.out.println("Connected to server");

        PrintStream ps = new PrintStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Client: ");
            String str1 = kb.readLine();
            ps.println(str1);

            if (str1.equals("exit")) {
                break;
            }

            String str = br.readLine();
            System.out.println("Server: " + str);
        }

        ps.close();
        br.close();
        kb.close();
        s.close();
    }
}
