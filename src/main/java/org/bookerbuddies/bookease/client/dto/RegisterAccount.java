package org.bookerbuddies.bookease.client.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.bookerbuddies.bookease.account.Account;


//@AllArgsConstructor
@NoArgsConstructor
//@Data
public class RegisterAccount {
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Account account;
    //@NotNull(message = "ID Not to be null")
    //private Integer accountId;

   @NotNull(message="Name should not be null")
   @Pattern(regexp="[a-zA-Z]{2,30}",message="Your name should be min 2& max 30")
   private String name;
//   @NotNull(message="Balance should not be null")
    private Double balance;
//    @NotNull(message="ClientId should not be null")
    private Integer clientId;
//    @NotNull(message="Email should not be null")
    @Email(message = "Email syntax error")
    private String email;
    @NotNull(message="Password should not be null")
    private String password;

    public RegisterAccount(String name, Double balance) {
//        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public RegisterAccount(Integer clientId, String email, String password, String name, Account account) {
        this.name = name;
//        this.balance = balance;
        this.clientId = clientId;
        this.email = email;
        this.password = password;
        this.account=account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

//    public Integer getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(Integer accountId) {
//        this.accountId = accountId;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
