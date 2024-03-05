package projeto.cli.utils.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import projeto.cli.utils.service.LoginService;
import projeto.cli.utils.service.TasksService;

@Command(name = "tasks", description = "Commando de tasks")
public class TasksCommand implements Runnable {

    @Option(names = { "-l", "-login" })
    private boolean login;

    @Option(names = { "-t", "-tasks" })
    private boolean tasks;

    private LoginService loginService;

    private TasksService tasksService;

    public TasksCommand(LoginService loginService, TasksService tasksService) {
        this.loginService = loginService;
        this.tasksService = tasksService;
    }

    @Override
    public void run() {

        try {
            if (login) {
                this.loginService.login();
            } else if (tasks) {
                this.tasksService.findAll();
            } else {
                System.out.println("Deu erro");
            }
        } catch (Exception e) {
        }

    }

}
