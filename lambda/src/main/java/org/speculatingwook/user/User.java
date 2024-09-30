package org.speculatingwook.user;

public class User {
    private String name;
    private int age;
    private String department;
    private double salary;

    public User(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", department='" + department + "', salary=" + salary + "}";
    }
}
