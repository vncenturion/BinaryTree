package abb;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArvBin arvore1 = new ArvBin();

        //leitor arquivo
        String pCaminho = "C:\\Users\\vinic\\IdeaProjects\\ArvoreBinaria\\src\\abb\\lista.txt", linha;

        try {
            BufferedReader br = new BufferedReader(new FileReader(pCaminho));

            while ((linha = br.readLine()) != null)
            {
                String[] cadastro = linha.split(",");
                arvore1.inserirNo(new NoABB(Integer.parseInt(cadastro[0]),cadastro[1]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner teclado = new Scanner(System.in);
        int seletorMenu;

        do {

            MenuPrincipal.mostrarMenu();
            System.out.print("Digite sua opção: ");
            seletorMenu = teclado.nextInt();
            teclado.nextLine();

            switch (seletorMenu){
                case 1:
                    //inserir;
                    int RGM;
                    String NomeAluno;
                    System.out.print("Digite o RGM do aluno: ");
                    RGM = teclado.nextInt();
                    teclado.nextLine();//limpa buffer depois de nextInt
                    System.out.print("Digite o Nome do aluno: ");
                    NomeAluno = teclado.nextLine();
                    arvore1.inserirNo(new NoABB(RGM,NomeAluno));
                    System.out.println("");
                    break;
                case 2:
                    //remover;
                    System.out.print("Digite o RGM do aluno a excluir: ");
                    RGM = teclado.nextInt();
                    teclado.nextLine();//limpa buffer depois de nextInt
                    arvore1.excluirNo(RGM);
                    break;
                case 3:
                    //pesquisar;
                    System.out.print("Digite o RGM do aluno a localizar: ");
                    RGM = teclado.nextInt();
                    teclado.nextLine();//limpa buffer depois de nextInt
                    arvore1.localizarNo(RGM);
                    System.out.println("");
                    break;
                case 4:
                    arvore1 = new ArvBin();
                    break;
                case 5:
                    arvore1.exibirIn();
                    System.out.println("");
                    arvore1.exibirPre();
                    System.out.println("");
                    arvore1.exibirPos();
                    System.out.println("");
                    break;
                case 0:
                    //sair;
                    System.out.println("Saindo do programa...\n< pressione qualquer tecla >");
                    teclado.nextLine();//limpa buffer depois de nextInt
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (seletorMenu!=0);

        System.out.println("< Finalizado >");
    }
}
