
package filedatesearcher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDate {
    
    private final String date;
    private  int day;
    private  int month;
    private  int year;
    
    public FileDate(String date){
        this.date=date;
    }
    
    public boolean isValid(){
       String DATE_FORMAT = "dd-MM-yyyy";
       try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            String[] dateArray=date.split("-");
            day=Integer.parseInt(dateArray[0]);
            month=Integer.parseInt(dateArray[1]);
            year=Integer.parseInt(dateArray[2]);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    @Override
    public String toString(){
        return day+"-"+month+"-"+year;
    }
    
    
    public int compareTo(FileDate fileDate) {
      if(date.equals(fileDate.getDate())){
          return 0;
      }
      Date thisdate=new Date(year,month,day);
      Date otherdate=new Date(fileDate.getYear(),fileDate.getMonth(),fileDate.getDay());
      return (thisdate.before(otherdate))?-1:1;
    }

    public String getDate() {
        return date;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
   
}
