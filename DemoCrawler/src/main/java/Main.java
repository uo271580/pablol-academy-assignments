public class Main {

    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        //crawler.crawl("https://www.google.com/", 20);
        crawler.crawl("https://www.infosubvenciones.es/bdnstrans/GE/es/index", 20);
    }
}
