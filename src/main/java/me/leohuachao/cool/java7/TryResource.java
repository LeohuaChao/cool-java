package me.leohuachao.cool.java7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/13
 */
public class TryResource {
    public static void main(String[] args) {

        try (FileInputStream file = new FileInputStream("c://sources//lang.ini")) {
            byte[] b = new byte[1024];
            while (file.read(b) != -1) {
                System.out.println(new String(b));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("11");
        } catch (IOException ex) {
            System.out.println("22");
        }
    }
}
