
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BasicWebCrawler {
    public static void main(String[] args) {
        Gson gson = new Gson();
        final String url = "https://theinternship.io/";
        try {
            Partner partner = new Partner();
            ArrayList<String[]> resLogo = new ArrayList<>();
            final Document doc = Jsoup.connect(url).get();
            for(var ePartner : doc.getElementsByClass("partner")){
//                ArrayList<String> logo = new ArrayList<String>();
                var srcLogo = ePartner.getElementsByTag("img").attr("src");
                var textBox = ePartner.getElementsByClass("list-company").text();
                var textBoxLength = textBox.length();
                partner.setLogo("Logo",srcLogo);
//                logo.add("Logo");
//                logo.add(srcLogo);
                resLogo.add(new String[]{"Logo", srcLogo});
            }
            partner.setCompany(resLogo);
            System.out.println(gson.toJson(partner.getLogo()));

//            try (FileWriter writer = new FileWriter("E:\\0_Workspace\\BasicWebCrawlerJsoup\\resapi.json")) {
//                gson.toJson(partner, writer);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
