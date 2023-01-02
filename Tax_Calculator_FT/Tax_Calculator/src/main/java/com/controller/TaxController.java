package com.controller;

import com.domain.Tax;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.CurrencyService;
//import com.service.LeaveApplicationService;
import com.service.TaxService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/*@Controller*/
@RestController
@RequestMapping("/tax")
public class TaxController {

    private TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @CrossOrigin
    @PostMapping("/calc")
    public ResponseEntity<Tax> createCurrency(@Valid @RequestBody Tax tax) throws Exception {
        if (tax.getId() != null) {
            throw new BadRequestAlertException("A new leave application cannot have an id value");
        }
        System.out.println(tax);
        taxService.insert(tax);
        return ResponseEntity.created(new URI("/calc/"))
                .body(tax);
    }

    @PutMapping("/calc")
    public ResponseEntity<Tax> updateCurrency(@Valid @RequestBody Tax tax) throws Exception {
        if (tax.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        taxService.update(tax);
        return ResponseEntity.created(new URI("/calc/"))
                .body(tax);
    }
    @CrossOrigin
    @GetMapping("/calc")
    public ResponseEntity<List<Tax>> getAllCurrency() {
        List<Tax> tax = taxService.getAll();
        //System.out.println(tax.);
        return ResponseEntity.ok().body(tax);
    }

    @GetMapping("/calc/{id}")
    public ResponseEntity<Tax> getTax(@PathVariable Long id) {
        Optional<Tax> tax = Optional.ofNullable(taxService.get(id));
        if (tax.isPresent()) {
            return ResponseEntity.ok().body(tax.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }
    @CrossOrigin
    @DeleteMapping("/calc/{id}")
    public ResponseEntity<Tax> deleteTax(@PathVariable Long id) {
        taxService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @GetMapping("/tax_history/{user_id}")
    public ResponseEntity<List<Tax>> getAllTaxHistory(@PathVariable Long user_id) {
        System.out.println(user_id);
        List<Tax> tax = taxService.getByUserId(user_id);
        System.out.println(tax);
        return ResponseEntity.ok().body(tax);
    }



   /* @PostMapping("/rate")
    public ResponseEntity<Tax> createCurrency(@Valid @RequestBody Currency currency) throws Exception {
        if (currency.getId() != null) {
            throw new BadRequestAlertException("A new leave application cannot have an id value");
        }
        System.out.println(currency);
        currencyService.insert(currency);
        return ResponseEntity.created(new URI("/rate"))
                .body(currency);
    }*/


}
