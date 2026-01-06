public class Mydate {
 private    int day;
    private int month;
    private int year;

    //------------------------DefaultConstructor ------
    public Mydate(){
        day=0;
        month=0;
        year=0;
    }

    //-------------------------AllPropertiesConstructor
    public Mydate(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    //-------------------------CopyConstructor

    public Mydate(Mydate obj){
        day=obj.day;
        month=obj.month;
        year=obj.year;
    }

    public void setDay(int day) {
       this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

  public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day+"/"+month+"/"+year;
    }
}

