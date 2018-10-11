package me.leohuachao.cool.pattern.bridge;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/11
 */
public class OracleExporter extends DataBaseExporter {
    @Override
    void export(String connectStr, String filename) {
        System.out.println("connect to oracle: " + connectStr);
        writer.write("XXXX".getBytes(), filename);
        System.out.println("export finished!");
    }
}
