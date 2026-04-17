# 1. Start with a "base kitchen" that already has Java 17 installed
FROM eclipse-temurin:17-jdk-alpine

# 2. Tell the lunchbox where we should put our files
WORKDIR /app

# 3. Take the compiled 'food' (the JAR file) from your laptop and put it in the lunchbox
# It expects the file to be built in the 'target' folder
COPY target/*.jar app.jar

# 4. Tell the lunchbox to open a tiny window on port 8081 so we can talk to the app
EXPOSE 8081

# 5. Tell the lunchbox exactly what command to run to serve the food!
ENTRYPOINT ["java", "-jar", "app.jar"]
