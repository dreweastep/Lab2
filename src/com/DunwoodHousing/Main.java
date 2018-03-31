package com.DunwoodHousing;

import java.io.*;
import java.util.*;

public class Main {

    private ArrayList<Resident> residentList = new ArrayList<Resident>();
    private String FILENAME = "resident_records.ser";
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Main main = new Main();
        main.ReadIn();
        main.CreateResident();
        main.PrintList();
        main.WriteOut();



    }
    private void WriteOut() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(residentList);

            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private void ReadIn()
    {
        try {
            FileInputStream fileIn = new FileInputStream(FILENAME);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            residentList = (ArrayList) in.readObject();

            in.close();
            fileIn.close();

        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Resident list not found");
            c.printStackTrace();
        }
    }

    private void PrintList(){

        for(Resident resident : residentList) {

            System.out.println("\n" + resident.residentType);
            System.out.println("ID Number: " + resident.IDNumber);
            System.out.println("First Name: " + resident.firstName);
            System.out.println("Last Name: " + resident.lastName);
            System.out.println("Room Number: " + resident.roomNumber);
            System.out.println("Floor Number: " + resident.floorNumber);
            System.out.println("Monthly Tuition: $" + (int) resident.monthlyRent);

        }
    }

    private void CreateResident() {

        boolean exitCreateResident = false;

        while (!exitCreateResident) {

            Random rand = new Random();
            String ID = Integer.toString(rand.nextInt(10)) +
                        Integer.toString(rand.nextInt(10)) +
                        Integer.toString(rand.nextInt(10)) +
                        Integer.toString(rand.nextInt(10)) +
                        Integer.toString(rand.nextInt(10)) +
                        Integer.toString(rand.nextInt(10));


            System.out.println("Please choose resident type: ");
            System.out.println("(1)Student athlete ");
            System.out.println("(2)Student worker ");
            System.out.println("(3)Scholarship recipient ");
            String residentType = scanner.nextLine();

            System.out.println("Please enter a first name: ");
            String fname = scanner.nextLine();

            System.out.println("Please enter a last name: ");
            String lname = scanner.nextLine();

            System.out.println("Please enter a room number: ");
            String roomNumber = scanner.nextLine();

            if (residentType.equals("1")){

                System.out.println("Please choose a floor number: ");
                System.out.println("(4)");
                System.out.println("(5)");
                System.out.println("(6)");
                String floorNumber = scanner.nextLine();

                StudentAthlete myResident = new StudentAthlete(ID, fname,lname, roomNumber, floorNumber);
                residentList.add(myResident);
            }

            if (residentType.equals("2")){

                System.out.println("Please choose a floor number: ");
                System.out.println("(1)");
                System.out.println("(2)");
                System.out.println("(3)");
                String floorNumber = scanner.nextLine();

                System.out.println("Please enter monthly hours working: ");
                int monthlyHours = Integer.parseInt(scanner.nextLine());

                StudentWorker myResident = new StudentWorker(ID, fname,lname, roomNumber, floorNumber, monthlyHours);
                residentList.add(myResident);
            }

            if (residentType.equals("3")){

                System.out.println("Please choose a floor number: ");
                System.out.println("(7)");
                System.out.println("(8)");
                String floorNumber = scanner.nextLine();

                ScholarshipRecipient myResident = new ScholarshipRecipient(ID, fname,lname, roomNumber, floorNumber);
                residentList.add(myResident);
            }

            System.out.println("Would you like to enter another resident? (y/n)");
            String exit = scanner.nextLine();

            if (exit.equals("n")) {
                exitCreateResident = true;
            }

        }
    }
}
