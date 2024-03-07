import java.io.BufferedReader;   // Reads chunks of characters in input streams at once instead of one character at a time, raising efficiency.
import java.io.InputStreamReader; // Converts bytes to characters
import java.net.HttpURLConnection; // Connects to a resource on the internet (In this case, the NWS API)
import java.net.URI;
import java.net.URL; // Contstructs the URL for the NWS API
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TheWeatherApp { // Declares the main method 
    public static void main(String[] args) {
    try {
        //String apiKey = "your_api_key"; // Stores the API key
        //String city = "JacksonvilleFlorida"; // Chooses the key
        double gridX = 66; // Specify the grid X coordinate. Each NWS Forecast office has a unique grid combination. Find out what that is for your desired location. The code is currently set to Jacksonville, FL. 
        double gridY = 65; // Specify the grid Y coordinate 
        URI uri = new URI("https://api.weather.gov/gridpoints/JAX" + "/" + gridX + "," + gridY + "/forecast");
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();  // Opens a connection to the specified URL
        connection.setRequestMethod("GET"); // GET request method: retrieves information from the API

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // reads the input stream of the HTML connection
        String line; // Creates a string value called line that stores each line of the API response
        StringBuilder response = new StringBuilder(); // Accumulates the entire API response 
    
        while ((line = reader.readLine()) != null) {
            response.append(line); // Reads each line from the API response and adds it to the StringBuilder
        }

        System.out.println(response.toString()); // Prints the retrieved data



        reader.close(); // Closes the BufferedReader
        connection.disconnect(); // Disconnects the HTTP connection
                // Parse JSON response
      //  JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
       // JsonObject properties = jsonObject.getAsJsonObject("properties");

             // Extract relevant weather data using Gson
       // Gson gson = new Gson();
        //Forecast forecast = gson.fromJson(properties.getAsJsonObject("periods").get(0), Forecast.class);
        
                    // Access the parsed data
        //String detailedForecast = forecast.getDetailedForecast();
        
                    // Print the detailed forecast
        //System.out.println("Detailed Forecast: " + detailedForecast);

    } catch (Exception e) { // Handles exceptions
            e.printStackTrace(); 
        }
    }
}
