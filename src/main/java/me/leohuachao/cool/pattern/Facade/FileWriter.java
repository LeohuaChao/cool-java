package me.leohuachao.cool.pattern.Facade;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/12
 */
public class FileWriter {
    public void write(String filename, String content) {
        System.out.println("save content: " + content + " to file: " + filename);
    }
}
