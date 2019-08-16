package com.pratik.aeroyog;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

public class AttendanceFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view1 = inflater.inflate(R.layout.fragment_attend, container, false);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.circle_green, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_green, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_red, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_green, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_green, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_green, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_red, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_red, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_green, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_green, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_green, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_red, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_green, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_green, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));
        exampleList.add(new ExampleItem(R.drawable.circle_red, "Saturday, June 1, 2019", "6:30 to 7:30 a.m."));

        mRecyclerView = view1.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



        return view1;
    }


}