package projeto.cli.utils.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import projeto.cli.utils.dto.TokenResponseDTO;
import projeto.cli.utils.service.LoginService;

@Command(name = "tasks", description = "Commando de tasks")
public class TasksCommand implements Runnable{
    
    @Option(names = {"-l","-login"})
    private boolean login;

    private LoginService loginService;

    public TasksCommand(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void run() {
        
        try {
            if(login) {
                TokenResponseDTO tokenResponseDTO = this.loginService.login();
                System.out.println(tokenResponseDTO.token());
            }else{
                System.out.println("Nao funcionou");
            }
        }catch(Exception e) {}

    }
    
}
