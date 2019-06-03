package com.example.navigationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

public class HomeFragment extends Fragment implements View.OnClickListener {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.navigate_destination_button).setOnClickListener(this);
        view.findViewById(R.id.navigate_action_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigate_destination_button:
                NavOptions.Builder builder = new NavOptions.Builder();
                builder.setEnterAnim(R.anim.slide_in_right);
                builder.setExitAnim(R.anim.slide_out_left);
                builder.setPopEnterAnim(R.anim.slide_in_left);
                builder.setPopExitAnim(R.anim.slide_out_right);

                //NavHostFragment.findNavController(this).navigate(R.id.flow_step_one_dest, null);
                NavHostFragment.findNavController(this).navigate(R.id.flow_step_one_dest, null, builder.build());
                break;
            case R.id.navigate_action_button:
                break;
            default:
                break;
        }
    }
}
