import java.io.*;
import java.net.*;

public class WebPageDownloader {
    public static void main(String[] args) {
        String url = "https://google.com";
        String filename = "downloaded_page.html";

        try {
            URL webpage = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) webpage.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content.toString());
            fileWriter.close();

            System.out.println("Webpage content downloaded and saved to: " + file.getAbsolutePath());

            reader.close();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
