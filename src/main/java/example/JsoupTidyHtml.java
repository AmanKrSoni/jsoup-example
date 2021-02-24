package example;

import org.jsoup.Jsoup;

/**
 * Here we haven`t closed the <p> tag so it cleans while parsing incorrect html into correct onces</p>
 */
public class JsoupTidyHtml {

    public static void main(String[] args) {
        String tidyHTML = "<html>\n" +
                "<head>\n" +
                "<title>Try jsoup</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>This is <a href=\"http://jsoup.org/\">jsoup</a>.</p>\n" +
                "<p> Hello Cvtian \n" +
                "</body>\n" +
                "</html>";
        String cleanHTML = Jsoup.parse(tidyHTML).html();
        System.out.println(cleanHTML);
    }
}
