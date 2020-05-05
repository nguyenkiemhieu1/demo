package com.example.baith5.Account;

public class Employee1 {
    public String Name;
    public String Career;
    public String Phone;

    public Employee1(String name, String career, String phone) {
        Name = name;
        Career = career;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCareer() {
        return Career;
    }

    public void setCareer(String career) {
        Career = career;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "Name='" + Name + '\'' +
                ", Career='" + Career + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
