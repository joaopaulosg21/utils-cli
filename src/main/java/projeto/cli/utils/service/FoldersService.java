package projeto.cli.utils.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import projeto.cli.utils.dto.TokenDTO;

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

    public void createFile(TokenDTO tokenDTO) throws IOException {
        ObjectMapper mappper = new ObjectMapper();
        Path fullPath = Paths.get(path + "credentials/token.json");
        if (Files.exists(fullPath)) {
            Files.write(fullPath, mappper.writeValueAsString(tokenDTO).getBytes());
            System.out.println("Token de acesso atualizado");
        } else {
            Path newPath = Files.createFile(fullPath);
            System.out.println("Arquivo com as credenciais criado com sucesso: " + newPath);
            Files.write(newPath, mappper.writeValueAsString(tokenDTO).getBytes());
        }
    }

    public TokenDTO findToken() throws IOException{
        Path fullPath = Paths.get(path + "credentials/token.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Files.readString(fullPath), TokenDTO.class);

    }
}
