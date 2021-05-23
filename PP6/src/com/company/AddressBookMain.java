package com.company;

import java.util.*;

public class AddressBookMain {
    private static Scanner sc;
    List<Contact> contactList;
    static int selectOption;
    private HashMap<String, String> addressBookNameList;
    private boolean isRecordPresent =false;
    String fullname;
    String addressBookName;

    public AddressBookMain() {
        contactList = new ArrayList<>();
        addressBookNameList = new HashMap<String, String>();
    }

    private void createContact() {
        sc.nextLine();
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
        if(duplicateCheck(fullname)) {
            Contact contact = new Contact(addressBookName, firstname, lastname, address, city, state, zip, phonenumber, email);
            contactList.add(contact);
            System.out.println("Record Inserted Successfully");
            System.out.println("\n");
            displayAndSearchContact("");
        }
        else {
            System.out.println("FullName is already Exists");
            displayAndSearchContact("");
        }
    }

    private boolean duplicateCheck(String fullName) {
        for (Contact contact : contactList) {
            if (fullName.equals(contact.getFullname())) {
                return false;
            }
        }
        return true;
    }

    private void editContact() {
        sc =new Scanner(System.in);
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
                    replace(replaceString, fullname, "firstName");
                    isRecordPresent = false;
                    break;
                case "2":
                    System.out.println("Enter your LastName");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "lastName");
                    isRecordPresent = false;
                    break;
                case "3":
                    System.out.println("Enter your Address");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "address");
                    break;
                case "4":
                    System.out.println("Enter your City");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "city");
                    break;
                case "5":
                    System.out.println("Enter your State");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "state");
                    break;
                case "6":
                    System.out.println("Enter your Zip");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "zip");
                    break;
                case "7":
                    System.out.println("Enter your Phone number");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "phoneNumber");
                    break;
                case "8":
                    System.out.println("Enter your Email");
                    replaceString = sc.nextLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "email");
                    break;
                default:
                    isRecordPresent = false;
                    break;
            }
        }
    }

    private void deleteContact() {
        sc = new Scanner(System.in);
        boolean isDeleted = false;
        System.out.println("Enter your full name to search:");
        fullname = sc.nextLine();

        for (int i=0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (fullname.equals(contact.getFullname()) && addressBookName.equals(contact.getAddressBookName())) {
                contact.display();
                contactList.remove(i);
                isDeleted=true;
            }
        }

        if(isDeleted == true) {
            System.out.println("Record Deleted Successfully");
            System.out.println("\n");
        }
        else {
            System.out.println("Record is not Present");
        }

    }

    private void replace(String replaceString, String fullName, String replaceCode) {
        for (Contact contact : contactList) {
            if (fullName.equals(contact.getFullname())) {
                switch (replaceCode) {
                    case "firstName":
                        contact.setFirstname(replaceString);
                        successMessage();
                        displayAndSearchContact("");
                        break;
                    case "lastName":
                        contact.setLastname(replaceString);
                        successMessage();
                        displayAndSearchContact("");
                        break;
                    case "address":
                        contact.setAddress(replaceString);
                        successMessage();
                        displayAndSearchContact(fullName);
                        break;
                    case "city":
                        contact.setCity(replaceString);
                        successMessage();
                        displayAndSearchContact(fullName);
                        break;
                    case "state":
                        contact.setState(replaceString);
                        successMessage();
                        displayAndSearchContact(fullName);
                        break;
                    case "zip":
                        contact.setZip(Integer.parseInt(replaceString));
                        successMessage();
                        displayAndSearchContact(fullName);
                        break;
                    case "phoneNumber":
                        contact.setPhonenumber(replaceString);
                        successMessage();
                        displayAndSearchContact(fullName);
                        break;
                    case "email":
                        contact.setEmail(replaceString);
                        successMessage();
                        displayAndSearchContact(fullName);
                        break;
                }
            }
        }
    }

    private void createAddressBook() {
        sc =new Scanner(System.in);
        System.out.println("Enter your AddressBook Name:");
        addressBookName=sc.nextLine();
        addressBookNameList.put(addressBookName, addressBookName);
        System.out.println("AddressBook is added Successfully");
    }

    private void successMessage() {
        System.out.println("Record Updated Successfully");
        System.out.println("\n");
    }

    private void displayAndSearchContact(String fullname) {
        for (int i=0; i < contactList.size(); i++) {
            Contact contact =contactList.get(i);
            if(!fullname.isEmpty() || !fullname.isBlank()) {
                if (fullname.equals(contact.getFullname()) && addressBookName.equals(contact.getAddressBookName())) {
                    contact.display();
                    isRecordPresent = true;
                }
            }
            else if(addressBookName.equals(contact.getAddressBookName())) {
                contact.display();
            }
        }

        if(contactList.size() == 0) {
            System.out.println("Record is not present");
        }
    }

    private void addContactList() {
        boolean isCheck = true;
        selectAddressBook();
        System.out.println("Welcome to Address Book:" +addressBookName);
        while (isCheck) {
            System.out.println("Please select for the below option" + "\n1. To Create Contact" + "\n2. To Edit Contact" + "\n3. To Delete Contact" + "\n4. Display Record" + "\n5. Exit");
            selectOption = sc.nextInt();

            switch (selectOption) {
                case 1:
                    createContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                case 4:
                    displayAndSearchContact("");
                case 5:
                    isCheck = false;
                    addressBookName="";
                    break;
                default:
                    isCheck = false;
                    addressBookName="";
            }
        }
    }

    private void selectAddressBook() {
        System.out.println("Please Select your address book name for below list, Which you want to save contact: ");
        for (String addressBookName : addressBookNameList.keySet()) {
            System.out.println("Value: " + addressBookNameList.get(addressBookName));
        }
        addressBookName = sc.nextLine();
        boolean isCheck = addressBookNameList.containsValue(addressBookName);
        if(!isCheck) {
            System.out.println("Please select valid address book name");
            System.out.println("\n");
            selectAddressBook();
        }
    }
    public static void main(String args[]) {
        AddressBookMain addressBookMain = new AddressBookMain();
        sc =new Scanner(System.in);

        while(true) {
            System.out.println("Please select below Option:" + "\n1. Create AddressBook" + "\n2. Contact" + "\n3. Exit");
            selectOption = sc.nextInt();
            switch (selectOption) {
                case 1:
                    addressBookMain.createAddressBook();
                    break;
                case 2:
                    addressBookMain.addContactList();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
