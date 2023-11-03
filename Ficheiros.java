package ge;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ficheiros {

    public Ficheiros() {
    }

    public void guardarConfiguracoes (String valor){
        try {
            BufferedWriter es=new BufferedWriter(new PrintWriter("C:\\Program Files\\configuracao.txt"));
            es.write(valor);
            es.close();
        }catch(Exception e){
            System.out.println("erro ao guardar Jogador "+e);
        }
    }
    
   public  String lerConfiguracao(){
        String valor="";
        File file=new File("C:\\Program Files\\configuracao.txt");
        try {
            Scanner leitor=new Scanner(file);
            while (leitor.hasNextLine()){
               valor=leitor.nextLine();
              
            }
        } catch (FileNotFoundException e) {
            System.out.println("erro ao ler configuracao "+e);
        }
          return valor;
    }
}
