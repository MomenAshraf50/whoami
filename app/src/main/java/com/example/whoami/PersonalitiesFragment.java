package com.example.whoami;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalitiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalitiesFragment extends Fragment {
    List<PersonalityDetails> personalityDetailsList = new ArrayList<>();
    RecyclerView recyclerView;
    PersonalitiesAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PersonalitiesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonalitiesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonalitiesFragment newInstance(String param1, String param2) {
        PersonalitiesFragment fragment = new PersonalitiesFragment();
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
        return inflater.inflate(R.layout.fragment_personalities, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        personalityData();
        recyclerView = view.findViewById(R.id.personalities_rv);
        adapter = new PersonalitiesAdapter(personalityDetailsList,requireContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    public void personalityData(){
        personalityDetailsList.add(new PersonalityDetails(R.drawable.psychopathic,"Psychopathic Personality",
                "It is an anti-social personality, any person who shows patterns of manipulation and violation of others, which contradicts this behavior with the rules and behaviors of society, and he is a person with a mental illness called “psychopathy” but does not adopt the official diagnosis, some people develop psychopathy when 18 years old, but some signs of behavioral disorder appear since childhood, and the cause of psychopathy is gender, which males are more susceptible to this disease and be genetics, behavioral disorder, exposure to trauma, or unstable childhood.",
                "Have a high level of intelligence."
                ,"General disregard for responsibility and safety (behavior modification)."
                ,"Emotional immaturity and lack of judgment (behavior modification)."
                ,"Outward impulsivity from voluntary control (behavior modification)."
                ,"Not showing sympathy and regret over things."
                ,"Taking this disorder in a harmful or anti-social direction (behavior modification)."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.compulsive,"Compulsive Personality",
                "It is a permanent pattern of internal emotions, feelings, and external behavior and appears in perception, emotion, affection, impulse control, interaction with surrounding people, and this pattern is permanent and long-term and controls personal or social situations and usually leads This disorder tends to be orderly, elegant, and perfect, and its people feel a strong need to impose their own standards on their external environment.",
                "Often experience social isolation (behavior modification)."
                ,"They have difficulty forming and maintaining close relationships with others."
                ,"They work hard but their obsession with perfection can make them ineffective (behavior modification)."
                ,"They do not follow the whims of others, believing that they have the right opinion,"
                ,"They choose their friends very carefully, but they have many acquaintances."
                ,"Everything is subject to the workings of the mind."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.hysterical,"Hysterical Character",
                " It is a term in which a person seeks attention, attention and the attention of his companions with emotional reactions and exaggeration in describing situations and people suffering from depression and the emergence and focus of the focus on the cause of a defect in the house. The product of exposure to the breasts the product of exposure to the breasts is the effect of their owners on temptation. The central nervous system is largely caused by genetics",
                "Self-love and caring about himself."
                ,"Feeling uncomfortable (behavior modification)."
                ,"Great attention to appearance and its sustainability to attract attention."
                ,"Overlooking defects and seeking to fix them (behavior modification)."
                ,"Their emotions are childish, volatile, complex, and superficial."
                ,"The strength of the ability to be patient and persevere (reinforcement of behavior)."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.passionate,"Passionate Personality"
                ,"The strong feeling, energy, and strength that come from focusing on what excites you. She is a character who is both lively and emotional. She is one of the personalities who is very interested in achieving her desires and achieving scientific and social success. He is someone who loves strength and leadership, has strong management and can sometimes be ruthless, owners give people around them hope for a happy and exciting future and they feel that they have a purpose and that they are right. Steady steps in life."
                ,"A character who devoted his life to making dreams come true."
                ,"Sometimes she starts her day early and prefers morning to evening."
                ,"Surrounding herself with her work “work is life” (behavior modification)."
                ,"Pushing forward with full force (behavior modification)."
                ,"It has a special charm and is inspiring to others."
                ,"High concentration and keenness not to waste time on secondary matters."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.persecuted,"Persecuted Character"
                ,"He is a person who loves controversy, fierce defender of his opinions, sticks to his ideas, masters the role of victim, and you will not be able to win against him in any debate because he has a tremendous ability. To come out with millions of arguments and justifications why he is right while he restricts your freedom and invades your personal space and questions your movements and follows the details of your life and activities moment by moment Under the feeling that he takes care of you and loves you Always does not trust others because he loses confidence in everything in life He is always sensitive and skeptical about others and his reasons They are the environmental factor, motivation, genetic factor and recurrent psychological traits."
                ,"Fear of using something against him (behavior modification)."
                ,"very sensitive and does not accept anything."
                ,"Does not accept criticism (behavior modification)."
                ,"Discharge arrogance from within."
                ,"The patient's suspicion of a life partner (behavior modification)."
                ,"Bad and unjustified explanations (behavior modification)."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.inferiority,"Inferiority Personality"
                ,"It is an unconscious psychological deficiency in which a person feels a physical, psychological, or social deficiency or deficiency in a way that affects his behavior. Beyond this feeling, it seems to be complicated by the multiplication and intensification of feelings of inferiority through frustration or feeling of inferiority for various reasons in life such as gender, race, family, social class, mental or physical health appearance and they don't feel they can solve or master."
                ,"He is satisfied with the marginal roles in life."
                ,"Assuming a lower rank in dealing with others (behavior modification)."
                ,"Always rely on others."
                ,"Lacks a sense of confidence and independence (behavior modification)."
                ,"Exaggeration in thanking those around him."
                ,"Always convinced that he is in a state of submission and surrender (behavior modification)."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.introverted,"introverted Personality"
                ,"Set in the 1960s, a character who tends to exist in quiet environments far from human gatherings to regain her energy. Too much human interaction, so it pushes them to withdraw from some social situations, which can sometimes make them appear rude, and it is a trait that focuses on self and personal feelings rather than external factors and sources of motivation, and their presence in the world ranges from 25% to 40%."
                ,"They have great charisma."
                ,"He does not tend to start the conversation and does not prefer to engage in regular short conversations (behavior modification)."
                ,"Others tend to consult him and take his opinion on many difficult and sensitive life decisions."
                ,"He usually avoids situations of confrontation, conflict and disagreement."
                ,"He tends to meditate alone, like daydreaming."
                ,"Sensitive to mood, irritable."));
        personalityDetailsList.add(new PersonalityDetails(R.drawable.narcissistic,"Narcissistic Personality"
                ,"It is a psychological state in which there is a feeling of exaggeration of importance, as well as a deep need for increased attention and admiration, disorder of relationships, lack of empathy for others, but behind this exaggerated mask of overconfidence is weak. Self-confidence that makes him vulnerable to the least amount of criticism and this disorder causes many problems in areas of life such as relationships, work or finances, and they are not satisfied with their relationships most of the time and get frustrated in general. Among the causes of this disorder are: Environment: incompatibility in relationships through excessive admiration or excessive criticism, genetic factors ,Neurobiology: the link between the brain, behavior and thinking."
                ,"Arrogance and arrogance, then arrogance and boasting (behavior modification)."
                ,"Difficulty dealing with enemies."
                ,"Exaggerating their achievements and talents."
                ,"Stay away from their enemies to appear superior."
                , "Monopolizing speech and belittling those who look at them (behavior modification)."
                ,"They envy others and think that others limit them as well."));
    }
}