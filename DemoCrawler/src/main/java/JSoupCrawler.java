import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JSoupCrawler {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.infosubvenciones.es/bdnstrans/GE/es/index").get();
        System.out.println(doc.title());
    }
}
