package abb;

import java.io.Console;
import java.util.Scanner;

public class MenuPrincipal {

    public static void mostrarMenu() {

        System.out.println("EDITOR DE ARVORE BINARIA\n");
        System.out.println("""
                1. Inserir (rgm e nome)
                2. Remover um nó (por RGM)
                3. Pesquisar (por RGM)
                4. Esvaziar a árvore
                5. Exibir árvore
                0. Sair\n""");
    }

}
