package com.example.mynewretrofit.Recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynewretrofit.R;
import com.example.mynewretrofit.ViewModel.model;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.holder>

{
    List<model> data;

    public adapter(List<model> data) {
        this.data = data;

    }




    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.myview,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position)
    {

         System.out.println(data.get(position).getTitle());
        for (int i = 0; i < data.size(); i++) {
            holder.tv1.setText("title "   +data.get(position).getTitle());
            holder.tv2.setText("user id " +data.get(i).getUserId().toString());
            holder.tv3.setText("body" +data.get(i).getBody());
            holder.tv4.setText("id " +data.get(i).getId());

        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class holder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4;
        public holder(@NonNull View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.t1);
            tv2=(TextView)itemView.findViewById(R.id.t2);
            tv3=(TextView)itemView.findViewById(R.id.t3);
            tv4=(TextView)itemView.findViewById(R.id.t4);
        }
    }


}

