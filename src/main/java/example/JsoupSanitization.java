package example;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * To clean this HTML, Jsoup provides Jsoup.clean() method. This method expects an HTML content in form of String and it will return you clean HTML. To perform this task, Jsoup uses whitelist sanitizer.
 * The jsoup whitelist sanitizer works by parsing the input HTML (in a safe, sand-boxed environment), and then iterating through the parse tree and only allowing known-safe tags and attributes (and values) through into the cleaned output.

 * It does not use regular expressions, which are inappropriate for this task.

 * The cleaner is useful not only for avoiding XSS, but also in limiting the range of elements the user can provide: you may be OK with textual a, strong elements, but not structural div or table elements.

 * Reference : https://howtodoinjava.com/java/library/complete-jsoup-tutorial/
 */


public class JsoupSanitization {

    public static void main(String[] args) {
        String dirtyHTML = "<p><a href='//howtodoinjava.com/' onclick='sendCookiesToMe()'>Link</a></p>" +
                "<img src='#' />";
        String cleanHTML = Jsoup.clean(dirtyHTML, Whitelist.basicWithImages()); // # can be used Whitelist.basicWithImages()
        System.out.println(cleanHTML);
    }
}

