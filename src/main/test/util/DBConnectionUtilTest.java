package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionUtilTest {

    @Test
    void openConnection() {
        assertDoesNotThrow(()->DBConnectionUtil.openConnection());
    }
}