package com.fardoushlab.newsviews.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fardoushlab.newsviews.R;
import com.fardoushlab.newsviews.activities.HomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdPageFragment extends Fragment {
private Button continueBtn;

    public ThirdPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_third_page, container, false);
        continueBtn = view.findViewById(R.id.btn_continue);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HomeActivity.class));
            }
        });

        return  view;
    }

}
