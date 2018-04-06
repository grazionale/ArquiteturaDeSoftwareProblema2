package controler;

import dao.PaisDao;
import java.util.ArrayList;
import model.Pais;

public class PaisController {

    private PaisDao paisDao;
    
    public PaisController() {
        paisDao = new PaisDao();
    }
    
    public void cadastrar(Pais pais) {   
        paisDao.criar(pais); 
    }    
    
    public void alterar(Pais pais, int id) {   
        paisDao.alterar(pais, id); 
    }  
    
    public void deletar(int id) {   
        paisDao.deletar(id); 
    }  
    
    public Pais ler(int id) {   
        return paisDao.ler(id); 
    } 
    
    public ArrayList<Pais> lerTodos() {
        return paisDao.lerTodos();
    }
    
}
