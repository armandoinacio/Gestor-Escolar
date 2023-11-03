/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

import ge.libs.operacaoBasica;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Armando Inácio
 */
public class buscas extends dados{
     ArrayList<String> alunos=new ArrayList();
        
    void buscarTabelaPrecoMenslidade(String anoLectivo ,TableView tbl, TableColumn col_id, TableColumn col_nome,TableColumn col_mes)throws SQLException{
         ObservableList<divida> lista=FXCollections.observableArrayList();      
         sql="select * from lv"+new Operador().limparAnoLectivo(anoLectivo);
         executar(sql);
         rs=pst.executeQuery();
         while(rs.next()){
           //  String nome=nomeAluno();
             lista.add(new divida(rs.getString(2),rs.getString(2),new operacaoBasica().controlo_do_mes(Integer.parseInt(rs.getString(4)))));
         }
           mostrarDadosTabelaPrecosMensalidade(lista, tbl, col_id, col_nome,col_mes);
                 }
    void buscarTabelaPrecoMenslidade(String id,String anoLectivo ,TableView tbl, TableColumn col_id, TableColumn col_nome,TableColumn col_mes)throws SQLException{
         ObservableList<divida> lista=FXCollections.observableArrayList();      
         sql="select * from lv"+new Operador().limparAnoLectivo(anoLectivo)+" where idAluno=?";
         executar(sql);
         pst.setString(1,id);
         rs=pst.executeQuery();
         while(rs.next()){
             lista.add(new divida(rs.getString(2),nomeAluno(rs.getString(2)),new operacaoBasica().controlo_do_mes(Integer.parseInt(rs.getString(4)))));
         }
           mostrarDadosTabelaPrecosMensalidade(lista, tbl, col_id, col_nome,col_mes);
                 }
    void mostrarDadosTabelaPrecosMensalidade(ObservableList<divida>lista, TableView tbl, TableColumn id, TableColumn nome,TableColumn mes ) {
         id.setCellValueFactory(new PropertyValueFactory<>("id"));
         nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
         mes.setCellValueFactory(new PropertyValueFactory<>("ultimoMes"));
         tbl.setItems(lista);
    }
    String nomeAluno(String id){
        String nome="";
       
        for (int i = 0; i < alunos.size(); i++) {
            String v[]=alunos.get(i).split(";");
            if(v[0].equals(id)){
                nome=v[1];
            }
        }
        return nome;
    }
   public String qutdAlunos() throws SQLException{
       sql="select count(id) from alunos";
       executar(sql);
       rs=pst.executeQuery();
       return rs.next()?rs.getString(1):"";
    }
    public String qutdProfessores() throws SQLException{
       sql="select count(id) from professor";
       executar(sql);
       rs=pst.executeQuery();
       return rs.next()?rs.getString(1):"";
    }
      public String qturmas(String anoLectivo) throws SQLException{
       sql="select count(id) from turma where anoLectivo=?";
       executar(sql);
       pst.setString(1,new Operador().limparAnoLectivo(anoLectivo));
       rs=pst.executeQuery();
       return rs.next()?rs.getString(1):"";
    }
    public int verificarLogin(String palavraPasse) throws SQLException{
      
      String tipo="";
      sql="select * from administracao where senha=?";
        executar(sql);
        pst.setString(1,palavraPasse);
        rs=pst.executeQuery();
        if(rs.next()){
           tipo=rs.getString(5); 
      
        }
             if("secretário".equals(tipo.toLowerCase())){
            return 1;
        }
             else {if("administrador".equals(tipo.toLowerCase())) {
            return 2;
        }
             else{
                 return 0;
             }
                
    }}}

