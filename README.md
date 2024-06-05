# <p align="center">![](https://i.imgur.com/zRda5uX.png)</p>

## Overview
Noveleaf is a Spring MVC application built with Maven and Thymeleaf. This README provides instructions on how to build, test, and run the system using IntelliJ IDEA or directly from the command line.

## Prerequisites
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/install.html) (Will be installed when opened with IntelliJ)

## Build and Test the System

### Step 1: Clone the Repository
Clone the repository to your local machine using the following command:
```sh
git clone https://github.com/your-username/noveleaf.git
```

### Step 2: Open the Project in IntelliJ IDEA
1. Open IntelliJ IDEA.
2. Select **Open** from the welcome screen or **File > Open** if you have a project already open.
3. Navigate to the cloned repository and select the root folder.

### Step 3: Configure the JDK
1. Open **File > Project Structure**.
2. Under **Project Settings > Project**, set the Project SDK to Java 17.

### Step 4: Build the Project
1. Open the **Maven** tool window (usually on the right-hand side).
2. Click the **Refresh** button to load the Maven projects.
3. Expand the project tree, navigate to **Lifecycle**, and double-click **clean** and then **install** to build the project.

### Step 5: Test the Project
1. Navigate to the **src/test/java** folder.
2. Right-click on the test folder and select **Run 'All Tests'** to run all the test cases.

## Run the System

### Option 1: Using IntelliJ IDEA

#### Step 1: Add a New Run Configuration
1. Open **Run > Edit Configurations...**.
2. Click the **+** icon and select **Spring Boot**.
3. Set the name to "Noveleaf".
4. Set the Main class to `com.powerpuffsquirrels.noveleaf.NoveleafApplication`.
5. Set the JDK to Java 17.

#### Step 2: Run the Application
1. Select the "Noveleaf" configuration from the run configurations dropdown.
2. Click the **Run** button (green arrow) to start the application.

When the application starts, it will host the server on `http://localhost:10480`.

### Option 2: Without IntelliJ (For windows users)

#### Step 1: Build the Project
Run noveleaf-cleanbuild.bat

#### Step 2: Start the server
Run noveleaf-start.bat


The application will start and host the server on `http://localhost:10480`.

## Additional Notes
- Ensure your firewall settings allow access to port 10480.
- If you encounter any issues, consult the IntelliJ IDEA documentation or the [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/).


[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/32B92nwd)
