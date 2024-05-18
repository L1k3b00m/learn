package net_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class socket_client_test extends Thread{
    Socket socket = null;
    public socket_client_test(String IP,int port){
        try {
            socket = new Socket(IP,port);
        }catch (IOException e){
            System.out.println("连接失败");
        }
    }

    @Override
    public void run() {
        new sendMessage().start();
        super.run();
        try {//接受信息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(br != null){
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    class sendMessage extends Thread{
        @Override
        public void run() {
            super.run();
            if(socket != null){
                try{
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
                    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                    String in = null;
                    while((in = input.readLine()) != null){
                        if(in.equals("exit")) break;
                        pw.println(in);
                    }
                    pw.close();
                    input.close();
                }catch (IOException e){
                    System.out.println("发送失败");
                }
            }
        }
    }

    public static void main(String[] args) {
        new socket_client_test("127.0.0.1",8888).start();
    }
}
