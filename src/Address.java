public class Address {
    private String street;
    private String alley;
   private String number;
    private String unit;
    //------------------------DefaultConstructor ------
public Address(){
    street="null";
    alley="null";
    number="null";
    unit="null";
}
//-------------------------AllPropertiesConstructor
public Address(String street,String alley,String number,String unit){
    this.street=street;
    this.alley=alley;
    this.number=number;
    this.unit=unit;
}


//-------------------------CopyConstructor
public Address(Address obj){
    street= obj.street;
    alley=obj.alley;
    number=obj.number;
    unit=obj.unit;
}

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public String getNumber() {
        return number;
    }

    public String getUnit() {
        return unit;
    }

    public String getStreet() {
        return street;
    }

    public String getAlley() {
        return alley;
    }

    @Override
    public String toString() {

    return "street:"+street+",alley:"+alley+",no:"+number+",unit:"+unit;
    }
}
