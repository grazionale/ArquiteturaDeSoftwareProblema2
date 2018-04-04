/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import data.ClienteData;
import java.util.List;
import model.Cliente;

/**
 *
 * @author gabri
 */
public class ClienteDao {
    private ClienteData clientedata;

    public void criar(Cliente cliente) {
        clientedata.getClientes().add(cliente);
    }

    public void alterar(Cliente cliente, int id) { 
        for(int i = 0 ; i < clientedata.getClientes().size() ; i++){
            if(clientedata.getClientes().get(i).getId() == id) {
                clientedata.getClientes().set(i, cliente);
            }
        }
    }

    public void deletar(int id) {
        for(Cliente cliente : clientedata.getClientes()){
            if(cliente.getId() == id){
                clientedata.getClientes().remove(cliente);
            }
        }
    }

    public Cliente ler(int id) {
        for (Cliente cliente : clientedata.getClientes()) {
            if (cliente.getId() == id) {
                return cliente;
            } 
        }
        return null;
    }

    public List<Cliente> lerTodos() {
         return clientedata.getClientes();
    }
}
