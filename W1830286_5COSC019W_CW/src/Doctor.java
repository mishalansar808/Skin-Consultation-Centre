
public class Doctor extends Person{
    private String medicalLicenceNum;
    private String specialisation;

    //parameterized constructor for Doctor subclass
    public Doctor(String name, String surName, Integer age, String mobileNum, String gender, String medicalLicenceNum, String specialisation){
        super(name, surName, age, mobileNum, gender);

        this.medicalLicenceNum = medicalLicenceNum;
        this.specialisation = specialisation;
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

    public String getMedicalLicenceNum() {
        return medicalLicenceNum;
    }

    public void setMedicalLicenceNum(String medicalLicenceNum) {
        this.medicalLicenceNum = medicalLicenceNum;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}

