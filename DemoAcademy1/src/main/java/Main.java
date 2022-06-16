public class Main {

    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        crawler.crawl("https://sede.agenciatributaria.gob.es/", 20);
    }
}
