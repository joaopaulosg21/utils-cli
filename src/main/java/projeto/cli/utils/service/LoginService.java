package projeto.cli.utils.service;

import java.util.Scanner;

import projeto.cli.utils.api.Client;
import projeto.cli.utils.dto.LoginDTO;
import projeto.cli.utils.dto.TokenResponseDTO;

public class LoginService {

    private Client client;

    public LoginService(Client client) {
        this.client = client;
    }

    public TokenResponseDTO login() throws Exception {
        Scanner sc = new Scanner(System.in);
        LoginDTO login = new LoginDTO();
        System.out.print("Digite seu email: ");
        login.setEmail(sc.nextLine());

        System.out.print("Digite sua senha: ");
        login.setPassword(sc.nextLine());

        sc.close();

        return client.login(login);
    }
}
