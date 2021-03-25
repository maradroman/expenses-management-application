package util;

import com.google.gson.Gson;
import entity.ExpenseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JsonHandlerTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void sendJson() throws IOException {
        ExpenseEntity expense = new ExpenseEntity(12, "2021-04-25", 35.5, "USD", "Salmon");
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        PrintWriter printWriter = Mockito.mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(printWriter);
        assertDoesNotThrow(() -> JsonHandler.sendJson(response, expense));
    }

    @Test
    void jsonToExpense() {
    }

    @Test
    void getBody() {
    }
}