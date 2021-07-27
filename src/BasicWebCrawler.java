
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BasicWebCrawler {
    public static void main(String[] args) {
        final String url = "https://theinternship.io/";
        try {
            Gson gson = new Gson();
            ArrayList<GetWeb> listGetWeb = new ArrayList<>();
            final Document doc = Jsoup.connect(url).get();
            for(var ePartner : doc.getElementsByClass("partner")){
                GetWeb getWeb = new GetWeb();
                var srcLogo = ePartner.getElementsByTag("img").attr("src");
                var textBox = ePartner.getElementsByClass("list-company").text();
                var textBoxLength = textBox.length();
                getWeb.setTextBoxLength(textBoxLength);
                getWeb.setSrcLogo(srcLogo);
                listGetWeb.add(getWeb);
            }
            Collections.sort(listGetWeb, Collections.reverseOrder());
            ArrayList<ModelLogo> listModelLogo = new ArrayList<>();
            for (GetWeb bullet : listGetWeb) {
                ModelLogo modelLogo = new ModelLogo();
                String getSrcLogo = bullet.getSrcLogo();
                modelLogo.setLogo(getSrcLogo);
                listModelLogo.add(modelLogo);
            }
            ModelCompanies modelCompanies = new ModelCompanies(listModelLogo);
            System.out.println(gson.toJson(modelCompanies));

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

    public static class GetWeb implements Comparable<GetWeb>{
        private String srcLogo;
        private Integer textBoxLength;
        public String getSrcLogo() {
            return srcLogo;
        }
        public void setSrcLogo(String srcLogo) {
            this.srcLogo = srcLogo;
        }
        public Integer getTextBoxLength() {
            return textBoxLength;
        }
        public void setTextBoxLength(Integer textBoxLength) {
            this.textBoxLength = textBoxLength;
        }
        @Override
        public int compareTo(GetWeb o) {
            return this.getTextBoxLength().compareTo(o.getTextBoxLength());
        }
    }

    public static class ModelLogo {
        private String logo;
        public void setLogo(String logo) {
            this.logo = logo;
        }
    }

    public static class ModelCompanies {
        private List<ModelLogo> companies = null;
        public ModelCompanies(List<ModelLogo> companies) {
            this.companies = companies;
        }
    }

}
