package ge.libs;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class operacaoSQL extends conexao {
    int posicao=1;

        public int inserir(ArrayList<String> valores,String sql,String banco) throws SQLException {
            executar(sql,banco);
            for (String string:valores)
            {
              pst.setString(posicao,string);
              posicao++;
            }
            int feito=pst.executeUpdate();
            return feito>0?1:0;
        }
        public int alterar(ArrayList<String> valores,String sql,String banco) throws SQLException {
            executar(sql,banco);
            for (String string:valores)
            {
                pst.setString(posicao,string);
                posicao++;
            }
           int feito=pst.executeUpdate();
            return feito>0?1:0;
        }
        public int apagar(String sql,String chave,String banco) throws SQLException {
            executar(sql,banco);
            pst.setString(1,chave);
            return pst.executeUpdate()>0?1:0;
        }
        public  ObservableList<ResultSet> SelecaoSemWhere(String sql, String banco) throws SQLException {
            ObservableList<ResultSet> rs=FXCollections.observableArrayList();
            executar(sql,banco);
            this.rs= pst.executeQuery();
            while(this.rs.next()){
                rs.add(this.rs);
            }
            return rs;
        }
    public ResultSet SelecaoComWhereUmElemento(String sql,String chave, String banco) throws SQLException {
        executar(sql,banco);
        pst.setString(1,chave);
        rs= pst.executeQuery();
        rs.next();
        return rs;
    }
    public ObservableList<ResultSet> SelecaoComWhere(String sql,String chave, String banco) throws SQLException {
        ObservableList<ResultSet> rs=FXCollections.observableArrayList();
        executar(sql,banco);
        pst.setString(1,chave);
        this.rs= pst.executeQuery();
        while(this.rs.next()){
            rs.add(this.rs);
        }
        return rs;
    }
}
