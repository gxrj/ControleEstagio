package br.edu.femass.controleestagio.gui;

import br.edu.femass.controleestagio.dao.EstagioDao;
import br.edu.femass.controleestagio.model.Aluno;
import br.edu.femass.controleestagio.model.Estagio;
import br.edu.femass.controleestagio.model.Orientador;
import java.io.Serializable;
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

    private List<Estagio> estagios; 
    private Estagio estagio;
    private Boolean alterando;
    private List<Orientador> orientadores;
    private Orientador orientador;
    private List<Aluno> alunos;
    private Aluno aluno;
    
    @EJB
    EstagioDao daoEstagio = new EstagioDao();
    
    public GuiEstagio() {
    }
    
    public String iniciar(){
            estagios = daoEstagio.getEstagios();
            return "FrmLstEstagio";
    }
    
    public String incluir(){
            estagio = new Estagio();
            alterando = false;
            return "FrmCadEstagio";
    }
    
    public String alterar(Estagio e){
           estagio = e;
           alterando = true;
           return "FrmCadEstagio";
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
