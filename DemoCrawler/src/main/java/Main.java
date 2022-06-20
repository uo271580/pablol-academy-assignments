public class Main {

    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        //crawler.crawl("https://www.google.com/", 20);
        crawler.crawl("https://www.pap.hacienda.gob.es/bdnstrans/GE/es/convocatoria/634303", 20);
    }
}
