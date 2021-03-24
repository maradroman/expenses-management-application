package servlet;

import com.google.gson.Gson;
import dao.ExpenseDAO;
import dao.ExpenseDAOImpl;
import entity.ExpenseEntity;
import entity.TotalEntity;
import org.json.JSONException;
import util.CurrencyHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Total", urlPatterns = "/total")
public class TotalServlet extends HttpServlet {
    private static List<ExpenseEntity> expenseArrayList = new ArrayList<>();
    private static ExpenseDAO expenseDAO = new ExpenseDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currency = request.getParameter("base");
        Double exchangeRate = null;
        try {
            exchangeRate = CurrencyHandler.getExchangeRateByCurrency(currency);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        expenseArrayList = expenseDAO.getAll();
        Double finalExchangeRate = exchangeRate;
        Double result = expenseArrayList.stream().reduce(0.0, (sum, expense) -> {
            Double coef = null;
            try {
                coef = CurrencyHandler.getExchangeRateByCurrency(expense.getCurrency());
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return sum + (expense.getAmount() / coef) * finalExchangeRate;
        }, Double::sum);

        result = Math.round(result * 100.0) / 100.0;
        TotalEntity total = new TotalEntity(result, currency);

        sendJson(response, total);

    }

    public static void sendJson(HttpServletResponse response, Object expense) throws IOException {
        String expenseJsonString = new Gson().toJson(expense);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(expenseJsonString);
        out.flush();
    }


//        System.out.println(grouped);

}

