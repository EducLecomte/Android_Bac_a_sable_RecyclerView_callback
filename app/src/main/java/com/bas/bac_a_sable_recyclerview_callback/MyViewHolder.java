package com.bas.bac_a_sable_recyclerview_callback;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    private TextView tvview;
    private Button btnview;
    // 1 - Déclaration d'un WeakReference pour le Callback (instance de moindre importance
    // concernant le "garbage collector")
    private WeakReference<MyAdapter.Listener> callbackWeakRef;

    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);
        //c'est ici que l'on fait nos findView
        tvview = (TextView) itemView.findViewById(R.id.tv_card);
        btnview = (Button) itemView.findViewById(R.id.btn_card);
    }

    // Ajout une fonction pour remplir la cellule en fonction d'un MyObject
    // 2 - ajout de la référence callback reference à la signature
    public void bind(MyObject myObject, MyAdapter.Listener callback){
        tvview.setText(myObject.getText());
        btnview.setText(myObject.getInteger().toString());
        //3 - Implementation du  Listener dans ImageButton
        btnview.setOnClickListener(this);
        //4 - instanciation d'une weakReference à notre Listener
        this.callbackWeakRef = new WeakReference<MyAdapter.Listener>(callback);

    }

    @Override
    public void onClick(View view) {
        // 5 - quand on clic, on appel le callback
        MyAdapter.Listener callback = callbackWeakRef.get();
        if (callback != null) callback.onClickButton(getAdapterPosition());
    }
}
