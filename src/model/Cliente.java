
package model;

public class Cliente {
    private String nome;
    private String telefone;
    private Pais pais;
    private int limite_credito;
    private int idade;
    private int id;

    public Cliente(String nome, String telefone, int idade, Pais pais) {
        this.nome = nome;
        this.telefone = telefone;
        this.pais = pais;
        this.idade = idade;
    }
    
    public Cliente() {   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.length() < 5) {
            throw new Exception("Nome não pode conter menos de 5 caracteres");
        } else {
            this.nome = nome;
        }
        
        
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public int getLimite_credito() {
        
        
        
        
        return limite_credito;
    }

    public void setLimite_credito(int limite_credito) {
        if (getIdade() <= 18) {
                this.limite_credito = 100;
            } else if (getIdade() <= 35) {
                this.limite_credito = 300;
            } else {
                this.limite_credito = 500;
            }
        
        if (getPais().getSigla().equals("BR")) {
                this.limite_credito += 100;
            }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    
}
