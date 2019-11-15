package ua.edu.ucu;


import java.util.Objects;

class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.GPA, GPA) == 0 &&
                year == student.year &&
                name.equals(student.name) &&
                surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(GPA, year, name, surname);
    }

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", "
                + "GPA=" + GPA + ", year=" + year + '}';
    }
}
