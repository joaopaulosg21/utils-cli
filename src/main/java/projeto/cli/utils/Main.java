package projeto.cli.utils;

import picocli.CommandLine;
import projeto.cli.utils.api.Client;
import projeto.cli.utils.commands.TasksCommand;
import projeto.cli.utils.service.FoldersService;
import projeto.cli.utils.service.LoginService;

@SuppressWarnings("deprecation")
public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        FoldersService foldersService = new FoldersService();
        LoginService loginService = new LoginService(client, foldersService);
        CommandLine.run(new TasksCommand(loginService), args);
    }
}
