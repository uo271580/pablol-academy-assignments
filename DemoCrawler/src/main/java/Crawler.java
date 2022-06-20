import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {

    private final Queue<String> urlQueue;
    private final HashSet<String> visitedUrls;

    private FileWriter fileWriter;

    public Crawler() {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        this.urlQueue = new LinkedList<>();
        this.visitedUrls = new HashSet<>();
        try {
            fileWriter = new FileWriter("output.html");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(String text){
        try {
            fileWriter.write(text + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void crawl(String rootUrl, int breakpoint) {
        urlQueue.add(rootUrl);

        while (!urlQueue.isEmpty()) {
            String tempUrl = urlQueue.remove();
            visitedUrls.add(tempUrl);

            StringBuilder rawhtml = new StringBuilder();

            try {
                URL url = new URL(tempUrl);
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String inputLine = in.readLine();

                while (inputLine != null) {
                    writeToFile(inputLine);
                    rawhtml.append(inputLine);
                    inputLine = in.readLine();
                }
                in.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            String urlPattern = "(www|http:|https:)+[^\s]+[\\w]";
            Pattern pattern = Pattern.compile(urlPattern);
            Matcher matcher = pattern.matcher(rawhtml.toString());

            breakpoint--;
            System.out.println("(" + breakpoint + ") --> " + tempUrl);
            //getURLs(matcher);

            if (breakpoint == 0) {
                break;
            }
        }
    }

    private void getURLs(Matcher matcher) {
        while (matcher.find()) {
            String actualUrl = matcher.group();

            if (!visitedUrls.contains(actualUrl)) {
                System.out.println("(" + visitedUrls.size() + ") Website found with URL " + actualUrl);
                visitedUrls.add(actualUrl);
                urlQueue.add(actualUrl);
            }
        }
    }
}