package br.com.alfa.trabalho.service;

import br.com.alfa.trabalho.model.Movimentacao;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Iagho on 02/03/2017.
 */

public interface MovimentacaoService extends java.rmi.Remote {

    void save(Movimentacao movimentacao) throws RemoteException;

    List<Movimentacao> findAll() throws RemoteException;
}