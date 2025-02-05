# Use a specific version of OpenJDK
FROM openjdk:11-jdk-slim-sid

# Set the working directory
WORKDIR /javaapp

# Copy only the necessary source files
COPY demo.java .

# Compile the Java program
RUN javac demo.java

# Set the default command to run the Java program
CMD ["java", "demo"]