import java.io.Serializable;


//super class Person
public class Person implements Serializable {
    private String name;
    private String surName;
    private Integer age;
    private String mobileNum;
    private String gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    //parameterized constructor for the Person class
    Person(String name, String surName, Integer age, String mobileNum, String gender){
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
        this.mobileNum = mobileNum;

    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getMobileNum() {
        return mobileNum;
    }


}

