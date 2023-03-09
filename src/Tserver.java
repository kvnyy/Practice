import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tserver {
    public static void main(String[] args) throws IOException {
        //第一，创建服务器ServerSocket对象和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);
        //第二，使用ServerSocket对象中的方法accept，获取到请求的客户端对象Socket
        Socket socket = server.accept();
        //第三，使用Socket对象中的方法getInputStream（）获取网络字节输入流InputSream对象
        InputStream is = socket.getInputStream();
        //第四，使用网络输入流InputStream对象中的方法read，读取客户端发送的数据
        //准备一个数组用来装发送过来的数据
        byte[] bytes = new byte[1024];
        //左边：获取到数据的长度 右边：将数据读入数组中
        int len = is.read(bytes);
        //输出数据到控制台中  从数组bytes将数据转化为字符串  从下标为0的开始，直到下标为len
        System.out.println(new String(bytes, 0, len));

        //第五，使用Socket对象中的方法getOutputStream（）获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        //第六，使用网络字节输出流OutputStream对象中的方法write，给客户端回写数据
        os.write("已经收到你的数据！".getBytes());
        //第七，释放资源（Socket，ServerSocket）
        socket.close();
        server.close();

    }
}
