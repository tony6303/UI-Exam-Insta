package com.example.instaappexam.midcomponent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instaappexam.R;

import org.w3c.dom.Text;

import java.util.List;

public class MidAdapter extends RecyclerView.Adapter<MidAdapter.MidViewHolder>{

    private final List<MidItem> midList;

    public MidAdapter(List<MidItem> midList) {
        this.midList = midList;
    }

    @NonNull
    @Override
    public MidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // xml에 있는 그림이 메모리에 올라오는과정 : inflate
        View view = inflater.inflate(R.layout.mid_component_item, parent, false);
        return new MidViewHolder(view); // ViewHolder에 view를 꼽아서 반환함 ~
        // 하단의 MyViewHolder 생성자로 가보자
    }

    @Override
    public void onBindViewHolder(@NonNull MidViewHolder holder, int position) {
        holder.setItem(midList.get(position));
    }

    @Override
    public int getItemCount() {
        return midList.size();
    }

    class MidViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_username;

        public MidViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_username = itemView.findViewById(R.id.tv_username);
        }

        public void setItem(MidItem midItem){
            tv_username.setText(midItem.getUsername());
        }
    }
}
