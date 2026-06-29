# WEATHER REST API CLIENT

**COMPANY**: CODTECH IT SOLUTIONS PRIVATE LIMITED

**NAME**: DATTI LAVANYA

**INTERN ID**: CTIS9772

**DOMAIN**: JAVA PROGRAMMING

**DURATION**: 8 WEEKS

**MENTOR**: NEELA SANTOSH

# 🌦️ Weather REST API Client using Java

## 📌 Project Overview

This project is a Java-based REST API Client that consumes a public weather API to fetch and display real-time weather information in a structured format.

The application connects to the **Open-Meteo Weather API**, sends an HTTP GET request, receives the JSON response, extracts the required weather information, and presents it in a clean and readable format.

This project demonstrates Java networking, REST API integration, JSON response parsing, and exception handling.

---

## 🎯 Objective

Develop a Java application that:

* Consumes a public REST API
* Sends HTTP GET requests
* Parses JSON responses
* Displays weather information in a structured format

---

## 🚀 Features

* Fetches real-time weather information
* Uses Java HTTP networking (`HttpURLConnection`)
* Consumes the Open-Meteo REST API
* Parses JSON response
* Displays:

  * Location
  * Observation Time
  * Temperature
  * Wind Speed
  * Wind Direction
  * Weather Code
  * Weather Condition
* Converts weather codes into readable descriptions
* Measures API response time
* Includes proper exception handling
* Clean and modular code structure

---

## 🛠️ Technologies Used

* Java
* REST API
* HTTP GET Requests
* JSON Parsing
* Java Networking (`HttpURLConnection`)
* BufferedReader
* Exception Handling

---

## 🌐 API Used

**Open-Meteo Weather API**

https://api.open-meteo.com/

Example Endpoint:

```text
https://api.open-meteo.com/v1/forecast?latitude=17.3850&longitude=78.4867&current_weather=true
```

---

## 📂 Project Structure

```text
RESTAPICLIENT
      ├── WeatherAPIClient.java
      └── WeatherAPIClient.class
```

---

## ▶️ How to Compile

Open the terminal inside the project folder.

Compile the program:

```bash
javac WeatherAPIClient.java
```

---

## ▶️ How to Run

```bash
java WeatherAPIClient
```

> If you are using packages, compile and run from the parent directory:

```bash
javac RestApiClient/WeatherAPIClient.java
java RestApiClient.WeatherAPIClient
```

---

## 📷Output



---

## 🔄 Project Workflow

```text
Start
   │
   ▼
Connect to Weather API
   │
   ▼
Send HTTP GET Request
   │
   ▼
Receive JSON Response
   │
   ▼
Extract Weather Data
   │
   ▼
Convert Weather Code
   │
   ▼
Display Structured Weather Report
   │
   ▼
End
```

---

## 📚 Learning Outcomes

This project helped in understanding:

* REST API fundamentals
* Java Networking
* HTTP Requests and Responses
* JSON Data Parsing
* Exception Handling
* Modular Programming
* Real-world API Integration

---

## 💡 Future Enhancements

* Search weather by city name
* Support multiple cities
* Display humidity and pressure
* 7-day weather forecast
* Use a JSON library (Jackson/Gson)
* Build a Java Swing or JavaFX GUI
* Export weather reports to a text file

---

## 👨‍💻 Author

**Datti Lavanya**

Java Internship Project

---

## 📄 License

This project is created for educational and internship purposes.
