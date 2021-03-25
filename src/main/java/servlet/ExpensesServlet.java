package servlet;

import dao.ExpenseDAO;
import dao.ExpenseDAOImpl;
import entity.ExpenseEntity;
import org.json.JSONException;
import org.json.JSONObject;
import util.JsonHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@WebServlet(name = "Expenses", urlPatterns = "/expenses")
public class ExpensesServlet extends HttpServlet {
    public static List<ExpenseEntity> expenseArrayList = new ArrayList<>();
    public static Date date;
    public static String currency;
    static ExpenseDAO expenseDAO = new ExpenseDAOImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExpenseEntity expense = null;
        try {
            expense = JsonHandler.jsonToExpense(request);
        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }
        expense = expenseDAO.addExpense(expense);
        JsonHandler.sendJson(response, expense);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        expenseArrayList = expenseDAO.getAll();
        Map<String, List<ExpenseEntity>> grouped = expenseArrayList.stream().collect(Collectors.groupingBy(x -> x.getDate()));
        JsonHandler.sendJson(response, grouped);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateParameter = req.getParameter("date");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(dateParameter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        expenseArrayList = expenseDAO.getByDate(date);
        try {
            expenseDAO.deleteExpensesByDate(date);
            JsonHandler.sendJson(resp, expenseArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

