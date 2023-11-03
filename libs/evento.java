package ge.libs;

import animatefx.animation.AnimationFX;
import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomInRight;
import animatefx.animation.ZoomOut;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.jws.Oneway;

public class evento extends operacaoBasica  {


    public void mostrarSimples(AnchorPane anchorPane){
        anchorPane.toFront();
        new ZoomIn(anchorPane).play();

    }
    public void mostrarSimplesCapa(AnchorPane anchorPane,AnchorPane capa){
        capa.toFront();
        anchorPane.toFront();
        new ZoomIn(anchorPane).play();
    }
    public void mostrarComTexto(AnchorPane anchorPane,AnchorPane capa,Label label,String texto){
        capa.toFront();
        anchorPane.toFront();
        new ZoomIn(anchorPane).play();
        label.setText(texto);
    }
    public void fecharSimples(AnchorPane anchorPane){
        anchorPane.toBack();
        new ZoomOut(anchorPane).play();
    }
    public void fecharSimplesCapa(AnchorPane anchorPane,AnchorPane capa){
        capa.toBack();
        new ZoomOut(anchorPane).play();
    }
    void Janela(Pane pane,AnchorPane capa,String mensagem,Label label) {
        label.setText(mensagem);
       capa.toFront();
        pane.toFront();
        new ZoomIn(pane).play();

    }





}
