package Aufgabe3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Website {
        public static void main (String[] args) {
            String urlString = "https://uol.de/en/computingscience/se/publications";
            try {
                URL url = new URL(urlString);
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                int conferenceCount = 0;
                int journalCount = 0;
                int thesisCount = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains("[inproceedings]")) {
                        conferenceCount++;
                    } else if (line.contains("[article]")) {
                        journalCount++;
                    } else if (line.contains("[phdthesis]")) {
                        thesisCount++;
                    }
                }
                bufferedReader.close();
                System.out.println("Conference Articles: " + conferenceCount);
                System.out.println("Journal Articles: " + journalCount);
                System.out.println("PhD Theses: " + thesisCount);
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
