package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    List<Contact> contactList;
    static int selectOption;
    private HashMap<String, String> addressBookNameList;
    private boolean isRecordPresent =false;
    String fullname;
    String addressBookName;
    String cityName = "", stateName = "", searchPerson = "";
    boolean isViewRecord = false;
    Map<String, List<String>> dictionaryCity;
    Map<String, List<String>> dictionaryState;
    InputStreamReader r=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(r);

    public AddressBookMain() {
        contactList = new ArrayList<>();
        addressBookNameList = new HashMap<String, String>();
        dictionaryCity =  new HashMap<>();
        dictionaryState = new HashMap<>();
    }

    private void createContact() throws IOException {
        System.out.println("Enter your Firstname:");
        String firstname = br.readLine();

        System.out.println("Enter your Lastname:");
        String lastname = br.readLine();

        System.out.println("Enter your Address:");
        String address = br.readLine();

        System.out.println("Enter your City:");
        String city = br.readLine();

        System.out.println("Enter your State:");
        String state = br.readLine();

        System.out.println("Enter your ZipCode:");
        int zip = Integer.parseInt(br.readLine());

        System.out.println("Enter your Phone number:");
        String phonenumber = br.readLine();

        System.out.println("Enter your Email:");
        String email = br.readLine();

        fullname= firstname + " " + lastname;
        if(duplicateCheck(fullname)) {
            Contact contact = new Contact(addressBookName, firstname, lastname, address, city, state, zip, phonenumber, email);
            contactList.add(contact);
            System.out.println("Record Inserted Successfully");
            System.out.println("\n");
            displayAndSearchContact("");
            List<String> lists = new ArrayList<>();
            String listName = firstname + " " + lastname;
            lists.add(listName);
            dictionaryCity.put(city,lists);
            dictionaryState.put(state, lists);
        }
        else {
            System.out.println("FullName is already Exists");
            displayAndSearchContact("");
        }
    }

    private boolean duplicateCheck(String fullName) {
        return contactList.stream().allMatch(n -> !n.getFullname().equals(fullName));
    }

    private void editContact() throws IOException {
        String selectOption;
        String replaceString;
        System.out.println("Enter your full name to search:");
        fullname = br.readLine();
        displayAndSearchContact(fullname);
        if (!isRecordPresent) {
            System.out.println("Record is not Present, Please Enter valid fullname");
            return;
        }
        while(isRecordPresent) {
            System.out.println("Please Enter your choose number which field you what to edit to exit please Enter 0: \n1. FirstName" + "\n2. LastName" + "\n3. Address" + "\n4. City" + "\n5. State" + "\n6. Zip" + "\n7. Phonenumber" + "\n8. email");
            selectOption = br.readLine();

            switch (selectOption) {
                case "1":
                    System.out.println("Enter your FirstName");
                    replaceString = br.readLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "firstName");
                    isRecordPresent = false;
                    break;
                case "2":
                    System.out.println("Enter your LastName");
                    replaceString = br.readLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "lastName");
                    isRecordPresent = false;
                    break;
                case "3":
                    System.out.println("Enter your Address");
                    replaceString = br.readLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "address");
                    break;
                case "4":
                    System.out.println("Enter your City");
                    replaceString = br.readLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "city");
                    List<String> lists = new ArrayList<>();
                    lists.add(fullname);
                    dictionaryCity.put(replaceString, lists);
                    break;
                case "5":
                    System.out.println("Enter your State");
                    replaceString = br.readLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "state");
                    List<String> listState = new ArrayList<>();
                    listState.add(fullname);
                    dictionaryState.put(replaceString, listState);
                    break;
                case "6":
                    System.out.println("Enter your Zip");
                    replaceString = br.readLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "zip");
                    break;
                case "7":
                    System.out.println("Enter your Phone number");
                    replaceString = br.readLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "phoneNumber");
                    break;
                case "8":
                    System.out.println("Enter your Email");
                    replaceString = br.readLine();
                    System.out.println("\n");
                    replace(replaceString, fullname, "email");
                    break;
                default:
                    isRecordPresent = false;
                    break;
            }
        }
    }

    private void deleteContact() throws IOException {
        boolean isDeleted = false;
        System.out.println("Enter your full name to search:");
        fullname = br.readLine();

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

    private void createAddressBook() throws IOException {
        System.out.println("Enter your AddressBook Name:");
        addressBookName=br.readLine();
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

    private void addContactList() throws IOException {
        boolean isCheck = true;
        selectAddressBook();
        System.out.println("Welcome to Address Book:" +addressBookName);
        System.out.println("Welcome to Address Book:" +addressBookName);
        while (isCheck) {
            System.out.println("Please select for the below option" + "\n1. To Create Contact" + "\n2. To Edit Contact" + "\n3. To Delete Contact" + "\n4. Display Record" + "\n5. Search Record" + "\n6. View Record" + "\n7. Sort Data" + "\n8. Exit");
            selectOption = Integer.parseInt(br.readLine());

            switch (selectOption) {
                case 1:
                    createContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    displayAndSearchContact("");
                    break;
                case 5:
                    searchRecord(isViewRecord);
                    break;
                case 6:
                    viewRecord();
                    break;
                case 7:
                    sortData();
                    break;
                case 8:
                    isCheck = false;
                    addressBookName="";
                    break;
                default:
                    isCheck = false;
                    addressBookName="";
            }
        }
    }

    private void askUserWhatToView() throws IOException {
        System.out.println("Do you want to search by City, Please enter Y-Yes and N-No");
        String cityResult = br.readLine();

        if(!cityResult.isEmpty() && !cityResult.isBlank()) {
            if (cityResult.equals("Y")) {
                System.out.println("Please Enter the city name:");
                cityName = br.readLine();
            }
        }

        System.out.println("Do you want to search by State, Please enter Y-Yes and N-No");
        String stateResult = br.readLine();

        if(!stateResult.isEmpty() && !stateResult.isBlank()) {
            if (stateResult.equals("Y")) {
                System.out.println("Please Enter the state name:");
                stateName = br.readLine();
            }
        }

        System.out.println("Please Enter the person name you wait to search");
        searchPerson = br.readLine();
    }

    private void viewRecord() throws IOException {
        boolean results;
        askUserWhatToView();
        if (!cityName.equals("")) {
            results = Optional.ofNullable(dictionaryCity.get(cityName))
                    .map(l -> l.stream().anyMatch(s -> s.contains(searchPerson)))
                    .orElse(false);
        } else {
            results = Optional.ofNullable(dictionaryState.get(stateName))
                    .map(l -> l.stream().anyMatch(s -> s.contains(searchPerson)))
                    .orElse(false);
        }

        if(results) {
            isViewRecord = true;
            searchRecord(isViewRecord);
        }
    }

    private void sortData() throws IOException {
        List<Contact> sortName = null;
        System.out.println("Enter your choice you want to sort \n1. Person Name");
        int sortChoice = Integer.parseInt(br.readLine());
        switch (sortChoice) {
            case 1:
                sortName = contactList.stream().sorted(Comparator.comparing(Contact::getFullname)).collect(Collectors.toList());
                break;
            default:
                break;
        }
       
        for (int i=0; i < sortName.size(); i++) {
            Contact contact = sortName.get(i);
            contact.display();
        }
    }

    private void searchRecord(boolean isViewOrSearchRecord) throws IOException {
        List<Contact> result = null;

        if(!isViewOrSearchRecord) {
            askUserWhatToView();
        }
        if(!cityName.equals("")) {
            long cityCount = contactList.stream().filter(e -> e.getCity().equals(cityName)).count();
            System.out.println("City Count: " +cityCount);
            System.out.println(" ");
        }
        else {
            long stateCount = contactList.stream().filter(e -> e.getState().equals(stateName)).count();
            System.out.println("State Count: " +stateCount);
            System.out.println(" ");
        }

        String finalCityName = cityName;
        String finalStateName = stateName;
        if(searchPerson.isEmpty() && searchPerson.isBlank()) {
            System.out.println("Please Enter the search Person Name");
        } else if (!searchPerson.isBlank() && !finalCityName.isBlank() && !finalStateName.isBlank() &&
                !searchPerson.isEmpty() && !finalCityName.isEmpty() && !finalStateName.isEmpty()) {
            result = contactList.stream()
                    .filter(e -> e.getCity().equals(finalCityName))
                    .filter(e -> e.getState().equals(finalStateName))
                    .filter(e -> e.getFullname().equals(searchPerson))
                    .collect(Collectors.toList());
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).getFullname() + " | " + result.get(i).getCity() + " | " +
                        result.get(i).getAddress() + " | " + result.get(i).getPhonenumber());
            }
        } else if (!searchPerson.isBlank() && !finalCityName.isBlank() && !searchPerson.isEmpty() && !finalCityName.isEmpty()) {
            result = contactList.stream()
                    .filter(e -> e.getCity().equals(finalCityName))
                    .filter(e -> e.getFullname().equals(searchPerson))
                    .collect(Collectors.toList());
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).getFullname() + " | " + result.get(i).getCity() + " | " +
                        result.get(i).getAddress() + " | " + result.get(i).getPhonenumber());
            }
        } else if (!searchPerson.isBlank() && !finalStateName.isBlank() && !searchPerson.isEmpty() && !finalStateName.isEmpty()) {
            result = contactList.stream()
                    .filter(e -> e.getState().equals(finalStateName))
                    .filter(e -> e.getFullname().equals(searchPerson))
                    .collect(Collectors.toList());
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).getFullname() + " | " + result.get(i).getCity() + " | " +
                        result.get(i).getAddress() + " | " + result.get(i).getPhonenumber());
            }
        }
        cityName = "";
        stateName = "";
        searchPerson = "";
        isViewRecord = false;
    }

    private void selectAddressBook() throws IOException {
        System.out.println("Please Select your address book name for below list, Which you want to save contact: ");
        for (String addressBookName : addressBookNameList.keySet()) {
            System.out.println("Value: " + addressBookNameList.get(addressBookName));
        }
        addressBookName = br.readLine();
        boolean isCheck = addressBookNameList.containsValue(addressBookName);
        if(!isCheck) {
            System.out.println("Please select valid address book name");
            System.out.println("\n");
            selectAddressBook();
        }
    }

    public static void main(String args[]) throws IOException {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        AddressBookMain addressBookMain = new AddressBookMain();
        while(true) {
            System.out.println("Please select below Option:" + "\n1. Create AddressBook" + "\n2. Contact" + "\n3. Exit");
            selectOption = Integer.parseInt(br.readLine());
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
