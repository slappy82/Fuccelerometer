package com.me.fuccelerometer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.me.fuccelerometer.databinding.FragmentLandingscreenBinding;

public class LandingScreenFragment extends Fragment {

    private FragmentLandingscreenBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLandingscreenBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonLandingToAccel.setOnClickListener(v ->
                NavHostFragment.findNavController(LandingScreenFragment.this)
                        .navigate(R.id.action_LandingScreenFragment_to_AccelerometerFragment)
        );

        binding.buttonLandingToGyro.setOnClickListener( v ->
                NavHostFragment.findNavController( LandingScreenFragment.this)
                        .navigate(R.id.action_LandingScreenFragment_to_GyroscopeFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}