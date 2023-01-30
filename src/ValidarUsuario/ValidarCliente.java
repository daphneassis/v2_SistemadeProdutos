package ValidarUsuario;

import Pessoas.Cliente;

public class ValidarCliente {

    public static boolean validaClienteLoginSenha(String loginCliente, String senhaCliente, Cliente cliente){
        if(cliente.getLogin().equals(loginCliente)&&cliente.getSenha().equals(senhaCliente)){
            System.out.println("Login de cliente realizado com sucesso!");
            return true;
        } else{
            System.out.println("Login ou senha inválidas");
            return false;
        }
    }
}
