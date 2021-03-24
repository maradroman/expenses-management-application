package entity;

public class ExpenseEntity {
    private Integer id;
    private String date;
    private Double amount;
    private String currency;
    private String product;

    public ExpenseEntity(Integer id, String date, Double amount, String currency, String product) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.product = product;
    }


    @Override
    public String toString() {
        return "entity.ExpenseEntity{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", product='" + product + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExpenseEntity() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
