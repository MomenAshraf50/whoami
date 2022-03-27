package com.example.whoami;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalitiesFactorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalitiesFactorsFragment extends Fragment {
    String formationFactors,factorOne,factorTwo,factorThree,factorFour,factorFive,factorSix,factorSeven;
    TextView textViewFormationFactors,textViewFactorOne,textViewFactorTwo,textViewFactorThree,
    textViewFactorFour,textViewFactorFive,textViewFactorSix,textViewFactorSeven;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PersonalitiesFactorsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonalitiesFactorsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonalitiesFactorsFragment newInstance(String param1, String param2) {
        PersonalitiesFactorsFragment fragment = new PersonalitiesFactorsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personalities_factors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewFormationFactors = view.findViewById(R.id.home_tv_app_formation_factors);
        textViewFactorOne = view.findViewById(R.id.factor_one);
        textViewFactorTwo = view.findViewById(R.id.factor_two);
        textViewFactorThree = view.findViewById(R.id.factor_three);
        textViewFactorFour = view.findViewById(R.id.factor_four);
        textViewFactorFive = view.findViewById(R.id.factor_five);
        textViewFactorSix = view.findViewById(R.id.factor_six);
        textViewFactorSeven = view.findViewById(R.id.factor_seven);
        data();
        setData();
    }

    public void data(){
        formationFactors = "Each person has a unique personality that distinguishes him from others and grew up with him as an instinct in him or acquired from his surroundings, so the outward appearance or lifestyle is not enough to evaluate people, so analytical studies must be applied to clarify the nature of their personality and the personality of the individual depends on many factors, including:";
        factorOne = "Some characteristics of an individual's behavior are hereditary that we inherit from parents or grandparents, such as physical height or innocence, intellectual ability, ability to learn and strength, and all of this has a great influence on our behavior patterns.";
        factorTwo = "It is one of the influences that have a clear impact on the individual, whether through different behaviors or ideas, and their source is from his home, school, or society.";
        factorThree ="The social and economic status of the family and the education of the parents and other family members constitute the personality of the individual to a large extent, and in fact the family members themselves try to influence the behavior of the children in a desperate attempt to diagnose their values and roles further.";
        factorFour = "It is the combination of rapid understanding, the ability to learn, the ability to adapt to the environment and benefit from all previous experiences, and individuals differ in their levels of intelligence.";
        factorFive = "constitutes the value and tendencies of personality as it is the unique feature of a social group, the values and standards shared by its members distinguish it from other social groups. The essence of culture is the collective programming of the mind according to anthropological concepts. Culture is linked to a common system of beliefs, attitudes, properties, traits, habits and the values that determine the behavior of the group, so culture plays an important role in influencing the behavior of the individual.";
        factorSix = "The health and strength of the body provides a source of confidence or weakness and regression, and the integrity of the mind, such as the power of remembering and thinking, builds a part of the human personality and contributes to the secretions of the various glands in his body to keep him in balance.";
        factorSeven = "It is an important element in the formation of personality. It affects the human psyche clearly in the behavior. The mood of the individual may be impulsive and dominant as inherited or emotional traits acquired from those around him.";
    }
    public void setData(){
        textViewFormationFactors.setText(formationFactors);
        textViewFactorOne.setText(factorOne);
        textViewFactorTwo.setText(factorTwo);
        textViewFactorThree.setText(factorThree);
        textViewFactorFour.setText(factorFour);
        textViewFactorFive.setText(factorFive);
        textViewFactorSix.setText(factorSix);
        textViewFactorSeven.setText(factorSeven);
    }
}