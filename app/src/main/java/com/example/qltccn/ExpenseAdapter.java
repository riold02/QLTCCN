package com.example.qltccn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class ExpenseAdapter extends ArrayAdapter<Expense> {

    public ExpenseAdapter(Context context, List<Expense> expenses) {
        super(context, 0, expenses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Expense expense = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_expense, parent, false);
        }

        TextView nameTextView = convertView.findViewById(R.id.expenseName);
        TextView amountTextView = convertView.findViewById(R.id.expenseAmount);
        TextView dateTextView = convertView.findViewById(R.id.expenseDate);

        nameTextView.setText(expense.getName());
        amountTextView.setText(String.valueOf(expense.getAmount()));
        dateTextView.setText(expense.getDate().toDate().toString());

        return convertView;
    }
}