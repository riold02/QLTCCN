package com.example.qltccn;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ExpenseAdapter extends ArrayAdapter<Expense> {

    public ExpenseAdapter(Context context, ArrayList<Expense> expenses) {
        super(context, 0, expenses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Expense expense = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_expense, parent, false);
        }

        TextView expenseName = convertView.findViewById(R.id.expenseName);
        TextView expenseDate = convertView.findViewById(R.id.expenseDate);
        TextView expenseAmount = convertView.findViewById(R.id.expenseAmount);

        expenseName.setText(expense.getName());
        expenseDate.setText(expense.getDate());
        expenseAmount.setText(expense.getAmount());

        return convertView;
    }
}