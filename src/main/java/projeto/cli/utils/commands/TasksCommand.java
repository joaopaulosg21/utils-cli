package projeto.cli.utils.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import projeto.cli.utils.service.LoginService;

@Command(name = "tasks", description = "Commando de tasks")
public class TasksCommand implements Runnable {

    @Option(names = { "-l", "-login" })
    private boolean login;

    @Option(names = { "-t", "-tasks" })
    private boolean tasks;

    private LoginService loginService;

    public TasksCommand(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void run() {

        try {
            if (login) {
                this.loginService.login();
            } else if (tasks) {
                System.out.println("Tasks");
            } else {
                System.out.println("Deu erro");
            }
        } catch (Exception e) {
        }

    }

}
