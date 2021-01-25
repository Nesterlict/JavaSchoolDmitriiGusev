package ecare.MVC.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private int contractID;

    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;

    @Basic
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    public Tariff getTariff() {return tariff;}

    public void setTariff(Tariff tariff) {this.tariff = tariff;}

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "contract_used_options",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id"))
    private Set<Options> usedOptions = new HashSet<>();

    public Contract() {
    }

    public Contract(String phoneNumber, String status, User user, Tariff tariff) {
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.user = user;
        this.tariff = tariff;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Options> getUsedOptions() {
        return usedOptions;
    }

    public void setUsedOptions(Set<Options> usedOptions) {
        this.usedOptions = usedOptions;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", tariff=" + tariff +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return status == contract.status && phoneNumber.equals(contract.phoneNumber) && user.equals(contract.user) && tariff.equals(contract.tariff) && usedOptions.equals(contract.usedOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, status, user, tariff, usedOptions);
    }
}
