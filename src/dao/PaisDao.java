package dao;

import data.PaisData;
import java.util.List;
import model.Pais;

public class PaisDao {

    private PaisData paisdata;

    public void criar(Pais pais) {

    }

    public void alterar(Pais pais, int id) {

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

    public List<Pais> lerTodos() {
         return paisdata.getPaises();
    }
    
}
