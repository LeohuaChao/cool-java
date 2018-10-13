package me.leohuachao.cool.pattern.Facade;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/12
 */
public class Main {
    public static void main(String args[]) {
        AbstractEncryptFacade encrypt = new EncryptFacade();
        encrypt.fileEncrypt("aaa.txt");
    }
}
