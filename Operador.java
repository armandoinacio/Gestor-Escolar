/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

/**
 *
 * @author Armando Inácio
 */
public class Operador {

    public String limparAnoLectivo(String string) {
        String nova = "";
        int i = 0;
        while (i < string.length()) {
            if (isNumero(Character.toString(string.charAt(i)))) {
                nova += "" + string.charAt(i);
            }
            i++;
        }
        return nova;
    }

    boolean isNumero(String numero) {
        return numero.matches("[0-9]*");
    }

    void definirAnoLectivo(String valor) {
        new Ficheiros().guardarConfiguracoes(valor);
    }

    String buscarAnoLectivo() {
        return new Ficheiros().lerConfiguracao();
    }
}
