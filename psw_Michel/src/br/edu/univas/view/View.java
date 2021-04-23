package br.edu.univas.view;

public class View {
    public void startApp(){
        System.out.println("---  GERADOR DE SENHAS  --- ");
    }
    public void askMin(){
        System.out.println("Digite o tamanho mínimo da senha: ");
    }
    public void askMax(){
        System.out.println("Digite o tamanho máximo da senha: ");
    }
    public void showOp(){
        System.out.println("*       DIGITE         *");
        System.out.println("      1  =  SIM");
        System.out.println("      0  =  NÃO");
    }
    public void askMinus(){
        System.out.println("Deseja letras minúsculas na senha?");
    }
    public void askMaius(){
        System.out.println("Deseja letras maiúsculas na senha?");
    }
    public void askNumber(){
        System.out.println("Deseja números na senha?");
    }
    public void askCarac(){
        System.out.println("Deseja caracteres especiais na senha?");
    }

    public void askUrl(){
        System.out.println("Cole o diretório para gerar o arquivo txt da senha: ");
    }

}
