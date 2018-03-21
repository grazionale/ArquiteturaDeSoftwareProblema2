
package model;

public class Cliente {
    private String nome;
    private String telefone;
    private Pais pais;
    private int limite_credito;
    private int idade;

    public Cliente(String nome, String telefone, int idade, Pais pais) {
        this.nome = nome;
        this.telefone = telefone;
        this.pais = pais;
        this.idade = idade;
    }
    
    public Cliente() {   }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        this.limite_credito = limite_credito;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    
}
