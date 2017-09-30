/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.client;

import e_exceptions.Issue;
import e_exceptions.IssueException;
import e_persistence.services.exceptions.ServiceException;
import e_tools.text.Strings;
import e_tools.time.TimeToolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tupinamba.gerencial.persistence.ServiceFactory;
import tupinamba.gerencial.server.client.dto.AddressDTO;
import tupinamba.gerencial.server.client.dto.AppendixDTO;
import tupinamba.gerencial.server.client.dto.ClientDTO;
import tupinamba.gerencial.server.client.dto.IdentyDocumentDTO;
import tupinamba.gerencial.server.client.dto.PhoneDTO;

/**
 *
 * @author Mazuhim
 */
public class ClientController implements AutoCloseable {

    private List<Client> entities;
    private List<Client> selectedEntities;
    private Client entity;
    private ClientService service;

    public ClientController() {
        this.service = ServiceFactory.openClientService();
        this.entities = new ArrayList<>();
        this.selectedEntities = new ArrayList<>();
    }

    public boolean load() {
        this.entities = service.findAll();
        return this.entities != null;
    }

    public void newEntity() {
        this.entity = new Client();
        this.entity.setCreationDate(new Date());

        this.entities.add(entity);

        this.setSelectedEntity(entity);
    }

    public List<Client> getEntities() {
        return entities;
    }

    public void setEntities(List<Client> entities) {
        this.entities = entities;
    }

    public List<Client> getSelectedEntities() {
        return selectedEntities;
    }

    public void setSelectedEntities(List<Client> selectedEntities) {
        this.selectedEntities = selectedEntities;
        this.entity = selectedEntities.isEmpty() ? null : selectedEntities.get(0);
    }

    public void setSelectedEntities1(List<Client> selectedEntities) {
        this.selectedEntities = selectedEntities;
        this.entity = selectedEntities.isEmpty() ? null : selectedEntities.get(0);
    }

    public void setSelectedEntity(Client client) {
        List<Client> clients = new ArrayList<>();
        clients.add(client);

        this.setSelectedEntities(clients);
    }

    public void selectAll() {
        this.setSelectedEntities(new ArrayList(this.entities));
    }

    public void selectAll1() {
        this.setSelectedEntities1(new ArrayList(this.entities));
    }

    public Client getEntity() {
        return entity;
    }

    public void setEntity(Client entity) {
        this.entity = entity;
    }

    public void save() throws ServiceException, IssueException {
        this.validate();
        this.service.save(this.entity);
    }

    public ClientService getService() {
        return service;
    }

    public void setService(ClientService service) {
        this.service = service;
    }

    @Override
    public void close() throws Exception {
        this.service.close();
    }

    public int getIdClient() {
        return entity.getIdClient();
    }

    public void setIdClient(int idClient) {
        entity.setIdClient(idClient);
    }

    public String getName() {
        return entity.getName();
    }

    public void setName(String name) {
        entity.setName(name);
    }

    public String getKinship() {
        return entity.getKinship();
    }

    public void setKinship(String kinship) {
        entity.setKinship(kinship);
    }

    public boolean isHolder() {
        return entity.isHolder();
    }

    public void setHolder(boolean holder) {
        entity.setHolder(holder);
    }

    public int getSex() {
        return entity.getSex();
    }

    public void setSex(int sex) {
        entity.setSex(sex);
    }

    public Date getDateBirth() {
        return entity.getDateBirth();
    }

    public void setDateBirth(Date dateBirth) {
        entity.setDateBirth(dateBirth);
    }

    public String getCpf() {
        return entity.getCpf();
    }

    public void setCpf(String cpf) {
        entity.setCpf(cpf);
    }

    public String getOccupation() {
        return entity.getOccupation();
    }

    public void setOccupation(String occupation) {
        entity.setOccupation(occupation);
    }

    public double getIncome() {
        return entity.getIncome();
    }

    public void setIncome(double income) {
        entity.setIncome(income);
    }

    public IdentyDocument getDocument() {
        return entity.getDocument();
    }

    public void setDocument(IdentyDocumentDTO documentDTO) {
        IdentyDocument document;
        if (documentDTO.getIdIdentyDocument() == null || documentDTO.getIdIdentyDocument() == 0) {
            document = new IdentyDocument();
            document.setClient(entity);
            document.setExpeditionDate(TimeToolkit.parseString(documentDTO.getExpeditionDate()));
            document.setRegistryEntity(documentDTO.getRegistryEntity());
            document.setRg(documentDTO.getRg());
        } else {
            document = this.service.findDocumentId(documentDTO.getIdIdentyDocument());
        }
        entity.setDocument(document);
    }

    public List<Appendix> getAppendix() {
        return entity.getAppendixList();
    }

    public void setAppendix(List<Appendix> appendix) {
        entity.setAppendixList(appendix);
    }

    public List<Phone> getPhones() {
        return entity.getPhones();
    }

    public void setPhones(List<Phone> phones) {
        entity.setPhones(phones);
    }

    public Date getCreationDate() {
        return entity.getCreationDate();
    }

    public void setCreationDate(Date creationDate) {
        entity.setCreationDate(creationDate);
    }

    public void addAppendix(AppendixDTO appendixDTO) {
        Appendix appendix;
        if (appendixDTO.getIdAppendix() == null || appendixDTO.getIdAppendix() == 0) {
            appendix = new Appendix();
            appendix.setName(appendixDTO.getName());
            appendix.setSize(appendixDTO.getSize());
            appendix.setClient(entity);
        } else {
            appendix = this.service.findAppendix(appendixDTO.getIdAppendix());
        }
        entity.addAppendix(appendix);
    }

    public void removeAppendix(int idAppendix) {
        entity.removeAppendix(idAppendix);
    }

    public Address getAddress() {
        return entity.getAddress();
    }

    public void setAddress(AddressDTO addressDTO) {
        Address address;
        if (addressDTO.getIdAddress() == null || addressDTO.getIdAddress() == 0) {
            address = new Address();
            address.setCep(addressDTO.getCep());
            address.setCity(addressDTO.getCity());
            address.addClient(entity);
            address.setNeighborhood(addressDTO.getNeighborhood());
            address.setNumber(addressDTO.getNumber());
            address.setStreet(addressDTO.getStreet());
            address.setUf(addressDTO.getUf());
        } else {
            address = this.service.findAddress(addressDTO.getIdAddress());
        }
        entity.setAddress(address);
    }

    public void addPhone(PhoneDTO phoneDTO) {
        Phone phone;
        if (phoneDTO.getIdPhone() == null || phoneDTO.getIdPhone() == 0) {
            phone = new Phone();
            phone.setDdd(phoneDTO.getDdd());
            phone.setMainPhone(phoneDTO.isMainPhone());
            phone.setClient(entity);
            phone.setNumber(phoneDTO.getNumber());
        } else {
            phone = this.service.findPhone(phoneDTO.getIdPhone());
        }
        entity.addPhone(phone);
    }

    public void removePhone(int idPhone) {
        entity.removePhone(idPhone);
    }

    public ClientDTO toDTO(Client client) {

        ClientDTO clientDTO = new ClientDTO();

        return null;
    }

    private void validate() throws IssueException {
        IssueException exception = new IssueException();

        this.load();

        if (!Strings.isValid(entity.getCpf())) {
            exception.addIssue(new Issue("CPF inválido", "Por favor digite um cpf valido para o cliente"));
        }
        for (Client entity1 : entities) {
            if (this.entity.getCpf().equals(entity1.getCpf())) {
                exception.addIssue(new Issue("CPF já cadastrado", "Esse CPF já foi cadastrado, por favor verifique se esse cliente já não esta cadastrado no sistema"));
            }
        }

        if (!Strings.isValid(this.entity.getName())) {
            exception.addIssue(new Issue("Nome inválido", "Por favor digite um nome valido para o cliente"));
        }

        if (!this.entity.isHolder() && Strings.isValid(this.entity.getKinship())) {
            exception.addIssue(new Issue("Parentesco invalido", "Se o cliente não for o titular, deve ser informado seu parentesco com o titular do plano"));
        }

        if (this.entity.getDateBirth() == null) {
            exception.addIssue(new Issue("Data de nascimento", "Por favor, indique sua data de nascimento"));
        }
        
        if (!Strings.isValid(this.entity.getOccupation())) {
            exception.addIssue(new Issue("Ocupação", "Por favor informe a ocupação do cliente"));
        }
        
        if (this.entity.getIncome() < 1 ) {
            exception.addIssue(new Issue("Renda", "Por favor informe a renda do cliente"));
        }
        
        if (!exception.isEmpty()) {
            throw exception;
        }
    }

}
