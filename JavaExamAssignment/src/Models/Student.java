package Models;

import java.io.*;

public class Student implements Serializable, Comparable<Student>{

    private static final long serialVersionUID = 1L;

    String name;
    int grade;

    public Student(String name, int grade){this.name = name;this.grade = grade;}

    public String toString(){
        return name+"   "+grade;
    }

    @Override
    public int compareTo(Student s1) {
        return s1.name.compareTo(this.name);
    }
}
