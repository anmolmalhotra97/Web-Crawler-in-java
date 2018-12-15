import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.net.*;
import java.util.ArrayList;
import java.io.*;
import org.jsoup.select.Elements;
import java.io.IOException;

class doc {

    String[] selectAnchors(String parsedHTML, String url) {
        ArrayList<String> arrStrings = new ArrayList<>();
        Document docu = Jsoup.parse(parsedHTML);
        Elements links = docu.select("a[href]");
        for (Element link : links) {
            int f = 0;
            String str = new String(link.attr("abs:href"));
            if (str.length() > 2 && !arrStrings.contains(str) && str.contains(url)) {
                arrStrings.add(str);
            }
        }
        return arrStrings.toArray(new String[0]);
    }

    int fileWriting(String dir, int counter, String parsedHTML) {
        try {
            FileWriter fw = new FileWriter(dir + "/" + counter + ".txt");
            fw.write(parsedHTML);
            fw.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        counter++;
        return counter;
    }

    String parseHTML(String url) {
        String html = new String();
        try {
            html = Jsoup.connect(url).get().html();
        } catch (MalformedURLException e) {
            System.out.println(e.toString());
        } catch (ProtocolException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return html;
    }
}