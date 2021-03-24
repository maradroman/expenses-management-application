package dao;

import entity.ExpenseEntity;
import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ExpenseDAOImpl implements ExpenseDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public ExpenseEntity addExpense(ExpenseEntity expense) {
        String sql = "INSERT INTO expenses(date, amount, currency, product) values (?,?,?,?)";
        ExpenseEntity expenseEntity = null;

        try {
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, expense.getDate());
            preparedStatement.setString(2, expense.getAmount().toString());
            preparedStatement.setString(3, expense.getCurrency());
            preparedStatement.setString(4, expense.getProduct());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("SELECT * FROM expenses ORDER BY id DESC LIMIT 1;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                expenseEntity = new ExpenseEntity();
                expenseEntity.setId(resultSet.getInt("id"));
                expenseEntity.setDate(resultSet.getDate("date").toString());
                expenseEntity.setAmount(resultSet.getDouble("amount"));
                expenseEntity.setCurrency(resultSet.getString("currency"));
                expenseEntity.setProduct(resultSet.getString("product"));
            }
            return expenseEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ExpenseEntity> getByDate(Date date) {
        List<ExpenseEntity> list = new ArrayList<>();
        ExpenseEntity expenseEntity = null;

        String sql = "select * from expenses where date=? ORDER BY date";
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {

            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, sqlDate);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                expenseEntity = new ExpenseEntity();
                expenseEntity.setId(resultSet.getInt("id"));
                expenseEntity.setDate(resultSet.getDate("date").toString());
                expenseEntity.setAmount(resultSet.getDouble("amount"));
                expenseEntity.setCurrency(resultSet.getString("currency"));
                expenseEntity.setProduct(resultSet.getString("product"));
                list.add(expenseEntity);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public List<ExpenseEntity> getAll() {
        List<ExpenseEntity> list = new ArrayList<>();
        ExpenseEntity expenseEntity = null;

        String sql = "select * from expenses";
        try {
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                expenseEntity = new ExpenseEntity();
                expenseEntity.setId(resultSet.getInt("id"));
                expenseEntity.setDate(resultSet.getDate("date").toString());
                expenseEntity.setAmount(resultSet.getDouble("amount"));
                expenseEntity.setCurrency(resultSet.getString("currency"));
                expenseEntity.setProduct(resultSet.getString("product"));
                list.add(expenseEntity);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean deleteExpensesByDate(Date date) {
        String sql = "DELETE FROM expenses WHERE date=?";

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            connection = DBConnectionUtil.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
