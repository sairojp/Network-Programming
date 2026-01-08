import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class PrivateDataProxy extends ProxySelector {
    private List<URI> failed = new ArrayList<>();
    private final List<Proxy> noProxy = new ArrayList<>();
    private final List<Proxy> proxies = new ArrayList<>();

    public PrivateDataProxy() {
        noProxy.add(Proxy.NO_PROXY);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("secure.connection.com", 443);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, inetSocketAddress);
        proxies.add(proxy);
    }

    @Override
    public List<Proxy> select(URI uri) {
        if (uri.getPath().startsWith("/confidential")) {
            return proxies;
        }
        return noProxy;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress address, IOException ex) {
        failed.add(uri);
    }
}