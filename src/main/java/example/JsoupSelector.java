package example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Reference : https://jsoup.org/cookbook/extracting-data/selector-syntax


 * Selector combinations

 * el#id: elements with ID, e.g. div#logo
 * el.class: elements with class, e.g. div.masthead
 * el[attr]: elements with attribute, e.g. a[href]
 * Any combination, e.g. a[href].highlight
 * ancestor child: child elements that descend from ancestor, e.g. .body p finds p elements anywhere under a block with class "body"
 * parent > child: child elements that descend directly from parent, e.g. div.content > p finds p elements; and body > * finds the direct children of the body tag
 * siblingA + siblingB: finds sibling B element immediately preceded by sibling A, e.g. div.head + div
 * siblingA ~ siblingX: finds sibling X element preceded by sibling A, e.g. h1 ~ p
 * el, el, el: group multiple selectors, find unique elements that match any of the selectors; e.g. div.masthead, div.logo


 * Pseudo selectors

 * :lt(n): find elements whose sibling index (i.e. its position in the DOM tree relative to its parent) is less than n; e.g. td:lt(3)
 * :gt(n): find elements whose sibling index is greater than n; e.g. div p:gt(2)
 * :eq(n): find elements whose sibling index is equal to n; e.g. form input:eq(1)
 * :has(selector): find elements that contain elements matching the selector; e.g. div:has(p)
 * :not(selector): find elements that do not match the selector; e.g. div:not(.logo)
 * :contains(text): find elements that contain the given text. The search is case-insensitive; e.g. p:contains(jsoup)
 * :containsOwn(text): find elements that directly contain the given text
 * :matches(regex): find elements whose text matches the specified regular expression; e.g. div:matches((?i)login)
 * :matchesOwn(regex): find elements whose own text matches the specified regular expression
 * Note that the above indexed pseudo-selectors are 0-based, that is, the first element is at index 0, the second at 1, etc
 */
public class JsoupSelector {

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

        String html2 = "<html>\n" +
                "<head>\n" +
                "<title>Try jsoup</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>This is <a href=\"http://jsoup.org/\">jsoup</a>.</p>\n" +
                "<p> Hello Cvtian \n" +
                "<p class='test' id='test3'> Test <p>\n" +
                "<div class='test'> <p id='check1'> check <p> <p id='check2'> check2 <p> " +
                " <div class='child1'><h1> hello second div </div>" +
                " <div class='child2'><h1> hello third div </div>" +
                " <div class='child3'><h1> hello fourth div </div>" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        //
        Document document = Jsoup.parse(html2);

       /* // selecting all p
        Elements paragraphs = document.select("p");
        for (Element ele  : paragraphs) {
            System.out.println(ele.text());
        }*/

        // Selecting para of class => test
        //System.out.println(document.selectFirst("p#test3").text());

        // Selecting div of class => test -> para of id -> check1
        //System.out.println(document.selectFirst("div.test > p#check1").text());

        // Selecting div of class => test -> para of id -> check2
        //System.out.println(document.selectFirst("div.test > p#check2").text());

        // selecting siblingA + siblingB means that just immediate after A select sibling B
        System.out.println(document.selectFirst("div.child1 + div").text());

        //System.out.println("test that it will get only their immediate sibling");
        // test that it will getting only immediate next to A ie. div.child1
       /* for(Element element : document.select("div.child1 + div")){
            System.out.println(element.text());
        }*/


        System.out.println("------");
        System.out.println("test that it will get all sibling after A");
        for(Element element : document.select("div.child1 ~ div")){
            System.out.println(element.text());
        }
    }
}
