/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.capstone.info;

/**
 *
 * @author Afshin
 */
public class User {
    private int databaseID;
    private String idEmail;
    private String password;
    private String firstName;
    private String lastName;

    /**
     * @return the databaseID
     */
    public int getDatabaseID() {
        return databaseID;
    }

    /**
     * @param databaseID the databaseID to set
     */
    public void setDatabaseID(int databaseID) {
        this.databaseID = databaseID;
    }

    /**
     * @return the idEmail
     */
    public String getIdEmail() {
        return idEmail;
    }

    /**
     * @param idEmail the idEmail to set
     */
    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
