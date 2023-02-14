package com.example.first_project;

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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    List<ModelClass> list;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public Adapter() {
    }

    // constructor
    public Adapter(List<ModelClass> list, Context context) {
        this.list = list;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
     //   LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
       // View view = inflater.inflate(R.layout.item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        ModelClass usersModelClass = list.get(position);

        holder.textViewID.setText(Integer.toString(usersModelClass.getId()));
        holder.editText_Name.setText(usersModelClass.getName());
        holder.editText_Password.setText(usersModelClass.getPassword());

        // onClick for update Btn
        holder.button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = holder.editText_Name.getText().toString();
                String stringPassword = holder.editText_Password.getText().toString();

                databaseHelperClass.updateUsers(new ModelClass(usersModelClass.getId(),stringName,stringPassword));
                notifyItemChanged(position);
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
                }

        });

        // onClick for delete Btn
        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteUsers(usersModelClass.getId());
                list.remove(position);
                Toast.makeText(context, "Deleted successfully", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    // ViewHolder class
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Password;
        Button button_update;
        Button button_delete;

        // constructor for ViewHolder
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.textId);
            editText_Name = itemView.findViewById(R.id.etName);
            editText_Password= itemView.findViewById(R.id.etPassword);
            button_delete = itemView.findViewById(R.id.deleteBtn);
            button_update = itemView.findViewById(R.id.updateBtn);

        }
    }
}
