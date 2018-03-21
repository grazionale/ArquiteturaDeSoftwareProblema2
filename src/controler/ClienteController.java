package controler;

import data.ClienteData;
import model.Cliente;

public class ClienteController {

    ClienteData c = new ClienteData();

    public String cadastrar(Cliente cliente) {

        if (cliente.getNome().length() < 5) {
            return "Informe pelo menos 5 caracteres para o nome do cliente";

        } else {
            if(!c.getClientes().isEmpty()){
                for (Cliente cli : c.getClientes()) {
                    if (cli.getNome().equals(cliente.getNome())) {
                        return "Cliente informado já existente";
                    }
                }                
            } 

            if (cliente.getIdade() <= 18) {
                cliente.setLimite_credito(100);
            } else if (cliente.getIdade() <= 35) {
                cliente.setLimite_credito(300);
            } else {
                cliente.setLimite_credito(500);
            }

            if (cliente.getPais().getSigla().equals("BR")) {
                cliente.setLimite_credito(cliente.getLimite_credito() + 100);
            }

            c.getClientes().add(cliente);

            return "Sucesso";
        }

    }
}
