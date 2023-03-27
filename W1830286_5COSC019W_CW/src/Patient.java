
public class Patient extends Person{
    private Integer patientId;

    public Patient(String name, String surName, Integer age, String mobileNum, String gender, Integer patientId){
        super(name, surName, age, mobileNum, gender);

        this.patientId = patientId;
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurName(){
        return super.getSurName();
    }

    @Override
    public void setSurName(String surName) {
        super.setSurName(surName);
    }

    @Override
    public Integer getAge(){
        return super.getAge();
    }

    @Override
    public void setAge(Integer age) {
        super.setAge(age);
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender);
    }

    @Override
    public String getMobileNum() {
        return super.getMobileNum();
    }

    @Override
    public void setMobileNum(String mobileNum) {
        super.setMobileNum(mobileNum);
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
}
