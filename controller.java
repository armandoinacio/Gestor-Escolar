/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;
import ge.libs.*;
import animatefx.animation.*;
import com.company.conexao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Armando Inácio
 */
public class controller {
    private int indiceAluno;
    private int posicionador = 1;
    private String anoLectivoDefinido="";
     private int posicionadorAlterar = 1;
    private String conroladorDePosicao;
    private String anoLectivoEturmaSelecionado=null;
    private String nomeAlunoSelecionado=null;
    private String numeroAlunoSelecionado=null;
    private String classeAlunoSelecionado=null;
    turma turma;
    int tipoUsusario=0;
    int resultado=0;
    private Label label;
    @FXML
    private AnchorPane pnlMenuEventos;
    @FXML
    private JFXButton btnNovoEventoEntrar;
    @FXML
    private JFXButton btnListaDeEventosEntrar;
    @FXML
    private AnchorPane pnlMenuOutros;
    @FXML
    private JFXButton btnListagemEntrarpnlOutros;
    @FXML
    private JFXButton btnCriarTurmasEntrarpnlOutros;
    @FXML
    private JFXButton btnCartaoOutrosEntrar;
    @FXML
    private JFXButton btnExcluirOutrosEntrar;
    @FXML
    private JFXButton btnNotasrOutrosEntrar;
    @FXML
    private AnchorPane pnlMenuAdministracao;
    @FXML
    private JFXButton btnNovoFuncionarioEntrar;
    @FXML
    private JFXButton btnAlterarProfessorEntrar2;
    @FXML
    private AnchorPane pnlMenuProfessor;
    @FXML
    private JFXButton btnNovoProfessorEntrar;
    @FXML
    private AnchorPane pnlMenuAluno;
    @FXML
    private JFXButton btnNovoAlunoEntrar;
    @FXML
    private JFXButton btnAlterarAlunoEntrar;
    @FXML
    private AnchorPane pnlCadstroEstudante;
    @FXML
    private Pane pnlDadosEncarregado;
    @FXML
    private JFXTextField txtEncarregadopnlDadosEncarregado;
    @FXML
    private JFXComboBox<String> cmbGeneropnlDadosEncarregado;
    @FXML
    private JFXTextField txtEnderecopnlDadosEncarregado;
    @FXML
    private JFXTextField txtProfissaopnlDadosEncarregado;
    @FXML
    private JFXTextField txtTelefonepnlDadosEncarregado;
    @FXML
    private JFXTextField txtTelefoneAlternativopnlDadosEncarregado;
    @FXML
    private Pane pnlDadosAcademicos;
    @FXML
    private JFXTextField txtClassepnlDadosAcademicos;
    @FXML
    private JFXTextField txtProvinciaActualpnlDadosAcademicos;
    @FXML
    private JFXTextField txtMuncipiopnlDadosAcademicos;
    @FXML
    private JFXTextField txtBairroActualpnlDadosAcademicos;
    @FXML
    private Pane pnlDadosPessoas;
    @FXML
    private JFXTextField txtNomeCadastropnlDadosPessoas;
    @FXML
    private JFXComboBox<String> cmbGeneropnlDadosPessoas;
    @FXML
    private JFXTextField txtBIpnlDadosPessoas;
    @FXML
    private JFXTextField txtProvinciaOrigempnlDadosPessoas;
    @FXML
    private JFXDatePicker DataDeNascimentopnlDadosPessoas;
    @FXML
    private JFXTextField txtMunicipioOrigempnlDadosPessoas;
    @FXML
    private JFXTextField txtBairroOrigem;
    @FXML
    private JFXButton btnFecharCadastro;
    @FXML
    private Label lblTotalNumeroEstudantes;
    @FXML
    private JFXButton btnAcaopnlDadosPessoas;
    @FXML
    private JFXButton tbnVoltarNovoEstudante;
    @FXML
    private AnchorPane capa1;
    @FXML
    private JFXButton btnNovoAluno;
    @FXML
    private JFXButton btnProfessores;
    @FXML
    private JFXButton btnAdministracao;
    @FXML
    private JFXButton btnOutros;
    @FXML
    private JFXButton btnEventos;
    @FXML
    private Pane pnlEsconderMenu;
    private eventos evento = new eventos();
    private Aluno aluno;
    private dados dado = new dados();
    @FXML
    private Pane pnlNotificacao;
    @FXML
    private ImageView imagemNotificacao;
    @FXML
    private Pane pnlEsconderBotaoVoltar;
    @FXML
    private ImageView iconeBotacao;
    @FXML
    private Label lblMensagem;
    @FXML
    private AnchorPane pnlListatudante;
    @FXML
    private JFXButton btnAlterarEntrar;
    @FXML
    private TableView<Aluno> tbl_AlunosLista;
    @FXML
    private TableColumn<Aluno,String> col_idAluno;
    @FXML
    private TableColumn<Aluno,String> col_nomeAluno;
    @FXML
    private TableColumn<Aluno,String> col_idadeAluno;
    @FXML
    private TableColumn<Aluno,String> col_sexoAluno;
    @FXML
    private TableColumn<Aluno,String> col_encarregadoAluno;
    @FXML
    private TableColumn<Aluno,String> col_telefoneAluno;
    @FXML
    private TableColumn<Aluno,String> col_enderecoAluno;
    @FXML
    private JFXButton btnFecharCadastro1;
    @FXML
    private Label lblTotalAlunos;
    @FXML
    private ImageView iconeBotacao2;
    @FXML
    private JFXButton tbnVoltarNovoEstudante2;
    @FXML
    private Pane pnlEsconderBotaoVoltar2;
    @FXML
    private JFXTextField txtBuscarAlunos;
    @FXML
    private JFXButton btnFichaTecnicaAluno;
    @FXML
    private JFXComboBox<String> comFiltrarAluno;
    @FXML
    private Label lblPercentagemHomem;
    @FXML
    private Label lblPercentagemMulher;
    @FXML
    private ImageView refrescarTabelaAlunos;
    @FXML
    private AnchorPane pnlAlterarEstudante;
    @FXML
    private Pane pnlDadosEncarregadoAlterar;
    @FXML
    private JFXTextField txtEncarregadopnlDadosEncarregado1;
    @FXML
    private JFXComboBox<?> cmbGeneropnlDadosEncarregado1;
    @FXML
    private JFXTextField txtEnderecopnlDadosEncarregado1;
    @FXML
    private JFXTextField txtProfissaopnlDadosEncarregado1;
    @FXML
    private JFXTextField txtTelefonepnlDadosEncarregado1;
    @FXML
    private JFXTextField txtTelefoneAlternativopnlDadosEncarregado1;
    @FXML
    private Pane pnlDadosAcademicosAlterar;
    @FXML
    private JFXTextField txtClassepnlDadosAcademicos1;
    @FXML
    private JFXTextField txtProvinciaActualpnlDadosAcademicos1;
    @FXML
    private JFXTextField txtMuncipiopnlDadosAcademicos1;
    @FXML
    private JFXTextField txtBairroActualpnlDadosAcademicos1;
    @FXML
    private Pane pnlDadosPessoasAlterar;
    @FXML
    private JFXTextField txtNomeCadastropnlDadosPessoas1;
    @FXML
    private JFXComboBox<String> cmbGeneropnlDadosPessoas1;
    @FXML
    private JFXTextField txtBIpnlDadosPessoas1;
    @FXML
    private JFXTextField txtProvinciaOrigempnlDadosPessoas1;
    @FXML
    private JFXDatePicker DataDeNascimentopnlDadosPessoas1;
    @FXML
    private JFXTextField txtMunicipioOrigempnlDadosPessoas1;
    @FXML
    private JFXTextField txtBairroOrigem1;
    @FXML
    private JFXButton btnFecharAlterarAluno;
    @FXML
    private JFXButton btnAcaopnlAlterar;
    @FXML
    private ImageView iconeBotacao1;
    @FXML
    private Label lblNomePnlAlterar;
    @FXML
    private JFXButton btnVoltarAlterar;
    @FXML
    private Pane pnlEsconderBotaoVoltarAlterar;
    @FXML
    private AnchorPane pnlCadastroProfessor;
    @FXML
    private JFXTextField txtNomeCompletoProfessor;
    @FXML
    private JFXComboBox<String> cmbGeneropnlDadosProfessor;
    @FXML
    private JFXTextField txtBIpnlDadosProfessor;
    @FXML
    private JFXTextField txtCertificadoProfessor;
    @FXML
    private JFXDatePicker DataDeNascimentopnlDadosProfessor;
    @FXML
    private JFXButton btnGuardarProfessor;
    @FXML
    private ImageView iconeBotacao3;
    @FXML
    private JFXTextField txtTelefoneProfessor;
    @FXML
    private JFXButton btnFecharCadastro2;
    @FXML
    private JFXButton btnListaProfessores;
    @FXML
    private AnchorPane pnlListatudante1;
    @FXML
    private JFXButton btnAlterarProfessorEntrar;
    @FXML
    private TableView<Professor> tbl_ProfessorLista;
    @FXML
    private TableColumn<Professor,String> col_nomeProfessor;
    @FXML
    private TableColumn<Professor,String> col_idadeProfessor;
    @FXML
    private TableColumn<Professor,String> col_sexoProfessor;
    @FXML
    private TableColumn<Professor,String> col_documentoProfessor;
    @FXML
    private TableColumn<Professor,String> col_certificadoProfesssor;
    @FXML
    private TableColumn<Professor,String> col_telefoneProfessor;
    @FXML
    private Label lblTotalProfessores;
    @FXML
    private JFXButton btnFecharListaProfessores;
    @FXML
    private AnchorPane pnlAlterarProfessor;
    @FXML
    private JFXTextField txtNomeCompletoProfessor1;
    @FXML
    private JFXComboBox<String> cmbGeneropnlDadosProfessor1;
    @FXML
    private JFXTextField txtBIpnlDadosProfessor1;
    @FXML
    private JFXTextField txtCertificadoProfessor1;
    @FXML
    private JFXDatePicker DataDeNascimentopnlDadosProfessor1;
    @FXML
    private JFXButton btnAlterarProfessor;
    @FXML
    private ImageView iconeBotacao31;
    @FXML
    private JFXTextField txtTelefoneProfessor1;
    @FXML
    private JFXButton btnFecharAlterarProfessor;
    Professor professor;
    private String indiceProfessor;
    @FXML
    private AnchorPane pnlGeralListatudante;
    @FXML
    private JFXTextField txtBuscarAlunosListagemGeral;
    @FXML
    private JFXButton btnVerAlunsDadosPnlListarGeral;
    @FXML
    private Label lblPercentagemHomem1;
    @FXML
    private Label lblPercentagemMulher1;
    @FXML
    private JFXButton btnFecharListaGeral;
    @FXML
    private AnchorPane pnlCrirarTurma;
    @FXML
    private JFXButton btnGuardarTurma;
    @FXML
    private Label lblPercentagemHomem11;
    @FXML
    private JFXButton btnFecharCriarTurma;
    @FXML
    private Label lblNumeroDeTurmas;
    @FXML
    private JFXTextField txtNomeTurma;
    @FXML
    private JFXTextField txtClasseTurma;
    @FXML
    private JFXTextField txtSalaTurma;
    @FXML
    private JFXTextField txtPeriodoTurma;
    @FXML
    private Label lblOrganizarTurmaEntrar;
    @FXML
    private JFXTextField txtAnoLectivo;
    @FXML
    private AnchorPane pnlAdicionarCooletivo;
    @FXML
    private Label lblPercentagemHomem1211;
    @FXML
    private Label lblPercentagemMulher1111;
    @FXML
    private JFXButton btnSairPnlAdicionarColetivo;
    @FXML
    private JFXComboBox<String> cmbSelecionarTurmaAAdicionarColetivo;
    @FXML
    private JFXComboBox<String> cmbClasseAlunosAdicionarColetivo;
    @FXML
    private JFXTextField txtQtdAlunosPnlAdicionarTurmaColetivo;
    @FXML
    private JFXButton btnAdicionarAlunoPnlAdicionarColetivo;
    @FXML
    private Label lblQtdAlunosExistentesAdiconarColetivo;
    @FXML
    private AnchorPane pnlAdicionarIndividual;
    @FXML
    private JFXButton btnAdicionarAlunoPnlAdicionarIndividual;
    @FXML
    private Label lblNomePnlAdicionarIndividual;
    @FXML
    private Label lblClassePnlAdicionarIndividual;
    @FXML
    private JFXTextField txtBuscarAlunoPnlAdicionarTurmaIndividual;
    @FXML
    private Label lblPercentagemHomem121;
    @FXML
    private Label lblPercentagemMulher111;
    @FXML
    private JFXButton btnSairPnlAdicionarIndividual;
    @FXML
    private TableView<Aluno> tbl_ListaAlunosAdicionarIndividual;
    @FXML
    private TableColumn<Aluno,String> col_NumeroAlunoAdiconarIndividual;
    @FXML
    private TableColumn<Aluno,String> col_NomeAlunoAdiconarIndividual;
    @FXML
    private TableColumn<Aluno,String> col_classeAlunoAdiconarIndividual;
    @FXML
    private JFXComboBox<String> cmbFiltrarPorPnlAdicionarAlunoTurma;
    @FXML
    private AnchorPane pnlOrganizarTurma;
    @FXML
    private JFXButton btnOrganizarIndividual;
    @FXML
    private JFXButton btnOrganizarTurmaColetivo;
    @FXML
    private Label lblTurmaAOgranizar;
    @FXML
    private JFXTextField txtBuscarTurmaPnlOrganizar;
    @FXML
    private Label lblPercentagemHomem12;
    @FXML
    private Label lblPercentagemMulher11;
    @FXML
    private JFXButton btnSairPnlOrganizarTurma;
    @FXML
    private TableView<turma> tbl_TurmasCriadas;
    @FXML
    private TableColumn<turma,String> col_turma;
    @FXML
    private TableColumn<turma,String> col_classe;
    @FXML
    private TableColumn<turma,String> col_sala;
    @FXML
    private TableColumn<turma,String> col_periodo;
    @FXML
    private Label lblAnoLectivoOrganizarTurma;
    @FXML
    private JFXTextField txtBuscarAlunosListagemGeral1;
    @FXML
    private AnchorPane moduloFinaceiro;
    @FXML
    private AnchorPane pnlMenuRelatorios;
    @FXML
    private JFXButton btnRecibosRelatorios;
    @FXML
    private JFXButton btnDevedoresRelatorios;
    @FXML
    private JFXButton btnTabelaDePrecosRelatorios;
    @FXML
    private AnchorPane pnlMenuTabelaPrecos;
    @FXML
    private JFXButton btnTabelaDePrecosDiversos;
    @FXML
    private JFXButton btnTabelaPrecosMensalidade;
    @FXML
    private AnchorPane pnlMenuDividas;
    @FXML
    private JFXButton btnDividasProprinasEntrar;
    @FXML
    private JFXButton btnDividasDiversos;
    @FXML
    private AnchorPane pnlMenuPagamento;
    @FXML
    private JFXButton btnPagamentosDiversosEntrar;
    @FXML
    private JFXButton btnMensalidadeEntrar;
    @FXML
    private JFXButton btnGraficos;
    @FXML
    private JFXButton btnRelatórios;
    @FXML
    private JFXButton btnTabelaDePrecos;
    @FXML
    private JFXButton btnDividas;
    @FXML
    private JFXButton btnPagamentos;
    @FXML
    private Circle btnTrocarModuloFinanceiro;
    @FXML
    private ImageView iconeTrocarModuloFinanceiro;
    @FXML
    private AnchorPane pnlMenuGraficos;
    @FXML
    private JFXButton btnNovoEventoEntrar1;
    @FXML
    private JFXButton btnListaDeEventosEntrar1;
    @FXML
    private Pane pnlMenuModoSecretario;
    @FXML
    private JFXButton btnModoSecretarioFinaceiro;
    @FXML
    private Pane pnlEsconderMenuFinanceiro;
    @FXML
    private Pane pnlEsconderModoSecretario;
    @FXML
    private AnchorPane pnlTabelaDePrecoDiversos;
    @FXML
    private TableView<TabelaPrecos> tbl_TabelaPrecosDiversos;
    @FXML
    private TableColumn<TabelaPrecos,String> col_descricaoTabelaPrecos;
    @FXML
    private TableColumn<TabelaPrecos,String> col_diversosTabelaPreco;
    @FXML
    private JFXTextField txtPrecoTabelaPrecoDiversos;
    @FXML
    private JFXButton btnGuardarTabelaPrecoDiversos;
    @FXML
    private JFXTextField txtDescricacaoTabelaPrecoDiversos;
    @FXML
    private Label lblPercentagemHomem1212111;
    @FXML
    private Label lblPercentagemMulher1112111;
    @FXML
    private JFXButton btnSairPnlTabelaDePrecoDiversos;
    @FXML
    private AnchorPane pnlTabelaDePrecoMensalidade;
    @FXML
    private TableView<TabelaPrecos> tbl_TabelaPrecos;
    @FXML
    private TableColumn<TabelaPrecos,String> col_classeTabelaPrecos;
    @FXML
    private TableColumn<TabelaPrecos,String> col_mensalidadeTabelaPreco;
    @FXML
    private JFXComboBox<String> cmbClasseTabelaPreco;
    @FXML
    private JFXTextField txtPrecoTabelaPreco;
    @FXML
    private JFXButton btnGuardarTabelaPreco;
    @FXML
    private Label lblPercentagemHomem121211;
    @FXML
    private Label lblPercentagemMulher111211;
    @FXML
    private JFXButton btnSairPnlTabelaDePrecoMensalidade;
    @FXML
    private AnchorPane pnlPagamentoDiversos;
    @FXML
    private JFXButton btnPagarDiversos;
    @FXML
    private Label lblNomePagarDiversos;
    @FXML
    private Label lblClassePagarDiversos;
    @FXML
    private Label lblDescricaoPagarDiversos;
    @FXML
    private Label lblPrecoPagarDiversos;
    @FXML
    private JFXComboBox<String> cmbFiltrarDescricoesPagarDiversos;
    @FXML
    private JFXTextField txtQtdPagarDiversos;
    @FXML
    private JFXTextField txtBuscarAlunoPagarDiversos;
    @FXML
    private Label lblPercentagemHomem12121;
    @FXML
    private Label lblPercentagemMulher11121;
    @FXML
    private JFXButton btnSairPnlPagarDiversos;
    @FXML
    private JFXButton btnVerDividasMensalidade1;
    @FXML
    private AnchorPane pnlPagamentoMensalidade;
    @FXML
    private JFXButton btnPagarMensalidade;
    @FXML
    private Label lblNomeMensalidade;
    @FXML
    private Label lblClasseMensalidade;
    @FXML
    private Label lblUltimoMesPago;
    private Label lblMesAPagar;
    @FXML
    private JFXRadioButton rdMultar;
    @FXML
    private JFXTextField txtBuscarAlunoMensalidade;
    @FXML
    private Label lblPercentagemHomem1212;
    @FXML
    private Label lblPercentagemMulher1112;
    @FXML
    private JFXButton btnSairPnlPagamentoMensalidade;
    @FXML
    private JFXButton btnVerDividasMensalidade;
    @FXML
    private AnchorPane CapaModulo;
    @FXML
    private AnchorPane moduloSecretario;
    @FXML
    private Circle btnTrocarModuloSecretario;
    @FXML
    private ImageView iconeTrocarModuloSecretario;
    @FXML
    private Pane pnlMenuModoFinanceiro;
    @FXML
    private JFXButton btnModoFinanceiroSecretario;
    @FXML
    private Pane pnlEsconderMenuModuloFinanceiro;
    @FXML
    private AnchorPane pnlNovoAnoLectivo;
    @FXML
    private Label lblPercentagemHomem121212;
    @FXML
    private Label lblPercentagemMulher111212;
    @FXML
    private JFXButton btnSairNovoAnoLectivo;
    @FXML
    private JFXTextField txtNovoAnoLectivo;
    @FXML
    private JFXButton btnNovoAnoLectivoEntrar;
    @FXML
    private JFXButton btnGuardarAnoLectivo;
    @FXML
    private AnchorPane pnlDefinirAnoLectivo;
    @FXML
    private Label lblPercentagemHomem1212121;
    @FXML
    private Label lblPercentagemMulher1112121;
    @FXML
    private JFXButton btnSairDefinirAnoLectivo;
    @FXML
    private Label lblAnoLectivoActual;
    @FXML
    private JFXButton btnGuardarAnoLectivo1;
    @FXML
    private JFXComboBox<String> cmbAnoLetivoDefinir;
    @FXML
    private JFXButton btnDefinirAnoLectivoEntrar;
    @FXML
    private JFXComboBox<String> cmbMesAPagar;
    @FXML
    private Label lblPercentagemHomem1213;
    @FXML
    private JFXButton btnImprimir;
    @FXML
    private Label lblPercentagemMulher1113;
    @FXML
    private AnchorPane pnlDividasMensalidade;
    @FXML
    private JFXTextField txtBusdcarAlunoDividasMensalidade;
    @FXML
    private JFXButton btnSairPnlDividasMensalidade;
    @FXML
    private TableView<divida> btl_ListaDosDevedoresMensalidade;
    @FXML
    private TableColumn<divida, String> col_IdAlunoPagoDividas;
    @FXML
    private TableColumn<divida, String> col_NomePagoDividas;
    @FXML
    private TableColumn<divida, String> col_UltimoMesPagoDividas;
    @FXML
    private JFXComboBox<String> cmbFiltrarAlunosDividasMensalidade;
    @FXML
    private Label lblTortalAlunos;
    @FXML
    private Label lblTotalTurmas;
    @FXML
    private PieChart graficoGeneroModuloScretario;
    @FXML
    private BarChart<String ,Number> GraficoAlunosPorTurmas;
    @FXML
    private PieChart GraficoAlunosPorClasses;
    @FXML
    private AnchorPane pnlAdministracao;
    @FXML
    private JFXTextField txtNomeCompletoAdministracao;
    @FXML
    private Label lblPercentagemHomem12131;
    @FXML
    private JFXButton btnGuardarDadosAdministracao;
    @FXML
    private Label lblPercentagemMulher11131;
    @FXML
    private JFXButton tbnSairAdministracao;
    @FXML
    private JFXComboBox<String> cmbTipoDeUsuarioAdminstracao;
    @FXML
    private JFXTextField txtFuncaoAdministracao;
    @FXML
    private JFXTextField txtPalavraPasseAdministracao;
    @FXML
    private JFXButton btnSairModuloSecretario;
    @FXML
    private AnchorPane pnlLogar;
    @FXML
    private JFXPasswordField txtPalavraPasseLogar;
    @FXML
    private JFXButton btnLogar;
    @FXML
    private JFXButton btnFecharGeral;
    @FXML
    public void initialize() {
        try {  
            dado.criarTabelaGeralTurmas();
          
        } catch (SQLException ex) {
            System.out.println("erro ao crirar tabela turmas "+ex);
        }
        try {
            dado.criarPessoal();
        } catch (SQLException ex) {
          System.out.println("erro ao crirar tabela pessoal "+ex);
        }
     cmbGeneropnlDadosEncarregado.getItems().addAll("Masculino","Femenino");
     cmbGeneropnlDadosPessoas.getItems().addAll("Masculino","Femenino");
     cmbGeneropnlDadosProfessor.getItems().addAll("Masculino","Femenino");
     comFiltrarAluno.getItems().addAll("ID","Nome","BI","Encarregado","Classe","Genero");
     cmbMesAPagar.getItems().addAll("Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro");
     //comFiltrarAlunoGeral.getItems().addAll("ID","Nome","BI","Encarregado","Classe","Genero");
     cmbClasseAlunosAdicionarColetivo.getItems().addAll("Iniciação","1ª","2ª","3ª","4ª","5ª","6ª","7ª","8ª","9ª","10ª","11ª","12ª","13ª");
     cmbFiltrarPorPnlAdicionarAlunoTurma.getItems().addAll("ID","Nome","BI","Encarregado","Classe","Genero");
     cmbClasseTabelaPreco.getItems().addAll("Iniciação","1ª","2ª","3ª","4ª","5ª","6ª","7ª","8ª","9ª","10ª","11ª","12ª","13ª");
     cmbFiltrarAlunosDividasMensalidade.getItems().addAll("Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro");
     cmbTipoDeUsuarioAdminstracao.getItems().addAll("Secretário","Administrador");
     anoLectivoDefinido=new Operador().buscarAnoLectivo();
     lblAnoLectivoActual.setText(anoLectivoDefinido);
     buscarAnoLectivoNoBanco();
     buscarDescricao();
     tabelaDividas();
     graficoSemanal();
     graficoAlunosGeneros();
     graficoAlunosClasses();
     dadosDoPainel();
    }
    @FXML
    private void eventos(MouseEvent event) {
        if (event.getSource() == btnNovoAluno) {
            evento.esconderMenu(pnlEsconderMenu);
            evento.mostrarMenu(pnlEsconderMenu, pnlMenuAluno);

        } else if (event.getSource() == btnProfessores) {
            evento.esconderMenu(pnlEsconderMenu);
            evento.mostrarMenu(pnlEsconderMenu, pnlMenuProfessor);
        } else if (event.getSource() == btnAdministracao) {
            evento.esconderMenu(pnlEsconderMenu);
            evento.mostrarMenu(pnlEsconderMenu, pnlMenuAdministracao);
        } else if (event.getSource() == btnOutros) {
            evento.esconderMenu(pnlEsconderMenu);
            evento.mostrarMenu(pnlEsconderMenu, pnlMenuOutros);
        }
         else if (event.getSource() == lblOrganizarTurmaEntrar) {
            evento.esconderTela(capa1,pnlCrirarTurma);
            evento.mostrarTela(capa1,pnlOrganizarTurma);
        }
        else if(event.getSource()==btnVerAlunsDadosPnlListarGeral){
           FichaTecnica(txtBuscarAlunosListagemGeral.getText(),txtBuscarAlunosListagemGeral1.getText()); 
         }
        else if(event.getSource()==btnGuardarProfessor){
            cadastrarProfessor();
        }
          else if(event.getSource()==btnGuardarTurma){
            cadastrarTurmas();
        }
          else if(event.getSource()==btnAdicionarAlunoPnlAdicionarIndividual){
              adicionarAlunosTurma();
          }
        
        
        else if(event.getSource()==btnListaProfessores){
            evento.mostrarTela(capa1, pnlListatudante1);
            TabelaProfessorGeral();
        }
        else if(event.getSource()==btnAlterarProfessorEntrar){
            mostrarDadosProfessores(indiceProfessor);
            evento.mostrarTela(capa1, pnlAlterarProfessor);
        }
        else if(event.getSource()==btnCriarTurmasEntrarpnlOutros){
            lblNumeroDeTurmas.setText(dado.qtdTurmas());
            evento.esconderMenu(pnlEsconderMenu);
            evento.mostrarTela(capa1,pnlCrirarTurma);
        }
        else if(event.getSource()==btnOrganizarIndividual){
            evento.esconderTela(capa1,pnlOrganizarTurma);
            evento.mostrarTela(capa1,pnlAdicionarIndividual);
        }
        else if(event.getSource()==btnOrganizarTurmaColetivo){
            evento.esconderTela(capa1,pnlOrganizarTurma);
            evento.mostrarTela(capa1,pnlAdicionarCooletivo);
        }
        if(event.getSource()==btnAlterarProfessor){
            actulaizarProfessor();
        }
        if(event.getSource()==btnAdministracao && tipoUsusario==2){
             evento.esconderMenu(pnlEsconderMenu);
            evento.mostrarTela(capa1,pnlAdministracao);
        }
        else if(event.getSource()==btnListagemEntrarpnlOutros){
            evento.esconderMenu(pnlEsconderMenu);
            evento.mostrarTela(capa1, pnlGeralListatudante);
        }
        else if (event.getSource() == btnEventos) {
            evento.esconderMenu(pnlEsconderMenu);
            evento.mostrarMenu(pnlEsconderMenu, pnlMenuEventos);
        } else if (event.getSource() == btnAcaopnlDadosPessoas) {
            if (posicionador < 3) {
                posicionador++;
                accaoTelaEstudante(posicionador);
               
                
            }
            if (posicionador == 3) {
                btnAcaopnlDadosPessoas.setText("Guardar");
                cadastrarAlunoS();               
            } else {
                btnAcaopnlDadosPessoas.setText("Proximo");              
            }
        } else if (event.getSource() == tbnVoltarNovoEstudante ) {
            posicionador--;
            accaoTelaEstudante(posicionador);
            if (posicionador == 3) {
                btnAcaopnlDadosPessoas.setText("Guardar");
                } else {
                btnAcaopnlDadosPessoas.setText("Proximo");
                conroladorDePosicao = "Proximo";
            }
        }
        //acao no painel alterar
         else if (event.getSource() == btnAcaopnlAlterar) {
            if (posicionadorAlterar < 3) {
                posicionadorAlterar++;
                accaoTelaEstudanteAlterar(posicionadorAlterar);
               
                
            }
            if (posicionadorAlterar == 3) {
                btnAcaopnlAlterar.setText("Alterar");
                actulaizar();
                notificacao("Alterado com sucesso!");
            } else {
                btnAcaopnlAlterar.setText("Proximo");              
            }
        } else if (event.getSource() == btnVoltarAlterar ) {
            posicionadorAlterar--;
            accaoTelaEstudanteAlterar(posicionadorAlterar);
            if (posicionadorAlterar == 3) {
                btnAcaopnlAlterar.setText("Guardar");
                } else {
                btnAcaopnlAlterar.setText("Proximo");
                conroladorDePosicao = "Proximo";
            }
        }
        
        
        
        
       //fim eventos painel alterar 
        else if(event.getSource()==btnAlterarEntrar){
            mostrarDados(indiceAluno);
            System.out.println("indice "+indiceAluno);
            evento.mostrarTela(capa1, pnlAlterarEstudante);
        }
        else if(event.getSource()==btnFichaTecnicaAluno){
            FichaTecnica(indiceAluno);
        }
       
// modulo financeiro todos os eventos
        else if(event.getSource()==btnTrocarModuloSecretario || event.getSource()==iconeTrocarModuloSecretario){
            System.out.println("entrei Modulo secretario");
            evento.mostrarMenu(pnlEsconderModoSecretario,pnlMenuModoSecretario);
        }
        else if(event.getSource()==btnTrocarModuloFinanceiro || event.getSource()==iconeTrocarModuloFinanceiro){
              System.out.println("entrei Modulo Financeiro");
             evento.mostrarMenu(pnlEsconderMenuFinanceiro,pnlMenuModoFinanceiro);
        }
        else if(event.getSource()==btnPagamentos){
            evento.esconderMenu(pnlEsconderMenuFinanceiro);
            evento.mostrarMenu(pnlEsconderMenuModuloFinanceiro,pnlMenuPagamento);
       
    }
         else if(event.getSource()==btnDividas){
              evento.esconderMenu(pnlEsconderMenuFinanceiro);
            evento.mostrarMenu(pnlEsconderMenuModuloFinanceiro,pnlMenuDividas);
         }
         else if(event.getSource()==btnTabelaDePrecos){
              evento.esconderMenu(pnlEsconderMenuFinanceiro);
            evento.mostrarMenu(pnlEsconderMenuModuloFinanceiro,pnlMenuTabelaPrecos);
         }
         
        else if(event.getSource()==btnRelatórios){
             evento.esconderMenu(pnlEsconderMenuFinanceiro);
            evento.mostrarMenu(pnlEsconderMenuModuloFinanceiro,pnlMenuRelatorios);
         }
        else if(event.getSource()==btnModoFinanceiroSecretario && tipoUsusario==2){
            evento.mostrarMenu(CapaModulo,moduloFinaceiro);
         }
        else if(event.getSource()==btnModoSecretarioFinaceiro && tipoUsusario==2){
            evento.mostrarMenu(CapaModulo,moduloSecretario);
         }
       
         else if(event.getSource()==btnTabelaPrecosMensalidade){
             tabelaMostrarPrecoMensalidade();
            evento.esconderMenu(pnlEsconderMenuFinanceiro);
            evento.mostrarTela(capa1, pnlTabelaDePrecoMensalidade);
        }
         else if(event.getSource()==btnTabelaDePrecosDiversos){
             tabelaMostrarPrecoDiversos();
            evento.esconderMenu(pnlEsconderMenuFinanceiro);
            evento.mostrarTela(capa1, pnlTabelaDePrecoDiversos);
        }
         else if(event.getSource()==btnNovoAnoLectivoEntrar){
           
            evento.esconderMenu(pnlEsconderMenuModuloFinanceiro);
            evento.mostrarTela(capa1, pnlNovoAnoLectivo);
        }
         else if(event.getSource()==btnDefinirAnoLectivoEntrar){           
            evento.esconderTela(capa1, pnlNovoAnoLectivo);
            evento.mostrarTela(capa1, pnlDefinirAnoLectivo);
        }
    }
    

    void accaoTelaEstudante(int posicao) {
        switch (posicao) {
            case 1:
                evento.mostrarPaineis(pnlDadosPessoas);
                pnlEsconderBotaoVoltar.toFront();
                break;
            case 2:
                evento.mostrarPaineis(pnlDadosAcademicos);
                tbnVoltarNovoEstudante.toFront();
                break;
            case 3:
                evento.mostrarPaineis(pnlDadosEncarregado);
                tbnVoltarNovoEstudante.toFront();
                break;
            default:
                break;
        }
    }
    void accaoTelaEstudanteAlterar(int posicao) {
        switch (posicao) {
            case 1:
                evento.mostrarPaineis(pnlDadosPessoasAlterar);
                pnlEsconderBotaoVoltarAlterar.toFront();
                break;
            case 2:
                evento.mostrarPaineis(pnlDadosAcademicosAlterar);
                btnVoltarAlterar.toFront();
                break;
            case 3:
                evento.mostrarPaineis(pnlDadosEncarregadoAlterar);
                btnVoltarAlterar.toFront();
                break;
            default:
                break;
        }
    }

    @FXML
    private void MouseOut(MouseEvent event) {
        if (event.getSource() == pnlMenuAluno || event.getSource() == pnlMenuProfessor || event.getSource() == pnlMenuAdministracao || event.getSource() == pnlMenuOutros || event.getSource() == pnlMenuEventos) {
            evento.esconderMenu(pnlEsconderMenu);
        }
        else if (event.getSource() == pnlMenuPagamento || event.getSource() == pnlMenuDividas || event.getSource() == pnlMenuGraficos || event.getSource() == pnlMenuTabelaPrecos || event.getSource() == pnlMenuRelatorios) {
            evento.esconderMenu(pnlEsconderMenuFinanceiro);
        }
         if(event.getSource()==pnlMenuModoFinanceiro){
            evento.esconderMenu(pnlEsconderMenuModuloFinanceiro);
        }
        else if(event.getSource()==pnlMenuModoSecretario){
             evento.esconderMenu(pnlEsconderModoSecretario);
            
        }
            }

    @FXML
    private void Entrar(MouseEvent event) {
        if (event.getSource() == btnNovoAlunoEntrar) {

            evento.mostrarTela(capa1, pnlCadstroEstudante);
            pnlEsconderMenu.toBack();
        }
         else if(event.getSource()==btnAlterarAlunoEntrar){
            TabelaAlunosGeral();
            evento.mostrarTela(capa1,pnlListatudante);
            pnlEsconderMenu.toBack();
        }
        else if(event.getSource()==btnNovoProfessorEntrar){
             evento.mostrarTela(capa1,pnlCadastroProfessor);
              pnlEsconderMenu.toBack();
        }
         else if(event.getSource()==btnMensalidadeEntrar){
             evento.esconderMenu(pnlEsconderMenuFinanceiro);
            evento.mostrarTela(capa1, pnlPagamentoMensalidade);
        }
        else if(event.getSource()==btnPagamentosDiversosEntrar){
             evento.esconderMenu(pnlEsconderMenuFinanceiro);
            evento.mostrarTela(capa1, pnlPagamentoDiversos);
        }
         else if(event.getSource()==btnDividasProprinasEntrar){
                evento.esconderMenu(pnlEsconderMenuFinanceiro);
            evento.mostrarTela(capa1, pnlDividasMensalidade);
          
         }
    }

    @FXML
    private void Sair(MouseEvent event) {
        if (event.getSource() == btnFecharCadastro) {
  
            evento.esconderTela(capa1, pnlCadstroEstudante);
            evento.esconderMenu(pnlEsconderMenu);
        }
          if(event.getSource()==tbnSairAdministracao){
            evento.esconderTela(capa1,pnlAdministracao);
            evento.esconderMenu(pnlEsconderMenu);
        }
        else if(event.getSource()==btnFecharListaProfessores){
             evento.esconderTela(capa1,pnlListatudante1);
        }
        else if(event.getSource()==btnSairPnlOrganizarTurma){
             evento.esconderTela(capa1,pnlOrganizarTurma);
             evento.mostrarTela(capa1, pnlCrirarTurma);
        }
        else if(event.getSource()==btnSairPnlAdicionarIndividual){
             evento.esconderTela(capa1,pnlAdicionarIndividual);
             evento.mostrarTela(capa1, pnlOrganizarTurma);
        }
         else if(event.getSource()==btnSairPnlAdicionarColetivo){
             evento.esconderTela(capa1,pnlAdicionarCooletivo);
             evento.mostrarTela(capa1, pnlOrganizarTurma);
        }
        else  if (event.getSource() == btnFecharCadastro1) {
            evento.esconderTela(capa1,pnlListatudante);    
        }
        else  if (event.getSource() == btnFecharCriarTurma) {
            evento.esconderTela(capa1,pnlCrirarTurma);  
        }
        else  if (event.getSource() == btnFecharCadastro2) {
            evento.esconderTela(capa1,pnlCadastroProfessor);        
        }
        else  if (event.getSource() == btnFecharAlterarAluno) {
            TabelaAlunosGeral();
            evento.esconderTela(capa1, pnlAlterarEstudante);
            evento.mostrarTela(capa1,pnlListatudante);
        }
        else  if (event.getSource() == btnFecharAlterarProfessor) {
            TabelaAlunosGeral();
            evento.esconderTela(capa1, pnlAlterarProfessor);
            evento.mostrarTela(capa1,pnlListatudante1); 
        }
         else  if (event.getSource() == btnFecharListaGeral) {
            evento.esconderTela(capa1, pnlGeralListatudante);         
        }
           else  if (event.getSource() == btnSairPnlDividasMensalidade) {
            evento.esconderTela(capa1, pnlDividasMensalidade);         
        }
        else if(event.getSource()==btnSairPnlPagamentoMensalidade){
             evento.esconderTela(capa1,pnlPagamentoMensalidade);  
        }
         else if(event.getSource()==btnSairPnlPagarDiversos){
             evento.esconderTela(capa1,pnlPagamentoDiversos);
        }
        else if(event.getSource()==btnSairPnlTabelaDePrecoMensalidade){
             evento.esconderTela(capa1,pnlTabelaDePrecoMensalidade);         
        }
        else if(event.getSource()==btnSairPnlTabelaDePrecoDiversos){
             evento.esconderTela(capa1,pnlTabelaDePrecoDiversos);     
        }
        else if(event.getSource()==btnSairNovoAnoLectivo){
            evento.esconderTela(capa1,pnlNovoAnoLectivo); 
        }
        else if(event.getSource()==btnSairDefinirAnoLectivo){
          evento.esconderTela(capa1,pnlDefinirAnoLectivo);
            evento.mostrarTela(capa1, pnlNovoAnoLectivo);
        }
           else if(event.getSource()==btnSairModuloSecretario){
            pnlLogar.toFront();
            new BounceInDown(pnlLogar).play();
            
        }
         else if(event.getSource()==btnFecharGeral){
            System.exit(1);
            
        }
       
    }
    public void cadastrarAlunoS() {
        aluno = new Aluno();
        aluno.setNome(txtNomeCadastropnlDadosPessoas.getText());
        aluno.setBilhete(txtBIpnlDadosPessoas.getText());
        aluno.setDataNascimento(DataDeNascimentopnlDadosPessoas.getValue().toString());
        aluno.setGenero(cmbGeneropnlDadosPessoas.getValue());
        aluno.setProvincia_origem(txtProvinciaOrigempnlDadosPessoas.getText());
        aluno.setMunicipio_origem(txtMunicipioOrigempnlDadosPessoas.getText());
        aluno.setBairro_origem(txtBairroOrigem.getText());
        aluno.setClasse(txtClassepnlDadosAcademicos.getText());
        aluno.setProvincia_actual(txtProvinciaActualpnlDadosAcademicos.getText());
        aluno.setMunicipio_actual(txtMuncipiopnlDadosAcademicos.getText());
        aluno.setBairro_actual(txtBairroActualpnlDadosAcademicos.getText());
        aluno.setEncarregado(txtEncarregadopnlDadosEncarregado.getText());
        aluno.setEndereco(txtEnderecopnlDadosEncarregado.getText());
        aluno.setGeneroEncarregado(cmbGeneropnlDadosEncarregado.getValue());
        aluno.setProfissao(txtProfissaopnlDadosEncarregado.getText());
        aluno.setTelefone(txtTelefonepnlDadosEncarregado.getText());
        aluno.setTelefone2(txtTelefoneAlternativopnlDadosEncarregado.getText());
        try {
           resultado= dado.InserirDadosAluno(aluno);
            posicionador=1;
            accaoTelaEstudante(posicionador);
            notificacao("Cadastrado com sucesso!");
            limpar_campos();
           
        } catch (SQLException ex) {
            System.out.println("erro no " + ex);
        }
}
    void cadastrarProfessor(){
        try {
            Professor professor= new Professor(txtNomeCompletoProfessor.getText(),txtBIpnlDadosProfessor.getText(),DataDeNascimentopnlDadosProfessor.getValue().toString(),cmbGeneropnlDadosProfessor.getValue(),txtCertificadoProfessor.getText(),txtTelefoneProfessor.getText());
            resultado=dado.cadastrarProfessor(professor);
            notificacao("Professor cadastrado!");
            limparProfessor();
            
        } catch (SQLException ex) {
            System.out.println("erro ao cadastrar professor "+ ex);
        }
    }
    void cadastrarTurmas(){
        try {
        turma=new turma(txtNomeTurma.getText(),(txtClasseTurma.getText()),(txtSalaTurma.getText()),txtPeriodoTurma.getText(),txtAnoLectivo.getText());
        resultado=dado.novaTurma(turma);
            notificacao("Turma "+txtNomeTurma.getText()+" criado com sucesso!");
            limparDadosTurmas();
           } catch (SQLException e) {
            System.out.println("erro ao crirar turmas");
        }
    }
    void setarAnoLectivo(){
        new Operador().definirAnoLectivo(cmbAnoLetivoDefinir.getValue());
    }
    void buscarInformacoesDoAlunoPagamentos(){
        try {
            dado.buscarInformacoAluno(txtBuscarAlunoMensalidade.getText(), lblNomeMensalidade, lblClasseMensalidade);
            dado.buscarInformacoAlunoMensalidade(txtBuscarAlunoMensalidade.getText(), lblUltimoMesPago, lblMesAPagar, anoLectivoDefinido);
        } catch (SQLException ex) {
            System.out.println("erro ao buscar Informacoes "+ex);
        }
    }
  void criarNovovoAnoLectivo(){
      int feito;
      int feito2;
      int feito3;
      try {
        feito=dado.criarNovoAnoLectivo(txtNovoAnoLectivo.getText());
        feito2=dado.inserirAnoLectivoNoBanco(txtNovoAnoLectivo.getText());
        feito3=dado.criarNovoAnoLectivoPagamentosDiversos(txtNovoAnoLectivo.getText());
        if(feito>0){
            notificacao("Ano Lectivo Criado");
        }
      } catch (SQLException e) {
          System.out.println("Erro ao criar ano lectivo "+e);
      }
  }
  void buscarDescricao(){
      cmbFiltrarDescricoesPagarDiversos.getItems().clear();
        try {
            ArrayList<String> precos=new ArrayList();
            precos=dado.buscarDadosTabelaDiversos();
            precos.forEach(preco->{
            cmbFiltrarDescricoesPagarDiversos.getItems().addAll(preco);
            });
        } catch (SQLException ex) {
          
        }
      
  }
  void buscarAnoLectivoNoBanco(){
      ArrayList<String> lista=new ArrayList();
        try {
            lista=dado.buscarAnoLectivo();
        } catch (SQLException ex) {
            System.out.println("erro ao pegar ano lectivo do banco "+ ex);
        }
            cmbAnoLetivoDefinir.getItems().clear();
            lista.forEach(anoLectivo->{cmbAnoLetivoDefinir.getItems().add(anoLectivo);
                System.out.println(anoLectivo);
            });
      
  }
void inserirDadosTabelaPrecoMensalidade(){
    int estado=0;
        try {
            estado=dado.inserirTabelaDePrecoMensalidade(new TabelaPrecos(cmbClasseTabelaPreco.getValue(),txtPrecoTabelaPreco.getText()));
            if(estado==1){
                limparTabelaPrecosMensalidade();
                notificacao("O preço"+ txtPrecoTabelaPreco.getText()+" foi definido");
            }
        } catch (SQLException ex) {
            System.out.println("erro ao cadastrar um novopreco mensalidade  "+ex);
        }
}  
void inserirDadosTabelaPrecoDiversos(){
    int estado=0;
        try {
            estado=dado.inserirTabelaDePrecoDiversos(new TabelaPrecos(txtDescricacaoTabelaPrecoDiversos.getText(),txtPrecoTabelaPrecoDiversos.getText()));
            if(estado==1){
                limparTabelaPrecosDiversos();
                notificacao("O preço"+ txtPrecoTabelaPrecoDiversos.getText()+" foi definido");
            }
        } catch (SQLException ex) {
            System.out.println("erro ao cadastrar um novopreco mensalidade  "+ex);
        }
}
void adicionarAlunosTurma(){
    int resposta=0;
        try {
           resposta= dado.receberDadosAluno(anoLectivoEturmaSelecionado,new Operador().limparAnoLectivo(lblAnoLectivoOrganizarTurma.getText()), Integer.toString(indiceAluno),lblNomePnlAdicionarIndividual.getText(), lblClassePnlAdicionarIndividual.getText());
           if(resposta==1){
               notificacao("Aluno Nº "+Integer.toString(indiceAluno)+" Adicionado!");
           }
        } catch (SQLException ex) {
            System.out.println("erro ao adiconar aluno na turma "+anoLectivoEturmaSelecionado+" "+ex);
        }
    }
    void mostrarTurmas(){
        
        try {
            lblAnoLectivoOrganizarTurma.setText(txtBuscarTurmaPnlOrganizar.getText());
            dado.tabelaTurmas(txtBuscarTurmaPnlOrganizar.getText(), tbl_TurmasCriadas, col_turma,col_classe, col_sala, col_periodo);
        } catch (SQLException e) {
            System.out.println("erro ao exibir turma "+e);
        }
    }
    public void notificacao(String sms) {
        lblMensagem.setText(sms);
        pnlNotificacao.toFront();
        new ZoomInUp(pnlNotificacao).play();         
    }
    void fecharNoificacao(){
        new ZoomOutDown(pnlNotificacao).play();
          }
       void limparDadosTurmas(){
           txtNomeTurma.setText(null);
           txtClasseTurma.setText(null);
           txtSalaTurma.setText(null);
           txtPeriodoTurma.setText(null);
           txtPeriodoTurma.setText(null);
       }
       void limparTabelaPrecosMensalidade(){
           cmbClasseTabelaPreco.setValue(null);
           txtPrecoTabelaPreco.setText(null);
       }
        void limparTabelaPrecosDiversos(){
           txtDescricacaoTabelaPrecoDiversos.setText(null);
           txtPrecoTabelaPrecoDiversos.setText(null);
       }
        
       void  limpar_campos(){
        txtNomeCadastropnlDadosPessoas.setText(null);
        txtBIpnlDadosPessoas.setText(null);
        DataDeNascimentopnlDadosPessoas.setValue(null);
        cmbGeneropnlDadosPessoas.setValue(null);
        txtProvinciaOrigempnlDadosPessoas.setText(null);
        txtMunicipioOrigempnlDadosPessoas.setText(null);
        txtBairroOrigem.setText(null);
        txtClassepnlDadosAcademicos.setText(null);
        txtProvinciaActualpnlDadosAcademicos.setText(null);
        txtMuncipiopnlDadosAcademicos.setText(null);
        txtBairroActualpnlDadosAcademicos.setText(null);
        txtEncarregadopnlDadosEncarregado.setText(null);
        txtEnderecopnlDadosEncarregado.setText(null);
        cmbGeneropnlDadosEncarregado.setValue(null);
        txtProfissaopnlDadosEncarregado.setText(null);
        txtTelefonepnlDadosEncarregado.setText(null);
        txtTelefoneAlternativopnlDadosEncarregado.setText(null);
    }
       void limparProfessor(){
           txtNomeCompletoProfessor.setText(null);
           txtBIpnlDadosProfessor.setText(null);
           DataDeNascimentopnlDadosProfessor.setValue(null);
           cmbGeneropnlDadosProfessor.setValue(null);
           txtCertificadoProfessor.setText(null);
           txtTelefoneProfessor.setText(null);
       }
        void limparProfessorAlterar(){
           txtNomeCompletoProfessor1.setText(null);
           txtBIpnlDadosProfessor1.setText(null);
           DataDeNascimentopnlDadosProfessor1.setValue(null);
           cmbGeneropnlDadosProfessor1.setValue(null);
           txtCertificadoProfessor1.setText(null);
           txtTelefoneProfessor1.setText(null);
       }
         void limparPagarDiversos(){
           txtBuscarAlunoPagarDiversos.setText(null);
          lblNomePagarDiversos.setText(null);
           cmbFiltrarDescricoesPagarDiversos.setValue(null);
           lblPrecoPagarDiversos.setText(null);
           lblDescricaoPagarDiversos.setText(null);          
           txtQtdPagarDiversos.setText(null);
       }
        void limparPagarMensalidade(){
           txtBuscarAlunoMensalidade.setText(null);
           lblNomeMensalidade.setText(null);      
           lblUltimoMesPago.setText(null);
           lblClasseMensalidade.setText(null);          
           cmbMesAPagar.setValue(null);
       }
        void cadastrarPessoalAdminstracao(){
        try {
            if(dado.InserirPessoalAdministraca(txtNomeCompletoAdministracao.getText(), txtFuncaoAdministracao.getText(), txtPalavraPasseAdministracao.getText(), cmbTipoDeUsuarioAdminstracao.getValue())==1){
                notificacao(cmbTipoDeUsuarioAdminstracao.getValue()+" adicionado");
            }
        } catch (SQLException ex) {
            System.out.println("erro ao cadastrare pESOOAL"+ex);
        }}
        void efectuarPagamento(){
        try {
           if(new pagamentos().pagarMensalidade(txtBuscarAlunoMensalidade.getText(), lblClasseMensalidade.getText(), cmbMesAPagar.getValue(), anoLectivoDefinido)==1){
               notificacao("O mês "+cmbMesAPagar.getValue()+" pago!");
               limparPagarMensalidade();
           }
        } catch (SQLException ex) {
            System.out.println("erro ao pagar " +ex);
        }
        }
          void efectuarPagamentoDiversos(){
        try {
            if(new pagamentos().pagarDiversos(txtBuscarAlunoPagarDiversos.getText(), cmbFiltrarDescricoesPagarDiversos.getValue(),txtQtdPagarDiversos.getText(), anoLectivoDefinido)==1){
                notificacao( cmbFiltrarDescricoesPagarDiversos.getValue()+" Pago!");
                limparPagarDiversos();
               
            }
             
        } catch (SQLException ex) {
            System.out.println("erro ao pagar " +ex);
        }
        }
public void FichaTecnica(int id) {
    String Nome = null,nascimento = null,documento = null,genero = null,provincia = null,municipio = null,encarregado = null,SexoEncarregado = null,Endereco = null,Telefone = null,Telefone2 = null;
       ArrayList<String> ListaGeralAlunos= dado.AlunosGeral();
         for (String ListaGeralAluno : ListaGeralAlunos) {
            String dados[]=ListaGeralAluno.split(";");
            if(dados[0].equals(Integer.toString(id))){
                Nome=dados[1];
                nascimento=dados[2];
                documento=dados[3];
                genero=dados[4];
                provincia=dados[5];
                municipio=dados[6];
                encarregado=dados[11];
                SexoEncarregado=dados[17];
                Endereco=dados[18];
                Telefone=dados[13];
                Telefone2=dados[14];
                break;
            }}
       
        String caminho ="FichaIndividual.jasper";
        Map parametros = new HashMap();
        parametros.put("Nome", Nome);
        parametros.put("nascimento", nascimento);
        parametros.put("documento", documento);
        parametros.put("genero", genero);
        parametros.put("provincia", provincia);
        parametros.put("municipio", municipio);
        parametros.put("encarregado", encarregado);
        parametros.put("SexoEncarregado", SexoEncarregado);
        parametros.put("Endereco", Endereco);
        parametros.put("Telefone", Telefone);
        parametros.put("Telefone2", Telefone2);       
        try {
            JasperPrint print = JasperFillManager.fillReport(caminho, parametros, dado.conexao);
            JasperViewer ver = new JasperViewer(print, false);
            ver.setVisible(true);
            ver.setTitle("Fluxo diário de cáixa");
        } catch (JRException ex) {
            System.out.println("erro na ficha tecnica "+ex);
        }

    }
public void FichaTecnica(String turma,String anoLectivo) {
        String classe="",periodo="",sala="";
        
        String caminho ="ListaAlunos.jasper";
        Map parametros = new HashMap();
        parametros.put("turmaOriginal", turma);
        parametros.put("turma", turma+anoLectivo);
        parametros.put("classe", "9");
        parametros.put("sala", "9");
        parametros.put("periodo", "9");
               
        try {
            JasperPrint print = JasperFillManager.fillReport(caminho, parametros, dado.conexao);
            JasperViewer ver = new JasperViewer(print, false);
            ver.setVisible(true);
            ver.setTitle("Lista Geral "+turma);
        } catch (JRException ex) {
            System.out.println("erro na ficha tecnica "+ex);
        }

    }
       void TabelaAlunosGeral(){
        try {
          dado.bsucarAlunoGeral(tbl_AlunosLista, col_idAluno, col_nomeAluno, col_idadeAluno, col_sexoAluno, col_encarregadoAluno, col_telefoneAluno, col_enderecoAluno);
        } catch (SQLException ex) {
            System.out.println("erro na tabela "+ex);
        }
        dado.buscarTotal();
        lblTotalAlunos.setText(Integer.toString(dado.totaAlunos));
        lblPercentagemHomem.setText(Integer.toString(dado.percentgemAlunos().get(0)));
        lblPercentagemMulher.setText(Integer.toString(dado.percentgemAlunos().get(1)));
       }
        void TabelaProfessorGeral(){
        try {
          dado.bsucarProfessorGeral(tbl_ProfessorLista, col_nomeProfessor,col_documentoProfessor, col_idadeProfessor, col_sexoProfessor, col_certificadoProfesssor, col_telefoneProfessor);
        } catch (SQLException ex) {
            System.out.println("erro na tabela professor "+ex);
        }
        dado.totalProfessores();
        lblTotalProfessores.setText(Integer.toString(dado.totalProfessores));
        }
        void tabelaMostrarPrecoMensalidade(){
        try {
            dado.buscarTabelaPrecoMenslidade(tbl_TabelaPrecos,col_classeTabelaPrecos,col_mensalidadeTabelaPreco);
        } catch (SQLException ex) {
            System.out.println("erro na tabela precos "+ex);
        }
        }
         void tabelaMostrarPrecoDiversos(){
        try {
            dado.buscarTabelaPrecoDiversos(tbl_TabelaPrecosDiversos,col_descricaoTabelaPrecos,col_diversosTabelaPreco);
        } catch (SQLException ex) {
            System.out.println("erro na tabela precos "+ex);
        }
        }
         String selecionarTurma(){
          int index=tbl_TurmasCriadas.getSelectionModel().getSelectedIndex();
          turma=tbl_TurmasCriadas.getItems().get(index);
          String nome=turma.getNome();
             System.out.println(">> "+nome);
             anoLectivoEturmaSelecionado=""+nome+""+new Operador().limparAnoLectivo(lblAnoLectivoOrganizarTurma.getText());
          return nome;
          
      }
      void selecionarAluno(){
          int index=tbl_AlunosLista.getSelectionModel().getSelectedIndex();
          aluno=tbl_AlunosLista.getItems().get(index);
          int id=Integer.parseInt(aluno.getId());
          indiceAluno=id;
      }
      void selecionarAlunoAdicionar(){
          int index=tbl_ListaAlunosAdicionarIndividual.getSelectionModel().getSelectedIndex();
          aluno=tbl_ListaAlunosAdicionarIndividual.getItems().get(index);
          int id=Integer.parseInt(aluno.getId());
          dadosAlunoAdiconarIndividual(Integer.toString(id));
      }
      void selecionarProfessor(){
          int index=tbl_ProfessorLista.getSelectionModel().getSelectedIndex();
          professor=tbl_ProfessorLista.getItems().get(index);
          String id=(professor.getDocumento());
          indiceProfessor=id;
      }
      public void mostrarDadosProfessores(String id){
          
         ArrayList<String> ListaGeralProfessores= dado.ProfessoresGeral();
         for (String ListaGeralProfessor : ListaGeralProfessores) {
            String dados[]=ListaGeralProfessor.split(";");
        if(dados[1].equals((id))){
        txtNomeCompletoProfessor1.setText(dados[0]);
        txtBIpnlDadosProfessor1.setText(dados[1]);
        txtCertificadoProfessor1.setText(dados[4]);
        txtTelefoneProfessor1.setText(dados[5]);
        DataDeNascimentopnlDadosProfessor1.setDisable(true);       
        cmbGeneropnlDadosProfessor1.getItems().clear();
        cmbGeneropnlDadosProfessor1.getItems().addAll("Masculino","Femenino");               
            }
        }
    }
        public void mostrarDados(int id){
          System.out.println("entrei");
         ArrayList<String> ListaGeralAlunos= dado.AlunosGeral();
         for (String ListaGeralAluno : ListaGeralAlunos) {
            String dados[]=ListaGeralAluno.split(";");
            if(dados[0].equals(Integer.toString(id))){
        txtNomeCadastropnlDadosPessoas1.setText(dados[1]);
        txtBIpnlDadosPessoas1.setText(dados[3]);
        DataDeNascimentopnlDadosPessoas1.setDisable(true);
        txtProvinciaOrigempnlDadosPessoas1.setText(dados[5]);
        txtMunicipioOrigempnlDadosPessoas1.setText(dados[6]);
        txtBairroOrigem1.setText(dados[7]);
        txtClassepnlDadosAcademicos1.setText(dados[8]);
        txtProvinciaActualpnlDadosAcademicos1.setText(dados[16]);
        txtMuncipiopnlDadosAcademicos1.setText(dados[9]);
        txtBairroActualpnlDadosAcademicos1.setText(dados[10]);
        txtEncarregadopnlDadosEncarregado1.setText(dados[11]);
        txtEnderecopnlDadosEncarregado1.setText(dados[18]);
        cmbGeneropnlDadosEncarregado1.setDisable(true);
        txtProfissaopnlDadosEncarregado1.setText(dados[12]);
        txtTelefonepnlDadosEncarregado1.setText(dados[13]);
        txtTelefoneAlternativopnlDadosEncarregado1.setText(dados[14]);
        cmbGeneropnlDadosPessoas1.getItems().clear();
        cmbGeneropnlDadosPessoas1.getItems().addAll("Masculino","Femenino");
        break;
        
            }
        }
    }
        void dadosAlunoAdiconarIndividual(String id){
            ArrayList<String> ListaGeralAlunos= dado.AlunosGeral();
            ListaGeralAlunos.forEach(aluno->{
            String valor[]=aluno.split(";");
            if(valor[0].equals(id)){
                indiceAluno=Integer.parseInt(valor[0]);
                lblNomePnlAdicionarIndividual.setText(valor[1]);
                lblClassePnlAdicionarIndividual.setText(valor[8]);
            }
            });
        }
       
      void actulaizar(){
        try {
            int control=dado.altualizar(indiceAluno, txtNomeCadastropnlDadosPessoas1.getText(),txtBIpnlDadosPessoas1.getText(),txtProvinciaOrigempnlDadosPessoas1.getText(), txtMunicipioOrigempnlDadosPessoas1.getText(), txtBairroOrigem1.getText(), txtClassepnlDadosAcademicos1.getText(),txtProvinciaActualpnlDadosAcademicos1.getText() , txtMuncipiopnlDadosAcademicos1.getText(),txtBairroActualpnlDadosAcademicos1.getText(),txtEncarregadopnlDadosEncarregado1.getText(), txtEnderecopnlDadosEncarregado1.getText(), txtProfissaopnlDadosEncarregado1.getText(), txtTelefonepnlDadosEncarregado1.getText(), txtTelefoneAlternativopnlDadosEncarregado1.getText(),cmbGeneropnlDadosPessoas1.getValue().toString());
            if(control==1){
              
            }
        } catch (SQLException ex) {
            System.out.println("erro em actualizr "+ ex);
        }
      }
      void actulaizarProfessor(){
       
        try {
            int control=dado.altualizarProfessor(indiceProfessor,txtNomeCompletoProfessor1.getText(),txtBIpnlDadosProfessor1.getText(),cmbGeneropnlDadosProfessor1.getValue(),txtCertificadoProfessor1.getText(),txtTelefoneProfessor1.getText());
            if(control==1){
                notificacao("Dados Alterado!");
                resultado=1;
                limparProfessorAlterar();
            }
        } catch (SQLException ex) {
            System.out.println("erro na actualizacao professor "+ex);
        }
       
      }
     void filtrar(){
        if(txtBuscarAlunos.getText()==null){
           TabelaAlunosGeral();
        }else{
          try {
            dado.Filtrar(comFiltrarAluno.getValue(),txtBuscarAlunos.getText(),tbl_AlunosLista, col_idAluno, col_nomeAluno, col_idadeAluno, col_sexoAluno, col_encarregadoAluno, col_telefoneAluno, col_enderecoAluno);
        } catch (SQLException ex) {
            System.out.println("erro "+ex);
        }   
        }        
     }
     void filtrarAdiocnarIndividual(){
        try {
            dado.FiltrarAlunosIndividualAcionar(cmbFiltrarPorPnlAdicionarAlunoTurma.getValue(),txtBuscarAlunoPnlAdicionarTurmaIndividual.getText(),tbl_ListaAlunosAdicionarIndividual, col_NumeroAlunoAdiconarIndividual, col_NomeAlunoAdiconarIndividual, col_classeAlunoAdiconarIndividual);
        } catch (SQLException ex) {
            System.out.println("erro "+ex);
        }   
                
     }
     void tabelaDividas(){
        try {
            new buscas().buscarTabelaPrecoMenslidade(anoLectivoDefinido, btl_ListaDosDevedoresMensalidade, col_IdAlunoPagoDividas, col_NomePagoDividas, col_UltimoMesPagoDividas);
        } catch (SQLException ex) {
            System.out.println("erro na tabela dividas "+ex);
        }
     }
      void tabelaDividasIndividual(){
        try {
            new buscas().buscarTabelaPrecoMenslidade(txtBusdcarAlunoDividasMensalidade.getText(),anoLectivoDefinido, btl_ListaDosDevedoresMensalidade, col_IdAlunoPagoDividas, col_NomePagoDividas, col_UltimoMesPagoDividas);
        } catch (SQLException ex) {
            System.out.println("erro na tabela dividas "+ex);
        }
     }
     void mostrarTurmaEscolhidaOrganizar(String turma){
         cmbSelecionarTurmaAAdicionarColetivo.getItems().clear();
         cmbSelecionarTurmaAAdicionarColetivo.getItems().add(turma);
     }
    @FXML
    private void SelecionarTabela(MouseEvent event) {
        if(event.getSource()==tbl_AlunosLista){
            selecionarAluno();
        }
        else if(event.getSource()==tbl_ProfessorLista){
            selecionarProfessor();
        }
        else if(event.getSource()==tbl_TurmasCriadas){
            lblTurmaAOgranizar.setText(selecionarTurma());
            mostrarTurmaEscolhidaOrganizar(selecionarTurma());
    }
       else if(event.getSource()==tbl_ListaAlunosAdicionarIndividual){
               selecionarAlunoAdicionar();
    }
       
    }

    @FXML
    private void buscarAluno(KeyEvent event) {
        if(event.getSource()==txtBuscarAlunos){
            filtrar();
        }
        else if(event.getSource()==txtBuscarAlunoMensalidade){
            buscarInformacoesDoAlunoPagamentos();
        }
      
           }

    @FXML
    private void Refrescar(MouseEvent event) {
        if(event.getSource()==refrescarTabelaAlunos){
            TabelaAlunosGeral();
        }
    }

    private void buscarAluno(InputMethodEvent event) {
        
    }

    @FXML
    private void buscarTurma(KeyEvent event) {
         if(event.getSource()==txtBuscarTurmaPnlOrganizar){
                mostrarTurmas();
                }
         else if(event.getSource()==txtBuscarAlunoPnlAdicionarTurmaIndividual){
               filtrarAdiocnarIndividual();
                }
         
    }

    @FXML
    private void trocarModulo(MouseEvent event) {
        if(event.getSource()==btnTrocarModuloSecretario ||  event.getSource()==iconeTrocarModuloSecretario){
            evento.mostrarMenu(pnlEsconderMenuModuloFinanceiro, pnlMenuModoFinanceiro);
        }
        else if(event.getSource()==btnTrocarModuloFinanceiro ||  event.getSource()==iconeTrocarModuloFinanceiro){
              evento.mostrarMenu(pnlEsconderModoSecretario, pnlMenuModoSecretario);
        }
    }

    @FXML
    private void TabelaPrecoDiversos(MouseEvent event) {
          //Acao sobre tabela precos
       if(event.getSource()== btnGuardarTabelaPrecoDiversos){
             inserirDadosTabelaPrecoDiversos();
             tabelaMostrarPrecoDiversos();
             buscarDescricao();
         }
        
    }

    @FXML
    private void TabelaPreco(MouseEvent event) {
         if(event.getSource()== btnGuardarTabelaPreco){
             inserirDadosTabelaPrecoMensalidade();
             tabelaMostrarPrecoMensalidade();
         }
    }

    @FXML
    private void PagarMensalidade(MouseEvent event) {
        if(event.getSource()==btnPagarMensalidade){
            efectuarPagamento();
        }
    }

    @FXML
    private void criarAnoLectivo(MouseEvent event) {
        if(event.getSource()==btnGuardarAnoLectivo){
            criarNovovoAnoLectivo();
            buscarAnoLectivoNoBanco();
        }
    }

    @FXML
    private void definirAnoLectivo(MouseEvent event) {
        if(event.getSource()==btnGuardarAnoLectivo1)
        setarAnoLectivo();
        lblAnoLectivoActual.setText(new Operador().buscarAnoLectivo());
        buscarAnoLectivoNoBanco();
        anoLectivoDefinido=lblAnoLectivoActual.getText();
    }

    @FXML
    private void PagarDiversos(MouseEvent event) {
        if(event.getSource()==btnPagarDiversos){
            efectuarPagamentoDiversos();
        }
    }

    @FXML
    private void buscarDadosPagamentosDiversos(MouseEvent event) throws SQLException {
        if(event.getSource()==cmbFiltrarDescricoesPagarDiversos){
            lblDescricaoPagarDiversos.setText(cmbFiltrarDescricoesPagarDiversos.getValue());
            lblPrecoPagarDiversos.setText(new operacaoBasica().formatar(Integer.parseInt(dado.buscarPrecoDiversos(cmbFiltrarDescricoesPagarDiversos.getValue()))) );
            btnPagarDiversos.setText(cmbFiltrarDescricoesPagarDiversos.getValue());
        }
    }

    @FXML
    private void buscarAlunosDiversosPagamentos(KeyEvent event) throws SQLException {
        if(event.getSource()==txtBuscarAlunoPagarDiversos){
            dado.buscarInformacoAluno(txtBuscarAlunoPagarDiversos.getText(), lblNomePagarDiversos, lblClassePagarDiversos);
        }
          
    }

    @FXML
    private void ImprimirRelatorioDevedores(MouseEvent event) {
    }

    @FXML
    private void buscarAlunosTabelaDividas(KeyEvent event) throws SQLException {
        if(txtBusdcarAlunoDividasMensalidade.equals(event.getSource())){
            System.out.println("entrei no individual ");
              tabelaDividasIndividual();     
        }       
    }
    @FXML
    private void buscarDividasTabela(MouseEvent event) throws SQLException {
        
      if(txtBusdcarAlunoDividasMensalidade.equals(event.getSource())){
                    //dado.buscarInformacoAlunoMensalidade(cmbFiltrarAlunosDividasMensalidade.getValue(), anoLectivoDefinido, btl_ListaDosDevedoresMensalidade, col_IdAlunoPagoDividas, col_NomePagoDividas, col_UltimoMesPagoDividas);
        }  
    }

    void graficoSemanal(){
        GraficoAlunosPorTurmas.getData().clear();   
              
       XYChart.Series semana2 = new XYChart.Series();
       XYChart.Series semana1 = new XYChart.Series();     
        XYChart.Series semana3 = new XYChart.Series();     
       semana2.getData().add(new XYChart.Data("10TB",78)); 
       semana1.getData().add(new XYChart.Data("12TB",43));    
       semana3.getData().add(new XYChart.Data("2TB",53));    
       GraficoAlunosPorTurmas.getData().addAll(semana2,semana1,semana3);
        
             }
    void graficoAlunosGeneros(){
         ObservableList<PieChart.Data> grafico = FXCollections.observableArrayList(
                new PieChart.Data("Masculino", dado.buscarTotalHomem()),
                new PieChart.Data("Femenino", dado.buscarTotalMulher())

        );
        graficoGeneroModuloScretario.setData(grafico);
       
          
        
        
    }
  void dadosDoPainel(){
       try {
            lblTortalAlunos.setText(new buscas().qutdAlunos());
            lblTotalProfessores.setText(new buscas().qutdProfessores());
            lblTotalTurmas.setText(new buscas().qturmas(anoLectivoDefinido));
        } catch (SQLException ex) {
  }  
  }

 void graficoAlunosClasses(){
         ObservableList<PieChart.Data> grafico = FXCollections.observableArrayList(
                new PieChart.Data("6", 7),
                new PieChart.Data("9", 3)

        );
        GraficoAlunosPorClasses.setData(grafico);
    }

    @FXML
    private void GuardarDadosAdministracao(MouseEvent event) {
        if(event.getSource()==btnGuardarDadosAdministracao){
            cadastrarPessoalAdminstracao();
            limparDadosAdminstracao();
        }
    }

    @FXML
    private void Logar(MouseEvent event) throws SQLException {
         
        if(event.getSource()==btnLogar){
            tipoUsusario= new buscas().verificarLogin(txtPalavraPasseLogar.getText());
          if(tipoUsusario==2 || tipoUsusario==1){
                  moduloSecretario.toFront();
                  pnlEsconderMenu.toFront();
                  new BounceIn(pnlEsconderMenu);
                
          }
            txtPalavraPasseLogar.setText(null);
             tabelaDividas();
     graficoSemanal();
     graficoAlunosGeneros();
     graficoAlunosClasses();
     dadosDoPainel();
            
           
        }
    }

    private void limparDadosAdminstracao() {
     txtNomeCompletoAdministracao.setText(null);
     txtFuncaoAdministracao.setText(null);
     txtPalavraPasseAdministracao.setText(null);
     cmbTipoDeUsuarioAdminstracao.setValue(null);
    }
} 


