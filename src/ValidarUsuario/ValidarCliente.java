package ValidarUsuario;

import Pessoas.Administrador;
import Pessoas.Cliente;

import java.util.Scanner;

public class ValidarCliente {
    private Scanner sc;
    private Cliente cliente;

    ValidarCliente(Scanner sc){
        this.sc= this.sc;
    }

    public static boolean validaClienteLoginSenha(Cliente cliente, Cliente cliente2){
        if(cliente.getLogin().equals(cliente2.getLogin())&&cliente.getSenha().equals(cliente2.getSenha())){
            System.out.println("Login de cliente realizado com sucesso!");
            return true;
        } else{
            System.out.println("Login ou senha inválidas");
            return false;
        }
    }
}