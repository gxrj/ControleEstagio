/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.femass.controleestagio.gui;

import br.edu.femass.controleestagio.dao.OrientadorDao;
import br.edu.femass.controleestagio.model.Orientador;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author dumas
 */
@Named(value = "guiOrientador")
@SessionScoped
public class GuiOrientador implements Serializable{
    
    private List<Orientador> orientadores;
    private Orientador orientador;
    private Boolean alterando;

    @EJB
    OrientadorDao orientadorDao;

    public GuiOrientador(){
    }
    
        public String iniciar() {
        orientadores = orientadorDao.getOrientadores();
        return "FrmLstOrientador";
    }

    public String incluir() {
        orientador = new Orientador();
        alterando = false;
        return "FrmCadOrientador";
    }

    public String alterar(Orientador o) {
        orientador = o;
        alterando = true;
        return "FrmCadOrientador";
    }

    public String excluir(Orientador o) {
        orientadorDao.excluir(o);
        orientadores = orientadorDao.getOrientadores();
        return null;
    }

    public String gravar() {
        if (alterando) {
            orientadorDao.alterar(orientador);
        } else {
            orientadorDao.inserir(orientador);
        }
        return iniciar();
    }
    
    /**
     * @return the orientadores
     */
    public List<Orientador> getOrientadores() {
        return orientadores;
    }

    /**
     * @param orientadores the orientadores to set
     */
    public void setOrientadores(List<Orientador> orientadores) {
        this.orientadores = orientadores;
    }

    /**
     * @return the orientador
     */
    public Orientador getOrientador() {
        return orientador;
    }

    /**
     * @param orientador the orientador to set
     */
    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }
    
}
