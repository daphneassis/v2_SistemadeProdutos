package Menus;

import Pessoas.Administrador;

import java.util.Scanner;

public class MenuLoginAdm {

    private Scanner sc;

     Administrador administrador;
    public MenuLoginAdm(Scanner sc){
        this.sc=sc;}

       public Administrador menuLoginAdm() {
           System.out.println("-------Login Administrador---------");
           System.out.print("Digite o login:");
           String loginAdm = sc.next();
           System.out.print("Digite a senha:");
           String senhaAdm = sc.next();
           return administrador = new Administrador(loginAdm,senhaAdm);
       }

}
