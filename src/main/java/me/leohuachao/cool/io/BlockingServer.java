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
 * @Description: 阻塞 I/O 模式
 * @date 2018/8/15
 */
public class BlockingServer {

    public static final Integer DEFAULT_PORT = 8080;

    private static final Logger log = LogManager.getLogger(BlockingServer.class);

    public static void main(String[] args) throws IOException {

        Configurator.setRootLevel(Level.DEBUG);

        String response = "HTTP/1.1 200 OK\r\nConnection: Close\r\nContent-Length: 1\r\n\r\nA";

        /**
         * 用单线程逐个处理所有请求，同一时间只能处理一个请求，且等待I/O的过程浪费CPU资源
         * 同时无法充分使用多CPU的优势
         */

        try (
                ServerSocket server = new ServerSocket(DEFAULT_PORT);
        ) {
            while (true) {

                try (
                        Socket client = server.accept();    // 阻塞
                        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                ) {

                    log.info(in.readLine());    // 阻塞

                    out.println(response);      // 可能阻塞
                }
            }
        }
    }
}
