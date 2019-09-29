package org.ian.banking.challenge.dal;

import org.ian.banking.challenge.domain.Client;

public interface ClientDAO {
    int createNewClient(Client client);
}
