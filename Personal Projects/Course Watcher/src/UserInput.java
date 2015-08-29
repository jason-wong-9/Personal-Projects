import javax.swing.*;

/**
 * Created by jason on 15-08-20.
 */
public class UserInput {
    private String email;
    private String phone;
    private String year;
    private String sumwin;
    private String dept;
    private String coursenumber;
    private String session;
    private String restricted;
    private static String url;

    public UserInput() {
        email = "";
        phone = "";
        year = "";
        sumwin = "";
        dept = "";
        coursenumber = "";
        session = "";
        restricted = "";
        url = "";
    }

    public void setEmail () {
        email = JOptionPane.showInputDialog("Enter your email if you want to get email notification. Otherwise enter N/A: ");
    }
    public String getEmail() {
        return email;
    }
    public boolean validateEmail() {
        if (email == null) {
            return false;
        }
        return !email.isEmpty();
    }


    public void setPhone () {
        phone = JOptionPane.showInputDialog("Enter your phone if you want to get text notification. Otherwise enter N/A: ");
    }
    public String getPhone() {
        return phone;
    }
    public boolean validatePhone() {
        if (phone == null){
            return false;
        }
        return !phone.isEmpty();
    }


    public void setYear () {
        year = JOptionPane.showInputDialog("Enter the session year: ");
    }
    public String getYear() {
        return year;
    }
    public boolean validateYear() {
        if (year == null){
            return false;
        }
        return !year.isEmpty();
    }



    public void setSumWin () {
        sumwin = JOptionPane.showInputDialog("Summer/Winter?").toUpperCase();
    }
    public String getSumWin() {
        return sumwin;
    }
    public boolean validateSumWin() {
        if (sumwin == null){
            return false;
        }
        return (sumwin.equals("SUMMER") || sumwin.equals("WINTER"));
    }

    public void setDept () {
        dept = JOptionPane.showInputDialog("Enter the Department: ").toUpperCase();
    }
    public String getDept() {
        return dept;
    }
    public boolean validateDept() {
        if (dept == null){
            return false;
        }
        return !dept.isEmpty();
    }

    public void setCourseNumber () {
        coursenumber = JOptionPane.showInputDialog("Enter the Course Number: ").toUpperCase();
    }
    public String getCourseNumber() {
        return coursenumber;
    }
    public boolean validateCourseNumber() {
        if (coursenumber == null){
            return false;
        }
        return !coursenumber.isEmpty();
    }

    public void setSession() {
        session = JOptionPane.showInputDialog("Enter the Course Session ").toUpperCase();
    }
    public String getSession() {
        return session;
    }
    public boolean validateSession() {
        if (session == null) {
            return false;
        }
        return !session.isEmpty();
    }

    public void setRestricted() {
        restricted = JOptionPane.showInputDialog("Check for restricted seats? (Y/N)").toUpperCase();
    }
    public String getRestricted() {
        return restricted;
    }
    public boolean validateRestricted() {
        if (restricted == null){
            return false;
        }
        return (restricted.equals("Y") || restricted.equals("N"));
    }

    public String createUrl() {
        url = "https://courses.students.ubc.ca/cs/main?sessyr=" + year
                + "&sesscd=" + sumwin.substring(0, 1)
                + "&pname=subjarea&tname=subjareas&req=5&dept=" + dept
                + "&course=" + coursenumber + "&section=" + session;
        return url;
    }


}
