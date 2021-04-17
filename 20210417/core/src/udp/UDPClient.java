package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @program: core
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-17 19:48
 */
public class UDPClient {
    //服务器的IP
    private static final String ip="152.136.24.204";
    //服务器的端口号
    private static final int port=9001;
    //数据最大长度
    private static final int bleng=1024;

    public static void main(String[] args) throws IOException {

        //1.启动客户端
        DatagramSocket client=new DatagramSocket();
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.print("我：");
            String msg=scanner.nextLine();
            //给服务器端发送消息
            DatagramPacket datagramPacket=new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            client.send(datagramPacket);
            //3.接收服务器的返回消息
            DatagramPacket serPacket=new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            client.receive(serPacket);
            String serMSG=new String(serPacket.getData());
            System.out.println("对方："+serMSG);
        }
    }
}
