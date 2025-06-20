import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This program demonstrates a basic web request and JSON parser of the result.
 * It is using the public openweathermap API to print the weather in a city of choice.
 * @author Florin
 *
 */
public class Program {

    private static String ApiKey = "75a89e6fbe96cfacd4d39f57fa3018f3";
    private static String UrlFormat = "http://api.openweathermap.org/data/2.5/weather?q={city name}&units=imperial&appid={API key}";
    
    public static void main(String[] args) throws IOException, ParseException {
        
        // Ask the user to input a city/location
        System.out.print("Enter a city name (i.e. Kirkland, WA, US)> ");
        Scanner inputStream = new Scanner(System.in);
        String location = inputStream.nextLine();
        inputStream.close();
        String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8.name());
        System.out.println();
                
        // format and print the Url
        String urlLink = UrlFormat
                .replace("{city name}", encodedLocation)
                .replace("{API key}", ApiKey);
        System.out.printf("URL:\n    %s\n",urlLink);
        System.out.println();

        // Send the request to the server and read and print the raw response
        URL url = new URL(urlLink);
        URLConnection urlConnection = url.openConnection();
        InputStream responseStream = urlConnection.getInputStream();
        Scanner parser = new Scanner(responseStream);
        parser.useDelimiter("\\A"); // match on "beginning of the input"
        String response = parser.next(); // read the entire response
        parser.close();
        System.out.printf("Raw response:\n    %s\n", response);
        System.out.println();
        
        // Parse the JSON object from the response
        JSONParser jParser = new JSONParser();
        JSONObject jResponse = (JSONObject)jParser.parse(response);
        String city = (String)jResponse.get("name");
        JSONObject jMain = (JSONObject)jResponse.get("main");
        double temp = (double)jMain.get("temp");
        long pressure = (long)jMain.get("pressure");
        long humidity = (long)jMain.get("humidity");
        
        // Print the final output
        System.out.printf("Current weather in %s:\n", city);
        System.out.printf("    Temperature = %fF\n", temp);
        System.out.printf("    Atmospheric pressure = %d hPa\n", pressure);
        System.out.printf("    Air humidity = %d%%\n", humidity);
    }

}
