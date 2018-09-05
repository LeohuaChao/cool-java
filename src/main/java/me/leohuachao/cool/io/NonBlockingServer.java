package me.leohuachao.cool.io;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/23
 */
public class NonBlockingServer {
    public static final Integer DEFAULT_PORT = 8080;

    private static final Logger log = LogManager.getLogger(BlockingServer.class);

    public static void main(String[] args) {

        Configurator.setRootLevel(Level.DEBUG);

        final String response = "HTTP/1.1 200 OK\r\nConnection: Close\r\nContent-Length: 1\r\n\r\nA";

        try (
                Selector selector = Selector.open();
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ) {
            serverSocketChannel.bind(new InetSocketAddress(DEFAULT_PORT));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (selector.select() > 0) {
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()) {
                        ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel client = acceptServerSocketChannel.accept();
                        client.configureBlocking(false);
                        //log.info("Accept request from {}", client.getRemoteAddress());
                        client.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        client.read(buffer);
                        buffer.flip();
                        //log.info(new String(buffer.array()));
                        client.register(selector, SelectionKey.OP_WRITE);
                    } else if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        buffer.put(response.getBytes());
                        buffer.flip();
                        client.write(buffer);
                        key.cancel();
                        client.close();
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
