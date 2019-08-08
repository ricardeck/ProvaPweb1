/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Loureiro
 */
public class Comunicacao {

    private Integer idComunicacao;
    private String destinatarioNome;
    private String destinatarioTelefone;
    private String destinatarioEmail;
    private String remetenteNome;
    private String remetenteTelefone;
    private String remetenteEmail;
    private Date data;

    public Integer getIdComunicacao() {
        return idComunicacao;
    }

    public void setIdComunicacao(Integer idComunicacao) {
        this.idComunicacao = idComunicacao;
    }
    
    public void setDestinatarioNome(String destinatarioNome) {
        this.destinatarioNome = destinatarioNome;
    }

    public void setDestinatarioTelefone(String destinatarioTelefone) {
        this.destinatarioTelefone = destinatarioTelefone;
    }

    public void setDestinatarioEmail(String destinatarioEmail) {
        this.destinatarioEmail = destinatarioEmail;
    }

    public void setRemetenteNome(String remetenteNome) {
        this.remetenteNome = remetenteNome;
    }

    public void setRemetenteTelefone(String remetenteTelefone) {
        this.remetenteTelefone = remetenteTelefone;
    }

    public void setRemetenteEmail(String remetenteEmail) {
        this.remetenteEmail = remetenteEmail;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String getDestinatarioNome() {
        return destinatarioNome;
    }

    public String getDestinatarioTelefone() {
        return destinatarioTelefone;
    }

    public String getDestinatarioEmail() {
        return destinatarioEmail;
    }

    public String getRemetenteNome() {
        return remetenteNome;
    }

    public String getRemetenteTelefone() {
        return remetenteTelefone;
    }

    public String getRemetenteEmail() {
        return remetenteEmail;
    }

    public Date getData() {
        return data;
    }
    
    

}
