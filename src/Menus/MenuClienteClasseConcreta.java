package Menus;

import Enums.EnumCategoria;
import Produtos.ProdutoAbstrato;

import java.util.*;

import static Menus.MenuAdmClasseConcreta.visualizarProdutos;

public class MenuClienteClasseConcreta {

    private static MenuClienteAbstract menuCliente;
    private static Scanner sc;
    private static List<ProdutoAbstrato> listaProdutos = new ArrayList<>();


    public MenuClienteClasseConcreta(Scanner sc){
        this.sc=sc;
}

    public static void menuCliente() {
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
                visualizarProdutos();
                break;
            case 2:
              filtrarPorCategoria();
                break;
            case 3:
               filtrarPorMarca();
                break;
            case 4:
               ordenarPorNome();
                break;
            case 5:
               ordenarPorPreco();
                break;
        }
    }
    public static void filtrarPorCategoria() {
        System.out.println("Filtrar pela categoria: (m)Mercado/(l)Livro/(i)Informática");
        char opcaoFiltroPorCategoria = sc.next().charAt(0);
        if (opcaoFiltroPorCategoria == 'm') {
            for (ProdutoAbstrato produto : listaProdutos) {
                if (produto.getCategoria().equals(EnumCategoria.MERCADO)) {
                    System.out.println(produto);
                }
            }
        }
        if (opcaoFiltroPorCategoria == 'l') {
            for (ProdutoAbstrato produto : listaProdutos) {
                if (produto.getCategoria().equals(EnumCategoria.LIVRO)) {
                    System.out.println(produto);
                }
            }
        }
        if (opcaoFiltroPorCategoria == 'i') {
            for (ProdutoAbstrato produto : listaProdutos) {
                if (produto.getCategoria().equals(EnumCategoria.INFORMATICA)) {
                    System.out.println(produto);
                }
            }
        }
    }
    public static void filtrarPorMarca() {
        System.out.println("Digite a marca:");
        String opcaoFiltrarPorMarca = sc.next();
        for (ProdutoAbstrato produto : listaProdutos) {
            if (produto.getMarca().equals(opcaoFiltrarPorMarca)) {
                System.out.println(produto);
            }
        }
    }

    public static void ordenarPorNome() {
        System.out.println("Ordenar a lista por nome na ordem crescente ou descrescente?(c/d)");
        char opcaoOrdemNome = sc.next().charAt(0);
        if (opcaoOrdemNome == 'c') {
            Collections.sort(listaProdutos);
            for (ProdutoAbstrato produto : listaProdutos) {
                System.out.println(produto);
            }
        }
        if (opcaoOrdemNome == 'd') {
            Collections.reverse(listaProdutos);
            for (ProdutoAbstrato produto : listaProdutos) {
                System.out.println(produto);
            }
        }
    }

    public static void ordenarPorPreco() {
        System.out.println("Ordenar a lista por preço na ordem crescente ou descrescente?(c/d)");
        char opcaoOrdemPreco = sc.next().charAt(0);
        if (opcaoOrdemPreco == 'c') {
            Collections.sort(listaProdutos, Comparator.comparing(ProdutoAbstrato::getPreco));
            for (ProdutoAbstrato produto : listaProdutos) {
                System.out.println(produto);
            }
        }
        if (opcaoOrdemPreco == 'd') {
            Collections.reverse(listaProdutos);
            for (ProdutoAbstrato produto : listaProdutos) {
                System.out.println(produto);
            }
        }
    }

}
