"# attendance-system" 


Overview

This project is a web application that consists of a backend built with Spring Boot and a frontend developed using HTML and JavaScript. The backend handles API requests and processes data, which is stored in a JSON file. The frontend provides a user interface for interacting with the system.


Prerequisites

Before running the project, ensure you have the following installed on your system:

Java 21
IntelliJ IDEA 
Live Server extension in VS Code (for running the frontend)
Setup and Running the Project


Backend Setup

Open IntelliJ IDEA and import the backend project.
Ensure that you have all required dependencies installed via Maven.
In the backend WebSecurityConfig file, ensure the CORS origin URL matches the frontend URL:

@Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") 
            .allowedOrigins("http://127.0.0.1:5501") //Please check with your live server port and replace it here.
            .allowedMethods("GET", "POST", "PUT", "DELETE") 
            .allowedHeaders("*"); 
}

Run the backend application from IntelliJ IDEA.


Frontend Setup

Open the frontend project folder in Visual Studio Code.
Install the Live Server extension from the VS Code marketplace if not already installed.
Open the index.html file and right-click, then select Open with Live Server.
Ensure the frontend is accessible at http://127.0.0.1:5501( Please check with your live server port and replace it accordingly).


Testing Credentials

Use the following credentials to log in and test the application:
Username : admin
Password : 123

Username : chamika
Password : 5680288


Please note:

My frontend live server port is http://127.0.0.1:5501. Please check with your live server port and replace it accordingly.
A .geeks file is used at the beginning to upload an empty folder to GitHub, as GitHub does not allow empty folders to be pushed.