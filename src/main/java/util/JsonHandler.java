package util;

import com.google.gson.Gson;
import entity.ExpenseEntity;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonHandler {
    public static JSONObject jsonObject;
    public static Date date;
    public static String formattedDate;
    public static double amount;
    public static String currency;
    public static String product;

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
        jsonObject = new JSONObject(getBody(request));

        try {
            date = format.parse(jsonObject.getString("date"));
            formattedDate = format.format(date);
            amount = Double.parseDouble(jsonObject.getString("amount"));
            currency = jsonObject.getString("currency");
            product = jsonObject.getString("product");
        } catch (Exception e) {
            e.printStackTrace();

        }
        expense.setAmount(amount);
        expense.setDate(formattedDate);
        expense.setCurrency(currency);
        expense.setProduct(product);
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
