import java.util.Date;

public class Consultation{
    private final Date date;
    private final String appointmentTime;
    private final String docName;
    private final String consultationFee;
    private String notes;

    public Consultation(String docName, String medicalLicenseNum, Date date, String appointmentTime, String notes, String consultationFee){

        this.docName = docName;
        this.date = date;
        this.appointmentTime = appointmentTime;
        this.notes = notes;
        this.consultationFee = consultationFee;
    }

    public String getDocName() {
        return docName;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public Date getDate() {
        return date;
    }

    public String getConsultationFee() {
        return consultationFee;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
