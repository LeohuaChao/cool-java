package me.leohuachao.cool.pattern.factory;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/9
 */
public class FactoryMethod {
    public static void main(String[] args) {
        ImageReaderFactory factory = new JPGReaderFactory();
        factory.read();
    }
}

interface ImageReader {
    void read();
}

interface ImageReaderFactory {
    ImageReader getImageReader();

    default void read() {
        ImageReader reader = this.getImageReader();
        reader.read();
    }
}

class GIFReaderFactory implements ImageReaderFactory {
    @Override
    public ImageReader getImageReader() {
        return new GIFReader();
    }
}

class GIFReader implements ImageReader {
    @Override
    public void read() {
        System.out.println("read GIF");
    }
}

class JPGReaderFactory implements ImageReaderFactory {
    @Override
    public ImageReader getImageReader() {
        return new JPGReader();
    }
}

class JPGReader implements ImageReader {
    @Override
    public void read() {
        System.out.println("read JPG");
    }
}


