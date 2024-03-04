package projeto.cli.utils.service;

import java.util.List;

import projeto.cli.utils.api.Client;
import projeto.cli.utils.dto.TaskDTO;
import projeto.cli.utils.dto.TokenDTO;

public class TasksService {

    private Client client;

    private FoldersService foldersService;

    public TasksService(FoldersService foldersService, Client client) {
        this.foldersService = foldersService;
        this.client = client;
    }

    public void findAll() {
        try {

            TokenDTO token = foldersService.findToken();

            List<TaskDTO> obj = client.findAllTasks(token.token());
            System.out.println(obj);
        } catch (Exception e) {
            System.out.println("Arquivo com as credenciais não existe efetue o login");
        }
    }
}
