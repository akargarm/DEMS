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
public class Expense {
    private String expenseDescription;
    private BigDecimal amountExpense;

    /**
     * @return the expenseDescription
     */
    public String getExpenseDescription() {
        return expenseDescription;
    }

    /**
     * @param expenseDescription the expenseDescription to set
     */
    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    /**
     * @return the amountExpense
     */
    public BigDecimal getAmountExpense() {
        return amountExpense;
    }

    /**
     * @param amountExpense the amountExpense to set
     */
    public void setAmountExpense(BigDecimal amountExpense) {
        this.amountExpense = amountExpense;
    }
}
