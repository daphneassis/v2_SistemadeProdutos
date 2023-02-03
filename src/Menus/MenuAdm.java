package Menus;

import java.awt.*;
import java.util.Scanner;

public class MenuAdm extends MenuAdmAbstract{

    MenuAdmAbstract menuAdm;

    public MenuAdm(Scanner sc,MenuAdmAbstract menuAdm) {
        super(sc);
        this.menuAdm= menuAdm;
    }
    public static void menuAdministrador(Scanner sc, MenuAdmAbstract menuAdm) {
        System.out.println("-----Menu Administrador ------: ");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Visualizar produtos");
        System.out.println("3 - Editar produto");
        System.out.println("4 - Remover produto");
        System.out.println("0 - Retornar ao Menu Inicial");
        System.out.println("Entre com a opção desejada: ");
        int opcaoMenuAdm = sc.nextInt();
        switch (opcaoMenuAdm) {
            case 0:
                System.out.println("Retornando ao Menu Inicial");
                break;
            case 1:
                menuAdm.cadastrarProdutos();
                break;
            case 2:
                menuAdm.visualizarProdutos();
                break;
            case 3:
                menuAdm.editarProdutos();
                break;
            case 4:
                menuAdm.removerProdutos();
                break;
        }
    }



}
