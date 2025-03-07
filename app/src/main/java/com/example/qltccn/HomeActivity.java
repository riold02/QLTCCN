package com.example.qltccn;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListView listView;
    private ExpenseAdapter adapter;
    private List<Expense> expenseList;
    private ExpenseManager expenseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = findViewById(R.id.expensesListView);

        expenseList = new ArrayList<>();
        adapter = new ExpenseAdapter(this, expenseList);
        listView.setAdapter(adapter);

        expenseManager = new ExpenseManager();

        // Ví dụ: Thêm chi tiêu
        expenseManager.addExpense("Groceries", 100.0, "Food", expenseList, adapter);
    }
}