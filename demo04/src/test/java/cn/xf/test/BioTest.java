package cn.xf.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: bio单元测试
 * @ClassName: cn.xf.test.BioTest
 * @Author: xiongfeng
 * @Date: 2023/5/10 08:44
 * @Version: 1.0
 */
public class BioTest {

	public static void main(String[] args) {

		try {
			ServerSocket socket = new ServerSocket(9000);
			while (true) {

				Socket accept = socket.accept();
				System.out.println("客户端链接成功---");

//				handle(accept);

				//多线程实现
			new Thread(new Runnable() {
				@Override
				public void run() {
					handle(accept);
				}
			}).start();

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	public static void handle(Socket socket) {


		try {
			byte[] b = new byte[1024];

			System.out.println("准备read～～～");
			int read = socket.getInputStream().read(b);

			System.out.println("读取完毕～～");

			if (read != -1) {

				System.out.println("信息---" + new String(b, 0, read));

			}


		} catch (Exception e) {

		}


	}
}
