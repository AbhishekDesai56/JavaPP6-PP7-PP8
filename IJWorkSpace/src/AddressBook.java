import java.util.Scanner;

public class AddressBook {

    private String firstName;
    private  String lastName;
    private  String address;
    private  String city;
    private  String state;
    private  int zip;
    private  int phoneNumber;
    private  String emailId;

    Scanner sc = new Scanner(System.in);

    public AddressBook(String firstName, String lastName, String address, String city, String state, int zip, int phoneNumber, String emailId)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public void AddContanctDetails() {
        System.out.println("Enter your FirstName: ");
        firstName= sc.nextLine();
        System.out.println("Enter your LastName: ");
        lastName=sc.nextLine();
        System.out.println("Enter your Address: ");
        address=sc.nextLine();
        System.out.println("Enter your City: ");
        city=sc.nextLine();
        System.out.println("Enter your State: ");
        state=sc.nextLine();
        System.out.println("Enter the Zip");
        zip=sc.nextInt();
        System.out.println("Enter your Phone Number: ");
        phoneNumber=sc.nextInt();
        System.out.println("Enter your emailId: ");
        emailId=sc.nextLine();
    }

    public void Display() {
        System.out.println("Welcome to Address Book, Please Choose For Below Point");
        System.out.println("1. Add Contact");
        System.out.println("2. Edit Contact");
        System.out.println("3. Delete Contact");
        int selectedNumber=sc.nextInt();
        switch(selectedNumber) {
            case 1:
                AddContanctDetails();
        }

    }

    public static void main(String args[])
    {
       AddressBook addressBook = new AddressBook();
       addressBook.Display();
    }
}
