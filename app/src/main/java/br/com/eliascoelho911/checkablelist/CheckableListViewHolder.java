package br.com.eliascoelho911.checkablelist;

import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class CheckableListViewHolder extends RecyclerView.ViewHolder {

    public CheckableListViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract CompoundButton getCompoundButton();
}
