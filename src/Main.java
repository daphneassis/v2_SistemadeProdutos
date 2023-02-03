import Enums.EnumCategoria;
import Menus.*;
import Pessoas.Administrador;
import Pessoas.Cliente;
import Produtos.ProdutoAbstrato;
import ValidarUsuario.ValidarAdm;
import ValidarUsuario.ValidarCliente;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {

        int opcaoMenuInicial, opcaoSubmenu, opcaoMenuAdm=0, opcaoMenuCliente;
        String loginCliente, senhaCliente;
        List<ProdutoAbstrato> listaProdutos = new ArrayList<>();
        Cliente cliente = null;
        MenuAdmAbstract menuAdm = null;
        do {
            boolean continuando = true;
            MenuInicial.menuInicial();
            opcaoMenuInicial = sc.nextInt();
            if (opcaoMenuInicial == 1) {
                boolean abreMenuAdm = ValidarAdm.validaAdmLoginSenha(new MenuLoginAdm(sc).menuLoginAdm());
                if (abreMenuAdm) {
                    do {
                        MenuAdm.menuAdministrador(sc, menuAdm);
                } while (opcaoMenuAdm != 0) ;
            }
        }
        if (opcaoMenuInicial == 2) {
            do {
                MenuCadastroLoginCliente.menuCadastroLoginCliente();
                opcaoSubmenu = sc.nextInt();
                if (opcaoSubmenu == 1) {
                    System.out.println("-------Cadastro Cliente---------");
                    System.out.print("Digite o login a ser cadastrado:");
                    loginCliente = sc.next();
                    System.out.print("Digite a senha a ser cadastrada:");
                    senhaCliente = sc.next();
                    cliente = new Cliente(loginCliente, senhaCliente);
                    System.out.print("Cadastro realizado com sucesso! Faça o seu login para acesso ao Menu. \n");
                }
                if (opcaoSubmenu == 2) {
                    System.out.println("-------Login Cliente---------");
                    System.out.print("Digite o login:");
                    loginCliente = sc.next();
                    System.out.print("Digite a senha:");
                    senhaCliente = sc.next();
                    boolean abreMenuCliente = ValidarCliente.validaClienteLoginSenha(loginCliente, senhaCliente, cliente) == true;
                    if (abreMenuCliente) {
                        do {
                            MenuCliente.menuCliente();
                            opcaoMenuCliente = sc.nextInt();
                            switch (opcaoMenuCliente) {
                                case 0:
                                    System.out.println("Saindo do Menu Cliente");
                                    break;
                                case 1:
                                    for (ProdutoAbstrato produto : listaProdutos) {
                                        System.out.println(produto);
                                    }
                                    break;
                                case 2:
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
                                    break;
                                case 3:
                                    System.out.println("Digite a marca:");
                                    String opcaoFiltrarPorMarca = sc.next();
                                    for (ProdutoAbstrato produto : listaProdutos) {
                                        if (produto.getMarca().equals(opcaoFiltrarPorMarca)) {
                                            System.out.println(produto);
                                        }
                                    }
                                    break;
                                case 4:
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
                                    break;
                                case 5:
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
                                    break;
                            }
                        } while (opcaoMenuCliente != 0);
                    }
                }
            } while (opcaoSubmenu != 3);
        }
    } while(opcaoMenuInicial !=0);
}
}
