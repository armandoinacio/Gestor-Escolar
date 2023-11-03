package ge;
import ge.libs.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import api_javadbc.API_JAVADBC;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class dados {
    ArrayList<String> ListaGeralAlunos=new ArrayList();
    PreparedStatement pst;
    ResultSet rs;
    String banco="escola";
    Connection conexao;
    ArrayList<String> ListaGeralProfessores=new ArrayList<>();
    protected String sql;
    public int totaAlunos;
    public int totalProfessores;
    int totalFemenino;
    int totalMasculino;
    protected Connection Conectar()
    {
        return conexao = api_javadbc.API_JAVADBC.Conectar("escola");
    }
    
        public void executar(String sql) {
        conexao = api_javadbc.API_JAVADBC.Conectar("escola");
        try {
            pst = conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Erro no executar" + ex);
        }
    }
        public int InserirPessoalAdministraca(String nome,String funcao,String senha,String tipoUsuario) throws SQLException{
            sql="insert into administracao values(null,?,?,?,?)";
            executar(sql);
            pst.setString(1,nome);
            pst.setString(2,funcao);
            pst.setString(3,senha);
            pst.setString(4,tipoUsuario);
            return pst.executeUpdate()>0?1:0;
        }

    public int InserirDadosAluno(Aluno aluno) throws SQLException {
        sql = "insert into alunos values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,default,?,?,?)";
        executar(sql);

        pst.setString(1, aluno.getNome());
        pst.setString(2, aluno.getDataNascimento());
        pst.setString(3, aluno.getBilhete());
        pst.setString(4, aluno.getGenero());
        pst.setString(5, aluno.getProvincia_origem());
        pst.setString(6, aluno.getMunicipio_origem());
        pst.setString(7, aluno.getBairro_origem());
        pst.setString(8, aluno.getClasse());
        pst.setString(9, aluno.getMunicipio_actual());
        pst.setString(10, aluno.getBairro_actual());
        pst.setString(11, aluno.getEncarregado());
        pst.setString(12, aluno.getProfissao());
        pst.setString(13, aluno.getTelefone());
        pst.setString(14, aluno.getTelefone2());
        pst.setString(15, aluno.getProvincia_actual());
        pst.setString(16, aluno.getGeneroEncarregado());
        pst.setString(17, aluno.getEndereco());
        int feito = pst.executeUpdate();
        return feito>0?1:0;
    }
    public int cadastrarProfessor(Professor professor)throws SQLException{
        sql="insert into professor values(null,?,?,?,?,?,?,default)";
        executar(sql);
        pst.setString(1,professor.getNome());
        pst.setString(2,professor.getDocumento());
        pst.setString(3,professor.getNascimento());
        pst.setString(4,professor.getGenero());
        pst.setString(5,professor.getCertificado());
        pst.setString(6,professor.getTelefone());
        int feito=pst.executeUpdate();
        return feito>0?1:0;
    }
    public int novaTurma(turma nome) throws SQLException{
          String anoLectivoLimpo=new Operador().limparAnoLectivo(nome.getAnoLectivo());
        sql="insert into turma values(null,?,?,?,?,?)";
        executar(sql);
        pst.setString(1,nome.getNome());
        pst.setString(2,(nome.getClasse()));
        pst.setString(3,(nome.getSala()));
        pst.setString(4,nome.getPeriodo());
        pst.setString(5,anoLectivoLimpo);
        int feito=pst.executeUpdate();
        return feito>0?1:0;
    }
    public int deleteTurma(int id)throws SQLException{
        sql="delete";
        return 0;
    }
    int calcular_idade(int ano) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(new Date(System.currentTimeMillis()));
        int anoActual = Integer.parseInt(data.substring(6, 10));

        int idade = anoActual - ano;
        return idade;
    }
    public void bsucarAlunoGeral(TableView tabela, TableColumn id, TableColumn nome, TableColumn idade, TableColumn genero, TableColumn encarregado, TableColumn telefone, TableColumn endereco) throws SQLException {
        Aluno aluno;
        ObservableList<Aluno> listaAluno = FXCollections.observableArrayList();
        sql = "select id,nome,nascimento,genero,encarregado,telefone,enderecoEncarregado from alunos order by nome";
        executar(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            String []TudoDadata=rs.getString(3).split("-");
            String idadeCalculada=Integer.toString(calcular_idade(Integer.parseInt(TudoDadata[0])));
            listaAluno.add(aluno = new Aluno(rs.getString(1), rs.getString(2), idadeCalculada, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        MostrarTBAlunos(listaAluno, tabela, id, nome, idade, genero, encarregado, telefone, endereco);
    }
    public void bsucarProfessorGeral(TableView tabela, TableColumn nome, TableColumn idade, TableColumn genero, TableColumn bilhete, TableColumn certificado , TableColumn telefone) throws SQLException {
        Professor professor;
        ObservableList<Professor> listaAluno = FXCollections.observableArrayList();
        sql = "select nome,documento,nascimento,genero,certificado,telefone from professor order by nome";
        executar(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            String []TudoDadata=rs.getString(3).split("-");
            String idadeCalculada=Integer.toString(calcular_idade(Integer.parseInt(TudoDadata[0])));
            listaAluno.add(professor = new Professor(rs.getString(1), rs.getString(2), idadeCalculada, rs.getString(4), rs.getString(5), rs.getString(6)));
        }
        MostrarTBProfessor(listaAluno, tabela, nome, idade, genero, bilhete, certificado, telefone);
    }


    private void MostrarTBAlunos(ObservableList<Aluno> lista, TableView tabela, TableColumn id, TableColumn nome, TableColumn idade, TableColumn genero, TableColumn encarregado, TableColumn telefone, TableColumn endereco) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        encarregado.setCellValueFactory(new PropertyValueFactory<>("encarregado"));
        telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tabela.setItems(lista);

    }
    
    private void MostrarTBAlunosAdiconarIndividual(ObservableList<Aluno> lista, TableView tabela, TableColumn id, TableColumn nome, TableColumn classe) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        classe.setCellValueFactory(new PropertyValueFactory<>("classe"));
        tabela.setItems(lista);

    }
    
     private void MostrarTBProfessor(ObservableList<Professor> lista, TableView tabela, TableColumn nome, TableColumn bilhete,TableColumn idade, TableColumn genero,  TableColumn certificado, TableColumn telefone) {
      
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        idade.setCellValueFactory(new PropertyValueFactory<>("nascimento"));
        genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        bilhete.setCellValueFactory(new PropertyValueFactory<>("documento"));
        certificado.setCellValueFactory(new PropertyValueFactory<>("certificado"));
        telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tabela.setItems(lista);

    }
    private void mostrarTurmas(ObservableList<turma> turmas, TableView tabela,TableColumn nome,TableColumn classe,TableColumn sala,TableColumn periodo){
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        classe.setCellValueFactory(new PropertyValueFactory<>("classe"));
        sala.setCellValueFactory(new PropertyValueFactory<>("sala"));
        periodo.setCellValueFactory(new PropertyValueFactory<>("periodo"));
        tabela.setItems(turmas);
    }
    public ArrayList<String> AlunosGeral(){
        ListaGeralAlunos.clear();
        sql="select * from alunos";
        executar(sql);
        try {
            rs=pst.executeQuery();
            while(rs.next())                      
                // 0, 1   ,    2        ,  3    , 4    ,       5        ,        6        ,     7      ,  8   ,        9       ,       10       ,      11     ,      12    ,    13    ,   14 ,  15     ,  16  ,       17      ,     18
                //id,nome,dataNascimento,bilhete,genero,provincia_origem,municipio_origem,bairro_origem,classe,provincia_actual,municipio_actual,bairro_actual,encarregado,profissao,telefone,telefone2,tempo,generoEncarregado,endereco;
                ListaGeralAlunos.add(rs.getString(1)+";"+rs.getString(2)+";"+rs.getString(3)+";"+rs.getString(4)+";"+rs.getString(5)+";"+rs.getString(6)+";"+rs.getString(7)+";"+rs.getString(8)+";"+rs.getString(9)+";"+rs.getString(10)+";"+rs.getString(11)+";"+rs.getString(12)+";"+rs.getString(13)+";"+rs.getString(14)+";"+rs.getString(15)+";"+rs.getString(16)+";"+rs.getString(17)+";"+rs.getString(18)+";"+rs.getString(19));            
        } catch (SQLException e) {
            System.out.println("erro nos dados gerais" +e);
        }
        System.out.println(ListaGeralAlunos.size());
        return ListaGeralAlunos;
    }
    public ArrayList<String> ProfessoresGeral(){
        ListaGeralProfessores.clear();
        sql="select * from professor";
        executar(sql);
        try {
            rs=pst.executeQuery();
            while(rs.next())                      
                // 0, 1   ,    2        ,  3    , 4    ,       5        ,        6        ,     7      ,  8   ,        9       ,       10       ,      11     ,      12    ,    13    ,   14 ,  15     ,  16  ,       17      ,     18
                //id,nome,dataNascimento,bilhete,genero,provincia_origem,municipio_origem,bairro_origem,classe,provincia_actual,municipio_actual,bairro_actual,encarregado,profissao,telefone,telefone2,tempo,generoEncarregado,endereco;
                ListaGeralProfessores.add(rs.getString(2)+";"+rs.getString(3)+";"+rs.getString(4)+";"+rs.getString(5)+";"+rs.getString(6)+";"+rs.getString(7));            
        } catch (SQLException e) {
            System.out.println("erro nos dados gerais dos professores" +e);
        }
  
        return ListaGeralProfessores;
    }
    void buscarTotal(){
        sql="select count(id) from alunos";
        executar(sql);
        try {
            rs=pst.executeQuery();
            if(rs.next())
            totaAlunos=Integer.parseInt(rs.getString(1));
        } catch (Exception e) {
        }
    }
     void totalProfessores(){
        sql="select count(id) from professor";
        executar(sql);
        try {
            rs=pst.executeQuery();
            if(rs.next())
            totalProfessores=Integer.parseInt(rs.getString(1));
        } catch (Exception e) {
        }
    }
    int buscarTotalHomem(){
        sql="select count(id) from alunos where genero=?";
        executar(sql);
        try {
            pst.setString(1,"Masculino");
            rs=pst.executeQuery();
            if(rs.next()){
                totalMasculino=Integer.parseInt(rs.getString(1));
            }
            
        } catch (Exception e) {
        }
        return totalMasculino;
    }
    int buscarTotalMulher(){
      sql="select count(id) from alunos where genero=?";
        executar(sql);
        try {
            pst.setString(1,"Femenino");
            rs=pst.executeQuery();
            if(rs.next())
            totalFemenino=Integer.parseInt(rs.getString(1));
        } catch (Exception e) {
        }
        return totalFemenino;
    }
    ArrayList<Integer> percentgemAlunos(){
        ArrayList<Integer>numeros=new ArrayList<>();
        buscarTotalHomem();
        buscarTotalMulher();
        String generos[] = null;
        String homem=null;
        String mulher=null;
        System.out.println(totaAlunos);
        System.out.println(totalFemenino);
        System.out.println(totalMasculino);
        numeros.add((totalMasculino));
        numeros.add(totalFemenino);
        return numeros;
    }
    int altualizar(int id,String nome,String documento,String provincia_Origem,String municipio_Origem,String bairro_Origem,String classe,String provincia_Actual,String municipio_Actual,String bairro_Actual,String encarregado,String endereco,String profissao,String telefone,String telefone2,String genero) throws SQLException{
        int control = 0;
        sql="update alunos set nome=?,documento=?,provincia_origem=?,municipio_origem=?,bairro=?,classe=?,provincia_actual=?,municipio_actual=?,bairro_actual=?,encarregado=?,enderecoEncarregado=?,profissao=?,telefone=?,telefone_alternativo=?,genero=? where id=?";
        executar(sql);
      
            pst.setString(1, nome);
            pst.setString(2,documento);
            pst.setString(3, provincia_Origem);
            pst.setString(4,municipio_Origem);
            pst.setString(5,bairro_Origem);
            pst.setString(6,classe);
            pst.setString(7,provincia_Actual);
            pst.setString(8,municipio_Actual);
            pst.setString(9,bairro_Actual);
            pst.setString(10,encarregado);
            pst.setString(11,endereco);
            pst.setString(12,profissao);
            pst.setString(13, telefone);
            pst.setString(14,telefone2);
            pst.setString(15,genero);
            pst.setString(16,Integer.toString(id));
            int updated=pst.executeUpdate();
            if(updated>0){
                control= 1;
            }else{
                control=0;
            }
       
        return control>0?1:0;
    }
    public  void  Filtrar(String filtro,String valor,TableView tabela, TableColumn id, TableColumn nome, TableColumn idade, TableColumn genero, TableColumn encarregado, TableColumn telefone, TableColumn endereco) throws SQLException{
     Aluno aluno;
        ObservableList<Aluno> listaAluno = FXCollections.observableArrayList();
        sql = "select id,nome,nascimento,genero,encarregado,telefone,enderecoEncarregado from alunos where "+filtro+"="+valor;
        executar(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            String []TudoDadata=rs.getString(3).split("-");
            String idadeCalculada=Integer.toString(calcular_idade(Integer.parseInt(TudoDadata[0])));
            listaAluno.add(aluno = new Aluno(rs.getString(1), rs.getString(2), idadeCalculada, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        MostrarTBAlunos(listaAluno, tabela, id, nome, idade, genero, encarregado, telefone, endereco);
     
} 
    public  void  FiltrarAlunosIndividualAcionar(String filtro,String valor,TableView tabela, TableColumn id, TableColumn nome, TableColumn classe) throws SQLException{
     Aluno aluno;
        ObservableList<Aluno> listaAluno = FXCollections.observableArrayList();
        sql = "select id,nome,classe from alunos where "+filtro+"="+valor;
        executar(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            listaAluno.add(aluno = new Aluno(rs.getString(1), rs.getString(2), rs.getString(3)));
        }
        MostrarTBAlunosAdiconarIndividual(listaAluno, tabela, id, nome, classe);
     
} 

    int altualizarProfessor(String bilheteID,String nome, String bilhete, String genero, String certificado, String telefone)throws SQLException{
      sql="update professor set nome=?,documento=?,genero=?,certificado=?,telefone=? where documento=?";
        executar(sql);
      
          pst.setString(1,nome);
          pst.setString(2,bilhete);
          pst.setString(3,genero);
          pst.setString(4,certificado);
          pst.setString(5,telefone);
          pst.setString(6,bilheteID);
          int feito=pst.executeUpdate();
          if(feito>0){
              return 1;
          }
        
        return 0;
    }
    
    
    //Buscar a turma
   public void tabelaTurmas(String anoLectivo, TableView tabela,TableColumn nome,TableColumn classe,TableColumn sala,TableColumn periodo) throws SQLException
   {
       String anoLectivoLimpo=new Operador().limparAnoLectivo(anoLectivo);
       ObservableList<turma> turmas = FXCollections.observableArrayList();
        sql = "select nome,classe,sala,periodo from turma where anoLectivo="+anoLectivoLimpo;
        executar(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
              turmas.add(new turma(rs.getString(1), rs.getString(2),rs.getString(2), rs.getString(4)));
        }
        mostrarTurmas(turmas, tabela, nome,classe, sala, periodo);
   }
    
     public String qtdTurmas(){
        String qtd=null;
         sql="select count(id) from turma";
         executar(sql);
         try {
             rs=pst.executeQuery();
             if(rs.next())
             qtd=rs.getString(1);
         } catch (Exception e) {
             System.out.println("erro qtdTurmas "+e);
         }
         return qtd;
     } 
     
     void criarTurmaLectivo(String turma)throws SQLException{
         sql="create table "+turma+" ("
                 + "id int not null primary key,"
                 + "nome varchar(60) not null,"
                 + "classe varchar(20) not null)";
         executar(sql);
         pst.execute();
     }
      void criarPessoal()throws SQLException{
         sql="create table administracao ("
                 + "id int not null primary key auto_increment,"
                 + "nome varchar(60) not null,"
                 + "funcao varchar(20) not null,"
                 + "senha varchar(30) not null,"
                 + "tipo varchar(20) not null )";
         executar(sql);
         pst.execute();
     }
       void criarTabelaGeralTurmas()throws SQLException{
         sql="  create table turma(\n" +
" id int not null primary key auto_increment,\n" +
" nome       varchar(50) not null,\n" +
" classe     varchar(20) not null,\n" +
" sala       varchar(30) not null,\n" +
" periodo    varchar(20) not null,\n" +
" anoLectivo varchar(20) not null\n" +
");";
         executar(sql);
         pst.execute();
     }
   
     int receberDadosAluno(String turma,String anoLectivo,String numero,String nome,String classe)throws SQLException{
        if(adicionarAlunosNaTurma(turma)==0){
            criarTurmaLectivo(turma);
        }
        else if(verificarAlunoTurma(Integer.parseInt(numero),listaTurmas(anoLectivo))==0 && turmaCerta(turma)==Integer.parseInt(classe)){
         sql="insert into "+turma+" values(?,?,?)";
         executar(sql);
         pst.setString(1, numero);
         pst.setString(2,nome);
         pst.setString(3,classe);
         int feito=pst.executeUpdate();
         if(feito>0){
             System.out.println("Aluno Adiciona na turma:: "+ turma);
         }
          return 1;
        }
      return 0;
     }
     int adicionarAlunosNaTurma(String turma) throws SQLException{
         sql="show tables like ?";
         executar(sql);
         pst.setString(1,turma);
         rs=pst.executeQuery();
         return rs.next()?1:0;
         
     }
     ArrayList<turma> listaTurmas(String anoLectivo)throws SQLException{
        ArrayList<turma>lista=new ArrayList();
        sql="select nome,anoLectivo from turma where anoLectivo="+anoLectivo;
        executar(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            lista.add(new turma(rs.getString(1)+rs.getString(2)));
         }
        return lista;
     }
     int verificarAlunoTurma(int id,ArrayList<turma>lista)throws SQLException{
         int estado = 0;
         for (turma t : lista) {
             sql = "select nome from " + t.getNome() + " where id=" + id;
             executar(sql);
             rs = pst.executeQuery();
             if (rs.next()) {
                 System.out.println("encontrado o aluno "+id +" Na turma "+t.getNome());
                 estado = 1;
             }
         }
         return estado;
     }
    int turmaCerta(String nomeTurma)throws SQLException{
       String letras="";
       
       int classe = 0;
       //Inverter Para pegar  a turma
       for(int i=0;i<nomeTurma.length();i++){
           if(!(new Operador().isNumero(Character.toString(nomeTurma.charAt(i))))){
               letras+=""+nomeTurma.charAt(i);
               System.out.println(letras) ;  
           }
       }
      String resutado[]=nomeTurma.split(letras);
      String turma=resutado[0]+letras;
     
        System.out.println("-> "+turma);
        sql="select classe from turma where nome=?";
        executar(sql);
        pst.setString(1,turma);
        rs=pst.executeQuery();
        if(rs.next()){
            classe=Integer.parseInt(rs.getString(1));
        }
     return classe;   
    }
   turma buscarDadosTurma(String turma,String anoLectivo){
       turma t = null;
        ArrayList<turma>lista=new ArrayList();
        sql="select sala,classe,periodo from turma where nome=? and anoLectivo=?";
        executar(sql);
        try {
            pst.setString(1,turma);
            pst.setString(2,anoLectivo);
            rs=pst.executeQuery();
            if(rs.next()){
               t=new turma(rs.getString(1),rs.getString(2),rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("erro ao buscarTurmas");
        }
        return t;
    }
   public int inserirTabelaDePrecoMensalidade(TabelaPrecos tabelaPreco)throws SQLException{
       ArrayList<String> dado=new ArrayList();
       dado.add(tabelaPreco.getDescricao());
       dado.add(tabelaPreco.getPreco());
      // if(verificarTabelaPreco(tabelaPreco.getDescricao())){
           // sql="update TabelaDePreco set preco=? where classe=?";
           // return new operacaoSQL().alterar(dado, sql, banco);
        //}else{
            sql="insert into TabelaDePreco values(?,?)";
            return new operacaoSQL().inserir(dado, sql,banco);
       //}    
       
   }
    public int inserirTabelaDePrecoDiversos(TabelaPrecos tabelaPreco)throws SQLException{        
       ArrayList<String> dado=new ArrayList();
       dado.add(tabelaPreco.getDescricao());
       dado.add(tabelaPreco.getPreco());
       //if(verificarTabelaDiversos(tabelaPreco.getDescricao())){
          //  sql="update TabelaDiversos set preco=? where classe=?";
          //  return new operacaoSQL().alterar(dado, sql, banco);
        //}else{
            sql="insert into TabelaDiversos values(?,?)";
            return new operacaoSQL().inserir(dado, sql,banco);
      // }       
   }
    public boolean verificarTabelaPreco(String classe)throws SQLException{
      ObservableList<ResultSet>res=FXCollections.observableArrayList();
       sql="insert classe from tabelaDePrecos where classe=?";
       res= new operacaoSQL().SelecaoComWhere(sql, classe, banco);
       return (rs.next());
    }
    public boolean verificarTabelaDiversos(String classe)throws SQLException{
        ObservableList<ResultSet>res=FXCollections.observableArrayList();
       sql="insert descricao from TabelaDiversos  where descricao=?";
       res= new operacaoSQL().SelecaoComWhere(sql, classe, banco);
       return (rs.next());
    }

    void buscarTabelaPrecoMenslidade(TableView tbl_TabelaPrecos, TableColumn col_classeTabelaPrecos, TableColumn col_mensalidadeTabelaPreco)throws SQLException{
         ObservableList<TabelaPrecos> listaDePrecos=FXCollections.observableArrayList();
         ObservableList<ResultSet>res=FXCollections.observableArrayList();
         sql="select * from TabelaDePreco";
         executar(sql);
         rs=pst.executeQuery();
         while(rs.next()){
             listaDePrecos.add(new TabelaPrecos(rs.getString(1),new operacaoBasica().formatar(Integer.parseInt(rs.getString(2)))));
         }
           mostrarDadosTabelaPrecosMensalidade(listaDePrecos, tbl_TabelaPrecos, col_classeTabelaPrecos, col_mensalidadeTabelaPreco);
                 }
    void mostrarDadosTabelaPrecosMensalidade(ObservableList<TabelaPrecos>lista, TableView tbl_TabelaPrecos, TableColumn classeTabelaPrecos, TableColumn mensalidadeTabelaPreco) {
         classeTabelaPrecos.setCellValueFactory(new PropertyValueFactory<>("descricao"));
         mensalidadeTabelaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tbl_TabelaPrecos.setItems(lista);
    }
    void buscarTabelaPrecoDiversos(TableView tbl_TabelaPrecos, TableColumn col_classeTabelaPrecos, TableColumn col_mensalidadeTabelaPreco)throws SQLException{
         ObservableList<TabelaPrecos> listaDePrecos=FXCollections.observableArrayList();
         ObservableList<ResultSet>res=FXCollections.observableArrayList();
         sql="select * from TabelaDiversos";
         executar(sql);
         rs=pst.executeQuery();
         while(rs.next()){
             listaDePrecos.add(new TabelaPrecos(rs.getString(1),new operacaoBasica().formatar(Integer.parseInt(rs.getString(2)))));
         }
           mostrarDadosTabelaPrecosMensalidade(listaDePrecos, tbl_TabelaPrecos, col_classeTabelaPrecos, col_mensalidadeTabelaPreco);
                 }
    void mostrarDadosTabelaPrecosDiversos(ObservableList<TabelaPrecos>lista, TableView tbl_TabelaPrecos, TableColumn classeTabelaPrecos, TableColumn mensalidadeTabelaPreco) {
         classeTabelaPrecos.setCellValueFactory(new PropertyValueFactory<>("descricao"));
         mensalidadeTabelaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tbl_TabelaPrecos.setItems(lista);
    }
    int criarNovoAnoLectivo(String anoLectivo)throws SQLException{    
        criarNovoAnoLectivoPagamentosDiversos(anoLectivo);
          sql="create table LV"+  new Operador().limparAnoLectivo(anoLectivo)+" ("
                 + "id int not null primary key auto_increment,"
                  + "idAluno int not null,"
                  + "preco int not null,"
                  + "mes int not null,"
                  + "tempo timestamp default current_timestamp)";                 
         executar(sql);
         return pst.execute()?1:0;             
    }
  int criarNovoAnoLectivoPagamentosDiversos(String anoLectivo)throws SQLException{      
          sql="create table pg"+  new Operador().limparAnoLectivo(anoLectivo)+" ("
                 + "id int not null primary key auto_increment,"
                  + "idAluno int not null,"
                  + "descricao varchar(40) not null,"
                  + "preco int not null,"
                  + "qtd int not null,"
                  + "total int not null,"              
                  + "tempo timestamp default current_timestamp)";                 
         executar(sql);
         return pst.execute()?1:0;             
    }        
    int inserirAnoLectivoNoBanco(String anoLectivo)throws SQLException{     
            sql="insert into anoLectivo values(?)";
            executar(sql);
            pst.setString(1,anoLectivo);
            int feito=pst.executeUpdate();
            return feito;
   }
    ArrayList<String> buscarAnoLectivo()throws SQLException{
         ArrayList<String> lista=new ArrayList();
        sql="select * from anoLectivo";
        executar(sql);
        rs=pst.executeQuery();
        while(rs.next()){
            lista.add(rs.getString(1));
        }
        return lista;
    }

    void buscarInformacoAluno(String id,Label nome,Label classe)throws SQLException{
        sql="select nome ,classe from alunos where id=?";
        executar(sql);
        pst.setString(1,id);
        rs=pst.executeQuery();
        if(rs.next()){
            nome.setText(rs.getString(1));
            classe.setText(rs.getString(2));
        }
        
    }
     void buscarInformacoAlunoMensalidade(String idAluno,Label mes,Label classe,String anoLectivo)throws SQLException{
        sql="select max(mes) from lv"+new Operador().limparAnoLectivo(anoLectivo)+" where idAluno=?";
        executar(sql);
        pst.setString(1,idAluno);
        rs=pst.executeQuery();
        if(rs.next()){
            mes.setText(new operacaoBasica().controlo_do_mes(Integer.parseInt(rs.getString(1))));
         
        }
        
    }
  
      //pegar o nome e enviar para a funcao de cima para depois enviar os dados para uma tabela de diuvudsdas e mostra todos os alunbos que forma selecinados
      
    String buscarTabelaDePrecoMensalidade(String classe) throws SQLException{
       String valor="";
                
        sql="select preco from TabelaDePreco where classe=?";
     
        executar(sql);
        pst.setString(1,classe);
        rs=pst.executeQuery();
        if(rs.next()){
           valor=(rs.getString(1));
            System.out.println("preco: "+rs.getString(1));
        }
        return valor;
    }

    int EfetuarPagamento(String idAluno, String preco,String mes, String anoLectivo) throws SQLException{
     sql ="insert into LV"+new Operador().limparAnoLectivo(anoLectivo)+" values(null,?,?,?,default)";
        executar(sql);
      pst.setString(1,idAluno);
      pst.setString(2,(preco));
      pst.setString(3,new operacaoBasica().NumeroDoMes(mes));
      return pst.executeUpdate()>0?1:0;
      
    }
     ArrayList<String> buscarDadosTabelaDiversos()throws SQLException{
         ArrayList<String> precos=new ArrayList();
         sql="select descricao from tabelaDiversos";
        executar(sql);
        rs=pst.executeQuery();
        while(rs.next()){
           precos.add(rs.getString(1)); 
        }
        return precos;
     }
    String buscarPrecoDiversos(String descricao)throws SQLException{
        sql="select preco from tabelaDiversos where descricao=?";
        executar(sql);
        pst.setString(1,descricao);
        rs=pst.executeQuery();
        return rs.next()?rs.getString(1):"";
        
    }

    int efetuarPagamentoDiverso(String idAluno, String descricao,String qtd, String preco, String anoLectivo)throws SQLException{
       sql ="insert into pg"+new Operador().limparAnoLectivo(anoLectivo)+" values(null,?,?,?,?,?,default)";
       int ValorTotal=Integer.parseInt(qtd)*Integer.parseInt(preco);
        executar(sql);
      pst.setString(1,idAluno);
      pst.setString(2,descricao);
      pst.setString(3,preco);
      pst.setString(4,qtd);
      pst.setString(5,Integer.toString(ValorTotal));
      return pst.executeUpdate()>0?1:0;
      
    }
}
