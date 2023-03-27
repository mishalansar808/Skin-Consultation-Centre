import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    Doctor[] doctor = new Doctor[10];//array to store the number of doctors in the skin consultation centre


    @Override
    public void Initialise() {//initialising all the variables
        for (int x = 0; x < doctor.length; x++) {
            doctor[x] = new Doctor("N/A", "N/A",0,"N/A", "N/A", "N/A",
                    "N/A");
        }
    }

    int docCounter = 0; //counter to keep track of no. of doctors in list


    @Override
    public void AddNewDoctor() {//adding a new doctor

        Scanner input = new Scanner(System.in);

        boolean allocatedSpace = false;

        for (int a = 0; a < doctor.length; a++) {//checking if list has space
            if (!doctor[a].getName().equals("N/A")) {
                allocatedSpace = true;
            } else {
                allocatedSpace = false;
            }
        }

        if (allocatedSpace && docCounter == 10) {//to stop input when the doctors list has reached 10
            System.out.println("THE DOCTOR'S LIST IS FULL.... ");
            System.out.println("PLEASE TRY AGAIN!!!");

        }

        System.out.println("__________________________________________________________________________________");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADD DOCTOR >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("__________________________________________________________________________________");

        int x = 0;
        while (x < doctor.length) {//user input
            try {
                if (doctor[x].getName().equals("N/A")) {
                    System.out.println("Enter First Name: ");
                    String name = input.next().toUpperCase();
                    System.out.println("Enter Surname: ");
                    String surName = input.next().toUpperCase();
                    System.out.println("Enter Age: ");
                    Integer age = input.nextInt();
                    System.out.println("Enter Gender (M or F): ");
                    String gender = input.next().toUpperCase();
                    System.out.println("Enter Mobile Number: ");
                    String mobileNum = input.next();
                    System.out.println("Enter Medical Licence Number: ");
                    String medicalLicenceNum = input.next();
                    medicalLicenceNum = medicalLicenceNum.toUpperCase();
                    System.out.println("Enter Specialisation: ");
                    String specialisation = input.next();
                    specialisation = specialisation.toUpperCase();


                    boolean output = false; //to make  sure the for loop does not implement the if conditions in a loop

                    for (int i = 0; i < doctor.length; i++) {//in case the name of the doctor already exists
                        if (doctor[i].getMedicalLicenceNum().equals(medicalLicenceNum)) {
                            System.out.println("The medical licence number you entered already exist! ");
                            System.out.println("Please try again...");
                            output = true;
                        }
                    }

                    if (!output) {//setting the variables
                        doctor[x].setName(name);
                        doctor[x].setSurName(surName);
                        doctor[x].setAge(age);
                        doctor[x].setGender(gender);
                        doctor[x].setMobileNum(mobileNum);
                        doctor[x].setMedicalLicenceNum(medicalLicenceNum);
                        doctor[x].setSpecialisation(specialisation);
                        System.out.println("Doctor successfully added...");
                        docCounter++;
                        System.out.println("Total No. of Doctors: " + (docCounter));
                        break;


                    }
                } else {
                    x++;
                }
            }catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }

        }
        System.out.println("\n");

    }


    @Override
    public void DeleteDoctor() {//Deleting an existing doctor

        Scanner input = new Scanner(System.in);



        if (docCounter == 0) {//to stop input if the doctors list is empty
            System.out.println("The Doctor's list is empty");
            System.out.println("Please try again!!!");
            return;//ends this part of the program
        }


        System.out.println("__________________________________________________________________________________");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< DELETE DOCTOR >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("__________________________________________________________________________________");
        System.out.println("\n");
        System.out.println("Enter Medical License Number of Doctor: ");
        String medicalLicenceNum = input.next();

        boolean output = false; //to make sure the for loop does not implement the if conditions in a loop

        for (int x = 0; x < doctor.length; x++) {//removing the doctor by resetting the variables to N/A
            if (doctor[x].getMedicalLicenceNum().equals(medicalLicenceNum)) {

                doctor[x].setName("N/A");
                doctor[x].setSurName("N/A");
                doctor[x].setAge(0);
                doctor[x].setGender("N/A");
                doctor[x].setMobileNum("N/A");
                doctor[x].setMedicalLicenceNum("N/A");
                doctor[x].setSpecialisation("N/A");

                System.out.println("The Doctor was removed successfully!!!");
                docCounter--;
                System.out.println("Total No. of Doctors: " + (docCounter));

                output = true;

            }
        }
        if (!output) {//if the user inputs a licence number that is not in the list
            System.out.println("Please enter a valid Licence Number...");
            System.out.println("Try again!!!");
            System.out.println("\n");
        }

    }

    @Override
    public void DisplayListOfDoctors() {//displaying the list of doctors

        System.out.println("__________________________________________________________________________________________________________________");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< DISPLAYING LIST OF DOCTORS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.println("\n");
        System.out.println("NO |      NAME     |     SURNAME     |   AGE   |   GENDER   |  MOBILE NO.  | MEDICAL LICENCE NO. | SPECIALISATION ");
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.println("\n");

        if (doctor[0].getName().equals("N/A")) {//checking if the table is empty
            System.out.print("\n");
            System.out.println("                                                 No Data Available to Display!!!                                                            ");
            System.out.print("\n__________________________________________________________________________________________________________________");
        }
        //sorting the doctors list by surname
        Doctor temp;
        for (int x = 0; x < doctor.length; x++){
            for(int i = x + 1; i < doctor.length; i++){
                if ((doctor[x].getSurName().compareTo(doctor[i].getSurName()) > 0)){
                    temp = doctor[x];
                    doctor[x] = doctor[i];
                    doctor[i] = temp;
                }
            }
        }

        int number = 1;//data input into the table
        for (int x = 0; x < doctor.length; x++) {
            if (!doctor[x].getName().equals("N/A")) {
                System.out.format("%-4s %-17s %-17s %-11s %-9s %-17s %-16s %-27s ",  number + ".", "DR. " +  doctor[x].getName(),
                        doctor[x].getSurName(), doctor[x].getAge(), doctor[x].getGender(), doctor[x].getMobileNum(),
                        doctor[x].getMedicalLicenceNum(), doctor[x].getSpecialisation());
                number ++;
                System.out.println("\n__________________________________________________________________________________________________________________");
            }
        }
    }

    @Override
    public void SaveInFile() {//saving to file
        try {
            FileWriter fileWriter = new FileWriter("Doctors.txt");
            for (Doctor doctor1 : doctor) {
                if (!doctor1.getName().equals("N/A")){
                    fileWriter.write(doctor1.getName() + "-" + doctor1.getSurName() + "-" + doctor1.getAge() + "-" +
                            doctor1.getGender() + "-" + doctor1.getMobileNum() + "-" + doctor1.getMedicalLicenceNum() + "-" +
                            doctor1.getSpecialisation() + "\n");
                }
            }
            System.out.print("\nFile saved successfully");
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred please try again!!!");
            e.printStackTrace();
        }
    }

    @Override
    public void LoadFile() {

        try{
            File file = new File("Doctors.txt");
            Scanner scanner1 = new Scanner(file);
            int i = 0;
            while (scanner1.hasNextLine()){
                String loadedData = scanner1.nextLine();
                String[] splitData = loadedData.split("-");
                Doctor newDoctor = new Doctor(splitData[0], splitData[1], Integer.parseInt(splitData[2]), splitData[4], splitData[3], splitData[5], splitData[6]);
                doctor[i] = newDoctor;
                i++;
            }

            scanner1.close();

        } catch (IOException e) {
            System.out.println("File Not Found!!!");
            e.printStackTrace();

        }
    }

    @Override
    public void GUI(){


        ImageIcon bgIcon = new ImageIcon("logo2.png");

        JLabel label = new JLabel();
        label.setText("Skin Consultation Center");
        label.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        label.setVerticalTextPosition(JLabel.NORTH);
        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setIcon(bgIcon);
        label.setVerticalAlignment(JLabel.NORTH);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(150,10,500, 75);

        JFrame frame = new JFrame();
        frame.setTitle("Skin Consultation Centre");//title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);

        ImageIcon frameIcon = new ImageIcon("logo.png");
        frame.setIconImage(frameIcon.getImage());

        frame.getContentPane().setBackground(new Color(0xbebebe));

        JButton option1 = new JButton(">Option 1<");
        option1.setForeground(new Color(0x000000));
        option1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        option1.setBounds(650, 150, 150, 40 );
        option1.setBackground(new Color(0x7e7e7e));
        frame.add(option1);

        JLabel label1 = new JLabel();
        label1.setText("Display list of Doctors ordered Alphabetically");
        label1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(5, 150, 600, 40);
        frame.add(label1);

        JButton option2 = new JButton(">Option 2<");
        option2.setForeground(new Color(0x000000));
        option2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        option2.setBounds(650, 250, 150, 40 );
        option2.setBackground(new Color(0x7e7e7e));
        frame.add(option2);

        JLabel label2 = new JLabel();
        label2.setText("Book a Consultation");
        label2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        label2.setVerticalTextPosition(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBounds(5, 250, 600, 40);
        frame.add(label2);

        JButton option3 = new JButton(">Option 3<");
        option3.setForeground(new Color(0x000000));
        option3.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        option3.setBounds(650, 350, 150, 40 );
        option3.setBackground(new Color(0x7e7e7e));
        frame.add(option3);

        JLabel label3 = new JLabel();
        label3.setText("View Bookings");
        label3.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        label3.setVerticalTextPosition(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setBounds(5, 350, 600, 40);
        frame.add(label3);


        ImageIcon imgIcon = new ImageIcon("logo1.png");
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(imgIcon);
        imgLabel.setBounds(850, 150, 300, 300);
        imgLabel.setVerticalAlignment(JLabel.CENTER);
        frame.add(imgLabel);

        option1.addActionListener(new ActionListener() { // to Display the list of all the Doctors &
                                                         // their details ordered alphabetically
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor temp;
                for (int x = 0; x < doctor.length; x++){
                    for(int i = x + 1; i < doctor.length; i++){
                        if ((doctor[x].getName().compareTo(doctor[i].getName()) > 0)){
                            temp = doctor[x];
                            doctor[x] = doctor[i];
                            doctor[i] = temp;
                        }
                    }
                }

                String[] tableHead = {"NAME", "SURNAME", "AGE", "MOBILE NO.", "GENDER", "SPECIALISATION", "MEDICAL LICENCE NO."};

                int Doc = 0;
                for (int y = 0; y < doctor.length; y++){
                    if (!doctor[y].getName().equals("N/A")){
                        Doc++;
                    }
                }

                String[][] data = new String[Doc][7];
                for (int z = 0; z < doctor.length; z++) {

                    if(!doctor[z].getName().equals("N/A")){

                        data[z][0] = doctor[z].getName();
                        data[z][1] = doctor[z].getSurName();
                        data[z][2] = String.valueOf(doctor[z].getAge());
                        data[z][3] = doctor[z].getGender();
                        data[z][4] = doctor[z].getMobileNum();
                        data[z][5] = doctor[z].getMedicalLicenceNum();
                        data[z][6] = doctor[z].getSpecialisation();
                    }
                }
                JFrame frame1 = new JFrame("Doctors table"); // creating another frame after clicking on the buttons
                frame1.setResizable(false);
                frame1.setIconImage(frameIcon.getImage());

                JButton doneButton = new JButton("DONE");//done button redirects to the first frame
                doneButton.setBounds(700,400,100,40);
                doneButton.setForeground(new Color(0x000000));
                doneButton.setBackground(new Color(0x7e7e7e));

                doneButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.setVisible(false);
                        frame.setVisible(true);
                    }
                });
                frame1.add(doneButton);

                JTable table = new JTable(data, tableHead);
                JScrollPane scrollPane = new JScrollPane(table);//to make a scrollable view of a component
                frame1.add(scrollPane);

                frame1.setVisible(true);
                frame.setVisible(false);
                frame1.setSize(1500,500); //setting the size of frame1
            }
        });

        option2.addActionListener(new ActionListener() { //Booking a consultation
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame2 = new JFrame();
                frame2.setTitle("Book a Consultation");
                frame2.setSize(1200, 700);
                frame2.setIconImage(frameIcon.getImage());
                frame2.getContentPane().setBackground(new Color(0xbebebe));
                frame2.setResizable(false);
                frame2.setLayout(null);
                frame2.setVisible(true);

                JLabel newLabel = new JLabel();
                newLabel.setText("Book a Consultation");
                newLabel.setFont(new Font("Times New Roman", Font.ITALIC, 40));
                newLabel.setVerticalTextPosition(JLabel.NORTH);
                newLabel.setHorizontalTextPosition(JLabel.RIGHT);
                newLabel.setVerticalAlignment(JLabel.NORTH);
                newLabel.setHorizontalAlignment(JLabel.CENTER);
                newLabel.setBounds(350,10,500, 75);
                frame2.add(newLabel);

                JLabel patientLabel = new JLabel();
                patientLabel.setText("Doctor Details & Availability");
                patientLabel.setFont(new Font("Times New Roman", Font.ITALIC, 30));
                patientLabel.setVerticalAlignment(JLabel.NORTH);
                patientLabel.setHorizontalAlignment(JLabel.LEFT);
                patientLabel.setBounds(100,100,500, 75);
                frame2.add(patientLabel);

                JLabel selDocLabel = new JLabel();
                selDocLabel.setText("Choose a Doctor: ");
                selDocLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                selDocLabel.setBounds(150, 200, 250, 30);

                String[] names = new String[doctor.length];

                for (int n = 0; n < doctor.length; n++) {
                    if (!doctor[n].getName().equals("N/A")) {
                        String name = "Dr. " + doctor[n].getName() + " " + doctor[n].getSurName();
                        names[n] = name;
                    }
                }
                JComboBox selDocComboBox = new JComboBox(names);
                selDocComboBox.setBounds(400, 200, 400, 30);
                selDocComboBox.getName();
                frame2.add(selDocLabel);
                frame2.add(selDocComboBox);

                JLabel selDateLabel = new JLabel();
                selDateLabel.setText("Choose a Date: ");
                selDateLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                selDateLabel.setBounds(150, 270, 250, 30);
                frame2.add(selDateLabel);

                Date today = new Date();
                JSpinner spinner = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.MONTH));
                JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
                spinner.setEditor(dateEditor);
                spinner.setBounds(400,270,200,30);
                frame2.add(spinner);

                JLabel selTimeLabel = new JLabel();
                selTimeLabel.setText("Choose a Time Slot: ");
                selTimeLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                selTimeLabel.setBounds(150, 340, 250, 30);
                frame2.add(selTimeLabel);


                JComboBox timeSlot = new JComboBox();
                timeSlot.addItem("07.00am - 08.00am");
                timeSlot.addItem("08.00am - 09.00am");
                timeSlot.addItem("09.00am - 10.00am");
                timeSlot.addItem("10.00am - 11.00am");
                timeSlot.addItem("11.00am - 12.00pm");
                timeSlot.addItem("12.00pm - 01.00pm");
                timeSlot.addItem("03.00pm - 04.00pm");
                timeSlot.addItem("04.00pm - 05.00pm");
                timeSlot.setBounds(400, 340, 400, 30);
                frame2.add(timeSlot);

                JButton checkButton = new JButton();
                checkButton.setText("Check Availability");
                checkButton.setBounds(400, 400, 250, 40);
                checkButton.setForeground(new Color(0x000000));
                checkButton.setBackground(new Color(0x7e7e7e));
                frame2.add(checkButton);

                checkButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String docName = "";
                        String date = "";
                        String time = "";

                        docName = (String) selDocComboBox.getSelectedItem();
                        time = (String) timeSlot.getSelectedItem();

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        date = sdf.format((Date) spinner.getValue());

                        boolean availability = true;
                        for(Consultation c:SkinConsultationManager.consultationList){
                            if(c.getDocName().equals(docName) && c.getDate().equals(date) && c.getAppointmentTime().equals(time)){
                                availability = false;
                                break;
                            }
                        }
                        if(availability){
                            JOptionPane.showMessageDialog(null,docName+" is available on "+date+" from "+time,"Availability message",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,docName+" is not available on "+date+" from "+time,"Availability message",JOptionPane.ERROR_MESSAGE);
                        }
                    }

                });

                frame2.add(imgLabel);

                JButton nextButton = new JButton("Next");//next button redirects to the third frame
                nextButton.setBounds(660,600,150,40);
                nextButton.setForeground(new Color(0x000000));
                nextButton.setBackground(new Color(0x7e7e7e));
                nextButton.setVisible(true);

                nextButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {



                            JFrame frame3 = new JFrame();
                            frame3.setTitle("Book a Consultation");
                            frame3.setSize(1200, 700);
                            frame3.setIconImage(frameIcon.getImage());
                            frame3.getContentPane().setBackground(new Color(0xbebebe));
                            frame3.setResizable(false);
                            frame3.setLayout(null);
                            frame3.setVisible(true);

                            frame3.add(newLabel);

                            JLabel bookLabel1 = new JLabel();
                            bookLabel1.setText("Patient Details");
                            bookLabel1.setFont(new Font("Times New Roman", Font.ITALIC, 30));
                            bookLabel1.setVerticalAlignment(JLabel.NORTH);
                            bookLabel1.setHorizontalAlignment(JLabel.LEFT);
                            bookLabel1.setBounds(100, 100, 500, 75);
                            frame3.add(bookLabel1);

                        JLabel nameLabel = new JLabel();
                        nameLabel.setText("Name: ");
                        nameLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        nameLabel.setBounds(150, 150, 250, 30);
                        JTextField nameTextField = new JTextField();
                        nameTextField.setBounds(400, 150, 400, 30);

                        frame3.add(nameLabel);
                        frame3.add(nameTextField);

                        JLabel nameLabel1 = new JLabel();
                        nameLabel1.setText("Surname: ");
                        nameLabel1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        nameLabel1.setBounds(150, 200, 300, 30);
                        JTextField nameTextField1 = new JTextField();
                        nameTextField1.setBounds(400, 200, 400, 30);
                        frame3.add(nameLabel1);
                        frame3.add(nameTextField1);

                        JLabel ageLabel = new JLabel();
                        ageLabel.setText("Age: ");
                        ageLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        ageLabel.setBounds(150, 250, 300, 30);
                        JTextField ageTextField = new JTextField();
                        ageTextField.setBounds(400, 250, 400, 30);
                        frame3.add(ageLabel);
                        frame3.add(ageTextField);

                        JLabel mobLabel = new JLabel();
                        mobLabel.setText("Mobile No.: ");
                        mobLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        mobLabel.setBounds(150, 300, 300, 30);
                        JTextField mobTextField = new JTextField();
                        mobTextField.setBounds(400, 300, 400, 30);
                        frame3.add(mobLabel);
                        frame3.add(mobTextField);

                        JLabel genderLabel = new JLabel();
                        genderLabel.setText("Gender: ");
                        genderLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        genderLabel.setBounds(150, 350, 300, 30);
                        frame3.add(genderLabel);

                        JRadioButton gRadioButton1 = new JRadioButton("Male");
                        gRadioButton1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        gRadioButton1.setBounds(450, 350, 200, 30);
                        gRadioButton1.setBackground(new Color(0xbebebe));
                        frame3.add(gRadioButton1);

                        JRadioButton gRadioButton2 = new JRadioButton("Female");
                        gRadioButton2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        gRadioButton2.setBounds(650, 350, 200, 30);
                        gRadioButton2.setBackground(new Color(0xbebebe));
                        frame3.add(gRadioButton2);

                        ButtonGroup buttonGroup0 = new ButtonGroup();
                        buttonGroup0.add(gRadioButton1);
                        buttonGroup0.add(gRadioButton2);

                        JLabel IdLabel = new JLabel();
                        IdLabel.setText("Patient ID: ");
                        IdLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        IdLabel.setBounds(150, 400, 300, 30);

                        JTextField IdTextField = new JTextField();
                        IdTextField.setBounds(400, 400, 400, 30);
                        frame3.add(IdLabel);
                        frame3.add(IdTextField);

                        JLabel newConsult = new JLabel();
                        newConsult.setText("Is this your first Consultation?");
                        newConsult.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        newConsult.setBounds(150, 450, 300, 30);
                        frame3.add(newConsult);

                        JRadioButton radioButton1 = new JRadioButton("Yes");
                        radioButton1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        radioButton1.setBounds(500, 450, 100, 30);
                        radioButton1.setBackground(new Color(0xbebebe));
                        frame3.add(radioButton1);

                        JRadioButton radioButton2 = new JRadioButton("No");
                        radioButton2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        radioButton2.setBounds(700, 450, 100, 30);
                        radioButton2.setBackground(new Color(0xbebebe));
                        frame3.add(radioButton2);

                        ButtonGroup buttonGroup = new ButtonGroup();
                        buttonGroup.add(radioButton1);
                        buttonGroup.add(radioButton2);

                        JLabel feeLabel = new JLabel();
                        feeLabel.setText("Consultation Fee: ");
                        feeLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        feeLabel.setBounds(150, 500, 300, 30);
                        frame3.add(feeLabel);

                        JLabel notesLabel = new JLabel();
                        notesLabel.setText("Notes: ");
                        notesLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
                        notesLabel.setBounds(150, 550, 300, 30);
                        JTextArea notesTextArea = new JTextArea();
                        notesTextArea.setBounds(400, 550, 400, 40);
                        frame3.add(notesLabel);
                        frame3.add(notesTextArea);


                            frame3.add(imgLabel);

                            JButton bookButton = new JButton("Book Consultation");
                            bookButton.setBounds(610, 610, 300, 40);
                            bookButton.setForeground(new Color(0x000000));
                            bookButton.setBackground(new Color(0x7e7e7e));
                            frame3.add(bookButton);

                            JButton cancelButton1 = new JButton("Cancel");//cancel button redirects to the first frame
                            cancelButton1.setBounds(490, 610, 100, 40);
                            cancelButton1.setForeground(new Color(0x000000));
                            cancelButton1.setBackground(new Color(0x7e7e7e));

                            cancelButton1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    frame3.setVisible(false);
                                    frame2.setVisible(true);
                                }
                            });
                            frame3.add(cancelButton1);

                    }
                });
                frame2.add(nextButton);


                JButton cancelButton = new JButton("Cancel");//cancel button redirects to the first frame
                cancelButton.setBounds(490,600,100,40);
                cancelButton.setForeground(new Color(0x000000));
                cancelButton.setBackground(new Color(0x7e7e7e));

                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame2.setVisible(false);
                        frame.setVisible(true);
                    }
                });
                frame2.add(cancelButton);

            }
        });

        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new JFrame();
                frame4.setTitle("Book a Consultation");
                frame4.setSize(1200, 700);
                frame4.setIconImage(frameIcon.getImage());
                frame4.getContentPane().setBackground(new Color(0xbebebe));
                frame4.setResizable(false);
                frame4.setLayout(null);
                frame4.setVisible(true);

                JLabel newLabel1 = new JLabel();
                newLabel1.setText("Book a Consultation");
                newLabel1.setFont(new Font("Times New Roman", Font.ITALIC, 40));
                newLabel1.setVerticalTextPosition(JLabel.NORTH);
                newLabel1.setHorizontalTextPosition(JLabel.RIGHT);
                newLabel1.setVerticalAlignment(JLabel.NORTH);
                newLabel1.setHorizontalAlignment(JLabel.CENTER);
                newLabel1.setBounds(350,10,500, 75);
                frame4.add(newLabel1);

                JLabel patientLabel = new JLabel();
                patientLabel.setText("Bookings");
                patientLabel.setFont(new Font("Times New Roman", Font.ITALIC, 30));
                patientLabel.setVerticalAlignment(JLabel.NORTH);
                patientLabel.setHorizontalAlignment(JLabel.LEFT);
                patientLabel.setBounds(100,100,500, 75);
                frame4.add(patientLabel);

                JButton cancelButton = new JButton("Cancel");//cancel button redirects to the first frame
                cancelButton.setBounds(490,600,100,40);
                cancelButton.setForeground(new Color(0x000000));
                cancelButton.setBackground(new Color(0x7e7e7e));

                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame4.setVisible(false);
                        frame.setVisible(true);
                    }
                });
                frame4.add(imgLabel);
            }
        });
    }
}



