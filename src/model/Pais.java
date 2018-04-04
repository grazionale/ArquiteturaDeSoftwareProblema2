package model;


public class Pais {
    private String nome;
    private String sigla;
    private int id;
    
    public Pais() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Pais(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        
        if(!nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new Exception("Nome não pode ser vazio");
        }  
        
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) throws Exception {
        
        if(!nome.isEmpty()) {
            this.sigla = sigla;
        } else {
            throw new Exception("Sigla não pode ser vazia");
        }    
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
