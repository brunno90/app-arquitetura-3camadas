package br.com.alfa.trabalho.service.impl;

/**
 * Created by Iagho on 03/03/2017.
 */

import br.com.alfa.trabalho.dao.MovimentacaoDao;
import br.com.alfa.trabalho.dao.exception.DAOException;
import br.com.alfa.trabalho.model.Movimentacao;
import br.com.alfa.trabalho.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.List;

@Service
public class MovimentacaoImpl extends UnicastRemoteObject implements MovimentacaoService {

    @Autowired
    MovimentacaoDao dao;

    public MovimentacaoImpl() throws RemoteException {
        super();
    }

    @Override
    @Transactional
    public void save(Movimentacao movimentacao) throws RemoteException {
        try {
            dao.save(movimentacao);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Movimentacao> findAll() throws RemoteException {
        try {
            return dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
