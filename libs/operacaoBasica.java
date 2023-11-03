package ge.libs;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class operacaoBasica extends operacaoSQL {
    int numeroDaSemana;
    public int DataActual(String tipo) {
        int dia, mes, ano;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(new Date(System.currentTimeMillis()));
        if (tipo.equalsIgnoreCase("dia")) {
            return dia = Integer.parseInt(data.substring(0, 2));
        }
             else if (tipo.equalsIgnoreCase("mes")) {
                        return mes = Integer.parseInt(data.substring(3, 5));
             }
             else if (tipo.equalsIgnoreCase("ano")) {
                       return ano = Integer.parseInt(data.substring(6, 10));
                }
        return 0;
    }
    public String SaberOgrupoDoDiaDaSemana(){

        Date data= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int week=cal.get(Calendar.DAY_OF_WEEK);
        int dia=0;//data.getDate();
        String diaDasemana="";

        if(dia<=7){
            numeroDaSemana=1;
            return DiasDaSemana(week)+"1";
        }else{
            if(dia>7 && dia<=14){
                numeroDaSemana=2;
                return DiasDaSemana(week)+"2";
            }else{
                if(dia>14 && dia<=21){
                    numeroDaSemana=3;
                    return DiasDaSemana(week)+"3";
                }else{
                    if(dia>21 && dia<=28){
                        numeroDaSemana=4;
                        return DiasDaSemana(week)+"4";
                    }else{
                        numeroDaSemana=5;
                        return DiasDaSemana(week)+"5";
                    }
                }
            }
        }


    }
    public String DiasDaSemana(int numero){
        String dia="";
        switch(numero){
            case 1: dia="Domingo";break;
            case 2: dia="Segunda-Feira";break;
            case 3: dia="Terça-Feira";break;
            case 4: dia="Quarta-Feira";break;
            case 5: dia="Quinta-Feira"; break;
            case 6: dia="Sexta-Feira";break;
            case 7: dia="Sabado";break;
        }
        return dia;
    }
    public String controlo_do_mes(int mes){
        String resultado="";
        switch(mes){
            case 1: resultado="Janeiro"; break;
            case 2: resultado="Fevereiro"; break;
            case 3: resultado="Março"; break;
            case 4: resultado="Abril"; break;
            case 5: resultado="Maio"; break;
            case 6: resultado="Junho"; break;
            case 7: resultado="Julho"; break;
            case 8: resultado="Agosto"; break;
            case 9: resultado="Setembro"; break;
            case 10: resultado="Outubro"; break;
            case 11: resultado="Novembro"; break;
            case 12: resultado="Dezembro"; break;

        }
        return resultado;
    }
      public String NumeroDoMes(String mes){
        String resultado="";
        switch(mes){
            case "Janeiro": resultado="1"; break;
            case "Fevereiro":resultado="2"; break;
            case "Março": resultado="3"; break;
            case "Abril":resultado="4"; break;
            case "Maio":resultado="5"; break;
            case "Junho":resultado="6"; break;
            case "Julho":resultado="7"; break;
            case "Agosto":resultado="8"; break;
            case "Setembro":resultado="9"; break;
            case "Outubro": resultado="10"; break;
            case "Novembro": resultado="11"; break;
            case "Dezembro": resultado="12"; break;

        }
        return resultado;
    }
    String removerCaraterDoEndereco(String endereco){
        String dados[]=endereco.split("\\\\");
        String novoEndereco ="file:";
        for (int i =1; i < dados.length; i++) {
            novoEndereco+="\\"+dados[i];
            //System.out.println(novoEndereco);
        }

        return novoEndereco;
    }

 public String formatar(int valor) {
        NumberFormat t = NumberFormat.getCurrencyInstance();
        String convertido = (t.format(valor) + "").replace("R$", "AO");
        return convertido;
    }

}
