package me.leohuachao.cool.pattern.bridge;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/11
 */
public abstract class DataBaseExporter {
    protected Writer writer;

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    abstract void export(String connectStr, String filename);
}
