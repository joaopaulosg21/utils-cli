package projeto.cli.utils.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import projeto.cli.utils.dto.TokenResponseDTO;

public class FoldersService {

    private final String path = System.getenv("HOME") + "/utils/";

    public void createDirectory() throws Exception {

        if (Files.exists(Paths.get(path))) {
            System.out.println("Caminho ja existe");
        } else {

            Path newPath = Files.createDirectories(Paths.get(path + "credentials/"));

            System.out.println("Caminho criado com seu token de acesso: " + newPath);
        }
    }

    public void createFile(TokenResponseDTO tokenResponseDTO) throws IOException {
        ObjectMapper mappper = new ObjectMapper();
        if (Files.exists(Paths.get(path + "credentials/token.json"))) {
            Files.write(Paths.get(path + "credentials/token.json"),
                    mappper.writeValueAsString(tokenResponseDTO).getBytes());
            System.out.println("Token de acesso atualizado");
        } else {
            Path newPath = Files.createFile(Paths.get(path + "credentials/token.json"));
            System.out.println("Arquivo com as credenciais criado com sucesso: " + newPath);
            Files.write(newPath, mappper.writeValueAsString(tokenResponseDTO).getBytes());
        }
    }
}
