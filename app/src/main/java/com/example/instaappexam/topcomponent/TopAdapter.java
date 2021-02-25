package com.example.instaappexam.topcomponent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instaappexam.R;

import java.util.List;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.TopViewHolder>{

    private static final String TAG = "TopAdapter";
    private final List<TopItem> topList;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public TopAdapter(List<TopItem> topList) {
        this.topList = topList;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public TopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // xml에 있는 그림이 메모리에 올라오는과정 : inflate
        View view = inflater.inflate(R.layout.top_component_item, parent, false);
        return new TopViewHolder(view); // ViewHolder에 view를 꼽아서 반환함 ~
        // 하단의 MyViewHolder 생성자로 가보자
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull TopViewHolder holder, int position) {
        holder.setItem(topList.get(position));
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return topList.size();
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    class TopViewHolder extends RecyclerView.ViewHolder{

        private TextView tvYourStory;

        public TopViewHolder(@NonNull View itemView) {
            super(itemView);
            // 뷰 객체에 대한 참조. (hold strong reference)
            tvYourStory = itemView.findViewById(R.id.tv_your_story);
        }

        public void setItem(TopItem topItem){
            tvYourStory.setText(topItem.getYourStory());
        }
    }
}
