//import com.techventus.server.voice.Voice;
//
//import java.io.IOException;
//
///**
// * Created by jason on 15-08-21.
// */
//public class VoiceConnection {
//    private String username;
//    private String password;
//    public VoiceConnection() {
//        username = "XXX";
//        password = "XXX";
//    }
//
//    public void sendsms(String numOfSeats, String phonenumber)
//            throws IOException {
//        if (phonenumber.equals("N/A")) {
//            main.newFrame.textArea.append("No SMS was sent!" + "\n");
//        } else
//            try {
//                Voice voice = new Voice(username, password);
//                voice.sendSMS(phonenumber, ("Hi,"
//                        + "\n\n Your course still has " + numOfSeats + "!"));
//                main.newFrame.textArea.append("SMS Sent at " + main.getcurrenttime() + "\n");
//            } catch (IOException e) {
//                main.newFrame.textArea.append("SMS Error!" + "\n");
//            }
//    }
//}
