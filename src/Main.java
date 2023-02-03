
import Menus.*;
import ValidarUsuario.ValidarAdm;
import ValidarUsuario.ValidarCliente;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {

        int opcaoMenuInicial, opcaoMenuAdm = 0, opcaoMenuCliente = 0;
        do {
            MenuInicial.menuInicial();
            opcaoMenuInicial = sc.nextInt();
            if (opcaoMenuInicial == 1) {
                boolean abreMenuAdm = ValidarAdm.validaAdmLoginSenha(new AdmLogin(sc).loginAdm());
                if (abreMenuAdm) {
                    do {MenuAdmClasseConcreta.menuAdministrador(sc);
                    } while (opcaoMenuAdm != 0);
                }
            }
            if (opcaoMenuInicial == 2) {
                boolean abreMenuCliente = ValidarCliente.validaClienteLoginSenha(new ClienteCadastro(sc).cadastroCliente(), new ClienteLogin(sc).loginCliente());
                if (abreMenuCliente) {
                    do {MenuClienteClasseConcreta.menuCliente(sc);
                    } while (opcaoMenuCliente != 0);
                }
            }
        } while (opcaoMenuInicial != 0);
    }
}

