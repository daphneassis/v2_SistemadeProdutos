import Enums.EnumCategoria;
import Enums.EnumSecoesMercado;
import Menus.MenuAdministrador;
import Menus.MenuCadastroLoginCliente;
import Menus.MenuCliente;
import Menus.MenuInicial;
import Pessoas.Administrador;
import Pessoas.Cliente;
import Produtos.Informatica;
import Produtos.Livro;
import Produtos.Mercado;
import Produtos.ProdutoAbstrato;
import ValidarUsuario.ValidarAdm;
import ValidarUsuario.ValidarCliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {

        int opcaoMenuInicial, opcaoSubmenu, opcaoMenuAdm, opcaoMenuCliente;
        String loginAdm, senhaAdm, loginCliente, senhaCliente;
        List<ProdutoAbstrato> listaProdutos = new ArrayList<>();
        Cliente cliente = null;

        do {
            boolean continuando = true;
            MenuInicial.menuInicial();
            opcaoMenuInicial = sc.nextInt();
            if (opcaoMenuInicial == 1) {
                System.out.println("-------Login Administrador---------");
                System.out.print("Digite o login:");
                loginAdm = sc.next();
                System.out.print("Digite a senha:");
                senhaAdm = sc.next();
                Administrador administrador = new Administrador(loginAdm, senhaAdm);
                boolean abreMenuAdm = ValidarAdm.validaAdmLoginSenha(loginAdm, senhaAdm, administrador);
                if (abreMenuAdm) {
                    do {
                        MenuAdministrador.menuAdministrador();
                        opcaoMenuAdm = sc.nextInt();
                        switch (opcaoMenuAdm) {
                            case 0:
                                System.out.println("Retornando ao Menu Inicial");
                                break;
                            case 1:
                                System.out.print("Digite o nome do produto: ");
                                String nomeProduto = sc.next();
                                System.out.print("Digite o preço do produto: ");
                                Double precoProduto = sc.nextDouble();
                                System.out.print("Digite a marca: ");
                                String marcaProduto = sc.next();
                                System.out.print("Qual a categoria do produto(Mercado(m)/Livro(l)/Informática(i)): ");
                                char ch = sc.next().charAt(0);
                                if (ch == 'm') {
                                    System.out.print("Qual a data de validade: ");
                                    Date dataValidade;
                                    try {
                                        dataValidade = sdf.parse(sc.next());
                                    } catch (ParseException e) {
                                        throw new RuntimeException(e);
                                    }
                                    System.out.print("Qual a seção do mercado? \n");
                                    for (EnumSecoesMercado secoes : EnumSecoesMercado.values()) {
                                        System.out.println(secoes);
                                    }
                                    EnumSecoesMercado secaoEscolhida = EnumSecoesMercado.escolhaSecaoMercado(sc.nextInt());
                                    listaProdutos.add(new Mercado(nomeProduto, precoProduto, marcaProduto, EnumCategoria.MERCADO, dataValidade, secaoEscolhida));
                                    System.out.print("Produto adicionado");

                                } else if (ch == 'l') {
                                    System.out.print("Digite a editora: ");
                                    String nomeEditora = sc.next();
                                    System.out.print("Digite o sobrenome do autor(a): ");
                                    String sobrenomeAutor = sc.next();
                                    listaProdutos.add(new Livro(nomeProduto, precoProduto, marcaProduto, EnumCategoria.LIVRO, nomeEditora, sobrenomeAutor));
                                    System.out.println("Produto adicionado");

                                } else if (ch == 'i') {
                                    System.out.print("Digite o nome do Software: ");
                                    String nomeSoftware = sc.next();
                                    System.out.print("Digite o tamanho da memória RAM: ");
                                    Double tamanhoMemoria = sc.nextDouble();
                                    listaProdutos.add(new Informatica(nomeProduto, precoProduto, marcaProduto, EnumCategoria.INFORMATICA, nomeSoftware, tamanhoMemoria));
                                    System.out.println("Produto adicionado");
                                }
                                break;
                            case 2:
                                for (ProdutoAbstrato produtoNaLista : listaProdutos) {
                                    System.out.println(produtoNaLista);
                                }
                                break;
                            case 3:
                                System.out.println("Digite o nome do produto que deseja editar: ");
                                String nome = sc.next();
                                boolean aux = true;
                                for (ProdutoAbstrato cadaProduto : listaProdutos) {
                                    if (cadaProduto.getNome().equals(nome)) {
                                        aux=false;
                                        System.out.println("Produto encontrado");
                                        System.out.println("O que deseja editar?(Nome(n)/Preço(p)/Marca(m)/Categoria(c):");
                                        char edicaoProduto = sc.next().charAt(0);
                                        if (edicaoProduto == 'n') {
                                            System.out.print("Digite o novo nome: ");
                                            String novoNome = sc.next();
                                            cadaProduto.setNome(novoNome);
                                        }
                                        if (edicaoProduto == 'p') {
                                            System.out.print("Digite o novo preco: ");
                                            Double novoPreco = sc.nextDouble();
                                            cadaProduto.setPreco(novoPreco);
                                        }
                                        if (edicaoProduto == 'm') {
                                            System.out.print("Digite a nova marca: ");
                                            String novaMarca = sc.next();
                                            cadaProduto.setMarca(novaMarca);
                                        }
                                        if (edicaoProduto == 'c') {
                                            System.out.print("Digite a nova categoria: (Mercado(m)/Livro(l)/Informática(i))");
                                            ch = sc.next().charAt(0);
                                            if (ch == 'm') {
                                                cadaProduto.setCategoria(EnumCategoria.MERCADO);
                                            } else if (ch == 'l') {
                                                cadaProduto.setCategoria(EnumCategoria.LIVRO);
                                            } else if (ch == 'i') {
                                                cadaProduto.setCategoria(EnumCategoria.INFORMATICA);
                                            }
                                        }
                                        System.out.println("Produto editado: " + cadaProduto);
                                        break;
                                    }
                                }
                                if(aux=false) {// problema aqui o produto não encontrado continua sendo mostrado
                                }else{
                                    System.out.println("Produto não encontrado");
                                }
                                break;
                        case 4:
                            System.out.println("Digite o nome do produto que deseja editar: ");
                            String nomeExcluido = sc.next();
                            for (ProdutoAbstrato c : listaProdutos) {
                                if (c.getNome().equals(nomeExcluido)) {
                                    System.out.println(c);
                                    listaProdutos.remove(c);
                                    System.out.println("Produto encontrado e deletado!");
                                } else {
                                    System.out.println("Produto não encontrado!");
                                }
                            }
                            break;
                    }
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
