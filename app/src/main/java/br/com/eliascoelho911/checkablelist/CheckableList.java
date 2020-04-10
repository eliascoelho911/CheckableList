package br.com.eliascoelho911.checkablelist;

import android.widget.CompoundButton;

class CheckableList {
    public static void refresh(CheckableListViewHolder itemHolder, CheckableListAdapter adapter) {
        CompoundButton compoundButton = itemHolder.getCompoundButton();
        boolean checked = compoundButton.isChecked();
        adapter.setChecked(compoundButton, checked, itemHolder.getAdapterPosition());
    }
}
