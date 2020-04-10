package br.com.eliascoelho911.checkablelist;

import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class CheckableListAdapter<T extends CheckableListViewHolder> extends RecyclerView.Adapter<T> {

    private static final int ALL_UNSELECTED = -1;
    private static int selectedIndex = ALL_UNSELECTED;
    private List<CompoundButton> compoundButtonList = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
        CompoundButton compoundButton = holder.getCompoundButton();
        int adapterPosition = holder.getAdapterPosition();
        checkButton(compoundButton, isSelected(adapterPosition));
        manipulateButtonList(holder, compoundButton);
    }

    public void move(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
    }

    public void remove(int position) {
        compoundButtonList.remove(position);
        fixSelectedIndex(position);
    }

    public final void setChecked(CompoundButton compoundButton, boolean checked, int adapterPosition) {
        checkButton(compoundButton, checked);
        if (checked) {
            setSelectedIndex(adapterPosition);
        } else {
            selectedIndex = ALL_UNSELECTED;
        }
    }

    public final void setSelectedIndex(int selectedIndex) {
        try {
            if (!hasSelectedItem()) {
                CheckableListAdapter.selectedIndex = selectedIndex;
            } else if (CheckableListAdapter.selectedIndex != selectedIndex) {
                int oldSelectedIndex = CheckableListAdapter.selectedIndex;
                CheckableListAdapter.selectedIndex = selectedIndex;
                fixSelections(selectedIndex, oldSelectedIndex);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            CheckableListAdapter.selectedIndex = selectedIndex;
        }
    }

    private void fixSelectedIndex(int position) {
        if (selectedIndex == position) {
            selectedIndex = ALL_UNSELECTED;
        } else if (selectedIndex > position){
            selectedIndex--;
        }
    }

    private void fixSelections(int selectedIndex, int oldSelectedIndex) {
        checkButton(oldSelectedIndex, false);
        checkButton(selectedIndex, true);
    }

    private void checkButton(int index, boolean checked) {
        compoundButtonList.get(index).setChecked(checked);
    }

    private void checkButton(CompoundButton compoundButton, boolean checked) {
        compoundButton.setChecked(checked);
    }

    private void manipulateButtonList(@NonNull T holder, CompoundButton compoundButton) {
        if (!buttonHasAdded(compoundButton)) {
            add(holder.getAdapterPosition(), compoundButton);
        }
    }

    private boolean hasSelectedItem() {
        return selectedIndex != ALL_UNSELECTED;
    }

    private void add(int position, CompoundButton compoundButton) {
        compoundButtonList.add(position, compoundButton);
    }

    private void swap(int currentPosition, int newPosition) {
        Collections.swap(compoundButtonList, currentPosition, newPosition);
        if (selectedIndex == currentPosition) {
            selectedIndex = newPosition;
        } else if (selectedIndex == newPosition) {
            selectedIndex = currentPosition;
        }
    }

    private boolean buttonHasAdded(CompoundButton compoundButton) {
        return compoundButtonList.contains(compoundButton);
    }

    private boolean isSelected(int position) {
        return position == selectedIndex;
    }
}
