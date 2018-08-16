package me.leohuachao.cool.io;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/16
 */
public class BlockingMultThreadServer {

    public static final Integer DEFAULT_PORT = 8080;

    private static final Logger log = LogManager.getLogger(BlockingServer.class);

    public static void main(String[] args) throws IOException {
        Configurator.setRootLevel(Level.DEBUG);

        final String response = "HTTP/1.1 200 OK\r\nConnection: Close\r\nContent-Length: 1\r\n\r\nA";

        /**
         * 每个请求都用一个线程去处理，当连接请求过多时，会导致服务器创建的线程过多，造成多线程上下文切换的开销，性能低下
         */

        try (
                ServerSocket server = new ServerSocket(DEFAULT_PORT);
        ) {
            while (true) {

                try {
                    final Socket client = server.accept();    // 阻塞
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                try (
                                        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                                ) {
                                    log.info(in.readLine());    // 阻塞

                                    out.println(response);      // 可能阻塞
                                }
                            } catch (IOException ex) {
                                log.error(ex);
                            }

                        }
                    }.start();
                } catch (IOException ex) {
                    log.error(ex);
                }
            }
        }
    }
}
