package com.example.tp08.Bases;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tp08.MainActivity;

public class BaseFragment extends Fragment {

    public MainActivity getContainerActivity(){ return (MainActivity)getActivity(); }

    public void setActivityTitle(String strTitle){
        getContainerActivity().setTitle(strTitle.toUpperCase());

    }

}