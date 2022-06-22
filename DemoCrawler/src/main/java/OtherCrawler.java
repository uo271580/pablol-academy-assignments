import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class OtherCrawler {


    public static void main(String[] args) {

        // Instantiate Web client, ① simulate Chrome browser A kind of ② use proxy IP A kind of

        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false); // Cancel CSS support A kind of
        webClient.getOptions().setJavaScriptEnabled(false); // Cancel JavaScript support A kind of
        try {
            HtmlPage page = webClient.getPage("https://empathy.co/"); // Get page by parsing

            List<DomElement> spanList = page.getByXPath("//li[@class='header-menu__list-item ']");

            for (int i = 0; i < spanList.size(); i++) {
                System.out.println(i + 1 + "," + spanList.get(i).getTextContent());
            }

            //HtmlForm htmlForm = page.getFirstByXPath("//form[@action='https://empathy.co/']");
            //System.out.println(page.getElementById("send-btn"));

        } catch (FailingHttpStatusCodeException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close(); // Close the client and free the memory
        }
    }


}
