package com.controller;

import com.domain.Tax;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/taxs")
public class TaxController {
    private DataSource dataSource;

    public TaxController(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/history")
    public String list(Model model) throws SQLException {
        List<Tax> taxs = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from tax");
        while (resultSet.next()) {
            Tax tax = new Tax();
            tax.setId(resultSet.getLong(1));
            tax.setCategory(resultSet.getString(2));
            tax.setZone(resultSet.getString(3));
            tax.setBasic(resultSet.getLong(4));
            tax.setRent(resultSet.getLong(5));
            tax.setMedical(resultSet.getLong(6));
            tax.setConveyance(resultSet.getLong(7));
            tax.setOt(resultSet.getLong(8));
            tax.setBonus(resultSet.getLong(9));
            tax.setInvestment(resultSet.getLong(10));
            tax.setTaxes(resultSet.getDouble(11));
            tax.setCreatedOn(resultSet.getDate(12));
            taxs.add(tax);
        }
        model.addAttribute("taxs", taxs);

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

        Date d = new Date(System.currentTimeMillis());
        tax.setCreatedOn(d);
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into tax (category, zone, salary, rent, medical, conveyance, ot, bonus, invest, tax, check_date ) " +
                "values (?, ?,?, ?,?, ?,?, ?,?, ?, ?)");
        ;

        double calculate_tax = tax.Calculation(tax.getCategory(),tax.getZone(),tax.getBasic(),tax.getRent(),tax.getMedical(),tax.getConveyance(),tax.getOt(),tax.getBonus());
        double payable_tax = tax.rebate(calculate_tax,tax.getInvestment());
        statement.setString(1, tax.getCategory() );
        statement.setString(2, tax.getZone() );
        statement.setLong(3, tax.getBasic() );
        statement.setLong(4, tax.getRent() );
        statement.setLong(5, tax.getMedical() );
        statement.setLong(6, tax.getConveyance() );
        statement.setLong(7, tax.getOt() );
        statement.setLong(8, tax.getBonus() );
        statement.setLong(9, tax.getInvestment() );
        statement.setDouble(10, payable_tax);
        statement.setDate(11, tax.getCreatedOn());
        model.addAttribute("payable",payable_tax);


        Integer res = statement.executeUpdate();

       // return "redirect:/taxs/history";
        return "tax/result";
    }

}
