package dao;

import entity.ExpenseEntity;

import java.util.Date;
import java.util.List;

public interface ExpenseDAO {
    ExpenseEntity addExpense(ExpenseEntity expense);

    List<ExpenseEntity> getAll();

    List<ExpenseEntity> getByDate(Date date);

    boolean deleteExpensesByDate(Date date);
}
