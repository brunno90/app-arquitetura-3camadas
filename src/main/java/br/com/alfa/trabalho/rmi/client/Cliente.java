package br.com.alfa.trabalho.rmi.client;

/**
 * Created by Brunno on 03/03/2017.
 */
import java.rmi.Naming;
public class Cliente {
    public static void main(String[] args) {
        Ola obj = null;
        String msg = "minha mensagem";
        String retorno = null;
        try {
            obj = (Ola)Naming.lookup("//127.0.0.1/OlaServidor");
            retorno = obj.showMsg(msg);
            System.out.println(retorno);
        }
        catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}