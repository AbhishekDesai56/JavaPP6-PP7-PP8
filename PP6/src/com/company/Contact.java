package com.company;

public class Contact {
    private String addressBookName;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phonenumber;
    private String email;

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullname() { return firstname + " " + lastname; }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public Contact(String addressBookName,String firstname, String lastname, String address, String city, String state, int zip, String phonenumber, String email) {
        setAddressBookName(addressBookName);
        setFirstname(firstname);
        setLastname(lastname);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setPhonenumber(phonenumber);
        setEmail(email);
    }

    public void display() {
            String fullName = firstname + " " + lastname;
            System.out.println("AddressBookName: " + addressBookName + " | " + "Fullname: " + fullName + " | " + "Firstname: " + firstname + " | " + "Lastname: " + lastname + " | " + "Address: " + address + " | " + "City: " + city + " | " + "State: " + state + " | " + "ZipCode: " + zip  + " | " + "Phonenumber: " + phonenumber + " | " + "Email: " + email + "\n");
    }
}