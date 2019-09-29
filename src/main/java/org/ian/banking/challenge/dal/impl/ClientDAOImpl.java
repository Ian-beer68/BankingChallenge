package org.ian.banking.challenge.dal.impl;

import org.ian.banking.challenge.dal.ClientDAO;
import org.ian.banking.challenge.domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientDAOImpl implements ClientDAO {
    private static final Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    public int createNewClient(Client client) {

        return 0;
    }
}
