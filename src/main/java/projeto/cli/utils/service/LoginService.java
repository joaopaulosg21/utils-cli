package projeto.cli.utils.service;

import java.util.Scanner;

import projeto.cli.utils.api.Client;
import projeto.cli.utils.dto.LoginDTO;
import projeto.cli.utils.dto.TokenDTO;

public class LoginService {

    private Client client;

    private FoldersService foldersService;

    public LoginService(Client client, FoldersService foldersService) {
        this.client = client;
        this.foldersService = foldersService;
    }

    public TokenDTO login() throws Exception {
        Scanner sc = new Scanner(System.in);
        LoginDTO login = new LoginDTO();
        System.out.print("Digite seu email: ");
        login.setEmail(sc.nextLine());

        System.out.print("Digite sua senha: ");
        login.setPassword(sc.nextLine());

        sc.close();
        TokenDTO tokenResponseDTO = client.login(login);
        foldersService.createDirectory();
        foldersService.createFile(tokenResponseDTO);
        return tokenResponseDTO;
    }
}
