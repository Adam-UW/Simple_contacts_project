package array.com;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Collections;


// *** Author -> Adam Shandi <- **//
public class Main <T> {

    private static Scanner scanner= new Scanner(System.in);
    private static Mobile  mobile= new Mobile("206-315-1551");


    public static void main(String[] args) {

        boolean quit= false;
        startPhone();
        printAction();
        while(!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action= scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\nShitting down.....");
                    quit=true;
                    break;

                case 1:
                    mobile.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printAction();
                    break;
            }

        }

    }


    private static void startPhone(){
        System.out.println("Stating phone");
    }

    private static void printAction() {
        System.out.println("\nAvailable actions\npress");
        System.out.println(
                "0 - to shutdown\n+" +
                "1 - to print contacts\n" +
                "2- to add a new contact\n" +
                "3  to update existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5- to query is an existing contacts\n"+
                "6- to print a list of available actions");
        System.out.println("Choose your action");
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number for the contact");
        String phone = scanner.nextLine();
        Contacts contact = Contacts.createContact(name, phone);
        if(mobile.addContact(contact)) System.out.println("new contact has been added ");
        else System.out.println("Can not add the existing contact");
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name");
        String name=scanner.nextLine();
        Contacts contact= mobile.queryContact(name);

        if(contact == null){
            System.out.println("has not found");
            return;
        }
        System.out.println("Enter new contact name");
        String newName= scanner.nextLine();
        System.out.println("Enter the contact phone number");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);

        if(mobile.updateContact(contact, newContact)){
            System.out.println("Successfully updated");
        }
        else{
            System.out.println("Error has occurred");
        }

    }


    private static void removeContact() {
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contacts contact = mobile.queryContact(name);

        if (contact == null) {
            System.out.println("has not found");
            return;
        }

        if(mobile.removeContact(contact)){
            System.out.println("Successfully deleted");
        }
        else{
            System.out.println("Error has occurred");
        }

    }

    private static  void queryContact(){
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contacts contact = mobile.queryContact(name);

        if (contact == null) {
            System.out.println("has not found");
            return;
        }

        System.out.println("Name " + contact.getName() + "Phone number is " + contact.getNumber());
    }
}
