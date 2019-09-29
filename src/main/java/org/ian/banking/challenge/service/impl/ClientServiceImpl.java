package org.ian.banking.challenge.service.impl;

import org.ian.banking.challenge.dal.ClientDAO;
import org.ian.banking.challenge.domain.Client;
import org.ian.banking.challenge.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    @Autowired
    private ClientDAO clientDAO;

    @Override
    public String createNewClient(Client client) {
        return null;
    }
}
