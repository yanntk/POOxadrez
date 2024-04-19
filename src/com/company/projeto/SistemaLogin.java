package com.company.projeto;

import com.company.projeto.GUIChess;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaLogin {
    private Map<String, String> usuarios;
    private Scanner scanner;

    public SistemaLogin() {
        usuarios = new HashMap<String, String>();
        scanner = new Scanner(System.in);
    }

    public boolean cadastrarUsuario(String username, String senha) {
        // Verifica se o usuário já existe
        if (usuarios.containsKey(username)) {
            System.out.println("Usuário já cadastrado.");
            return false;
        }

        // Cadastra o novo usuário
        usuarios.put(username, senha);
        System.out.println("Usuário cadastrado com sucesso.");
        return true;
    }

    public boolean login(String username, String senha) {
        // Verifica se o usuário existe e a senha está correta
        String senhaCadastrada = usuarios.get(username);
        if (senhaCadastrada != null && senhaCadastrada.equals(senha)) {
            System.out.println("Login realizado com sucesso.");
            return true;
        }

        System.out.println("Usuário ou senha incorretos.");
        return false;
    }

    public void abrirJogo() {
        // Inicia o jogo GUIChess após um login bem-sucedido
        GUIChess guiChess = new GUIChess();
    }

    public void fecharScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        SistemaLogin sistemaLogin = new SistemaLogin();
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que escolha entre login e cadastro
        System.out.println("Bem-vindo ao Sistema de Login!");
        System.out.println("Digite 1 para login ou 2 para cadastrar um novo usuário:");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            // Login
            System.out.println("Por favor, insira seu nome de usuário:");
            String username = scanner.nextLine();
            System.out.println("Agora, insira sua senha:");
            String senha = scanner.nextLine();

            if (sistemaLogin.login(username, senha)) {
                sistemaLogin.abrirJogo(); // Abre o jogo após um login bem-sucedido
            }
        } else if (opcao == 2) {
            // Cadastro
            System.out.println("Por favor, insira o nome de usuário que deseja cadastrar:");
            String novoUsername = scanner.nextLine();
            System.out.println("Agora, insira a senha para o novo usuário:");
            String novaSenha = scanner.nextLine();

            sistemaLogin.cadastrarUsuario(novoUsername, novaSenha);

            // Após o cadastro, redirecionar para o login
            System.out.println("Por favor, faça login com o novo usuário:");
            System.out.println("Insira seu nome de usuário:");
            String username = scanner.nextLine();
            System.out.println("Insira sua senha:");
            String senha = scanner.nextLine();

            if (sistemaLogin.login(username, senha)) {
                sistemaLogin.abrirJogo(); // Abre o jogo após um login bem-sucedido
            }
        } else {
            System.out.println("Opção inválida. Encerrando o programa.");
        }

        // Fecha o scanner
        sistemaLogin.fecharScanner();
        scanner.close();
    }
}
