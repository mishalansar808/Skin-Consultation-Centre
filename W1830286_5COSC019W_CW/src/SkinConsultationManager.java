import java.util.ArrayList;

//interface SkinConsultationManager which contains abstract method
public interface SkinConsultationManager {
    ArrayList<Consultation> consultationList = new ArrayList<>();

    void AddNewDoctor();

    void DeleteDoctor();

    void DisplayListOfDoctors();

    void SaveInFile();

    void LoadFile();

    void Initialise();

    void GUI();
}
