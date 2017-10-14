package com.rsp.client;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class RspClient {

    public static void main(String[] args) {
        RspClient client = new RspClient();
        client.connecting();
    }
    public void connecting(){
        Socket socket = null;
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.print("나이: ");
        user.setAge(scanner.nextInt());
        System.out.print("이름: ");
        user.setName(scanner.next());
        System.out.print("가위:1 바위:2 보:3");
        user.setRsp(scanner.nextInt());

        String serverIP = "localhost";
        int port = 3000;

        try{
            socket = new Socket(serverIP, port);

            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write(user.getRsp());
            bw.flush();

            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String result = br.readLine();
            System.out.println("Response from server: "+result);
        }catch(IOException ex){
            ex.printStackTrace();
        } finally{
            try{
                br.close();
                isr.close();
                is.close();

                bw.close();
                osw.close();
                os.close();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
