/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.server.client;

import e_exceptions.AuthenticationException;
import e_exceptions.OperationException;
import e_tools.time.TimeToolkit;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import tupinamba.gerencial.core.client.ClientController;
import tupinamba.gerencial.server.client.dto.AppendixDTO;
import tupinamba.gerencial.server.client.dto.ClientDTO;
import tupinamba.gerencial.server.client.dto.ClientParam;
import tupinamba.gerencial.server.client.dto.ClientResponse;

/**
 *
 * @author Mazuhim
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientActionHandler {

    public void save(ClientParam param) throws Exception {

        try (ClientController controller = new ClientController()) {
            controller.newEntity();
            controller.setCpf(param.getCpf());
            controller.setDateBirth(TimeToolkit.parseString(param.getDateBirth()));
            controller.setDocument(param.getDocument());
            controller.setHolder(param.isHolder());
            controller.setIncome(param.getIncome());
            controller.setKinship(param.getKinship());
            controller.setName(param.getName());
            controller.setOccupation(param.getOccupation());
            controller.setSex(param.getSex());

            controller.setAddress(param.getAddress());
            if (param.getAppendix() != null) {
                for (AppendixDTO appendixDTO : param.getAppendix()) {
                    controller.addAppendix(appendixDTO);
                }
            }

            if (param.getPhones() != null) {
                param.getPhones().forEach((phoneDTO) -> {
                    controller.addPhone(phoneDTO);
                });
            }

            controller.save();
        }
    }

    public List<ClientResponse> findClientsResponses() throws Exception {
        try (ClientController controller = new ClientController()) {
            controller.load();
            controller.selectAll();
//            Product p = controller.getProducts().get(0);

            List<ClientResponse> clients = new ArrayList<>();
            controller.getEntities().forEach((c) -> {
                clients.add(controller.toResponse(c));
            });
            return clients;
        }
    }

    public ClientDTO getData(Integer idClient) throws AuthenticationException, OperationException, Exception {
        try (ClientController controller = new ClientController()) {
            if (controller.find(idClient)) {
                return controller.toDTO(controller.getEntity());
            }

            throw new OperationException("Usuario não encontrado");
        }
    }

    public void updateClient(ClientDTO param) throws Exception {
        try(ClientController controller = new ClientController())
        {
            if (controller.find(param.getIdClient())) {
                controller.setAddress(param.getAddress());
                controller.setCpf(param.getCpf());
                controller.setCreationDate(TimeToolkit.parseString(param.getCreationDate()));
                controller.setDateBirth(TimeToolkit.parseString(param.getDateBirth()));
                controller.setDocument(param.getDocument());
                controller.setIdClient(param.getIdClient());
                controller.setIncome(param.getIncome());
                controller.setName(param.getName());
                controller.setOccupation(param.getOccupation());
                controller.setSex(param.getSex());
                
                if (param.isHolder()) {
                    controller.setHolder(param.isHolder());
                } else {
                    controller.setKinship(param.getKinship());
                }
                
                param.getAppendix().forEach((appendix) -> {
                    controller.addAppendix(appendix);
                });
                param.getPhones().forEach((phone) -> {
                    controller.addPhone(phone);
                });
                
                controller.save();
            } else{
                throw new OperationException("Usuario não encontrado");
            }
        }
    }

}
