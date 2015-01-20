package com.epam.mentoringApp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.epam.mentoringApp.dao.ExchangeOperationDao;
import com.epam.mentoringApp.model.ExchangeOperation;
import com.epam.mentoringApp.model.User;

@Repository
public class ExchangeOperationDaoImpl extends GenericJpaDaoImpl<ExchangeOperation, Long> implements
        ExchangeOperationDao {

    public ExchangeOperationDaoImpl() {
        super(ExchangeOperation.class);
    }

    @Override
    public List<ExchangeOperation> findByUser(User user) {
        Map<String, Object> criteriaMap = new HashMap<String, Object>();
        criteriaMap.put("user", user);
        return search(criteriaMap);
    }

}
