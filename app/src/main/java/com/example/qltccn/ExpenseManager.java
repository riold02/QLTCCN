package com.example.qltccn;

import android.util.Log;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.Timestamp;
import java.util.Date;
import java.util.List;

public class ExpenseManager {

    private FirebaseFirestore db;

    public ExpenseManager() {
        db = FirebaseFirestore.getInstance();
    }

    public void addExpense(String name, double amount, String category, List<Expense> expenseList, ExpenseAdapter adapter) {
        Expense expense = new Expense(name, amount, new Timestamp(new Date()), category);

        db.collection("expenses")
                .add(expense)
                .addOnSuccessListener(documentReference -> {
                    Log.d("Firestore", "DocumentSnapshot added with ID: " + documentReference.getId());
                    expenseList.add(expense);
                    adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> {
                    Log.w("Firestore", "Error adding document", e);
                });
    }

    public void deleteExpense(String documentId, List<Expense> expenseList, ExpenseAdapter adapter) {
        db.collection("expenses").document(documentId)
                .delete()
                .addOnSuccessListener(aVoid -> {
                    Log.d("Firestore", "DocumentSnapshot successfully deleted!");
                    adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> {
                    Log.w("Firestore", "Error deleting document", e);
                });
    }

    public void updateExpense(String documentId, String name, double amount, String category, List<Expense> expenseList, ExpenseAdapter adapter) {
        DocumentReference docRef = db.collection("expenses").document(documentId);
        docRef.update("name", name, "amount", amount, "category", category)
                .addOnSuccessListener(aVoid -> {
                    Log.d("Firestore", "DocumentSnapshot successfully updated!");
                    adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> {
                    Log.w("Firestore", "Error updating document", e);
                });
    }
}