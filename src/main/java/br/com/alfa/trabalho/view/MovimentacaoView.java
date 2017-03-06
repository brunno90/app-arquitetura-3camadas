package br.com.alfa.trabalho.view;


import br.com.alfa.trabalho.model.Conta;
import br.com.alfa.trabalho.model.Movimentacao;
import br.com.alfa.trabalho.model.TipoMovimentacao;
import br.com.alfa.trabalho.service.MovimentacaoService;
import br.com.alfa.trabalho.view.comum.BaseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Iagho Fernandes
 */
@Controller
@Scope("view")
public class MovimentacaoView extends BaseView {

    @Autowired
    MovimentacaoService service;
    private Movimentacao entity;
    private List<Movimentacao> list;

    @PostConstruct
    public void createNew() {
        entity = new Movimentacao();
        entity.setConta(new Conta());
        list = new ArrayList<>();
        connect();
    }

    public void loadLevel1() {
        try {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 5001);
                service = (MovimentacaoService) registry.lookup("movimentacao");
                list = service.findAll();
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        } finally {

        }

    }

    public void save() {
        try {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 5001);
                service = (MovimentacaoService) registry.lookup("movimentacao");
                service.save(entity);
                addMessageWARN("Movimentação Salva!");
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        } finally {

        }

    }

    private void connect() {
        try {
            Registry registry = LocateRegistry.createRegistry(5001);
            registry.bind("movimentacao", service);
            System.out.println("Servidor Compras Iniciado...");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public TipoMovimentacao[] getTipoMov() {
        return TipoMovimentacao.values();
    }

    public Movimentacao getEntity() {
        return entity;
    }

    public void setEntity(Movimentacao entity) {
        this.entity = entity;
    }

    public List<Movimentacao> getList() {
        return list;
    }

    public void setList(List<Movimentacao> list) {
        this.list = list;
    }
}
