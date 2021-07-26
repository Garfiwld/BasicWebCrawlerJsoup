import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Partner
{
   private  String nameLogo, srcLogo;
   private ArrayList<String[]> company;


   public ArrayList<String[]> getCompany() {
      return company;
   }

   public void setCompany(ArrayList<String[]> company) {
      this.company = company;
   }

   public String getNameLogo() {
      return nameLogo;
   }

   public String getSrcLogo() {
      return srcLogo;
   }

   public void setLogo(String nameLogo, String srcLogo) {
      this.nameLogo = nameLogo;
      this.srcLogo = srcLogo;
   }

   public ArrayList<String[]> getLogo(){
      return company;
   }
}
