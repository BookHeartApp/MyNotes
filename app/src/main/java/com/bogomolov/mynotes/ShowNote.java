package com.bogomolov.mynotes;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textview.MaterialTextView;

import androidx.fragment.app.Fragment;

public class ShowNote extends Fragment {

    public static final String ARG_INDEX = "index";
    private int index;

    public static ShowNote newInstance(int index) {
        ShowNote f = new ShowNote();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_note, container, false);
        MaterialTextView notesFrag = view.findViewById(R.id.notes);
        TypedArray images = getResources().obtainTypedArray(R.array.Data_Note);
        notesFrag.setText(images.getResourceId(index, -1));
        return view;
    }
}

