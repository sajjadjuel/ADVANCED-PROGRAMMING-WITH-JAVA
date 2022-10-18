package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private DataSource dataSource;

    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<h1>Hello Java<h1>");
    }

    @RequestMapping("/greet")
    public String greet() {
        return "home";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", "Mir Md Kawsur");
        return "welcome";
    }

    @RequestMapping("/register-form")
    public String registrationForm() {
        return "registration";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Registration Page: " + request.getParameter("username"));
        return "registration";
    }

    @RequestMapping("/register/v2")
    public String registerTwo(@ModelAttribute("firstname") String firstname, @ModelAttribute("lastname") String lastname, Model model) {
        model.addAttribute("firstname", firstname);
        model.addAttribute("lastname", lastname);
        return "welcome";
    }

    @RequestMapping("/data")
    public void getData() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while(resultSet.next()) {
            System.out.println(resultSet.getLong(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }
    }

    @RequestMapping("/data/create")
    public void createData() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into users (email, password) values (?, ?)");
        statement.setString(1, "test2@aiub.edu");
        statement.setString(2, "78910");
        statement.execute();
    }

    @RequestMapping("/data/update")
    public void createUpdate() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("update users set email = ?, password = ? where id = ?");
        statement.setString(1, "test3@aiub.edu");
        statement.setString(2, "111555");
        statement.setLong(3, 2);
        statement.executeUpdate();
    }
    @RequestMapping("/data/delete")
    public void deleteData() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from users where id = ?");
        statement.setLong(1, 2);
        statement.execute();
    }
    @RequestMapping("/calculator-form")
    public String calculatorForm() {
        return "calculator";
    }
    @RequestMapping("/calculator/v2")
    public String Calc(@ModelAttribute("firstvalue") int firstvalue, @ModelAttribute("secondvalue") int secondvalue,@ModelAttribute("operator") char operator, Model model) throws SQLException {
        model.addAttribute("firstvalue", firstvalue);
        model.addAttribute("secondvalue", secondvalue);
        model.addAttribute("operator", operator);
        int result=0;

        if(operator=='+')
        {
            model.addAttribute("result", firstvalue+secondvalue);
            result= firstvalue+secondvalue;
        }
        else if (operator=='-') {
            result= firstvalue-secondvalue;
            model.addAttribute("result", firstvalue-secondvalue);
        }
        else if (operator=='*') {
            result= firstvalue*secondvalue;
            model.addAttribute("result", firstvalue*secondvalue);
        }
        else if (operator=='/') {
             result= firstvalue/secondvalue;
            model.addAttribute("result", firstvalue/secondvalue);
        }


        model.addAttribute("result", result);
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into calc (value1, value2, Result) values (?, ?, ?)");
        statement.setLong(1, firstvalue);
        statement.setLong(2, secondvalue);
        statement.setLong(3, result);
        statement.execute();

        return "calculated";
    }

    @RequestMapping("/calculator/input")
    public void calculator() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into users (email, password) values (?, ?,?)");
        statement.setString(1, "test2@aiub.edu");
        statement.setString(2, "789");
        statement.execute();
    }
}
