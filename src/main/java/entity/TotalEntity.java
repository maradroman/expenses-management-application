package entity;

public class TotalEntity {
    private Double total;
    private String currency;

    public TotalEntity(Double total, String currency) {
        if (total!=0.0){
            this.currency = currency;
        }
        this.total = total;
    }



    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "entity.TotalEntity{" +
                "total=" + total +
                ", currency='" + currency + '\'' +
                '}';
    }

}
