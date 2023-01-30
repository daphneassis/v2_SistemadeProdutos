package ValidarUsuario;

import Pessoas.Administrador;

public class ValidarAdm {
    Administrador administrador;
    public static boolean validaAdmLoginSenha(String loginAdm, String senhaAdm, Administrador administrador){
        if (administrador.getLogin().equals(loginAdm)&&administrador.getSenha().equals(senhaAdm)){
            System.out.println("Login de administrador realizado com sucesso!");
            return true;
        } else{
            System.out.println("Login ou senha inválidas");
            return false;
        }
    }
}
