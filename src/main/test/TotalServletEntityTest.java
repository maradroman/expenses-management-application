import entity.TotalEntity;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TotalServletEntityTest {
    TotalEntity totalEntity;

    final Double total = 25.5;
    final String currency = "UAH";
    final Double totalAlter = 100.0;
    final String currencyAlter = "USD";

    @BeforeEach
    void setUp() {
        totalEntity = new TotalEntity(total, currency);
    }


    @org.junit.jupiter.api.Test
    void getTotal() {
        assertEquals(totalEntity.getTotal(), total);
    }

    @org.junit.jupiter.api.Test
    void setTotal() {
        totalEntity.setTotal(totalAlter);
        assertEquals(totalEntity.getTotal(), totalAlter);
    }

    @org.junit.jupiter.api.Test
    void getCurrency() {
        assertEquals(totalEntity.getCurrency(), currency);
    }

    @org.junit.jupiter.api.Test
    void setCurrency() {
        totalEntity.setCurrency(currencyAlter);
        assertEquals(totalEntity.getCurrency(), currencyAlter);
    }
}