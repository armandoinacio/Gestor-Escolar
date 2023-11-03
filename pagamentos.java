
package ge;

import java.sql.SQLException;
import java.util.ArrayList;


public class pagamentos {
    ArrayList<TabelaPrecos> tabelaDePrecos=new ArrayList();
     dados dado=new dados();
    public int pagarMensalidade(String idAluno,String classe,String mes,String anoLectivo) throws SQLException{
         String preco=dado.buscarTabelaDePrecoMensalidade(classe+"ª");
         System.out.println("classe: "+classe+" Preco: "+preco);
        return     dado.EfetuarPagamento(idAluno,preco,mes,anoLectivo);       
    }  
   public int pagarDiversos(String idAluno,String descricao,String qtd,String anoLectivo) throws SQLException{
       String preco=dado.buscarPrecoDiversos(descricao);
       return dado.efetuarPagamentoDiverso(idAluno,descricao,qtd,preco,anoLectivo);
   }
}
