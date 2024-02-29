package projeto.cli.utils.service;

import java.util.Scanner;

import projeto.cli.utils.api.Client;
import projeto.cli.utils.pojos.Login;

public class LoginService {
    
    private Client client;

    public LoginService(Client client) {
        this.client = client;
    }

    public void login() throws Exception{
        Scanner sc = new Scanner(System.in);
        Login login = new Login();
        System.out.print("Digite seu email: ");
        login.setEmail(sc.nextLine());

        System.out.print("Digite sua senha: ");
        login.setPassword(sc.nextLine());

        sc.close();

        client.login(login);
    }
}
