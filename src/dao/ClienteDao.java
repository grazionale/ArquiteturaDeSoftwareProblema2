package dao;

import data.ClienteData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;
import model.Cliente;
import util.Conexao;

public class ClienteDao {
    private final Connection con;
    private PreparedStatement pst;
    
    public ClienteDao() {
        this.con = new Conexao().Conector();
    }
    
    public void criar(Cliente cliente) {
        String sql = "insert into cliente (nome, telefone, limite_credito, idade, idPais) values (?,?, ?, ?, ?);";

        try {
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getTelefone());
            pst.setInt(3, cliente.getIdade());
            pst.setInt(4, cliente.getLimite_credito());
            pst.setInt(5, cliente.getPais().getId());
           
            pst.execute();
            pst.close();
        } catch (Exception e) {
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            throw new RuntimeException(e);              
        }
    }

    public void alterar(Cliente cliente, int id) { 
        
        String sql = "update cliente set nome = ?, telefone = ?, idade = ?, limite_credito = ?"
                + " idPais = ? where id = ?;";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getTelefone());
            pst.setInt(3, cliente.getIdade());
            pst.setInt(4, cliente.getLimite_credito());
            pst.setInt(5, cliente.getPais().getId());
            
            pst.execute();
            pst.close();
        } catch (Exception e) {
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            throw new RuntimeException(e);              
        }
        
    }

    public void deletar(int id) {
        String sql = "delete from cliente where id = ?";
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

    public Cliente ler(int id) {
        String sql = "select * from cliente inner join pais on cliente.ippais = pais.id where id = ?";

        try {
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            Cliente c = new Cliente();
            
            if(!rs.next()){
                System.out.println("Não achou");
            }
            
            c.setId(rs.getInt("cliente_id"));
            c.setNome(rs.getString("cliente_nome"));
            c.setTelefone(rs.getString("cliente_telefone")); 
            c.setIdade(rs.getInt("cliente_idade")); 
            c.setLimite_credito(rs.getInt("cliente_limite_credito")); 
            c.getPais().setId(rs.getInt("pais_id")); 
            c.getPais().setNome(rs.getString("pais_nome")); 
            c.getPais().setSigla(rs.getString("pais_sigla")); 
            
            rs.close();
            pst.close();
            
            return c;
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
