import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addcontact(Contact c) {
        contacts.add(c);

    }

    public void remove(String name) {
      boolean n=false;
       n= contacts.removeIf(c -> c.getfullname().equalsIgnoreCase(name));
if (n) {
    System.out.println("Deleted successfully.");
}else
    System.out.println("Not found....\nFailed!");
    }

    public Contact searchbyname(String fullnam) {
        for (Contact c : contacts) {
            if (c.getfullname().equalsIgnoreCase(fullnam)) {
                return c;
            }


        }
       System.out.println("Not found.....");
         return null;
           }

    public void searchbyphone(String phone) {
       boolean n=false;
        for (Contact c : contacts) {
            for (Phonenumber p : c.getPhones()) {
                if (p.getNumber().equals(phone)) {
                    System.out.println(c);
n=true;

                }

            }

        }
    if (n==false)
        System.out.println("Not found!");
    }

    public void showall() {
        if (contacts.isEmpty()) {
            System.out.println("phonebook is empty!");
            return;
        }
        for (Contact c : contacts)
            System.out.println(c);


    }
    public void editPhone(String fullName,
                          int index,
                          String newNumber,
                          Phonetype newType) {

        Contact old = searchbyname(fullName);

        if (old == null) {
            System.out.println("Contact not found!");
            return;
        }

        if (!newNumber.isEmpty() && old.hasphone(newNumber)) {
            System.out.println("Duplicate phone number!");
            return;
        }

        Contact updated = new Contact(
                old.getFirstname(),
                old.getLastname(),
                old.getEmail(),
                old.getGroup(),
                old.getBirthdate(),
                old.getAddress()
        );

        for (int i = 0; i < old.getPhones().size(); i++) {
            Phonenumber p = old.getPhones().get(i);

            if (i == index) {
                updated.addphone(new Phonenumber(
                        newNumber.isEmpty() ? p.getNumber() : newNumber,
                        newType == null ? p.getType() : newType
                ));
            } else {
                updated.addphone(p);
            }
        }

        contacts.remove(old);
        contacts.add(updated);

        System.out.println("Phone edited successfully.");


    }


    public void edit(String fullnam, String firstname, String lastname, String nemail, Grouptype ngroup, Mydate birthdate, Address address) {
        Contact oldcontact = searchbyname(fullnam);
        if (oldcontact == null) {
            System.out.println("contact not found!");
            return;
        }

        String fn = firstname.isEmpty() ? oldcontact.getFirstname() : firstname;
        String ln = lastname.isEmpty() ? oldcontact.getLastname() : lastname;
        String email = nemail.isEmpty() ? oldcontact.getEmail() : nemail;
        Grouptype group = (ngroup == null) ? oldcontact.getGroup() : ngroup;


        Contact updated = new Contact(fn, ln, email, group, birthdate == null ? oldcontact.getBirthdate() : birthdate, address == null ? oldcontact.getAddress() : address);

        for (Phonenumber p : oldcontact.getPhones()) {
            updated.addphone(p);
        }

        contacts.remove(oldcontact);
        contacts.add(updated);

        System.out.println("Contact edited successfully.");
    }


}



