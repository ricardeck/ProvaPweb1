/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Comunicacao;

/**
 *
 * @author Loureiro
 */
public class DAOComunicacaoDerby implements DAOComunicacao {

    @Override
    public boolean Save(Comunicacao comunicacao) throws Exception {
        Connection conn = DerbyDbConnection.getInstancia().getConexao();
        PreparedStatement pst = conn.prepareStatement("INSERT INTO SA.COMUNICACAO "
                + "   (destinatarioNome, destinatarioTelefone, destinatarioEmail, "
                + "    remetenteNome, remetenteTelefone, remetenteEmail, "
                + "    data) "
                + "VALUES (?, ?, ?, ?, ?, ?,?)");
        pst.setString(1, comunicacao.getDestinatarioNome());
        pst.setString(2, comunicacao.getDestinatarioTelefone());
        pst.setString(3, comunicacao.getDestinatarioEmail());
        pst.setString(4, comunicacao.getRemetenteNome());
        pst.setString(5, comunicacao.getRemetenteTelefone());
        pst.setString(6, comunicacao.getRemetenteEmail());

        java.util.Date dataUtil = comunicacao.getData();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

        pst.setDate(7, dataSql);

        return pst.execute();
    }

    @Override
    public boolean Load(Comunicacao comunicacao) throws Exception {
        Connection conn = DerbyDbConnection.getInstancia().getConexao();
        PreparedStatement pst = conn.prepareStatement("select * from SA.COMUNICACAO where destinatarioEmail=?");
        pst.setString(1, comunicacao.getDestinatarioEmail());
//        pst.setString(2, usuario.getSenha());

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            comunicacao.setIdComunicacao(rs.getInt("idComunicacao"));
            comunicacao.setDestinatarioNome(rs.getString("destinatarioNome"));
            comunicacao.setDestinatarioTelefone(rs.getString("destinatarioTelefone"));
            comunicacao.setDestinatarioEmail(rs.getString("destinatarioEmail"));
            comunicacao.setRemetenteNome(rs.getString("remetenteNome"));
            comunicacao.setRemetenteTelefone(rs.getString("remetenteTelefone"));
            comunicacao.setRemetenteEmail(rs.getString("remetenteEmail"));
            comunicacao.setData(rs.getDate("data"));
            return true;
        }
        return false;
    }

    @Override
    public boolean LoadForAll(List<Comunicacao> comunicacoes) throws Exception {
        Connection conn = DerbyDbConnection.getInstancia().getConexao();
//        Comunicacao comunicacao = new Comunicacao();
        PreparedStatement pst = conn.prepareStatement("select * from SA.COMUNICACAO");

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Comunicacao comunicacao = new Comunicacao();
            comunicacao.setIdComunicacao(rs.getInt("idComunicacao"));
            comunicacao.setDestinatarioNome(rs.getString("destinatarioNome"));
            comunicacao.setDestinatarioTelefone(rs.getString("destinatarioTelefone"));
            comunicacao.setDestinatarioEmail(rs.getString("destinatarioEmail"));
            comunicacao.setRemetenteNome(rs.getString("remetenteNome"));
            comunicacao.setRemetenteTelefone(rs.getString("remetenteTelefone"));
            comunicacao.setRemetenteEmail(rs.getString("remetenteEmail"));
            comunicacao.setData(rs.getDate("data"));
            comunicacoes.add(comunicacao);
        }
        return true;
    }

    @Override
    public boolean Delete(Comunicacao comunicacao) throws Exception {
        Connection conn = DerbyDbConnection.getInstancia().getConexao();
        PreparedStatement pst = conn.prepareStatement("DELETE FROM SA.COMUNICACAO WHERE IDCOMUNICACAO = ?");
        pst.setInt(1, comunicacao.getIdComunicacao());
        pst.executeUpdate();

        return true;
    }

}
