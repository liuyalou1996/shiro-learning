package com.universe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.universe.service.TransactionServiceA;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthTest {

  @Autowired
  private TransactionServiceA serviceA;

  @Test
  public void transactionTest() {
    serviceA.methodA();
  }

}
