/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;
 
import javafx.scene.layout.AnchorPane;
import animatefx.animation.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
/**
 *
 * @author Armando Inácio
 */
public class eventos {
   public void mostrarMenu(Pane fundo,Pane anchorPane){
       fundo.toFront();
       anchorPane.toFront();
       new ZoomIn(anchorPane).play();            
       }
   public void mostrarTela(AnchorPane fundo,Pane anchorPane){
       fundo.toFront();
       anchorPane.toFront();
       new ZoomIn(anchorPane).play();            
       }
   public void mostrarPaineis(Pane anchorPane){
       anchorPane.toFront();
       
   }
   
   public void esconderMenu(Pane fundo){
       fundo.toFront();
            
       }
   public void esconderTela(AnchorPane fundo,Pane anchorPane){
       fundo.toBack();
       anchorPane.toBack();
       new ZoomOut(anchorPane).play(); 
            
       }
   public void mandarModoAtras(AnchorPane tela){
       
   }
   public void mandarModoFrente(AnchorPane tela){
       
   }
  
}