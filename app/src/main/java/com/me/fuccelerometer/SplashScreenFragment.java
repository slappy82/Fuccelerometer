package com.me.fuccelerometer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.me.fuccelerometer.databinding.FragmentSplashscreenBinding;

public class SplashScreenFragment extends Fragment {

    private FragmentSplashscreenBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSplashscreenBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSplashToAccel.setOnClickListener(v ->
                NavHostFragment.findNavController(SplashScreenFragment.this)
                        .navigate(R.id.action_SplashScreenFragment_to_AccelerometerFragment)
        );

        binding.buttonSplashToGyro.setOnClickListener( v ->
                NavHostFragment.findNavController( SplashScreenFragment.this)
                        .navigate(R.id.action_SplashScreenFragment_to_GyroscopeFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}