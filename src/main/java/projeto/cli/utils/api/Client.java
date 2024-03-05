package projeto.cli.utils.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import projeto.cli.utils.dto.LoginDTO;
import projeto.cli.utils.dto.TaskDTO;
import projeto.cli.utils.dto.TokenDTO;

public class Client {

    private final HttpClient client = HttpClient.newHttpClient();

    private final ObjectMapper mapper = new ObjectMapper();

    private final String baseURI = "http://localhost:8080/";

    public TokenDTO login(LoginDTO login) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(BodyPublishers.ofString(mapper.writeValueAsString(login)))
                    .setHeader("Content-Type", "application/json")
                    .uri(new URI(baseURI + "api/users/login"))
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            return mapper.readValue(response.body(), TokenDTO.class);
        } catch (Exception e) {
            System.out.println("Email ou senha incorretos tente novamente");
        }

        return null;
    }

    public List<TaskDTO> findAllTasks(String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + token)
                .uri(new URI(baseURI + "api/tasks/find/all"))
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        mapper.findAndRegisterModules();
        return mapper.readValue(response.body(), new TypeReference<List<TaskDTO>>() {});
    }
}
