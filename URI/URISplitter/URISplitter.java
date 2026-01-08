import java.net.*;
public class URISplitter {
    public static void main(String[] args) throws URISyntaxException {
        URI u = new URI("http://admin@www.example.org:80/student/index.html?id=90#today");
        System.out.println("The URI is " + u);
        if (u.isOpaque()) {
            System.out.println("This is an opaque URI.");
            System.out.println("The scheme is " + u.getScheme());
            System.out.println("The scheme specific part is "
                    + u.getSchemeSpecificPart());
            System.out.println("The fragment ID is " + u.getFragment());
        } else {
            System.out.println("This is a hierarchical URI.");
            System.out.println("The scheme is " + u.getScheme());
            try {
                u = u.parseServerAuthority();
                System.out.println("The host is " + u.getHost());
                System.out.println("The user info is " + u.getUserInfo());
                System.out.println("The port is " + u.getPort());
            } catch (URISyntaxException ex) {
                // Must be a registry based authority
                System.out.println("The authority is " + u.getAuthority());
            }
            System.out.println("The path is " + u.getPath());
            System.out.println("The query string is " + u.getQuery());
            System.out.println("The fragment ID is " + u.getFragment());
        }
    }
}
