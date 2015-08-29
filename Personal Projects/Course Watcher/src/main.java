import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jason on 15-08-20.
 */
public class main {
    public static MainFrame newFrame = new MainFrame();
    private static int numberOfSecondsUpdate = 900;
    public static void main(String[] args) {
        UserInput newUserInput = new UserInput();
        newFrame.frameSetUp();
        newUserInput.setEmail();
        String email = newUserInput.getEmail();
        if (!newUserInput.validateEmail()) {
            JOptionPane.showMessageDialog(newFrame.textArea, "Invalid Email!",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        newUserInput.setPhone();
        String phone = newUserInput.getPhone();
        if (!newUserInput.validatePhone()) {
            JOptionPane.showMessageDialog(newFrame.textArea,
                    "You did not enter your phone number, or N/A!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        newUserInput.setYear();
        String year = newUserInput.getYear();
        if (!newUserInput.validateYear()) {
            JOptionPane.showMessageDialog(newFrame.textArea,
                    "You did not enter your session year!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        newUserInput.setSumWin();
        String sumwin = newUserInput.getSumWin();
        if(!newUserInput.validateSumWin()) {
            JOptionPane.showMessageDialog(newFrame.textArea,
                    "You did not enter either summer or winter!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        newUserInput.setDept();
        String dept = newUserInput.getDept();
        if(!newUserInput.validateDept()) {
            JOptionPane.showMessageDialog(newFrame.textArea,
                    "You did not enter the department!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        newUserInput.setCourseNumber();
        String coursenumber = newUserInput.getCourseNumber();
        if(!newUserInput.validateCourseNumber()) {
            JOptionPane.showMessageDialog(newFrame.textArea,
                    "You did not enter the course number!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        newUserInput.setSession();
        String session = newUserInput.getSession();
        if(!newUserInput.validateSession()){
            JOptionPane.showMessageDialog(newFrame.textArea,
                    "You did not enter the course session!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        newUserInput.setRestricted();
        String restricted = newUserInput.getRestricted();
        if(!newUserInput.validateRestricted()){
            JOptionPane.showMessageDialog(newFrame.textArea,
                    "You did not enter Y/N for restricted seats!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        String url = newUserInput.createUrl();
        JsoupConnection jsoupConnection = new JsoupConnection(url);
        if (!jsoupConnection.validUrl()) {
            JOptionPane.showMessageDialog(newFrame.textArea, "Invalid URL!",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }else {

            try {
                while (true) {
                    try {
                        JsoupConnection.sectioncheck(email, url, phone, restricted);
                        newFrame.textArea.show();
                        Thread.sleep(numberOfSecondsUpdate * 1000);
                    } catch (IOException e) {
                        newFrame.textArea.append("Error!" + "\n");
                    }
                }
            } catch (InterruptedException e) {
                newFrame.textArea.append("Error!" + "\n");
            }
        }
    }

    public static String getcurrenttime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return (sdf.format(cal.getTime()));
    }

}
