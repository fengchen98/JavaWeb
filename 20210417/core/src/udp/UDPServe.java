package udp;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: core
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-17 19:32
 */
public class UDPServe {
    private static final int port=9001;
    private static final int bleng=1024;
    public static void main(String[] args) throws IOException {
        //1.启动一个UDP服务器
        DatagramSocket socket=new DatagramSocket(port);
        System.out.println("服务器已启动");
        while (true){
            //2.初始化数据包
            DatagramPacket clientPacket=new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            //3.等待客户端的连接
            socket.receive(clientPacket);
            //执行到此，表示已经有客户端连接
            //接收到客户端的信息
            String msg=new String(clientPacket.getData());
            System.out.println("接收到客户端的信息:"+msg);
            //给客户端一个响应
            String serMSG=msg.replace("吗？",".");
            //发送消息
            DatagramPacket serPacket=new DatagramPacket(
                    serMSG.getBytes(),
                    serMSG.getBytes().length,//是字节长度
                    clientPacket.getAddress(),
                    clientPacket.getPort()

            );
            socket.send(serPacket);
        }
    }
}
