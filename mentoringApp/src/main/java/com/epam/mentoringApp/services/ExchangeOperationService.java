package com.epam.mentoringApp.services;

import java.math.BigDecimal;
import java.util.List;

import com.epam.mentoringApp.dto.AccountDto;
import com.epam.mentoringApp.dto.CurrencyOperationDto;
import com.epam.mentoringApp.dto.ExchangeOperationDto;
import com.epam.mentoringApp.dto.UserDto;
import com.epam.mentoringApp.model.ExchangeOperation;

public interface ExchangeOperationService extends IBasicService<ExchangeOperation, ExchangeOperationDto, Long>{

    List<ExchangeOperationDto> findByUser(UserDto user);

    void exchange(AccountDto fromAccountDto, AccountDto toAccountDto,
            CurrencyOperationDto currencyOperationDto, BigDecimal amount,
            UserDto userDto);
}
