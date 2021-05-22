package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
    List<Contact> contactList;

    public AddressBookMain() {
        contactList = new ArrayList<Contact>();
    }
    Scanner sc =new Scanner(System.in);
    public void createContact() {
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
        int zip = sc.nextInt();

        System.out.println("Enter your Phone number:");
        int phonenumber = sc.nextInt();

        System.out.println("Enter your Email:");
        String email = sc.nextLine();

        Contact contact = new Contact(firstname, lastname, address, city, state, zip, phonenumber, email);
        contactList.add(contact);
    }
    public static void main(String args[]) {
        System.out.println("Welcome to Address Book");
    }
}
