package example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Reference : https://howtodoinjava.com/java/library/complete-jsoup-tutorial/, https://www.baeldung.com/java-with-jsoup
 */
public class JsoupDataModification {
    public static void main(String[] args) {
        String html = "<html>\n" +
                "<head>\n" +
                "<title>Try jsoup</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>This is <a href=\"http://jsoup.org/\">jsoup</a>.</p>\n" +
                "<p> Hello Cvtian \n" +
                "<p class='test'> Test <p>\n" +
                "<div class='test'> <p id='check'> check <p> <p id='check2'> check2 <p> </div>\n" +
                "</body>\n" +
                "</html>";
        Document document = Jsoup.parse(html);

        // Adding Attribute to para -> class test
        Element para = document.select("p.test").first();
        para.attr("name", "test");

        System.out.println("---------------------------------------------\n\n");
        System.out.println(document.select("p.test").first().outerHtml() + " \n");
        System.out.println(document.html());

        System.out.println("---------------------------------------------\n\n");

        // Modifying Text to para -> class test
        Element paraTextModification = document.select("p.test").first();
        paraTextModification.text("Hello");
        System.out.println(document.select("p.test").first().outerHtml());


        //Removing para class -> test
        document.select("p.test").first().remove();
        System.out.println("---------------------------------------------\n\n");
        System.out.println(document.html());

    }
}
