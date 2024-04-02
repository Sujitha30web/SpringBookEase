package org.bookerbuddies.bookease.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.owner.Owner;

@Entity
@Data
//@Builder
@AllArgsConstructor
//@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;
    private String name;
    private Double balance;
    private String role;


    public Account() {
        super();
    }


    public Account(String name, Double balance, String role) {
        this.name = name;
        this.balance = balance;
        this.role = role;
    }

    public void setClient(Client client) {
    }
}
