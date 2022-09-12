package no.kristiania;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MyHttpClient {
    private final String host;
    InetAddress addr;
    Socket socket;
    private String input = "";

    public MyHttpClient(String host, int port) {
            this.host = host;
        try {
            addr = InetAddress.getByName(host);
            System.out.println(addr);
            socket = new Socket( addr, port );



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String GetMsg() throws IOException {
        BufferedReader BR = null;
        PrintWriter BW = null;

        try {
            BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BW = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        BW.print("GET /get HTTP/1.1\r\n");
        BW.print("Host: "+ host +"\r\n");
        BW.print("Accept: application/json\r\n");
        BW.print("Accept-Encoding: gzip, deflate\r\n");
        BW.print("Accept-Language: nb,en-US;q=0.9,en;q=0.8,nb-NO;q=0.7,no;q=0.6,nn;q=0.5\r\n");
        BW.print("Host: httpbin.org\r\n");
        BW.print("Referer: http://httpbin.org/\r\n");
        BW.print("Connection: close\r\n");
        BW.print("User-Agent: Chrome/54.0.2803.1\r\n\r\n");
        //BW.print("\r\n");
        BW.flush();

        String tmpInput ="";
        while (( tmpInput = BR.readLine()) != null){
            //System.out.println(tmpInput);
            input += tmpInput+"\n";
        }

        BW.close();
        socket.close();

        return input;

    }
}
