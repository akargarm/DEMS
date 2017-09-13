/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.capstone.info;

import java.math.BigDecimal;

/**
 *
 * @author Afshin
 */
public class Income {
    private String incomeDescription;
    private BigDecimal amountIncome;

    /**
     * @return the incomeDescription
     */
    public String getIncomeDescription() {
        return incomeDescription;
    }

    /**
     * @param incomeDescription the incomeDescription to set
     */
    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    /**
     * @return the amountIncome
     */
    public BigDecimal getAmountIncome() {
        return amountIncome;
    }

    /**
     * @param amountIncome the amountIncome to set
     */
    public void setAmountIncome(BigDecimal amountIncome) {
        this.amountIncome = amountIncome;
    }
}
