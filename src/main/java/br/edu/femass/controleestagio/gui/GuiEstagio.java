package br.edu.femass.controleestagio.gui;

import br.edu.femass.controleestagio.dao.AlunoDao;
import br.edu.femass.controleestagio.dao.EstagioDao;
import br.edu.femass.controleestagio.dao.OrientadorDao;
import br.edu.femass.controleestagio.model.Aluno;
import br.edu.femass.controleestagio.model.Estagio;
import br.edu.femass.controleestagio.model.Orientador;
import br.edu.femass.controleestagio.model.Status;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author souza
 */
@Named(value = "guiEstagio")
@SessionScoped
public class GuiEstagio implements Serializable{

    @EJB
    private AlunoDao alunoDao;

    private List<Estagio> estagios; 
    private Estagio estagio;
    private Boolean alterando;
    private List<Orientador> orientadores;
    private List <String> listaDeOrientadores;
    private List <String> listaDeAlunos;
    private Orientador orientador;
    private List<Aluno> alunos;
    private Aluno aluno;
    
    @EJB
    OrientadorDao orientadorDao = new OrientadorDao();
    @EJB
    EstagioDao daoEstagio = new EstagioDao();
    
    public GuiEstagio() {
    }
    
    public String iniciar(){
            estagios = daoEstagio.getEstagios();
            listaDeOrientadores = new ArrayList<>();
            listaDeAlunos = new ArrayList<>();            
            return "FrmLstEstagio";
    }
    
    public String incluir(){
            estagio = new Estagio();
            alterando = false;
            //Retorna a lista de itens para a selecao do combobox do FrmCadEstagio
            try{
                orientadores = orientadorDao.getOrientadores();
                listaDeOrientadores = orientadorDao.getListaOrientadores();
            }catch(Exception e){listaDeOrientadores = null ;}
            try{
                alunos = alunoDao.getAlunos();
                listaDeAlunos = alunoDao.getListaAlunos();
            }catch(Exception e){listaDeAlunos = null ;}
        
            
            return "FrmCadEstagio";
    }
    
    public String alterar(Estagio e){
           estagio = e;
           alterando = true;
           return "FrmCadEstagio";
    }
    
    public String mostraStatus (){
        Status[] s = Status.values();
        return Arrays.toString(s);
    } 
    public String excluir(Estagio e){
           daoEstagio.excluir(e);
           estagios = daoEstagio.getEstagios();
           return null;
    }
    public String voltarMenuPrincipal(){
        return "index";
    }
    public String voltar(){
        return "FrmLstEstagio";
    }
    
    public String gravar(){
        
        if(alterando){
            daoEstagio.alterar(estagio);
        }else{
            daoEstagio.inserir(estagio);
        }
        
        return iniciar();
    }

    public List<Estagio> getEstagios() {
        return estagios;
    }

    public void setEstagios(List<Estagio> estagios) {
        this.estagios = estagios;
    }

    public Estagio getEstagio() {
        return estagio;
    }

    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }

    public Boolean getAlterando() {
        return alterando;
    }

    public void setAlterando(Boolean alterando) {
        this.alterando = alterando;
    }

    public EstagioDao getDaoEstagio() {
        return daoEstagio;
    }

    public void setDaoEstagio(EstagioDao daoEstagio) {
        this.daoEstagio = daoEstagio;
    }

    public List<Orientador> getOrientadores() {
        return orientadores;
    }

    public void setOrientadores(List<Orientador> orientadores) {
        this.orientadores = orientadores;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
    
}
