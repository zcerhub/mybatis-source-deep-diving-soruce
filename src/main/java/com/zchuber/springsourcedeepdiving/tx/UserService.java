package com.zchuber.springsourcedeepdiving.tx;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation= Propagation.REQUIRED)
public interface UserService {

    void save(User user) throws MyException;

}
