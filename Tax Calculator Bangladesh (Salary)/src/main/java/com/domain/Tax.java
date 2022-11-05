package com.domain;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class Tax {
    private Long id;

    private String name;
    private String category;
    private String zone;
    private Long basic;
    private Long bonus;
    private Long ot;
    private Long medical;
    private Long investment;
    private Long conveyance;
    private Long rent;
    private double taxes;

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double tax;
    public double taxable= 0;

    public Long getConveyance() {
        return conveyance;
    }

    public void setConveyance(Long conveyance) {
        this.conveyance = conveyance;
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public Long getBasic() {
        return basic;
    }

    public void setBasic(Long basic) {
        this.basic = basic;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    public Long getOt() {
        return ot;
    }

    public void setOt(Long ot) {
        this.ot = ot;
    }

    public Long getMedical() {
        return medical;
    }

    public void setMedical(Long medical) {
        this.medical = medical;
    }

    public Long getInvestment() {
        return investment;
    }

    public void setInvestment(Long investment) {
        this.investment = investment;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private Date createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }


    public double Calculation(String Category, String Zone, Long Basic, double Rent, double Medical, double Conveyance, Long Ot, Long Bonus)
    {
        double cal_tax = 0;

        if (Rent!=0) {
            double rentExemption=0;
            rentExemption=Basic*.5;
            if(rentExemption>300000)
                rentExemption=300000;

            if (Rent > rentExemption) {
                Rent = Rent - rentExemption;
            } else {
                Rent = 0l;
            }
        }
        if(Medical!=0) {
            double medicalExemption=0;
            medicalExemption=Basic*.1;
            if(medicalExemption>300000)
                medicalExemption=300000;
            if (Medical > medicalExemption) {
                Medical = Medical - medicalExemption;
            } else {
                Medical = 0l;
            }
        }

        if(Conveyance!=0) {
            if (Conveyance > 30000) {
                Conveyance = Conveyance - 30000;
            } else {
                Conveyance = 0l;
            }
        }

        taxable= Basic+Rent+Medical+Conveyance+Bonus+Ot;
        if(Category.equals("General") )
            cal_tax=generalCal(300000);
        else if (Category.equals("Female/Senior Citizen")) {
            cal_tax=generalCal(350000);
        }
        else if (Category.equals("Disabled")) {
            cal_tax=generalCal(450000);
        }
        else if (Category.equals("Gazetted Freedom Fighters")) {
            cal_tax=generalCal(475000);
        }



        return cal_tax;
    }

    private double generalCal(int variable) {
        double cal_tax=0;
        if (taxable >variable) {
            taxable=taxable-variable;

            if (taxable > 100000) {
                taxable=taxable-100000;

                double calculated=100000*0.05;
                cal_tax = cal_tax + calculated;
            }
            else if (taxable < 100000) {

                double calculated=taxable*0.05;
                cal_tax=cal_tax + calculated;
                return cal_tax;
            }
            if (taxable > 300000) {
                taxable=taxable-300000;

                double calculated=300000*0.1;
                cal_tax=cal_tax + calculated;
            }
            else if (taxable < 300000) {

                double calculated=taxable*0.1;
                cal_tax = cal_tax + calculated;
                return cal_tax;
            }
            if (taxable > 400000) {
                taxable=taxable-400000;

                double calculated=400000*0.15;
                cal_tax = cal_tax + calculated;
            }
            else if (taxable < 400000) {

                double calculated=taxable*0.15;
                cal_tax = cal_tax + calculated;
                return cal_tax;
            }
            if (taxable > 500000) {
                taxable=taxable-500000;

                double calculated=500000*0.20;
                cal_tax = cal_tax + calculated;
            }
            else if (taxable < 500000) {

                double calculated=taxable*0.20;
                cal_tax=cal_tax + calculated;
                return cal_tax;
            }
            double calculated=taxable*0.25;
            cal_tax=cal_tax + calculated;
            return cal_tax;

        }
        else {cal_tax=0.0;}
        return cal_tax;
    }

    public double rebate(double calculate_tax, Long investment) {
        double finalTax;
        finalTax = calculate_tax-investment*.15;
        if(taxable>=300000)
        {
            if(finalTax<=4000)
                return 4000;

        }
        if(finalTax<=0)
            return 0;
        return finalTax;
    }


}
