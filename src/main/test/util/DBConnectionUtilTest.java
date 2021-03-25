package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DBConnectionUtilTest {

    @Test
    void openConnection() {
        assertDoesNotThrow(() -> DBConnectionUtil.openConnection());
    }
}