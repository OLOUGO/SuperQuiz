package com.example.superquiz.ui.welcome;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.superquiz.R;
import com.example.superquiz.databinding.FragmentWelcomeBinding;
import com.example.superquiz.ui.quiz.QuizFragment;

public class WelcomeFragment extends Fragment {
     FragmentWelcomeBinding binding ;
    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();

        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.playButton.setEnabled(false);

        // Verifier si la saisie de l'user n'est pas vide et dans ce cas autorisé le clic du button

        binding.usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                boolean isEmpty = editable.toString().isEmpty() ;
                binding.playButton.setEnabled(!isEmpty);


            }
        });

        // Detecter le clic sur le bouton let's play

        binding.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Naviguer vers le fragment de quiz
                Log.d("message","click");

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                QuizFragment quizFragment = new QuizFragment();
                fragmentTransaction.replace(R.id.fragment_container_view_tag,quizFragment);
                fragmentTransaction.commit();
            }
        });
    }
}