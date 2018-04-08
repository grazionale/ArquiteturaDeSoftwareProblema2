package controler;

import dao.ClienteDao;
import java.util.ArrayList;
import model.Cliente;

public class ClienteController {

    private ClienteDao clienteDao;
    
    public ClienteController() {
        clienteDao = new ClienteDao();
    } 
    
    public void cadastrar(Cliente cliente) {   
        clienteDao.criar(cliente); 
    }    
    
    public void alterar(Cliente cliente, int id) {   
        clienteDao.alterar(cliente, id); 
    }  
    
    public void deletar(int id) {   
        clienteDao.deletar(id); 
    }  
    
    public Cliente ler(int id) {   
        return clienteDao.ler(id); 
    } 
    
    public ArrayList<Cliente> lerTodos() {
        return clienteDao.lerTodos();
    }    
}
