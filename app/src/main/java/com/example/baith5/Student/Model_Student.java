package com.example.baith5.Student;

public class Model_Student {
    String name;
    Integer year;
    Double mark;

    public Model_Student(String name, Integer year, Double mark) {
        this.name = name;
        this.year = year;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
