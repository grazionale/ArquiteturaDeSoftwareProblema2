package dao;

import data.PaisData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Set;
import model.Pais;
import util.Conexao;

public class PaisDao {

    private PaisData paisdata;
    private final Connection con;
    private PreparedStatement pst;
    
    public PaisDao() {
        this.con = new Conexao().Conector();
    }
    
    
    public void criar(Pais pais) {
        String sql = "insert into pais (sigla, nome) values (?,?);";

        try {
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setString(1, pais.getSigla());
            pst.setString(2, pais.getNome());
           
            pst.execute();
            pst.close();
        } catch (Exception e) {
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            throw new RuntimeException(e);              
        }
    }

    public void alterar(Pais pais, int id) { 
        
        String sql = "update pais set sigla = ?, nome = ? where id = ?;";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setString(1, pais.getSigla());
            pst.setString(2, pais.getNome());
            pst.setInt(3, id);

            pst.execute();
            pst.close();
        } catch (Exception e) {
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            throw new RuntimeException(e);              
        }
        
    }

    public void deletar(int id) {
        String sql = "delete from pais where id = ?";
        try {
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setInt(1, id);

            pst.execute();
            pst.close();
        } catch (Exception e) {
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            throw new RuntimeException(e);              
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
