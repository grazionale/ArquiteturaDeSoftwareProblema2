package problema2;

import java.util.ArrayList;
import java.util.Scanner;

public class Problema2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<String>();

        do {
            System.out.println("Deseja listar ou entrar? (listar/entrar)");
            String x = sc.nextLine();

            if (x.equals("listar")) {
                if(!nomes.isEmpty()) {
                    System.out.println("Lista de Clientes");
                    for (int i = 0; i < nomes.size(); i++) {
                        System.out.println(nomes.get(i) + "\n");
                    }
                } else {
                    System.out.println("Lista vazia \n\n");
                }
                
            } else {
                System.out.println("Digite o nome do Cliente: ");
                nomes.add(sc.nextLine());
            }
        } while (true);

    }

}
