
/*
* The AddressBook Program implements an application that simply
* displays the Contacts in Address Book that can be modified in certain ways.
 *
 * @author: Lokesh
 * @date: 26-04-2022
 */
package com.bridgelab.AddressBook;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class AddressBook {
    public static Logger logger = Logger.getLogger(AddressBook.class);
    static boolean isRunning = true;

    //ArrayList object is created
    Collection<Contacts> person = new ArrayList<Contacts>();
    Dictionary address = new Hashtable();

    //Taking input from the user
    static Scanner scanner = new Scanner(System.in);

    /*
     * console method create for taking input as per the User choice.
     */
    public void console() {
        logger.info("-----------------");
        logger.info("1. Create contact");
        logger.info("2. Edit Contact");
        logger.info("3. Delete Contact");
        logger.info("4. Print all contacts");
        logger.info("5. Add multiple person to Address Book");
        logger.info("6. Create another address book");
        logger.info("7. Exit");
        logger.info("Enter your choice: ");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                createContacts();
                break;

            case 2:
                editContacts();
                break;

            case 3:
                deleteContact();
                break;

            case 4:
                printAllContacts();
                break;

            case 5:
                addMultiplePerson();
                break;

            case 6:
                addAddressBook();
                break;

            case 7:
                logger.info("Exit...");
                isRunning = false;
                break;

            default:
                logger.info("Enter valid option: ");
                break;
        }
    }

    /*
     * createContacts method created to create contacts with the given fields.
     */
    public void createContacts() {
        Contacts contacts = new Contacts();

        Scanner scanner = new Scanner(System.in);
        logger.info("Enter First Name: ");
        String firstName = scanner.nextLine();
        contacts.setFirstName(firstName);

        logger.info("Enter Last Name: ");
        String lastName = scanner.nextLine();
        contacts.setLastName(lastName);

        logger.info("Enter Address: ");
        String address = scanner.nextLine();
        contacts.setAddress(address);

        logger.info("Enter City: ");
        String city = scanner.nextLine();
        contacts.setCity(city);

        logger.info("Enter State: ");
        String state = scanner.nextLine();
        contacts.setState(state);

        logger.info("Enter zip: ");
        String zip = scanner.nextLine();
        contacts.setZip(zip);

        logger.info("Enter PhoneNumber: ");
        String phoneNumber = scanner.nextLine();
        contacts.setPhoneNumber(phoneNumber);

        logger.info("Enter Email: ");
        String email = scanner.nextLine();
        contacts.setEmail(email);

        person.add(contacts);
        logger.info("Contact " +firstName+ "created Successfully");
        System.out.println(person.toString());
    }

    /*
     * editContacts method created to update contacts with the given fields.
     */
    public void editContacts() {
        logger.info("Enter the name to edit: ");
        String first = scanner.next();

        boolean isPerson = false;

        //for loop used to get the size of array to edit the contact
        for (int i = 0; i < person.size(); i++) {
            if (((ArrayList<Contacts>) person).get(i).getFirstName().equals(first)) {

                isPerson = true;
                logger.info("Enter your choice to edit: 1. First Name\n2. Last Name\n3. Address\n4.City\n" +
                        "5. State\n6. Zip\n7. PhoneNumber\n8. Email\n9. Exit ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        logger.info("Enter First Name: ");
                        String firstName = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setFirstName(firstName);
                        break;

                    case 2:
                        logger.info("Enter Last Name: ");
                        String lastName = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setLastName(lastName);
                        break;

                    case 3:
                        logger.info("Enter Address: ");
                        String address = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setAddress(address);

                    case 4:
                        logger.info("Enter City: ");
                        String city = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setCity(city);
                        break;

                    case 5:
                        logger.info("Enter State: ");
                        String state = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setState(state);
                        break;

                    case 6:
                        logger.info("Enter Zip: ");
                        String zip = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setZip(zip);
                        break;

                    case 7:
                        logger.info("Enter PhoneNumber: ");
                        String phoneNumber = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setPhoneNumber(phoneNumber);
                        break;

                    case 8:
                        logger.info("Enter Email: ");
                        String email = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setEmail(email);
                        break;

                    default:
                        logger.info("Select valid option: ");

                } //end of switch
                logger.info(person);
            }
        }
        if (!isPerson)
            logger.info("Contact not found!!!");
    } // end of for loop

    /*
     * deleteContacts method created to remove specific contact.
     */
    public void deleteContact() {
        logger.info("Enter the First Name of the contact that you want to delete: ");
        String firstName = scanner.next();

        for (int i = 0; i< person.size();i++) {
            if (((ArrayList<Contacts>) person).get(i).getFirstName().equals(firstName)) {
                person.remove(((ArrayList<Contacts>)person).get(i));
                logger.info("Contact removed successfully!!!");
            } else
                logger.info("Contact not found.");
        }
    }

    /*
     * addMultiplePerson method created to add multiple person to address Book
     */
    public void addMultiplePerson() {
        while (true) {
            logger.info("Enter your choice \n1. Create Contact\n2. Edit Contact" + "\n3. To Delete Contact\n4. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> createContacts();
                case 2 -> editContacts();
                case 3 -> deleteContact();
                case 4 -> System.out.println("Exit..");
                default -> System.out.println("Invalid Choice");
            }
            if (option == 4)
                break;
        }
    }

    /*
     * addAddressBook method created to add new add multiple address book to the system.
     */
    public void addAddressBook() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter name of address Book you want: ");
        AddressBook addressBookMain = new AddressBook();
        String bookName = scanner.nextLine();
        address.put(bookName,addressBookMain);
        logger.info("Address Book " +bookName+ " has been created.");
    }
    /*
     * printAllContacts method created to print all contacts of AddressBook
     */
    public void printAllContacts() {
        for (int i = 0; i < person.size();i++) {
            logger.info(((ArrayList<Contacts>)person).get(i));
        }
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        /*
         * Displaying Welcome to Address Book Program in AddressBookMain class
         */
        logger.info("Welcome to Address Book Program!");
        //AddressBookMain object created
        AddressBook addressBookMain = new AddressBook();
        while (isRunning) {
            addressBookMain.console();
        }
    }
}