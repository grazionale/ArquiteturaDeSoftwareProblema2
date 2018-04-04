package dao;

import data.PaisData;
import java.util.List;
import java.util.Set;
import model.Pais;

public class PaisDao {

    private PaisData paisdata;

    public void criar(Pais pais) {
        paisdata.getPaises().add(pais);
    }

    public void alterar(Pais pais, int id) { 
        
        for(Pais paisArray : paisdata.getPaises()){
            if(paisArray.getId() == id){
                paisArray.setId(id);
                paisdata.getPaises().add(paisArray);
            }
        }
        
    }

    public void deletar(int id) {
        for(Pais paisArray : paisdata.getPaises()){
            if(paisArray.getId() == id){
                paisdata.getPaises().remove(paisArray);
            }
        }
    }

    public Pais ler(int id) {
        for (Pais paisArray : paisdata.getPaises()) {
            if (paisArray.getId() == id) {
                return paisArray;
            } 
        }
        return null;
    }

    public Set<Pais> lerTodos() {
         return paisdata.getPaises();
    }
    
}
