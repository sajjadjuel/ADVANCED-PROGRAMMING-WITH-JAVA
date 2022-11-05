package com.controller;

import com.domain.Tax;
import com.repository.TaxRepository;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/taxs")
public class TaxController {
    private TaxRepository taxRepository;

    public TaxController(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/history")
    public String list(Model model) throws SQLException {

        model.addAttribute("taxs", taxRepository.list());

        return "tax/History";
    }

    @RequestMapping("/Tax_Calculator")
    public String createForm(Model model) {
        model.addAttribute("tax", new Tax());
        return "tax/Home";
    }

    @RequestMapping("/calculate")
    public String create(@Valid @ModelAttribute("tax") Tax tax, Model model, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "tax/Home";
        }
        taxRepository.create(tax,model);
       //return "redirect:/taxs/history";
        return "tax/result";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("taxId") Long taxId) throws SQLException {
        taxRepository.delete(taxId);
        return "redirect:/taxs/history";
    }

}
