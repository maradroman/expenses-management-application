import entity.ExpenseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseEntityTest {
    ExpenseEntity expenseEntity;

    final Integer id = 1;
    final String date = "2021-04-25";
    final Double amount = 35.5;
    final String currency = "USD";
    final String product = "Salmon";

    final Integer idAlter = 2;
    final String dateAlter = "2021-01-12";
    final Double amountAlter = 7.55;
    final String currencyAlter = "EUR";
    final String productAlter = "Jogurt";



    @BeforeEach
    void setUp() {
        expenseEntity = new ExpenseEntity(id, date, amount, currency, product);
    }

    @Test
    void getId() {
        assertEquals(expenseEntity.getId(), id);
    }

    @Test
    void setId() {
        expenseEntity.setId(idAlter);
        assertEquals(expenseEntity.getId(), idAlter);

    }

    @Test
    void getDate() {
        assertEquals(expenseEntity.getDate(), date);
    }

    @Test
    void setDate() {
        expenseEntity.setDate(dateAlter);
        assertEquals(expenseEntity.getDate(), dateAlter);
    }

    @Test
    void getAmount() {
        assertEquals(expenseEntity.getAmount(), amount);
    }

    @Test
    void setAmount() {
        expenseEntity.setAmount(amountAlter);
        assertEquals(expenseEntity.getAmount(), amountAlter);
    }

    @Test
    void getCurrency() {
        assertEquals(expenseEntity.getCurrency(), currency);
    }

    @Test
    void setCurrency() {
        expenseEntity.setCurrency(currencyAlter);
        assertEquals(expenseEntity.getCurrency(), currencyAlter);
    }

    @Test
    void getProduct() {
        assertEquals(expenseEntity.getProduct(), product);
    }

    @Test
    void setProduct() {
        expenseEntity.setProduct(productAlter);
        assertEquals(expenseEntity.getProduct(), productAlter);
    }
}