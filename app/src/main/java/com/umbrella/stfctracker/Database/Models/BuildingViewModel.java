package com.umbrella.stfctracker.Database.Models;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.umbrella.stfctracker.DataTypes.Enums.Group;
import com.umbrella.stfctracker.Database.Entities.Building;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BuildingViewModel extends AndroidViewModel {
    private BuildingRepository mRepos;
    private Group currentGroup = null;

    private List<Building> usedBuildings;
    private LiveData<List<Building>> liveDataList;

    public BuildingViewModel(@NonNull Application application) {
        super(application);

        mRepos = new BuildingRepository(application);
        liveDataList = mRepos.getLiveBuildings();
    }

    public LiveData<List<Building>> getAllBuildingsLive() {
        return liveDataList;
    }

    public List<Building> collectBuildingsByGroup(List<Building> unsortedBuildings) {
        List<Building> newList = unsortedBuildings.stream()
                .filter(building -> building.getGroup().equals(currentGroup))
                .filter(building -> building.getLevels().stream().anyMatch(level ->
                        level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel()))
                .sorted().collect(Collectors.toCollection(LinkedList::new));

        usedBuildings = newList;
        return newList;
    }

    public List<Building> collectAllBuildings(List<Building> unsortedBuildings) {
        List<Building> oldList = new ArrayList<>(unsortedBuildings);
        List<Building> newList = new ArrayList<>();

        //Transfers the operation building.
        Optional<Building> optOps = oldList.stream().filter(building -> building.getName().equalsIgnoreCase("Operations")).findFirst();
        optOps.ifPresent(ops -> new swap(oldList, newList, ops));

        //Transfers all buildings without a group.
        List<Building> foundNone = oldList.stream()
                .filter(building -> building.getGroup().equals(Group.NONE)) //of group NONE
                .filter(building ->
                        building.getLevels().stream().anyMatch(level -> //Number of levels accessible at current Ops level.
                                level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel())
                ).sorted()
                .collect(Collectors.toList());

        new swap(oldList, newList, foundNone);

        List<Building> accessibleGroupItems = oldList.stream()
                .filter(building ->
                        building.getLevels().stream().anyMatch(level -> //Number of levels accessible at current Ops level.
                                level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel())
                ).collect(Collectors.toList());

        //Remove all elements from the old list that do not occur in the accessibleGroupItems
        oldList.retainAll(accessibleGroupItems);

        List<Building> retainedList = new LinkedList<>();

        //Loop till all items have been placed out of the oldList
        while (!oldList.isEmpty()) {
            Building currentItem = oldList.get(0);

            //Number of buildings of the current group.
            if (1 < accessibleGroupItems.stream().filter(building -> building.getGroup().equals(currentItem.getGroup())).count()) {
                //Sublist is needed, create empty building item to exist as a sublist item.
                retainedList.add(Building.createEmptyBuilding(currentItem.getGroup()));
                oldList.removeIf(building -> building.getGroup().equals(currentItem.getGroup()));
            } else {
                //Only one item of the group, can be placed as single item.
                new swap(oldList, retainedList, currentItem);
            }
        }
        //Place first the single items in the list followed by the group items.
        newList.addAll(retainedList.stream().filter(building -> building.getLevels().size() != 0).sorted().collect(Collectors.toList()));
        newList.addAll(retainedList.stream().filter(building -> building.getLevels().size() == 0).sorted().collect(Collectors.toList()));

        usedBuildings = newList;
        return newList;
    }

    public void setCurrentGroup(Group currentGroup) {
        this.currentGroup = currentGroup;
    }

    private static final class swap {
        private swap(List<Building> from, List<Building> to, List<Building> items) {
            to.addAll(items);
            from.removeAll(items);
        }

        private swap(List<Building> from, List<Building> to, Building item) {
            to.add(item);
            from.remove(item);
        }
    }

    public void addItemTouchHelperTo(RecyclerView recyclerView, Context context) {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START | ItemTouchHelper.END) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Building building = usedBuildings.get(viewHolder.getAdapterPosition());

                if (building.getLevels().stream().filter(level -> level.getLevel() == 1).collect(Collectors.toList()).get(0)
                        .getRequiredOperationsLevel() != building.getUnlockedLevel()) {

                    mRepos.levelDown(building);

                    Toast.makeText(context, context.getString(R.string.lower_down_confirmation, building.getName()), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, context.getString(R.string.lowest_level_warning, building.getName()), Toast.LENGTH_SHORT).show();
                }
                Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);
    }
}

