package com.epam.mentoringApp.dao;

import java.util.List;

import com.epam.mentoringApp.model.ExchangeOperation;
import com.epam.mentoringApp.model.User;

public interface ExchangeOperationDao extends BaseDao<ExchangeOperation, Long>{

    List<ExchangeOperation> findByUser(User user);
}
