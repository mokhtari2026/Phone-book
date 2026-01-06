import java.util.ArrayList;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
                    //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        int choice;
        PhoneBook phonebook = new PhoneBook();
        Scanner se = new Scanner(System.in);

        do {
            System.out.print("1-Add contact\n2-Remove contact\n3-Edit contact\n4-Show all contact\n5-Search by name\n6-Search by phoneNumber\n7-Exit\n");
            System.out.print("Please Enter Number:");
            choice = se.nextInt();
            se.nextLine();
            ArrayList<Contact> contacts = new ArrayList<>();

            switch (choice) {
                case 1:
                    System.out.print("First name:");
                    String fn = se.nextLine();
                    System.out.print("Last name:");
                    String ln = se.nextLine();
                    System.out.print("Email:");
                    String mail = se.nextLine();
                    System.out.print("Birth day: ");
                    int d = se.nextInt();
                    System.out.print("Birth month: ");
                    int m = se.nextInt();
                    System.out.print("Birth year: ");
                    int y = se.nextInt();
                    se.nextLine();
                    Mydate date = new Mydate(d, m, y);
                    System.out.print("Street: ");
                    String street = se.nextLine();
                    System.out.print("Alley: ");
                    String alley = se.nextLine();
                    System.out.print("Number: ");
                    String num = se.nextLine();
                    System.out.print("Unit: ");
                    String unit = se.nextLine();
                    Address address = new Address(street, alley, num, unit);
                    System.out.println("Choose Group:");
                    System.out.println("1. FAMILY");
                    System.out.println("2. FRIEND");
                    System.out.println("3. UNIVERSITY");
                    System.out.print("Group: ");

                    int g = se.nextInt();
                    se.nextLine();
                    Grouptype group;
                    switch (g) {
                        case 1:
                            group = Grouptype.family;
                            break;
                        case 2:
                            group = Grouptype.friend;
                            break;
                        case 3:
                            group = Grouptype.university;
                            break;
                        default:
                            group = Grouptype.family;
                            System.out.println("wrong number, family selected.");
                    }
                    Contact contact = new Contact(fn, ln, mail, group, date, address);
                    while (true) {
                        System.out.print("phone number:");
                        String phone = se.nextLine();
                        if (contact.hasphone(phone)) {
                            System.out.println("This phone number already exists!");
                            continue;
                        }
                        System.out.println("Choose Phone Type:");
                        System.out.println("1. MOBILE");
                        System.out.println("2. HOME");
                        System.out.println("3. WORK");
                        System.out.println("4. OTHER");
                        System.out.print("Phone type: ");
                        int pt = se.nextInt();
                        se.nextLine();
                        Phonetype phoneType;
                        switch (pt) {
                            case 1:
                                phoneType = Phonetype.mobile;
                                break;
                            case 2:
                                phoneType = Phonetype.home;
                                break;
                            case 3:
                                phoneType = Phonetype.work;
                                break;
                            case 4:
                                phoneType = Phonetype.other;
                                break;
                            default:
                                phoneType = Phonetype.other;
                                System.out.println("wrong number, other selected.");
                        }
                        contact.addphone(new Phonenumber(phone, phoneType));
                        System.out.println("add another phone?(y/n):");
                        if (!se.nextLine().equalsIgnoreCase("y")) {
                            break;
                        }
                    }


                    phonebook.addcontact(contact);
                    System.out.println("Contact added successfully.");
                    break;
                case 2:
                    System.out.print("Enter full name to remove: ");
                    String nametoremove = se.nextLine();
                    phonebook.remove(nametoremove);
                    //System.out.println("Contact removed ");
                    break;

                case 3:
                    System.out.print("1. Edit Name / Email / Group\n2. Edit Address\n3. Edit Birth Date\n4. Edit Phone\nEnter number:");

                    int editChoice = se.nextInt();
                    se.nextLine();

                    System.out.print("Enter full name: ");
                    String name = se.nextLine();

                    switch (editChoice) {

                        // -------- Basic Info --------
                        case 1:
                            System.out.print("New first name (Enter to skip): ");
                            String fna = se.nextLine();

                            System.out.print("New last name (Enter to skip): ");
                            String lna = se.nextLine();

                            System.out.print("New email (Enter to skip): ");
                            String email = se.nextLine();

                            System.out.println("New group (Enter to skip): ");
                            System.out.println("1. FAMILY  2. FRIEND  3. UNIVERSITY");

                            int b = se.nextInt();
                            se.nextLine();
                            Grouptype groupn;

                            switch (b) {
                                case 1:
                                    groupn = Grouptype.family;
                                    break;
                                case 2:
                                    groupn = Grouptype.friend;
                                    break;
                                case 3:
                                    groupn = Grouptype.university;
                                    break;
                                default:
                                    groupn = Grouptype.family;
                                    System.out.println("wrong number, family selected.");
                            }


                            phonebook.edit(name, fna, lna, email, groupn, null, null);
                            break;

                        // -------- Address --------
                        case 2:
                            System.out.print("Street: ");
                            String street1 = se.nextLine();
                            System.out.print("Alley: ");
                            String alley1 = se.nextLine();
                            System.out.print("Number: ");
                            String number = se.nextLine();
                            System.out.print("Unit: ");
                            String unit1 = se.nextLine();

                            phonebook.edit(name, "", "", "", null, null,
                                    new Address(street1, alley1, number, unit1)
                            );
                            break;

                        // -------- Birth Date --------
                        case 3:
                            System.out.print("Day: ");
                            int d1 = se.nextInt();
                            System.out.print("Month: ");
                            int m1 = se.nextInt();
                            System.out.print("Year: ");
                            int y1 = se.nextInt();
                            se.nextLine();

                            phonebook.edit(name, "", "", "", null, new Mydate(d1, m1, y1), null);
                            break;

                        // -------- Phone --------
                        case 4:
                            Contact c = phonebook.searchbyname(name);
                            if (c == null) break;

                            for (int i = 0; i < c.getPhones().size(); i++) {
                                System.out.println(i + ". " + c.getPhones().get(i));
                            }

                            System.out.print("Choose index: ");
                            int index = se.nextInt();
                            se.nextLine();

                            System.out.print("New number (Enter to skip): ");
                            String n = se.nextLine();

                            System.out.println("New type (Enter to skip): ");
                            System.out.println("1.MOBILE 2.HOME 3.WORK 4.OTHER");

                            int pt = se.nextInt();
                            se.nextLine();
                            Phonetype phoneType;
                            switch (pt) {
                                case 1:
                                    phoneType = Phonetype.mobile;
                                    break;
                                case 2:
                                    phoneType = Phonetype.home;
                                    break;
                                case 3:
                                    phoneType = Phonetype.work;
                                    break;
                                case 4:
                                    phoneType = Phonetype.other;
                                    break;
                                default:
                                    phoneType = Phonetype.other;
                                    System.out.println("wrong number, other selected.");
                            }


                            phonebook.editPhone(name, index, n, phoneType);
                            break;


                    }
                        case 4:
                            phonebook.showall();
                            break;
                case 5:
                System.out.print("Enter the full name to find it: ");
                    String firstn= se.nextLine();
                    System.out.println(phonebook.searchbyname(firstn));
                    break;
                case 6:
                    System.out.print("Enter phone to find it: ");
                    String ph = se.nextLine();
                    phonebook.searchbyphone(ph);

break;
                case 7:
                    System.out.println("Goodbye!");
                    break;
                default:

                    System.out.print("Wrong number!\nPlease enter a number from 1 to7 ");


            }
        }while (choice!=7);

se.close();
    }
}