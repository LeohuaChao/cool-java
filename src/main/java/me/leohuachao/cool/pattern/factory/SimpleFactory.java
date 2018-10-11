package me.leohuachao.cool.pattern.factory;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/9
 */
public class SimpleFactory {
    public static void main(String[] args) {

        Shape shape = ShapeFactory.getShape("circle");
        shape.draw();
        shape.erase();
    }
}

interface Shape {
    void draw();

    void erase();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw circle");
    }

    @Override
    public void erase() {
        System.out.println("erase cicle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw Triangle");
    }

    @Override
    public void erase() {
        System.out.println("erase Triangle");
    }
}

class ShapeFactory {

    public static Shape getShape(String name) {

        if (name.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (name.equalsIgnoreCase("triangle")) {
            return new Triangle();
        }

        throw new UnSupportedShapeException();
    }
}

class UnSupportedShapeException extends RuntimeException {

}