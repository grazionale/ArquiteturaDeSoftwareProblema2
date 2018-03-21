
package model;

public class Cliente {
    private String nome;
    private String telefone;
    private Pais pais;
    private String limite_credito;

    public Cliente(String nome, String telefone, Pais pais, String limite_credito) {
        this.nome = nome;
        this.telefone = telefone;
        this.pais = pais;
        this.limite_credito = limite_credito;
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

    public String getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(String limite_credito) {
        this.limite_credito = limite_credito;
    }
    
}
