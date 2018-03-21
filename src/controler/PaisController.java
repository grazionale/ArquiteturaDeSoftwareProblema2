package controler;

import data.PaisData;
import model.Pais;

public class PaisController {

    PaisData paises = new PaisData();
    
    public String cadastrar(Pais pais){  
        
        
        if(pais.getNome().isEmpty() || pais.getSigla().isEmpty()) {
            return "Informe todos os dados do pais";
            
        } else if(paises.getPaises().isEmpty()) {
            paises.getPaises().add(pais);
            return "Sucesso";
            
        } else {
            for(Pais paisArray: paises.getPaises()) {
                if(paisArray.getNome().equals(pais.getNome())) {
                    return "Já existe um pais com este nome";
                }
            }
            paises.getPaises().add(pais);
            return "Sucesso";
        }
        
    }    
}
