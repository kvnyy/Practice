
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Tclient {
    public static void main(String[] args) throws IOException {

        //第一，创建客户端对象Socket，构造方法中绑定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //第二，使用对象中的方法getOutputStream（）获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        //第三，使用网络字节输出流OutputStream对象中的方法write，给服务器发送对象
        os.write("你好服务器".getBytes());
        boolean judge=closeMind();
        if(judge)
            os.write("1".getBytes());
        //第四，使用Socket对象中的方法，getInputStream（）获取网络字节输入流对象，InputStream对象
        InputStream is = socket.getInputStream();
        //第五，使用网络输入流inputStream对象中的方法read，读取服务器回写的数据
        //准备一个数组用来装发送过来的数据
        byte[] bytes = new byte[1024];
        //左边：获取到数据的长度 右边：将数据读入数组中
        int len = is.read(bytes);
        //输出数据到控制台中  从数组bytes将数据转化为字符串  从下标为0的开始，直到下标为len
        System.out.println(new String(bytes, 0, len));

        //第六，释放资源（Socket）
        socket.close();
    }
    public static boolean closeMind()
    {
        System.out.println("click Q to close machine Server");
        char sin;
        Scanner scanner=new Scanner(System.in);
        sin=scanner.next().charAt(0);
        if(sin=='q'||sin=='Q')
            return true;
        else
            return false;
    }
}
