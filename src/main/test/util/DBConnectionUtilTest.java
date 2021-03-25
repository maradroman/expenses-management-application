package util;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionUtilTest {

    @Test
    void openConnection() {
        assertDoesNotThrow(() -> DBConnectionUtil.openConnection());
    }

    @Test
    void checkIfOpenConnectionReturnsNotNullValue(){
        assertNotNull(DBConnectionUtil.openConnection());
    }
}