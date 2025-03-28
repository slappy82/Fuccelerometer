package com.me.fuccelerometer;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.fuccelerometer.databinding.FragmentAccelerometerBinding;

public class AccelerometerFragment extends Fragment {

    private FragmentAccelerometerBinding binding;
    private AccelerometerViewModel accelViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAccelerometerBinding.inflate(inflater, container, false);
        accelViewModel = new ViewModelProvider(this).get(AccelerometerViewModel.class);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonAccelToGyro.setOnClickListener(v ->
                NavHostFragment.findNavController(AccelerometerFragment.this)
                        .navigate(R.id.action_AccelerometerFragment_to_GyroscopeFragment)
        );
    }

    @Override
    public void onResume() {
        super.onResume();

        accelViewModel.accelX.observe(this, newValue -> binding.textViewAccelXValue.setText(newValue));
        accelViewModel.accelY.observe(this, newValue -> binding.textViewAccelYValue.setText(newValue));
        accelViewModel.accelZ.observe(this, newValue -> binding.textViewAccelZValue.setText(newValue));
    }


}