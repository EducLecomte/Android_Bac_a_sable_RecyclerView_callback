package com.bas.bac_a_sable_recyclerview_callback;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    // 1 - Création d'une interface pour le callback
    public interface Listener {
        void onClickButton(int position);
    }

    // 2 - Déclaration du callback
    private final Listener callback;
    private List<MyObject> list;

    // 3 - Passage d'une instance de callback a travers le constucteur
    public MyAdapter(List<MyObject> list, Listener callback) {
        this.list = list;
        this.callback = callback;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_cards, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        MyObject myObject = list.get(position);
        // 4 - Passing an instance of callback through each ViewHolder
        myViewHolder.bind(myObject, this.callback);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public MyObject getObject(int position){
        return this.list.get(position);
    }


}
