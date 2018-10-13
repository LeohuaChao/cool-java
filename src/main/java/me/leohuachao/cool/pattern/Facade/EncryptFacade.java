package me.leohuachao.cool.pattern.Facade;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/12
 */
public class EncryptFacade extends AbstractEncryptFacade {

    private FileReader reader;

    private FileWriter writer;

    private Cipher cipher;

    public EncryptFacade() {
        this.reader = new FileReader();
        this.writer = new FileWriter();
        this.cipher = new Cipher();
    }

    @Override
    void fileEncrypt(String filename) {
        reader.read("aaa.txt");
        cipher.encrypt("aaa");
        writer.write("result.txt","aaa");
        System.out.println("finish encrypt for file.");
    }
}
