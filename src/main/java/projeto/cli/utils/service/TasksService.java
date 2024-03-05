package projeto.cli.utils.service;

import java.time.format.DateTimeFormatter;
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

            List<TaskDTO> list = client.findAllTasks(token.token());

            String alignFormat = "| %-24s | %-21s | %-11s|%n";

            System.out.format("+--------------------------+-----------------------+------------+%n");
            System.out.format("| Descrição                | Data                  | Completa   |%n");
            System.out.format("+--------------------------+-----------------------+------------+%n");
            for (TaskDTO taskDTO : list) {
                String date = taskDTO.time().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                System.out.format(alignFormat, taskDTO.description(), date, taskDTO.completed());
            }
            System.out.format("+--------------------------+-----------------------+------------+%n");
        } catch (Exception e) {
            System.out.println("Arquivo com as credenciais não existe ou token invalido efetue o login novamente");
        }
    }
}
