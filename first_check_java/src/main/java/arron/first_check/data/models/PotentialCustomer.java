package arron.first_check.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "potentialCustomer")
public class PotentialCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "job")
    private String job;

    @Column(name = "marriage")
    private String marriage;

    @Column(name = "fk_customer_id")
    private Integer fk_customer_id;

    @Column(name = "stockAmount")
    private Integer stockAmount;

    @Column(name = "realEstateAmount")
    private Integer realEstateAmount;

    @Column(name = "othersAmount")
    private Integer othersAmount;

    public PotentialCustomer(){
    }

    public PotentialCustomer(Long id,String name, String job,String marriage, Integer fk_customer_id, Integer stockAmount, Integer realEstateAmount, Integer othersAmount,Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.marriage = marriage;
        this.job = job;
        this.fk_customer_id = fk_customer_id;
        this.stockAmount = stockAmount;
        this.realEstateAmount  = realEstateAmount;
        this.othersAmount = othersAmount;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public Integer getFk_customer_id() {
        return fk_customer_id;
    }

    public void setFk_customer_id(Integer fk_customer_id) {
        this.fk_customer_id = fk_customer_id;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Integer getRealEstateAmount() {
        return realEstateAmount;
    }

    public void setRealEstateAmount(Integer realEstateAmount) {
        this.realEstateAmount = realEstateAmount;
    }

    public Integer getOthersAmount() {
        return othersAmount;
    }

    public void setOthersAmount(Integer othersAmount) {
        this.othersAmount = othersAmount;
    }


}
