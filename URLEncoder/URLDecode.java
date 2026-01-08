


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDecode {
  
   public static void main(String[] var0) {
      try {
         String decoded = URLDecoder.decode("https://www.google.com/search?hl=en&as_q=Java&as_epq=I%2FO", "UTF-8");
         System.out.println(decoded);
         
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }

   }
}