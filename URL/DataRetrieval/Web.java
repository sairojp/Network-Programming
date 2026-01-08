import java.net.URL;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.io.*;

public class Web {

    public static void main (String[] args){
        if(args.length > 0){
            InputStream in = null;
            try{
                URL u = new URL(args[0]);
                in = u.openStream();
                in = new BufferedInputStream(in);
                Reader r = new InputStreamReader(in);
                int c;
                while ((c = r.read()) != -1){
                    System.out.println( c);
                }
            }catch (MalformedURLException e){
                System.err.println(e);
            }catch (IOException e){
                System.err.println(e);
            }finally{
                if (in != null){
                    try{
                        in.close();
                    }catch(IOException e){
                        System.err.println(e);
                    }

                }
            }
        }

    }
}