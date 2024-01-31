package com.jallenllc.mongodbspringdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jallenllc.mongodbspringdemo.model.Expense;
import com.jallenllc.mongodbspringdemo.repository.ExpenseRepository;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
        .orElseThrow(() -> new RuntimeException(
            String.format("Cannot Find Expense by ID %s", expense.getId())));
        
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(){
       return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
            String.format("Cannot Find Expense By Name %s", name)
        ));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
