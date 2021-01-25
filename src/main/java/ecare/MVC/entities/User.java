package ecare.MVC.entities;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.*;

import javax.persistence.*;

/**
 * User entity class
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "surname")
    private String surname;

    @Basic
    @Column(name = "birthdate")
    private Date birthdate;

    @Basic
    @Column(name = "passport")
    private String passport;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "balance")
    private BigDecimal balance;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "access_level")
    private String accessLevel;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private final Set<Contract> contracts = new HashSet<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public User() {
    }

    public User(String name, String surname, Date birthdate, String passport, String address, String email, BigDecimal balance, String password, String accessLevel) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.passport = passport;
        this.address = address;
        this.email = email;
        this.balance = balance;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && surname.equals(user.surname) && Objects.equals(birthdate, user.birthdate) && passport.equals(user.passport) && Objects.equals(address, user.address) && email.equals(user.email) && balance.equals(user.balance) && password.equals(user.password) && accessLevel.equals(user.accessLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthdate, passport, address, email, balance, password, accessLevel);
    }
}

