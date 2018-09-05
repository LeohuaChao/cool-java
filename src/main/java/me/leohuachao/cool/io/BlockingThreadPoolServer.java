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
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/16
 */
public class BlockingThreadPoolServer {

    public static final Integer DEFAULT_PORT = 8080;

    private static final Logger log = LogManager.getLogger(BlockingServer.class);

    public static void main(String[] args) throws IOException {
        Configurator.setRootLevel(Level.DEBUG);

        final String response = "HTTP/1.1 200 OK\r\nConnection: Close\r\nContent-Length: 1\r\n\r\nA";

        /**
         * 这种实现方式，在大量的短连接场景下性能会有所提升，一位不用每次都创建和销毁线程，而是重用线程池中的线程
         * 但在大量长连接的场景中，因为线程被连接长期占用，一样没什么优势
         */

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try (
                ServerSocket server = new ServerSocket(DEFAULT_PORT);
        ) {
            while (true) {

                try {
                    final Socket client = server.accept();    // 阻塞
                    executorService.submit(new Runnable() {
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
                    });

                } catch (IOException ex) {
                    log.error(ex);
                }
            }
        }
    }
}
