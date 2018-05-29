/* File: URLConnectionReaderExample.java
 * Provided By: Todd Kelley
 * Modified By: Stanley Pieda
 * Modified Date: Sept, 2017
 * Description: Downloads web page as stream, prints html to console.
 */
import java.net.*;
import java.io.*;
public class URLConnectionReaderExample {
    public static void main(String[] args) {
        URL url = null;
        BufferedReader in = null;
        try {
        	url = new URL("http", "google.ca", 80, "/index.html");
        } catch(MalformedURLException e) {
            System.out.println("Cannot find webpage " + url);
            System.exit(-1);
        }
        try {
        URLConnection aConnection = url.openConnection(); 
        in = new BufferedReader( new InputStreamReader(aConnection.getInputStream()));
        }
        catch (IOException e) {
            System.out.println("Cannot connect to webpage " + url);
            System.exit(-1);
        }
        try {
        // Now read the webpage file
        String lineOfWebPage;
        while ((lineOfWebPage = in.readLine()) != null)
                System.out.println(lineOfWebPage);
            in.close(); // Close the connection to the net
        } catch(IOException e) {
            System.out.println("Cannot read from webpage " + url);
        }
    }
}
