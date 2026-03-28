package ru.itis.inf503.lab2_4.booking;

import java.util.Objects;

public class Person {
    private String gender;
    private String birthdate;
    private String fromcity;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getFromcity() {
        return fromcity;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }

    public Integer getGroup() {
        Integer birth = Integer.parseInt(birthdate.substring(0, 4));
        //1 - 0-14, 2 - 15-18, 3 - 19-25, 4 - 26-35, 5 - 36-45, 6 - 45-...
        // 2008
        if (birth >= 2008) return 1;
        if (birth >= 2004) return 2;
        if (birth >= 1997) return 3;
        if (birth >= 1987) return 4;
        if (birth >= 1977) return 5;
        return 6;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", fromcity='" + fromcity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return gender.equals(person.gender) && birthdate.equals(person.birthdate) && fromcity.equals(person.fromcity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, birthdate, fromcity);
    }
}
