import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String firstname;
    private String lastname;
    private String email;
    private Grouptype group;
    private Mydate birthdate;
    private Address address;
    private ArrayList<Phonenumber> phones;
//------------------------DefaultConstructor ------
public Contact(){
    firstname="null";
    lastname="null";
    email="null";
    group=Grouptype.university;

}
    //-------------------------AllPropertiesConstructor
 public Contact(String firstname,String lastname,String email,Grouptype group,Mydate birthdate,Address address){
    this.firstname=firstname;
    this.lastname=lastname;
    this.phones=new ArrayList<>();
    this.address=address;
    this.email=email;
    this.group=group;
    this.birthdate=birthdate;

 }
    //-------------------------CopyConstructor
public Contact(Contact obj){
    firstname=obj.firstname;
    lastname=obj.lastname;
    phones=obj.phones;
    address=obj.address;
    email=obj.email;
    group=obj.group;
    birthdate=obj.birthdate;

}



    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }


    public List<Phonenumber> getPhones() {
        return phones;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setGroup(Grouptype group) {
        this.group = group;
    }

    public Grouptype getGroup() {
        return group;
    }

    public void setBirthdate(Mydate birthdate) {
        this.birthdate = birthdate;
    }

    public Mydate getBirthdate() {
        return birthdate;
    }


    public void addphone(Phonenumber phone){
    phones.add(phone);
}
public void removephone(Phonenumber phone){
    phones.remove(phone);
}

public boolean hasphone(String number) {
    for (Phonenumber p : phones) {
        if (p.getNumber().equals(number)) {
            return true;
        }
    }
return false;
}

public String getfullname(){
    return firstname+" "+lastname;
}

    @Override
    public String toString() {
        return  "name:"+getfullname()+"\nemail:"+email+"\ngroup:"+group+"\nbirthdate:"+birthdate+"\naddress:"+address+"\nphone"+phones+
                "\n--------------------------";

    }
}
