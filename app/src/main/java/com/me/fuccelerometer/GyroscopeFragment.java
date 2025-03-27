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

import com.me.fuccelerometer.databinding.FragmentGyroscopeBinding;

public class GyroscopeFragment extends Fragment {

    private FragmentGyroscopeBinding binding;
    GyroscopeViewModel gyroViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentGyroscopeBinding.inflate(inflater, container, false);
        gyroViewModel = new ViewModelProvider(this).get(GyroscopeViewModel.class);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonGyroToAccel.setOnClickListener(v ->
                NavHostFragment.findNavController(GyroscopeFragment.this)
                        .navigate(R.id.action_GyroscopeFragment_to_AccelerometerFragment)
        );
    }

    @Override
    public void onResume() {
        super.onResume();

        gyroViewModel.gyroX.observe(this, newString -> binding.textViewGyroXValue.setText(newString));
        gyroViewModel.gyroY.observe(this, newString -> binding.textViewGyroYValue.setText(newString));
        gyroViewModel.gyroZ.observe(this, newString -> binding.textViewGyroZValue.setText(newString));
    }
}