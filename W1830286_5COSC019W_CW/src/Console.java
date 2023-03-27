import java.util.Scanner;

public class Console {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        WestminsterSkinConsultationManager object = new WestminsterSkinConsultationManager();

        object.Initialise();

        while (true){
            System.out.println("\n");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Skin Consultation Centre <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("\n");
            System.out.println("                                   ~~~MENU~~~                                         ");
            System.out.println("\n");
            System.out.println("**************************************************************************************");
            System.out.println("                       SELECT | A | TO ADD A NEW DOCTOR                               ");
            System.out.println("**************************************************************************************");
            System.out.println("                       SELECT | D | TO DELETE AN EXISTING DOCTOR                      ");
            System.out.println("**************************************************************************************");
            System.out.println("                       SELECT | P | TO PRINT THE LIST OF DOCTORS                      ");
            System.out.println("**************************************************************************************");
            System.out.println("                       SELECT | S | TO SAVE THE LIST OF DOCTORS TO A FILE             ");
            System.out.println("**************************************************************************************");
            System.out.println("                       SELECT | L | TO LOAD THE SAVED LIST OF DOCTORS                 ");
            System.out.println("**************************************************************************************");
            System.out.println("                       SELECT | G | TO OPEN GUI                                       ");
            System.out.println("**************************************************************************************");
            System.out.println("                       SELECT | E | TO END THIS PROGRAM                               ");
            System.out.println("**************************************************************************************");
            System.out.println("\n\n");
            System.out.print("PLEASE INPUT YOUR CHOICE: ");
            String choice = input.next().toUpperCase();
            switch (choice) {
                case "A" -> object.AddNewDoctor();
                case "D" -> object.DeleteDoctor();
                case "P" -> object.DisplayListOfDoctors();
                case "S" -> object.SaveInFile();
                case "L" -> object.LoadFile();
                case "G" -> object.GUI();
                case "E" -> {
                    System.out.println("\nTHE PROGRAM IS ENDING...");
                    System.out.println("THANK YOU...");
                    System.exit(0);//Ending the program
                }
                default -> System.out.println("PLEASE ENTER A VALID CHOICE!!!");
            }
        }
    }
}
