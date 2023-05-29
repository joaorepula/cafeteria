import java.util.ArrayList;
import java.util.Scanner;

import controller.*;
import model.Log;

public class App {
    static Scanner in = new Scanner(System.in);
    static boolean menu = true;
    static int qtd = 0;
    static Cafeteira nespresso = new Cafeteira();
    static Log log = new Log(new ArrayList<String>());
    public static void main(String[] args) throws Exception {

        log.salvar(nespresso.toLog());
        while(menu){
            System.out.println(
                "Escolha uma das opções abaixo\n" +
                "1 - Fazer Café.\n" + 
                "2 - Adicionar Café.\n" +
                "3 - Adicionar Água.\n" + 
                "4 - Ver Status.\n" +
                "5 - Ver Log.\n" +
                "6 - Ligar.\n" +
                "7 - Desligar.\n" +
                "0 - Para Encerrar.\n" 
            );
            
            int op = in.nextInt();
            switch(op){
                case 1:
                    System.out.println("Digite a quantidade de café desejada.");
                    qtd = in.nextInt();
                    if(nespresso.fazerCafe(qtd)){
                        System.out.println("Café pronto");
                        log.salvar(nespresso.toLog());
                        break;
                    }
                    System.out.println("Erro ao fazer café, verifique o Status.");
                break;
                case 2:
                    System.out.println("Informe a quantidade de café a ser adicionada.");
                    qtd = in.nextInt();
                    nespresso.encherCafe(qtd);
                    System.out.println("Quantidade de café: " + nespresso.getQtdCafe());
                    log.salvar(nespresso.toLog());
                break;
                case 3:
                    System.out.println("Informe a quantidade de água a ser adicionada.");
                    qtd = in.nextInt();
                    nespresso.encherAgua(qtd);
                    System.out.println("Quantidade de água: " + nespresso.getQtdAgua());
                    log.salvar(nespresso.toLog());
                break;
                case 4:
                    System.out.println(nespresso);
                break;
                case 5:
                    System.out.println(log);
                break;
                case 6:
                    nespresso.setStatus(Status.PRONTO);
                    log.salvar(nespresso.toLog());
                break;
                case 7:
                    nespresso.setStatus(Status.DESLIGADA);
                    log.salvar(nespresso.toLog());
                break;
                case 0:
                    menu = false;
                break;
            }
        }
    }
}
