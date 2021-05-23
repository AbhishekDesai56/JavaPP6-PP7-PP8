package com.company;

import java.util.*;

public class AddressBookMain {
    List<Contact> contactList;
    private boolean isRecordPresent =false;
    String fullname;
    String addressBookName ="ad1";

    public AddressBookMain() {
        contactList = new ArrayList<Contact>();
    }
    Scanner sc =new Scanner(System.in);

    private void createContact() {
        System.out.println("Enter your Firstname:");
        String firstname = sc.nextLine();

        System.out.println("Enter your Lastname:");
        String lastname = sc.nextLine();

        System.out.println("Enter your Address:");
        String address = sc.nextLine();

        System.out.println("Enter your City:");
        String city = sc.nextLine();

        System.out.println("Enter your State:");
        String state = sc.nextLine();

        System.out.println("Enter your ZipCode:");
        int zip = Integer.parseInt(sc.nextLine(),16);

        System.out.println("Enter your Phone number:");
        String phonenumber = sc.nextLine();

        System.out.println("Enter your Email:");
        String email = sc.nextLine();



        fullname= firstname + " " + lastname;
        if(DuplicateCheck(fullname)) {
            Contact contact = new Contact(addressBookName, firstname, lastname, address, city, state, zip, phonenumber, email);
            contactList.add(contact);
            System.out.println("Record Inserted Successfully");
            displayAndSearchContact("");
        }
        else {
            System.out.println("FullName is already Exists");
            displayAndSearchContact("");
        }
    }

    private boolean DuplicateCheck(String fullName) {
        for (Contact contact : contactList) {
            if (fullName.equals(contact.getFullname())) {
                return false;
            }
        }
        return true;
    }

    private void editContact() {
        String selectOption;
        String replaceString;
        System.out.println("Enter your full name to search:");
        fullname = sc.nextLine();
        displayAndSearchContact(fullname);
        if (!isRecordPresent) {
            System.out.println("Record is not Present, Please Enter valid fullname");
            return;
        }
        while(isRecordPresent) {
            System.out.println("Please Enter your choose number which field you what to edit to exit please Enter 0: \n1. FirstName" + "\n2. LastName" + "\n3. Address" + "\n4. City" + "\n5. State" + "\n6. Zip" + "\n7. Phonenumber" + "\n8. email");
            selectOption = sc.nextLine();

            switch (selectOption) {
                case "1":
                    System.out.println("Enter your FirstName");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    Replace(replaceString, fullname, "firstName");
                    isRecordPresent = false;
                    break;
                case "2":
                    System.out.println("Enter your LastName");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    Replace(replaceString, fullname, "lastName");
                    isRecordPresent = false;
                    break;
                case "3":
                    System.out.println("Enter your Address");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    Replace(replaceString, fullname, "address");
                    break;
                case "4":
                    System.out.println("Enter your City");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    Replace(replaceString, fullname, "city");
                    break;
                case "5":
                    System.out.println("Enter your State");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    Replace(replaceString, fullname, "state");
                    break;
                case "6":
                    System.out.println("Enter your Zip");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    Replace(replaceString, fullname, "zip");
                    break;
                case "7":
                    System.out.println("Enter your Phone number");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    Replace(replaceString, fullname, "phoneNumber");
                    break;
                case "8":
                    System.out.println("Enter your Email");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    Replace(replaceString, fullname, "email");
                    break;
                default:
                    isRecordPresent = false;
                    break;
            }
        }
    }

    private void deleteContact() {
        boolean isDeleted = false;
        System.out.println("Enter your full name to search:");
        fullname = sc.nextLine();

        for (int i=0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (fullname.equals(contact.getFullname())) {
                contact.display();
                contactList.remove(i);
                isDeleted=true;
            }
        }

        if(isDeleted == true) {
            System.out.println("Record Deleted Successfully");
        }
        else {
            System.out.println("Record is not Present");
        }

    }

    private void Replace(String replaceString, String fullName, String replaceCode) {
        for (Contact contact : contactList) {
            if (fullName.equals(contact.getFullname())) {
                switch (replaceCode) {
                    case "firstName":
                        contact.setFirstname(replaceString);
                        SuccessMessage();
                        displayAndSearchContact("");
                        break;
                    case "lastName":
                        contact.setLastname(replaceString);
                        SuccessMessage();
                        displayAndSearchContact("");
                        break;
                    case "address":
                        contact.setAddress(replaceString);
                        SuccessMessage();
                        displayAndSearchContact(fullName);
                        break;
                    case "city":
                        contact.setCity(replaceString);
                        SuccessMessage();
                        displayAndSearchContact(fullName);
                        break;
                    case "state":
                        contact.setState(replaceString);
                        SuccessMessage();
                        displayAndSearchContact(fullName);
                        break;
                    case "zip":
                        contact.setZip(Integer.parseInt(replaceString));
                        SuccessMessage();
                        displayAndSearchContact(fullName);
                        break;
                    case "phoneNumber":
                        contact.setPhonenumber(replaceString);
                        SuccessMessage();
                        displayAndSearchContact(fullName);
                        break;
                    case "email":
                        contact.setEmail(replaceString);
                        SuccessMessage();
                        displayAndSearchContact(fullName);
                        break;
                }
            }
        }
    }

    private void SuccessMessage() {
        System.out.println("Record Updated Successfully");
    }

    private void displayAndSearchContact(String fullname) {
        for (int i=0; i < contactList.size(); i++) {
            Contact contact =contactList.get(i);
            if(!fullname.isEmpty() || !fullname.isBlank()) {
                if (fullname.equals(contact.getFullname())) {
                    contact.display();
                    isRecordPresent = true;
                }
            }
            else {
                contact.display();
            }
        }
    }

    public static void main(String args[]) {
        int selectOption;
        Scanner sc1 = new Scanner(System.in);
        AddressBookMain addressBookMain = new AddressBookMain();
        System.out.println("Welcome to Address Book");
        while(true) {
            System.out.println("Please select for the below option" +  "\n1. To Create Contact" + "\n2. To Edit Contact" + "\n3. To Delete Contact");
            selectOption = sc1.nextInt();

            switch (selectOption) {
                case 1:
                    addressBookMain.createContact();
                    break;
                case 2:
                    addressBookMain.editContact();
                    break;
                case 3:
                    addressBookMain.deleteContact();
                default:
                    System.exit(0);
            }

        }
    }
}
