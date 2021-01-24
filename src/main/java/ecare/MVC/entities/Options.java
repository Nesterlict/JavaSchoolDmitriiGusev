package ecare.MVC.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private int optionID;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "price")
    private BigDecimal price;

    @Basic
    @Column(name = "connection_price")
    private BigDecimal connectionPrice;

    @Basic
    @Column (name = "description")
    private String description;

    @JoinTable(name = "required_options", joinColumns = {
            @JoinColumn(name = "option_id_1", referencedColumnName = "option_id")}, inverseJoinColumns = {
            @JoinColumn(name = "option_id_2", referencedColumnName = "option_id")
    })
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Options> requiredOptions = new HashSet<>();

    @JoinTable(name = "required_options", joinColumns = { // By using 'mappedby' there dependencies
            @JoinColumn(name = "option_id_2", referencedColumnName = "option_id")}, inverseJoinColumns = {  // will not persist
            @JoinColumn(name = "option_id_1", referencedColumnName = "option_id")
    })
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Options> requiredOptionsM = new HashSet<>();

    @JoinTable(name = "exclusive_options", joinColumns = {
            @JoinColumn(name = "option_id_1", referencedColumnName = "option_id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "option_id_2", referencedColumnName = "option_id", nullable = false)
    })
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Options> exclusiveOptions = new HashSet<>();

    @JoinTable(name = "exclusive_options", joinColumns = {
            @JoinColumn(name = "option_id_2", referencedColumnName = "option_id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "option_id_1", referencedColumnName = "option_id", nullable = false)
    })
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Options> exclusiveOptionsM = new HashSet<>();

    @JoinTable(name = "tariff_related_options", joinColumns = {
            @JoinColumn(name = "option_id", referencedColumnName = "option_id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "tariff_id", referencedColumnName = "tariff_id", nullable = false)
    })
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Tariff> tariffRelatedOptions = new HashSet<>();

    @JoinTable(name = "contract_used_options", joinColumns = {
            @JoinColumn(name = "option_id", referencedColumnName = "option_id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "contract_id", referencedColumnName = "contract_id", nullable = false)
    })
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Contract> contractUsedOptions = new HashSet<>();

    public Options(int optionID, String name, BigDecimal price, BigDecimal connectionPrice,String description) {
        this.optionID = optionID;
        this.name = name;
        this.price = price;
        this.connectionPrice = connectionPrice;
        this.description = description;
    }

    public Options(){
    }

    public int getOptionID() {
        return optionID;
    }

    public void setOptionID(int optionID) {
        this.optionID = optionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getConnectionPrice() {
        return connectionPrice;
    }

    public void setConnectionPrice(BigDecimal connectionPrice) {
        this.connectionPrice = connectionPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Options> getRequiredOptions() {
        return requiredOptions;
    }

    public void setRequiredOptions(Set<Options> requiredOptions) {
        this.requiredOptions = requiredOptions;
    }

    public Set<Options> getRequiredOptionsM() {
        return requiredOptionsM;
    }

    public void setRequiredOptionsM(Set<Options> requiredOptionsM) {
        this.requiredOptionsM = requiredOptionsM;
    }

    public Set<Options> getExclusiveOptions() {
        return exclusiveOptions;
    }

    public void setExclusiveOptions(Set<Options> exclusiveOptions) {
        this.exclusiveOptions = exclusiveOptions;
    }

    public Set<Options> getExclusiveOptionsM() {
        return exclusiveOptionsM;
    }

    public void setExclusiveOptionsM(Set<Options> exclusiveOptionsM) {
        this.exclusiveOptionsM = exclusiveOptionsM;
    }

    public Set<Tariff> getTariffRelatedOptions() {
        return tariffRelatedOptions;
    }

    public void setTariffRelatedOptions(Set<Tariff> tariffRelatedOptions) {
        this.tariffRelatedOptions = tariffRelatedOptions;
    }

    public Set<Contract> getContractUsedOptions() {
        return contractUsedOptions;
    }

    public void setContractUsedOptions(Set<Contract> contractUsedOptions) {
        this.contractUsedOptions = contractUsedOptions;
    }

    @Override
    public String toString() {
        return "Options{" +
                "optionID=" + optionID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", connectionPrice=" + connectionPrice +
                ", description='" + description + '\'' +
                ", requiredOptions=" + requiredOptions +
                ", requiredOptionsM=" + requiredOptionsM +
                ", exclusiveOptions=" + exclusiveOptions +
                ", exclusiveOptionsM=" + exclusiveOptionsM +
                ", tariffRelatedOptions=" + tariffRelatedOptions +
                ", contractUsedOptions=" + contractUsedOptions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Options options = (Options) o;
        return name.equals(options.name) && price.equals(options.price) && connectionPrice.equals(options.connectionPrice) && Objects.equals(description, options.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, connectionPrice, description);
    }
}
