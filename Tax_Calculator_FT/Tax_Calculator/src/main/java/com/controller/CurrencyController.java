package com.controller;

import com.domain.Currency;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.CurrencyService;
//import com.service.LeaveApplicationService;
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
@RequestMapping("/chk")
public class CurrencyController {

    private CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @CrossOrigin
    @PostMapping("/currency")
    public ResponseEntity<Currency> createCurrency(@Valid @RequestBody Currency currency) throws Exception {
        if (currency.getId() != null) {
            throw new BadRequestAlertException("A new leave application cannot have an id value");
        }
        System.out.println(currency);
        currencyService.insert(currency);
        return ResponseEntity.created(new URI("/leave-applications/"))
                .body(currency);
    }

    @PutMapping("/currency")
    public ResponseEntity<Currency> updateCurrency(@Valid @RequestBody Currency currency) throws Exception {
        if (currency.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        currencyService.update(currency);
        return ResponseEntity.created(new URI("/leaveApplications/"))
                .body(currency);
    }

    @GetMapping("/currency")
    public ResponseEntity<List<Currency>> getAllCurrency() {
        List<Currency> leaveApplications = currencyService.getAll();
        return ResponseEntity.ok().body(leaveApplications);
    }

    @GetMapping("/currency/{id}")
    public ResponseEntity<Currency> getCurrency(@PathVariable Long id) {
        Optional<Currency> currency = Optional.ofNullable(currencyService.get(id));
        if (currency.isPresent()) {
            return ResponseEntity.ok().body(currency.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }

    @DeleteMapping("/currency/{id}")
    public ResponseEntity<Currency> deleteCurrency(@PathVariable Long id) {
        currencyService.delete(id);
        return ResponseEntity.noContent().build();
    }



   /* @PostMapping("/rate")
    public ResponseEntity<Currency> createCurrency(@Valid @RequestBody Currency currency) throws Exception {
        if (currency.getId() != null) {
            throw new BadRequestAlertException("A new leave application cannot have an id value");
        }
        System.out.println(currency);
        currencyService.insert(currency);
        return ResponseEntity.created(new URI("/rate"))
                .body(currency);
    }*/


}
