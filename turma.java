
package ge;

public class turma {
    private String nome;
    private String classe;
    private String sala;
    private String periodo;
    private String anoLectivo;

    public turma(String nome, String classe, String sala, String periodo, String anoLectivo) {
        this.nome = nome;
        this.classe = classe;
        this.sala = sala;
        this.periodo = periodo;
        this.anoLectivo = anoLectivo;
       
    }
   
   
    public turma(String nome, String classe, String sala, String periodo) {
        this.nome = nome;
        this.classe = classe;
        this.sala = sala;
        this.periodo = periodo;
    }
    public turma(String sala, String classe,  String periodo) {
        this.classe = classe;
        this.sala = sala;
        this.periodo = periodo;
    }
     public turma(String nome) {
        this.nome = nome;
     }

    turma() {
       //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getAnoLectivo() {
        return anoLectivo;
    }

    public void setAnoLectivo(String anoLectivo) {
        this.anoLectivo = anoLectivo;
    }
    
}
