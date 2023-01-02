package com.service;

import com.domain.Currency;
//import com.repository.LeaveApplicationImplRepository;
import com.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CurrencyService  {

    private CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Transactional
    public Currency insert(Currency currency) {
        return currencyRepository.create(currency);
    }

    @Transactional(readOnly = true)
    public Currency get(Long id) {
        return currencyRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Currency> getAll() {
        return currencyRepository.getAll();
    }

    @Transactional
    public Currency update(Currency currency) {
        return currencyRepository.update(currency);
    }

    @Transactional
    public void delete(Long id) {
        currencyRepository.delete(id);
    }
}
