package com.rsp.client;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        Socket socket = null;
        String serverIP = "127.0.0.1";
        Scanner scanner = new Scanner(System.in);

        System.out.print("age: ");
        user.setAge(scanner.nextInt());
        System.out.print("name: ");
        user.setName(scanner.next());
        System.out.print("rsp: ");
        user.setRsp(scanner.nextInt());

        System.out.println(String.format("name: %s, age: %d, rsp: %s", user.getName(), user.getAge(), user.getRsp()));

        try{
            System.out.println(String.format("Connecting to server ( %s ) ...", serverIP));

            socket = new Socket(serverIP, 5000);

            //소켓의 출력스트림을 얻는다.
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.write(user.getRsp());
            dos.writeUTF(user.getName());
            dos.write(user.getAge());

            dos.close();
            socket.close();
        }catch (ConnectException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try{
            socket = new Socket(serverIP, 5000);

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
