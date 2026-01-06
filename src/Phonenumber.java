public class Phonenumber {
    private String number;
    private Phonetype type;
    //------------------------DefaultConstructor ------
   public Phonenumber(){
        number="null";
        type=Phonetype.other;
    }
    //-------------------------AllPropertiesConstructor
public   Phonenumber(String number,Phonetype type){
        this.number=number;
        this.type=type;
    }
    //-------------------------CopyConstructor
Phonenumber(Phonenumber obj){
        number=obj.number;
        type=obj.type;
}

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setType(Phonetype type) {
        this.type = type;
    }

    public Phonetype getType() {
        return type;
    }

    @Override
    public String toString() {
        return type+":"+number;
    }
}
