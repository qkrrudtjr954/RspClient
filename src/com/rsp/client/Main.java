package com.rsp.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try{
            String serverIP = "127.0.0.1";
            System.out.println(String.format("Connecting to server ( %s ) ...", serverIP));

            Socket socket = new Socket(serverIP, 5000);

            //소켓의 입력스트림을 얻는다.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            //소켓으로 부터 받은 데이터를 출력한다.
            System.out.println(String.format("Text from server %s", dis.readUTF()));
            System.out.println("Connection will be close");

            dis.close();
            socket.close();
        }catch (ConnectException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
