package br.edu.univas.main;

import br.edu.univas.view.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static Scanner l = new Scanner(System.in);
    public static int[] options = new int[4];
    public static int[] optionsBackup = new int[4];
    public static ArrayList<String[]> escolhidos = new ArrayList<>();
    public static Random random = new Random();
    public static String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
    public static String[] minc = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
            "r", "s", "t", "u", "v", "w", "x", "y", "z" };
    public static String[] maic = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    public static String[] espc = { "!", "@", "#", "$", "%", "&", "*" };
    public static View view = new View();

    public static void main(String[] args) {
        view.startApp();
        int tamanho = gerarTamanho();
        view.showOp();
        setarSenha();
        String senha = "";
        senha = gerarSenha(senha, tamanho);
        System.out.println(senha);
        gerarArquivo(senha);
    }

    public static int readInt() {
        int x = l.nextInt();
        l.nextLine();
        return x;
    }

    public static void setarSenha() {
        view.askMinus();
        options[0] = readInt();
        if (options[0] == 1) {
            escolhidos.add(minc);
        }
        view.askMaius();
        options[1] = readInt();
        if (options[1] == 1) {
            escolhidos.add(maic);
        }
        view.askNumber();
        options[2] = readInt();
        if (options[2] == 1) {
            escolhidos.add(nums);
        }
        view.askCarac();
        options[3] = readInt();
        if (options[3] == 1) {
            escolhidos.add(espc);
        }
        // esse for é pra manter um vetor com as opções escolhidas
        for (int i = 0; i < 4; i++) {
            optionsBackup[i] = options[i];
        }
    }

    public static String gerarSenha(String senha, int tamanho) {
        while (senha.length() < tamanho) {
            int x = random.nextInt(escolhidos.size());
            String[] sorteada = escolhidos.get(x);
            setarEscolhidos(sorteada);
            senha = senha + sorteada[random.nextInt(sorteada.length)];
            senha = verificarSenha(senha, tamanho);
        }
        return senha;
    }

    public static void setarEscolhidos(String[] sorteada) {
        if (sorteada.equals(minc)) {
            options[0] = 0;
        } else if (sorteada.equals(maic)) {
            options[1] = 0;
        } else if (sorteada.equals(nums)) {
            options[2] = 0;
        } else if (sorteada.equals(espc)) {
            options[3] = 0;
        }
    }

    public static String verificarSenha(String senha, int tamanho) {
        if (senha.length() == tamanho) {
            for (int i = 0; i < 4; i++) {
                if (options[i] == 1) {
                    senha = "";
                }
            }
            // esse for é pra resetar o vetor ops pras opções escolhidas anteriormente, já
            // que a senha foi zerada!
            for (int j = 0; j < 4; j++) {
                options[j] = optionsBackup[j];
            }
        }
        return senha;
    }

    public static void gerarArquivo(String senha) {
        view.askUrl();
        String dir = l.nextLine() + "/secret_password.txt";
        File f = new File(dir);
        try {
            FileWriter fileW = new FileWriter(f);
            BufferedWriter escrever = new BufferedWriter(fileW);
            escrever.write(senha);
            escrever.close();
            fileW.close();
        } catch (IOException ex) {
        }
    }

    public static int gerarTamanho() {
        view.askMin();
        int tmin = readInt();
        view.askMax();
        int tmax = readInt();
        int tamanho = random.nextInt((tmax - tmin) + 1) + tmin;
        return tamanho;
    }
}
