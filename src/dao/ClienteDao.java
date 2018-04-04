/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import data.ClienteData;
import java.util.List;
import java.util.Set;
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
        
        for(Cliente clienteArray : clientedata.getClientes()){
            if(clienteArray.getId() == id){
                clienteArray.setId(id);
                clientedata.getClientes().add(clienteArray);
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

    public Set<Cliente> lerTodos() {
         return clientedata.getClientes();
    }
}
