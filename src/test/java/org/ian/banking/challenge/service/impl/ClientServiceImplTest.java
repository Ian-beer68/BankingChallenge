package org.ian.banking.challenge.service.impl;

import org.ian.banking.challenge.dal.ClientDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {
    @Mock
    private ClientDAO clientDAO;
    @InjectMocks
    private ClientServiceImpl underTest;

    @Test
    public void shouldCreateNewClient() throws Exception {

    }

}