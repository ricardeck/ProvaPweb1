/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAOComunicacao;
import dao.DAOComunicacaoDerby;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Comunicacao;

/**
 *
 * @author Loureiro
 */
@ManagedBean(name = "comunicacaoBean")
@SessionScoped
public class ComunicacaoBean {

    private Comunicacao comunicacao;
    private List<Comunicacao> comunicacoes = new ArrayList<Comunicacao>();

    public ComunicacaoBean() {
        this.comunicacao = new Comunicacao();
    }

    public Comunicacao getComunicacao() {
        return comunicacao;
    }

    public List<Comunicacao> getComunicacoes() {
        return comunicacoes;
    }

    public void Save() {
        String message;
//        message = "teste";
        DAOComunicacao dao = new DAOComunicacaoDerby();
        try {
            if (dao.Save(comunicacao)) {
                message = "Problemas ao realizar a gravação!!!";

            } else {
                message = "Dados gravados com sucesso";
            }
        } catch (Exception ex) {
            message = "Problemas ao conectar com o BD - " + ex;
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("BD Gravação ", message));
    }

    public void Load() throws IOException, InterruptedException {
        String message = "ok";
        FacesContext context = FacesContext.getCurrentInstance();

//        message = "email teste";
        DAOComunicacao dao = new DAOComunicacaoDerby();
        try {
            if (dao.Load(comunicacao)) {
                refresh(context);
            } else {
                message = "Não foi encontrado o dado no banco ";

            }
        } catch (Exception ex) {
            message = "Problemas ao conectar com o BD!!!" + ex;
        }
        context.addMessage(null, new FacesMessage("BD Recuperação ", message));
    }

    public void LoadForAll() throws IOException, InterruptedException {
        String message = "ok";
        FacesContext context = FacesContext.getCurrentInstance();

//        message = "email teste";
        DAOComunicacao dao = new DAOComunicacaoDerby();
        try {
            if (dao.LoadForAll(comunicacoes)) {
                refresh(context);
            } else {
                message = "Não foi encontrado o dado no banco ";

            }
        } catch (Exception ex) {
            message = "Problemas ao conectar com o BD!!!" + ex;
        }
        context.addMessage(null, new FacesMessage("BD Recuperação ", message));
    }

    public void Delete() {
        String message;
//        message = "teste";
        DAOComunicacao dao = new DAOComunicacaoDerby();
        try {
            if (dao.Delete(comunicacao)) {
                message = "Dados deletados com sucesso";
            } else {
                message = "Problemas ao realizar a deleção!!!";
            }
        } catch (Exception ex) {
            message = "Problemas ao conectar com o BD - " + ex;
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("BD Gravação ", message));
    }

    public void refresh() throws IOException, InterruptedException, Exception {
        DAOComunicacao dao = new DAOComunicacaoDerby();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("pweb2.xhtml");
        if (dao.Load(comunicacao)) {
            refresh(context);
        }
    }
    
    public void redirect() throws IOException, InterruptedException, Exception {
        DAOComunicacao dao = new DAOComunicacaoDerby();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("pweb2.xhtml");
        if (dao.Load(comunicacao)) {
            refresh(context);
        }
    }

    private void refresh(FacesContext context) throws IOException, InterruptedException {
        context.getExternalContext().redirect("pweb.xhtml");
    }

}
