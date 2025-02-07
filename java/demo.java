import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class demo {
    public static void main(String[] args) throws IOException {
        // Create a new HTTP server listening on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Create a context for handling requests
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // Set the response headers
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                String htmlResponse = "<html><body><h1>Demo Java App</h1></body></html>";
                exchange.sendResponseHeaders(200, htmlResponse.length());
                
                // Get the response body stream
                OutputStream responseBody = exchange.getResponseBody();
                
                // Write the HTML content to the response body
                responseBody.write(htmlResponse.getBytes());
                responseBody.close();
            }
        });
        
        // Start the server
        server.start();
    }
}