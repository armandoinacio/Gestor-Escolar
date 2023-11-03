
package ge;


public class divida {
   String id,nome,ultimoMes;

    public divida(String id, String nome, String ultimoMes) {
        this.id = id;
        this.nome = nome;
        this.ultimoMes = ultimoMes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltimoMes() {
        return ultimoMes;
    }

    public void setUltimoMes(String ultimoMes) {
        this.ultimoMes = ultimoMes;
    }
   
}
