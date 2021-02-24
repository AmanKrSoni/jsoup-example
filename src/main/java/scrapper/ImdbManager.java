package scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Scraping data of website : https://www.imdb.com/chart/moviemeter/?ref_=nv_mv_mpm
 * Data in which we are interested in : [ Movie_Name, Movie_Year, Rating, Image]
 */
public class ImdbManager {

    static ImdbManager manager = new ImdbManager();

    public static void main(String[] args) {
        manager.scrapData();
    }

    public void scrapData(){
        String url = "https://www.imdb.com/chart/moviemeter/?ref_=nv_mv_mpm";
        Document document = getPageContent(url);
        showData(document);
    }

    public void showData(Document document){
        Elements table = document.body().getElementsByClass("lister-list");
        Elements rows = table.get(0).select("tr");
        for(int i =0; i < rows.size(); i++){
            Element row = rows.get(i);
            Elements columns = row.select("td");
            String imageUrl = columns.get(0).select("a > img").first().attr("src").trim();
            String movieName = columns.get(1).select("a").text();
            String movieYear = columns.get(1).select("span").first().text();
            String rating = columns.get(2).text();
            System.out.println(movieName + " | " + movieYear + " | " + rating + " | " + imageUrl);
        }
    }

    private static Document getPageContent(final String url) {
        System.out.println("getting page for url : " +url);
        Document document = null;
        try {
            document = Jsoup.connect(url)
                    .maxBodySize(0)
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .userAgent("Mozilla").get();
        } catch (Exception e) {
            System.err.println(String.format("Error while getting page for url %s", url));
            e.printStackTrace();
        }
        return document;
    }
}
