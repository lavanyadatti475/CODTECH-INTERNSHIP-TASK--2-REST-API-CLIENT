import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPIClient {

    // API URL
    private static final String API_URL =
            "https://api.open-meteo.com/v1/forecast?latitude=17.3850&longitude=78.4867&current_weather=true";

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("      WEATHER REST API CLIENT USING JAVA");
        System.out.println("==============================================");

        try {

            long startTime = System.currentTimeMillis();

            String jsonResponse = fetchWeatherData();

            displayWeatherReport(jsonResponse);

            long endTime = System.currentTimeMillis();

            System.out.println("\n----------------------------------------------");
            System.out.println("API Response Time : "
                    + (endTime - startTime) + " ms");
            System.out.println("----------------------------------------------");

        } catch (Exception e) {

            System.out.println("\nError:");
            System.out.println(e.getMessage());
        }
    }

    // Fetch weather data from REST API
    private static String fetchWeatherData() throws Exception {

        URL url = new java.net.URI(API_URL).toURL();

        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {

            throw new Exception(
                    "Failed to fetch weather data.\nHTTP Response Code : "
                            + responseCode);
        }

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()));

        StringBuilder response = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        return response.toString();
    }

    // Parse JSON and display report
    private static void displayWeatherReport(String json) {

        String currentWeather =
                json.split("\"current_weather\":\\{")[1]
                        .split("\\}")[0];

        String time =
                extractValue(currentWeather, "time", true);

        double temperature =
                Double.parseDouble(
                        extractValue(currentWeather,
                                "temperature",
                                false));

        double windSpeed =
                Double.parseDouble(
                        extractValue(currentWeather,
                                "windspeed",
                                false));

        int windDirection =
                Integer.parseInt(
                        extractValue(currentWeather,
                                "winddirection",
                                false));

        int weatherCode =
                Integer.parseInt(
                        extractValue(currentWeather,
                                "weathercode",
                                false));

        String condition =
                getWeatherDescription(weatherCode);

        System.out.println("\n============= WEATHER REPORT =============");

        System.out.printf("%-20s : %s%n",
                "Location", "Hyderabad");

        System.out.printf("%-20s : %s%n",
                "Observation Time", time);

        System.out.printf("%-20s : %.1f °C%n",
                "Temperature", temperature);

        System.out.printf("%-20s : %.1f km/h%n",
                "Wind Speed", windSpeed);

        System.out.printf("%-20s : %d°%n",
                "Wind Direction", windDirection);

        System.out.printf("%-20s : %d%n",
                "Weather Code", weatherCode);

        System.out.printf("%-20s : %s%n",
                "Condition", condition);

        System.out.println("==========================================");
    }

    // Extract values from JSON
    private static String extractValue(String json,
                                       String key,
                                       boolean isString) {

        if (isString) {

            return json.split("\"" + key + "\":\"")[1]
                    .split("\"")[0];

        } else {

            return json.split("\"" + key + "\":")[1]
                    .split(",")[0];
        }
    }

    // Convert weather code to description
    private static String getWeatherDescription(int code) {

        switch (code) {

            case 0:
                return "Clear Sky";

            case 1:
                return "Mainly Clear";

            case 2:
                return "Partly Cloudy";

            case 3:
                return "Overcast";

            case 45:
            case 48:
                return "Fog";

            case 51:
            case 53:
            case 55:
                return "Light Drizzle";

            case 61:
            case 63:
            case 65:
                return "Rain";

            case 71:
            case 73:
            case 75:
                return "Snow";

            case 80:
            case 81:
            case 82:
                return "Rain Showers";

            case 95:
                return "Thunderstorm";

            default:
                return "Unknown Weather";
        }
    }
}