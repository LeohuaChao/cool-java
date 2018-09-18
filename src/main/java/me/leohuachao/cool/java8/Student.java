package me.leohuachao.cool.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/14
 */
public class Student {
    private String name;
    private int age;
    private float score;

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public float getScore() { return score; }

    public Student setName(String name) { this.name = name; return this; }
    public Student setAge(int age) { this.age = age; return this; }
    public Student setScore(float score) { this.score = score; return this; }

    @Override
    public String toString() {
        return String.format("[name: \"%s\", age: %d, score: %.1f]", name, age, score);
    }

    public static void main(String[] args) {
        Student[] students = new Student[30];
        Random rand = new Random();
        Arrays.setAll(students,
                i -> new Student("" + (char)(65 + rand.nextInt(26)) + rand.nextInt(10),
                        rand.nextInt(3) + 14,
                        rand.nextInt(41) + 60));

        Stream<Student> stream = Arrays.stream(students);
        Map<String, List<Student>> map =
                stream.collect(Collectors.groupingBy(stu -> {
                    if (stu.getScore() >= 90) return "90-100";
                    else if (stu.getScore() >= 80) return "80-90";
                    else if (stu.getScore() >= 70) return "70-80";
                    else if (stu.getScore() >= 60) return "60-70";
                    else return "error";
                }));

        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":");
            entry.getValue().forEach(stu -> System.out.println("    " + stu));
        });
    }
}
