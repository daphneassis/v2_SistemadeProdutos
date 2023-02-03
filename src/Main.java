
import Menus.*;
import ValidarUsuario.ValidarAdm;
import ValidarUsuario.ValidarCliente;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int opcaoMenuInicial;
                //opcaoMenuAdm = 0, opcaoMenuCliente = 0;
         do{
              MenuInicial.menuInicial();
            opcaoMenuInicial = sc.nextInt();
            if (opcaoMenuInicial == 1) {
                boolean abreMenuAdm = ValidarAdm.validaAdmLoginSenha(new AdmLogin(sc).loginAdm());
                if (abreMenuAdm) {
                       new MenuAdmClasseConcreta(sc).menuAdministrador();
                       //a opção editar do Menu Adm ainda traz erro de produto não encontrado qnd encontra e deleta
                }
            }
            if (opcaoMenuInicial == 2) {// não tá carregando a lista de produtos pro cliente poder realizar as ações do Menu
                boolean abreMenuCliente = ValidarCliente.validaClienteLoginSenha(new ClienteCadastro(sc).cadastroCliente(), new ClienteLogin(sc).loginCliente());
                if (abreMenuCliente) {
                        new MenuClienteClasseConcreta(sc).menuCliente();
                }
            }
        } while (opcaoMenuInicial != 0);
    }
}

