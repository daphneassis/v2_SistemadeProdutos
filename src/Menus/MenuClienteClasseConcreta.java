package Menus;

import java.util.Scanner;

public class MenuClienteClasseConcreta extends MenuClienteAbstract {


    public MenuClienteClasseConcreta(Scanner sc) {
        super(sc);
    }

    public static void menuCliente(Scanner sc) {
        MenuClienteAbstract menuCliente=null;
        int opcaoMenuCliente;
        System.out.println("-------Menu Cliente ------: ");
        System.out.println("1 - Visualizar lista de produtos");
        System.out.println("2 - Filtrar por categoria");
        System.out.println("3 - Filtrar por marca");
        System.out.println("4 - Ordenar por nome(ordem crescente e descrescente)");
        System.out.println("5 - Ordenar por preço(ordem crescente e descrescente)");
        System.out.println("0 - Sair do Menu Cliente");
        System.out.println("Entre com a opção desejada: ");
        opcaoMenuCliente = sc.nextInt();
        switch (opcaoMenuCliente) {
            case 0:
                System.out.println("Saindo do Menu Cliente");
                break;
            case 1:
                menuCliente.visualizarProdutos();
                break;
            case 2:
                menuCliente.filtrarPorCategoria();
                break;
            case 3:
                menuCliente.filtrarPorMarca();
                break;
            case 4:
                menuCliente.ordenarPorNome();
                break;
            case 5:
                menuCliente.ordenarPorPreco();
                break;
        }
    }

}
