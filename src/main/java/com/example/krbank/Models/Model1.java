package com.example.krbank.Models;

import com.example.krbank.Views.AccountType;
import com.example.krbank.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model1 {
    private static Model1 model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private AccountType loginAccountType = AccountType.CLIENT;

    // Client Data Section
    private final Client client;
    private boolean clientLoginSuccessFlag;
    private boolean adminLoginSuccessFlag;

    private Model1() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // Client Data Section
        this.clientLoginSuccessFlag = false;
        this.client = new Client("", "", "", null, null, null);

        // Admin Data Section
        this.adminLoginSuccessFlag = false;

    }

    public static synchronized Model1 getInstance() {
        if (model == null) {
            model = new Model1();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver() {return databaseDriver;}

    /*
     * Client Method Section
     * */
    public boolean getClientLoginSuccessFlag() {return this.clientLoginSuccessFlag;}

    public void setClientLoginSuccessFlag(boolean flag) {this.clientLoginSuccessFlag = flag;}

    public Client getClient() {
        return client;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public void evaluateClientCred(String pAddress, String password) {
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.pAddressProperty().set(resultSet.getString("PayeeAddress"));
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.client.dateProperty().set(date);
//                checkingAccount = getCheckingAccount(pAddress);
//                savingsAccount = getSavingsAccount(pAddress);
//                this.client.checkingAccountProperty().set(checkingAccount);
//                this.client.savingsAccountProperty().set(savingsAccount);
                this.clientLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
     * Admin Method Section
     * */

    public boolean getAdminLoginSuccessFlag() {return this.adminLoginSuccessFlag;}

    public void setAdminLoginSuccessFlag(boolean adminLoginSuccessFlag) {
        this.adminLoginSuccessFlag = adminLoginSuccessFlag;
    }

    public void evaluateAdminCred(String username, String password) {
        ResultSet resultSet = databaseDriver.getAdminData(username, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.adminLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
