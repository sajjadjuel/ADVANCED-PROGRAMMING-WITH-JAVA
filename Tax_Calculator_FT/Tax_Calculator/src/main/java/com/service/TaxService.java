package com.service;

import com.domain.Tax;
//import com.repository.LeaveApplicationImplRepository;
import com.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaxService  {

    private TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @Transactional
    public Tax insert(Tax tax) {
        return taxRepository.create(tax);
    }

    @Transactional(readOnly = true)
    public Tax get(Long id) {
        return taxRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Tax> getAll() {
        return taxRepository.getAll();
    }

    @Transactional
    public Tax update(Tax tax) {
        return taxRepository.update(tax);
    }

    @Transactional(readOnly = true)
    public List<Tax> getByUserId(Long user_id) {
        return taxRepository.getByUserId(user_id);
    }
    @Transactional
    public void delete(Long id) {
        taxRepository.delete(id);
    }

}
