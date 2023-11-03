/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Validacao extends dados{
    
    public boolean verificarExisTurma(String turma) throws SQLException{
       sql="show tables like "+turma;
        executar(sql);
        return (rs=pst.executeQuery()).next();
        
    }
    
}
