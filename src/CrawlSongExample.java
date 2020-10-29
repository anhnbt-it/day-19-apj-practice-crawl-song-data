import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/29/2020
 * Time: 1:56 PM
 */
public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url  = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
            Scanner scanner = new Scanner(inputStreamReader);
            scanner.useDelimiter("\\Z");

            String content = scanner.next();
            content = content.replaceAll("\\n+", "");
            Pattern pattern = Pattern.compile("name_song\" title=\"(.*?)\"");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
            scanner.close();
            inputStreamReader.close();
            System.out.println("Done.");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
