package me.leohuachao.cool.pattern.bridge;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/11
 */
public class TXTWriter implements Writer {
    @Override
    public void write(byte[] data, String filename) {
        System.out.println("save content: " + new String(data));
        System.out.println("save to " + filename + " succeed.");
    }
}
