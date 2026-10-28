package com.example.midexam;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<StudentModel> students;
    private Context context;
    private DBHelper dbHelper;

    public StudentAdapter(List<StudentModel> students, Context context) {
        this.students = students;
        this.context = context;
        this.dbHelper = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.student_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final StudentModel studentModel = students.get(position);

        holder.textViewID.setText("ID: " + studentModel.getId());
        holder.editTextStudentID.setText(studentModel.getStudentId());
        holder.editTextName.setText(studentModel.getName());
        holder.editTextAge.setText(String.valueOf(studentModel.getAge()));

        holder.btnEdit.setOnClickListener(v -> {
            String strStudentID = holder.editTextStudentID.getText().toString();
            String strName = holder.editTextName.getText().toString();
            String strAge = holder.editTextAge.getText().toString();

            if (strStudentID.isEmpty() || strName.isEmpty() || strAge.isEmpty()) {
                Toast.makeText(context, "Mohon isi semua data", Toast.LENGTH_SHORT).show();
                return;
            }

            int age = Integer.parseInt(strAge);
            if (age < 17 || age > 50) {
                Toast.makeText(context, "Umur harus antara 17 - 50", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHelper.updateStudent(new StudentModel(studentModel.getId(), strStudentID, strName, age));
            Toast.makeText(context, "Update Successful", Toast.LENGTH_SHORT).show();

            ((Activity) context).finish();
            context.startActivity(((Activity) context).getIntent());
        });

        holder.btnDelete.setOnClickListener(v -> {
            dbHelper.deleteStudent(studentModel.getId());
            students.remove(position);
            notifyDataSetChanged();
            Toast.makeText(context, "Delete Successful", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewID;
        EditText editTextStudentID, editTextName, editTextAge;
        Button btnEdit, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewID = itemView.findViewById(R.id.textViewID);
            editTextStudentID = itemView.findViewById(R.id.editTextStudentID);
            editTextName = itemView.findViewById(R.id.editTextName);
            editTextAge = itemView.findViewById(R.id.editTextAge);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}