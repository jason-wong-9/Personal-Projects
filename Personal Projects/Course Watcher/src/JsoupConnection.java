import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by jason on 15-08-21.
 */
public class JsoupConnection {
    private static String url;
    private static EmailConnection emailConnection;
//    private static VoiceConnection voiceConnection;
    public JsoupConnection(String url) {
        this.url = url;
        emailConnection = new EmailConnection();
//        voiceConnection = new VoiceConnection();

    }
    public static Boolean validUrl() {
        Element requested = null;
        try {
            Document doc = Jsoup.connect(url).get();
            requested = doc.select("a:contains(archived versions)").first();
        } catch (IOException e) {
            return false;
        }
        return requested == null;

    }
    public static void sectioncheck(String email, String website, String phone,
                                    String restricted) throws IOException {
        Document doc = Jsoup.connect(website).get();
        Element Note = doc.select("strong:contains(Note: this section)")
                .first();
        if (Note != null) {
            String str = Note.text();
            if (str.equals("Note: this section is temp. unavailable")) {
                main.newFrame.textArea.append(main.getcurrenttime()
                        + " This section is temporary unavailable" + "\n");
            } else if (restricted.equals("Y")) {

                if (checkforseats(4, website) != 0) {
                    main.newFrame.textArea.append(main.getcurrenttime() + " There are still "
                            + checkforseats(4, website) + " seats available"
                            + "\n");
                    emailConnection.sendemail(checkforseats(4, website) + " seats available", email);
//                    voiceConnection.sendsms(checkforseats(4, website) + " seats available", phone);
                } else
                    main.newFrame.textArea.append(main.getcurrenttime()
                            + " There are no more seats" + "\n");
            } else if (checkforseats(6, website) != 0) {
                main.newFrame.textArea
                        .append(main.getcurrenttime() + " There are still "
                                + checkforseats(6, website)
                                + " seats available" + "\n");
                emailConnection.sendemail(checkforseats(6, website) + " seats available", email);
//                voiceConnection.sendsms(checkforseats(6, website) + " seats available", phone);
            } else
                main.newFrame.textArea.append(main.getcurrenttime()
                        + " There are no more seats" + "\n");

        } else if (restricted.equals("Y")) {
            if (checkforseats(3, website) != 0) {
                main.newFrame.textArea.append(main.getcurrenttime() + " There are still "
                        + checkforseats(3, website) + " seats available!"
                        + "\n");
                emailConnection.sendemail(checkforseats(3, website) + " seats available", email);
//                voiceConnection.sendsms(checkforseats(3, website) + " seats available", phone);
            } else
                main.newFrame.textArea.append(main.getcurrenttime()
                        + " There are no more seats" + "\n");
        } else if (checkforseats(5, website) != 0) {
            main.newFrame.textArea.append(main.getcurrenttime() + " There are still "
                    + checkforseats(5, website) + " seats available!" + "\n");
            emailConnection.sendemail(checkforseats(5, website) + " seats available", email);
//            voiceConnection.sendsms(checkforseats(5, website) + " seats available", phone);
        } else
            main.newFrame.textArea.append(main.getcurrenttime() + " There are no more seats"
                    + "\n");
    }


    private static int checkforseats(int i, String url) throws IOException {
        Document doc;
        doc = Jsoup.connect(url).get();
        Elements Strong = doc.select("strong");
        ArrayList<String> seats = new ArrayList<>();

        for (Element e : Strong) {
            String seat = e.text();
            seats.add(seat);
        }
        int y = Integer.parseInt(seats.get(i));
        return y;
    }

}
