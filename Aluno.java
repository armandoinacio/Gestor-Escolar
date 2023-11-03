
package ge;


public class Aluno {
    String nome,bilhete,dataNascimento,genero,provincia_origem,municipio_origem,bairro_origem,classe,provincia_actual,municipio_actual,bairro_actual,encarregado,endereco,generoEncarregado,profissao,telefone,telefone2,id,idade;

    public Aluno(String nome, String bilhete, String dataNascimento, String genero, String provincia_origem, String municipio_origem, String bairro_origem, String classe, String provincia_actual, String municipio_actual, String bairro_actual, String encarregado, String endereco, String generoEncarregado, String profissao, String telefone, String telefone2) {
        this.nome = nome;
        this.bilhete = bilhete;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.provincia_origem = provincia_origem;
        this.municipio_origem = municipio_origem;
        this.bairro_origem = bairro_origem;
        this.classe = classe;
        this.provincia_actual = provincia_actual;
        this.municipio_actual = municipio_actual;
        this.bairro_actual = bairro_actual;
        this.encarregado = encarregado;
        this.endereco = endereco;
        this.generoEncarregado = generoEncarregado;
        this.profissao = profissao;
        this.telefone = telefone;
        this.telefone2 = telefone2;
    }

    public Aluno(String id,String nome, String idade, String genero, String encarregado, String telefone, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.encarregado = encarregado;
        this.endereco = endereco;
        this.telefone = telefone;
        this.id = id;
    }

    public Aluno(String id, String nome, String classe) {
        this.nome = nome;
        this.classe = classe;
        this.id = id;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
    
    

    public Aluno() {
        
    }
     Aluno(String nome) {
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBilhete() {
        return bilhete;
    }

    public void setBilhete(String bilhete) {
        this.bilhete = bilhete;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProvincia_origem() {
        return provincia_origem;
    }

    public void setProvincia_origem(String provincia_origem) {
        this.provincia_origem = provincia_origem;
    }

    public String getMunicipio_origem() {
        return municipio_origem;
    }

    public void setMunicipio_origem(String municipio_origem) {
        this.municipio_origem = municipio_origem;
    }

    public String getBairro_origem() {
        return bairro_origem;
    }

    public void setBairro_origem(String bairro_origem) {
        this.bairro_origem = bairro_origem;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getProvincia_actual() {
        return provincia_actual;
    }

    public void setProvincia_actual(String provincia_actual) {
        this.provincia_actual = provincia_actual;
    }

    public String getMunicipio_actual() {
        return municipio_actual;
    }

    public void setMunicipio_actual(String municipio_actual) {
        this.municipio_actual = municipio_actual;
    }

    public String getBairro_actual() {
        return bairro_actual;
    }

    public void setBairro_actual(String bairro_actual) {
        this.bairro_actual = bairro_actual;
    }

    public String getEncarregado() {
        return encarregado;
    }

    public void setEncarregado(String encarregado) {
        this.encarregado = encarregado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGeneroEncarregado() {
        return generoEncarregado;
    }

    public void setGeneroEncarregado(String generoEncarregado) {
        this.generoEncarregado = generoEncarregado;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
    
}
