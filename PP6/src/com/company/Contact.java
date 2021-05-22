package com.company;

public class Contact {
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private int zip;
    private int phonenumber;
    private String email;

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

    public void setState(String State) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

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

    public int getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public Contact(String firstname, String lastname, String address, String city, String state, int zip, int phonenumber, String email) {
        setFirstname(firstname);
        setLastname(lastname);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setPhonenumber(phonenumber);
        setEmail(email);
    }
}