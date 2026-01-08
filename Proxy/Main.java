import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        PrivateDataProxy privateDataProxy = new PrivateDataProxy();
        // The setting the system-wide proxy selector
        ProxySelector.setDefault(privateDataProxy);
        // Print the default value
        // using getDefault() method
        System.out.println("Default value: " + ProxySelector.getDefault());
        // Display message only
        System.out.println("Getting proxy for /confidential");
        // Passing the string URL
        String confidentialUrl = "https://www.download.com/confidential";
        // Now, calling the constructor of the URL class
        URL confidential = new URL(confidentialUrl);
        // Requiring an proxy for url
        List<Proxy> confidentialProxies = privateDataProxy.select(confidential.toURI());
        // Show the proxy that was selected
        System.out.println("Proxy to use : " + confidentialProxies.get(0));
        // Display message only
        System.out.println("Getting proxy for /non-confidential");
        // passing the string URL
        // Custom URL as input
        String nonConfidentialURL = "https://www.download.com/non-confidential";
        // Now, calling the constructor of the URL class
        URL nonConfidential = new URL(nonConfidentialURL);
        // Requiring an proxy for URL
        List<Proxy> nonConfidentialProxies = privateDataProxy.select(nonConfidential.toURI());
        // Display the proxy that was selected
        System.out.println("Proxy to use : " + nonConfidentialProxies.get(0));
    }
}