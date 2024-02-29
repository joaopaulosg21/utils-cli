package projeto.cli.utils.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import projeto.cli.utils.pojos.Login;

public class Client {

    private final HttpClient client = HttpClient.newHttpClient();

    private final ObjectMapper mapper = new ObjectMapper();

    private final String baseURI = "http://localhost:8080/";

    public void login(Login login) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .POST(BodyPublishers.ofString(mapper.writeValueAsString(login)))
                .setHeader("Content-Type", "application/json")
                .uri(new URI(baseURI + "api/users/login"))
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
