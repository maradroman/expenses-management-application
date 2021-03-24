package util;

import com.google.gson.Gson;
import entity.ExpenseEntity;
import org.json.JSONException;
import org.json.JSONObject;
import servlet.ExpensesServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JsonHandler {
    public static void sendJson(HttpServletResponse response, Object expense) throws IOException {
        String expenseJsonString = new Gson().toJson(expense);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(expenseJsonString);
        out.flush();
    }

    public static ExpenseEntity jsonToExpense(HttpServletRequest request) throws JSONException, ParseException {
        ExpenseEntity expense = new ExpenseEntity();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ExpensesServlet.jsonObject = new JSONObject(getBody(request));

        try {
            ExpensesServlet.date = format.parse(ExpensesServlet.jsonObject.getString("date"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExpensesServlet.formattedDate = format.format(ExpensesServlet.date);
        try {
            ExpensesServlet.amount = Double.parseDouble(ExpensesServlet.jsonObject.getString("amount"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //currency processing
        try {
            ExpensesServlet.currency = ExpensesServlet.jsonObject.getString("currency");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //product processing
        try {
            ExpensesServlet.product = ExpensesServlet.jsonObject.getString("product");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        expense.setAmount(ExpensesServlet.amount);
        expense.setDate(ExpensesServlet.formattedDate);
        expense.setCurrency(ExpensesServlet.currency);
        expense.setProduct(ExpensesServlet.product);
        return expense;
    }

    public static String getBody(HttpServletRequest request) {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
            }
        } catch (IOException ex) {
            // throw ex;
            return "";
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {

                }
            }
        }
        body = stringBuilder.toString();

        return body;
    }
}
