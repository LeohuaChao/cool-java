package me.leohuachao.cool.clone;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/10
 */
public class CloneTest {
    public static void main(String args[]) throws CloneNotSupportedException{
        Foo a = new Foo();
        Foo b = a.clone();

        System.out.println(a == b);
        System.out.println(a.getDate() == b.getDate());
        System.out.println(a.getName() == b.getName());
    }
}

class Foo implements Cloneable{
    private String name;
    private String date;

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    protected Foo clone(){
        Object obj;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
        return (Foo)obj;
    }
}
