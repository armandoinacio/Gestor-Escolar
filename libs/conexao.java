package ge.libs;

import java.sql.*;

public class conexao {
    PreparedStatement pst=null;
    Connection conexao;
    ResultSet rs=null;
    String banco=null;
    public void executar(String sql,String banco) throws SQLException {
        conexao=Conectar(banco);
             pst=conexao.prepareStatement(sql);
    }

    //conexao banco de dados
    public static Connection Conectar(String Banco) {
        Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String caminho = "jdbc:mysql://localhost:3306/" + Banco + "";
        String usuario = "root";
        String senha = "";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(caminho, usuario, senha);
            System.out.println("feito");
            return conexao;
        } catch (Exception var7) {
            System.out.println(var7 + " Pegou mal");
            return null;
        }
    }
}
