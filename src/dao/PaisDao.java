package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Pais;
import util.Conexao;

public class PaisDao {

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
            JOptionPane.showMessageDialog(null, "País cadastrado com sucesso!");
        } catch (Exception e) {
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar país");
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
            JOptionPane.showMessageDialog(null, "País alterado com sucesso!");
        } catch (Exception e) {
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao alterar país!");
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
            JOptionPane.showMessageDialog(null, "País excluido com sucesso!");
        } catch (Exception e) {
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao excluir país!");
            throw new RuntimeException(e);              
        }        
    }

    public Pais ler(int id) {
        String sql = "select * from pais where id = ?";

        try {
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            Pais p = new Pais();
            
            if(!rs.next()){
                System.out.println("Não achou");
            }
            
            p.setId(rs.getInt("id"));
            p.setSigla(rs.getString("sigla"));
            p.setNome(rs.getString("nome")); 
            
            rs.close();
            pst.close();
            
            return p;
        } catch (Exception e) {
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            throw new RuntimeException(e);              
        }   
        
    }

    public ArrayList<Pais> lerTodos() {
         String sql = "select * from pais";

        try {
            ArrayList<Pais> paises = new ArrayList<>();
            PreparedStatement pst = this.con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Pais p = new Pais();
                p.setId(rs.getInt("id"));
                p.setSigla(rs.getString("sigla"));
                p.setNome(rs.getString("nome"));  
                paises.add(p);
            }
            rs.close();
            pst.close();
            
            return paises;
        } catch (Exception e) {
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            throw new RuntimeException(e);              
        }   
    }
    
}
