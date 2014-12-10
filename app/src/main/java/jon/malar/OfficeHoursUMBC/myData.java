package jon.malar.OfficeHoursUMBC;

import java.util.ArrayList;

/*
 * Authors: Jonathan Malar, David Ziska, William Lucas
 * Class: CMSC 331
 * Professor: Lupoli
 */

/**
 * Class that holds all data for office hours
 */
public class myData {

    ArrayList<String> number = new ArrayList<String>();
    ArrayList<String> prof = new ArrayList<String>();
    ArrayList<String> title = new ArrayList<String>();
    ArrayList<String> days = new ArrayList<String>();
    ArrayList<String> time = new ArrayList<String>();

    String selected = "blank";

    public void setSelected(String blah){
        selected = blah;
    }

    public void setNumber(String num, int index){
        number.set(index, num);
    }

    public void setProf(String teach, int index) { prof.set(index, teach);}

    public void setTitle(String newTitle, int index){
        title.set(index, newTitle);
    }

    public void setDays(String theDays, int index){
        days.set(index, theDays);
    }

    public void setTime(String theTime, int index){
        time.set(index, theTime);
    }

    public void addNumber(String num){
        number.add(num);
    }

    public void addProf(String teach) { prof.add(teach);}

    public void addTitle(String newTitle){
        title.add(newTitle);
    }

    public void addDays(String theDays){
        days.add(theDays);
    }

    public void addTime(String theTime){
        time.add(theTime);
    }

    public String getSelected(){
        return selected;
    }

    public int getSelectedIndex() { return number.indexOf(selected);}

    public String getNumber(int index){
        return number.get(index);
    }

    public ArrayList<String> getAllNumbers(){
        return number;
    }

    public String getTitle(int index){
        return title.get(index);
    }

    public String getDays(int index){
        return days.get(index);
    }

    public String getTime(int index){
        return time.get(index);
    }

    public String getProf(int index) {return prof.get(index);}

    public void removeNumber(int index){
        number.remove(index);
    }

    public void removeTitle(int index){
        title.remove(index);
    }

    public void removeDays(int index){
        days.remove(index);
    }

    public void removeTime(int index){
        time.remove(index);
    }

    public void removeProf(int index) { prof.remove(index);}

    public boolean isEmpty()
    {
        if (number.isEmpty()){
        return true;
    }
        else{
        return false;
    }
    }
}
