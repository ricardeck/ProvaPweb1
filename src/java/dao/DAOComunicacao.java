/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Comunicacao;

/**
 *
 * @author Loureiro
 */
public interface DAOComunicacao {

    public boolean Save(Comunicacao comunicacao) throws Exception;

    public boolean Load(Comunicacao comunicacao) throws Exception;

    public boolean LoadForAll(List<Comunicacao> comunicacoes) throws Exception;

    public boolean Delete(Comunicacao comunicacao) throws Exception ;

    }
