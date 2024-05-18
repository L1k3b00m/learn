package net_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class socket_server_test extends Thread{
    ServerSocket socket = null;
    Socket server = null;

    public socket_server_test(int port){
        try {
            socket = new ServerSocket(port);//绑定端口
        }catch (IOException e){
            System.out.println("服务器启动失败");
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("等待客户端连接.....");
            server = socket.accept();
            System.out.println("客户端连接成功:"+server.getInetAddress().getHostAddress());
            new sendMessage().start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter pw = new PrintWriter(server.getOutputStream(),true);//返回给客户端发送方式
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println("客户端发送:"+line);
                pw.println("服务器返回:"+line);
                if(line.equals("bye")) break;
            }
            pw.close();
            reader.close();
            server.close();
        }catch (IOException e){
            System.out.println("服务器连接失败");
        }
    }
    class sendMessage  extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                if(server != null){
                    PrintWriter pw = new PrintWriter(server.getOutputStream(),true);
                    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                    String in = null;
                    while ((in = input.readLine()) != null){
                        pw.println("服务器的通告：" + in);
                        if(in.equals("bye")) break;
                    }
                    pw.close();
                    input.close();
                }

            }catch (IOException e){
                System.out.println("服务器发送失败");
            }
        }
    }

    public static void main(String[] args) {
        socket_server_test server = new socket_server_test(8888);
        server.start();
    }
}
