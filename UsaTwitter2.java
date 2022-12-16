package br.com.americanas.polotech.projetoPoloTech;

import java.util.Scanner;

public class UsaTwitter2 {
    static String usuarioDigitado;
    static String senhaDigitada;

    public static void main(String[] args) {
        boolean iniciar = false;
        boolean sairDoTwitter = true;

        while (sairDoTwitter != false){
            if (iniciar == false) {
                iniciar = UsaTwitter2.loginTwitter();
                if (iniciar == false) {
                    System.out.println("Saindo do Twitter");
                    sairDoTwitter = false;
                }
            }
            if (iniciar) {
               iniciar = UsaTwitter2.navegarTwitter();
            }
        }
    }

    public static boolean navegarTwitter() {
        Scanner src = new Scanner(System.in);
        int escolha = 0;
        boolean validador = true;

        while (validador) {
            escolha = 0;
            System.out.println("===========================");
            System.out.println("1. Fazer um Tweet");
            System.out.println("2. Visualizar Timeline");
            System.out.println("3. Visualizar Tweets Feitos");
            System.out.println("4. Sair de " + "@" + usuarioDigitado);
            System.out.println("===========================");
            System.out.print("OPÇÃO ESCOLHIDA: ");
            escolha = src.nextInt();

            switch (escolha) {
                case 1:
                    TwitterMetodos criarTweet = new TwitterMetodos();
                    criarTweet.usuarioPublicacao = "@" + usuarioDigitado;
                    System.out.println("O que está acontecendo?");
                    src.nextLine();
                    String tweet = src.nextLine();
                    criarTweet.tweetsPublicacao = tweet;
                    criarTweet.dataPublicacao = TwitterMetodos.getDataAtual();

                    TwitterMetodos.inserirTweet(criarTweet);

                    break;
                case 2:
                    TwitterMetodos.exibirTimeline();
                    break;
                case 3:
                    TwitterMetodos.exibirTweetsFeitos(usuarioDigitado);
                    break;
                case 4:
                    System.out.println("===========================");
                    System.out.println("Saindo do Twitter\n");
                    validador = false;
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
            }
        }
        return validador;
    }


    public static boolean loginTwitter() {
        Scanner src = new Scanner(System.in);
        int escolha = 0;
        boolean validador = false;

        do {
            System.out.println("===========================");
            System.out.println("1. Login");
            System.out.println("2. Cadastrar");
            System.out.println("3. Sair");
            System.out.println("===========================");
            System.out.print("OPÇÃO ESCOLHIDA: ");
            escolha = src.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Usuário: ");
                    usuarioDigitado = src.next().trim();
                    System.out.print("Senha: ");
                    senhaDigitada = src.next().trim();
                    validador = Usuario.autenticaUsuario(usuarioDigitado,senhaDigitada);
                    if (!validador) {
                        System.out.println("****Usuário ou senha errados, tente novamente****");
                    }
                    break;
                case 2:
                    if (true) {
                        System.out.println("Cadastre um Nome de Usuário:");
                        String usuarioCadastro = src.next().toLowerCase();
                        System.out.println("Cadastre uma Senha:");
                        String senhaCadastro = src.next();

                        Usuario usuarioNovo = new Usuario();
                        usuarioNovo.nomeUsuario = usuarioCadastro.trim();
                        usuarioNovo.senhaUsuario = senhaCadastro.trim();
                        Usuario.cadastroUsuario(usuarioNovo);

                        System.out.println("Usuário Cadastrado com Sucesso");
                    }
                    break;
                case 3:
                    return false;

                case 4:
                    System.out.println("Escolha uma opção válida");
            }
        } while (validador == false);
        return true;
    }
}
