package me.leohuachao.cool.pattern.bridge;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/11
 */
public class Client {
    public static void main(String args[]) {
        DataBaseExporter exporter = new MysqlExporter();
        exporter.setWriter(new TXTWriter());

        exporter.export("mysql:127.0.0.1:3306:dinpay", "result.txt");
    }
}
