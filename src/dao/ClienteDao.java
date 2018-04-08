package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        String sql = "SELECT c.id AS c_id, c.nome AS c_nome, c.telefone AS c_telefone, c.limite_credito AS c_limite_credito, c.idade AS c_idade, " +
                        "p.id AS p_id, p.nome AS p_nome, p.sigla AS p_sigla " +
                        "FROM cliente AS c INNER JOIN pais AS p ON c.idPais = p.id " +
                        "WHERE c.id = ?";

        try {
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            Cliente c = new Cliente();
                        
            if(!rs.next()){
                System.out.println("Não achou");
            }
                                    
            c.setId(rs.getInt("c_id"));
            c.setNome(rs.getString("c_nome"));
            c.setTelefone(rs.getString("c_telefone")); 
            c.setIdade(rs.getInt("c_idade"));  
            c.getPais().setId(rs.getInt("p_id")); 
            c.getPais().setNome(rs.getString("p_nome")); 
            c.getPais().setSigla(rs.getString("p_sigla")); 
            c.setLimite_credito(rs.getInt("c_limite_credito"));
                        
            rs.close();
            pst.close();
            
            return c;
        } catch (Exception e) {
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            throw new RuntimeException(e);              
        }   
        
    }

    public ArrayList<Cliente> lerTodos() {
         String sql = "SELECT c.id AS c_id, c.nome AS c_nome, c.telefone AS c_telefone, c.limite_credito AS c_limite_credito, c.idade AS c_idade, " +
                        "p.id AS p_id, p.nome AS p_nome, p.sigla AS p_sigla " +
                        "FROM cliente AS c INNER JOIN pais AS p ON c.idPais = p.id";

        try {
            ArrayList<Cliente> clientes = new ArrayList<>();
            PreparedStatement pst = this.con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("c_id"));
                c.setNome(rs.getString("c_nome"));
                c.setTelefone(rs.getString("c_telefone")); 
                c.setIdade(rs.getInt("c_idade"));  
                c.getPais().setId(rs.getInt("p_id")); 
                c.getPais().setNome(rs.getString("p_nome")); 
                c.getPais().setSigla(rs.getString("p_sigla")); 
                c.setLimite_credito(rs.getInt("c_limite_credito"));
                clientes.add(c);
            }
            rs.close();
            pst.close();
            
            return clientes;
        } catch (Exception e) {
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            throw new RuntimeException(e);              
        }   
    }
}
