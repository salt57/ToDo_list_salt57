package com.example.todo_list.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todo_list.MainActivity;
import com.example.todo_list.Model.ToDoModel;
import com.example.todo_list.R;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private List<ToDoModel> todoList;
    private MainActivity activity;

    public ToDoAdapter(MainActivity activity){
        this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        ToDoModel item = todoList.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(toBoolean(item.getStatus()));
        holder.tag.setText(item.getTag());
    }
    private boolean toBoolean (int n){
        return n!=0;
    }
    public int getItemCount(){
        return todoList.size();
    }
    public void setTasks(List<ToDoModel> todoList){
        this.todoList = todoList;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox task;
        TextView tag;
        ViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
            tag = view.findViewById(R.id.todoTag);
        }
    }
}
