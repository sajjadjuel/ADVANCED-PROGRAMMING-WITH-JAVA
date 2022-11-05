package com.repository;

import com.domain.Tax;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import sun.dc.pr.PRError;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaxRepository {

    private DataSource dataSource;

    private static final String ALL = "select * from tax";
    private static final String variableALL = "select * from tax_variable";
    private static final String SELECT_ONE = "select * from tax where id = ?";
    private static final String CREATE = "insert into tax (category, zone, salary, rent, medical, conveyance, ot, bonus, invest, tax, check_date ) values (?, ?,?, ?,?, ?,?, ?,?, ?, ?)";

    //private static final String UPDATE = "update tax_variable set rentExemptionRate = ? , rentExemptionSet = ? , medicalExemptionRate = ? , medicalExemptionSet = ?, conveyanceSet = ? where id = ?";
    private static final String UPDATE = "update tax set salary = ?, rent = ?, medical = ?, conveyance = ?, ot = ?, bonus = ?, invest = ? where id = ?";
    private static final String DELETE = "delete from tax where id = ?";

    public TaxRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Tax> list() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(ALL);
        return mapper(resultSet);
    }

    public Tax get(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Tax tax = new Tax();
        while (resultSet.next()) {
            tax.setId(resultSet.getLong(1));
        }
        return tax;
    }

    public boolean create(Tax tax, Model model) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
        double calculate_tax = tax.Calculation(tax.getCategory(),tax.getZone(),tax.getBasic(),tax.getRent(),tax.getMedical(),tax.getConveyance(),tax.getOt(),tax.getBonus());

        double payable_tax = tax.rebate(calculate_tax,tax.getInvestment());
        preparedStatement.setString(1, tax.getCategory() );
        preparedStatement.setString(2, tax.getZone() );
        preparedStatement.setLong(3, tax.getBasic() );
        preparedStatement.setLong(4, tax.getRent() );
        preparedStatement.setLong(5, tax.getMedical() );
        preparedStatement.setLong(6, tax.getConveyance() );
        preparedStatement.setLong(7, tax.getOt() );
        preparedStatement.setLong(8, tax.getBonus() );
        preparedStatement.setLong(9, tax.getInvestment() );
        preparedStatement.setDouble(10, payable_tax);
        preparedStatement.setDate(11, Date.valueOf(LocalDate.now()));
        model.addAttribute("payable",payable_tax);
        return preparedStatement.execute();
    }

    public boolean update(Tax tax) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setLong(1, tax.getBasic() );
        preparedStatement.setLong(2, tax.getRent() );
        preparedStatement.setLong(3, tax.getMedical() );
        preparedStatement.setLong(4, tax.getConveyance() );
        preparedStatement.setLong(5, tax.getOt() );
        preparedStatement.setLong(6, tax.getBonus() );
        preparedStatement.setLong(7, tax.getInvestment() );
        preparedStatement.setLong(8, tax.getId() );
        return preparedStatement.execute();
    }

    public boolean delete(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setLong(1, id);
        return preparedStatement.execute();
    }

    private List<Tax> mapper(ResultSet resultSet) throws SQLException {
        List<Tax> taxs = new ArrayList<>();
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
        return taxs;
    }

}
