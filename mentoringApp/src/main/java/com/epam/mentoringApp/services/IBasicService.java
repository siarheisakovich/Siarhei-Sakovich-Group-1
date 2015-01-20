package com.epam.mentoringApp.services;

import java.io.Serializable;
import java.util.List;

public interface IBasicService<T, DTO, PK extends Serializable> {
    
    DTO create(DTO value);
    
    void update(DTO value);

    void delete(DTO value);
    
    DTO read(PK key);
    
    List<DTO> list();
}
