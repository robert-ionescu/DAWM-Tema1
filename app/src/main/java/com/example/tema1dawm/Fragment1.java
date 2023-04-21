package com.example.tema1dawm;

import static java.util.Arrays.asList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ListView animalsListView;
    static ArrayAdapter<String> arrayAdapter;
    SharedPreferences sharedPreferences;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animalsListView = (ListView)view.findViewById(R.id.animals_list_view);
        Animal a1 = new Animal("Câine", "Europa");
        Animal a2 = new Animal("Elefant", "Africa");
        Animal a3 = new Animal("Vulpe", "America de Nord");
        Animal a4 = new Animal("Pinguin", "Antarctica");
        Animal a5 = new Animal("Leu", "Africa");
        Animal a6 = new Animal("Urs", "America de Nord");
        Animal a7 = new Animal("Tigru", "Asia");
        Animal a8 = new Animal("Girafa", "Africa");
        Animal a9 = new Animal("Cangur", "Australia");
        Animal a10 = new Animal("Zebra", "Africa");
        Animal a11 = new Animal("Crocodil", "Australia");
        Animal a12 = new Animal("Lup", "Europa");
        Animal a13 = new Animal("Balena", "Oceanul Atlantic");
        Animal a14 = new Animal("Maimuță", "America de Sud");
        Animal a15 = new Animal("Bufniță", "Europa");
        Animal a16 = new Animal("Rinocer", "Africa");
        Animal a17 = new Animal("Delfin", "Oceanul Pacific");
        Animal a18 = new Animal("Koala", "Australia");
        Animal a19 = new Animal("Iguană", "America de Sud");
        Animal a20 = new Animal("Pisică sălbatică", "Europa");
        Animal a21 = new Animal("Găină", "Asia");
        Animal a22 = new Animal("Veveriță", "America de Nord");
        Animal a23 = new Animal("Albatros", "Oceanul Indian");
        Animal a24 = new Animal("Armadil", "America de Sud");
        Animal a25 = new Animal("Pește clown", "Oceanul Pacific");
        Animal a26 = new Animal("Hipopotam", "Africa");
        Animal a27 = new Animal("Porc spinos", "Australia");
        Animal a28 = new Animal("Ponei", "Europa");
        Animal a29 = new Animal("Gazela", "Africa");
        Animal a30 = new Animal("Căprioară", "Europa");
        Animal a31 = new Animal("Tapir", "America de Sud");
        Animal a32 = new Animal("Lemur", "Madagascar");
        Animal a33 = new Animal("Cameleon", "Africa");
        Animal a34 = new Animal("Șopârlă", "America de Sud");
        Animal a35 = new Animal("Fluture", "Asia");
        Animal a36 = new Animal("Păianjen", "America de Nord");
        Animal a37 = new Animal("Cobai", "America de Sud");
        Animal a38 = new Animal("Porumbel", "Europa");
        Animal a39 = new Animal("Arici", "Asia");
        Animal a40 = new Animal("Focă", "Antarctica");
        Animal a41 = new Animal("Iepure", "Europa");
        Animal a42 = new Animal("Suricată", "Africa");
        Animal a43 = new Animal("Morsă", "Oceanul Arctic");
        Animal a44 = new Animal("Bizon", "America de Nord");
        Animal a45 = new Animal("Pelicani", "Africa");
        Animal a46 = new Animal("Cal", "Europa");
        Animal a47 = new Animal("Cățeluș", "America de Sud");
        Animal a48 = new Animal("Pui de urs", "America de Nord");
        Animal a49 = new Animal("Pitbull", "Romania");
        Animal a50 = new Animal("Panda", "Africa");



        ArrayList<Animal> animals = new ArrayList<Animal> (asList(
                a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                a11, a12, a13, a14, a15, a16, a17, a18, a19, a20,
                a21, a22, a23, a24, a25, a26, a27, a28, a29, a30,
                a31, a32, a33, a34, a35, a36, a37, a38, a39, a40,
                a41, a42, a43, a44, a45, a46, a47, a48, a49,a50)
        );

        ArrayList <String> animalsData = new ArrayList<String>();
        for(int index = 0; index< animals.size(); index++)
        {
            animalsData.add(animals.get(index).displayAnimal());
        }
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, animalsData);
        animalsListView.setAdapter(arrayAdapter);

        animalsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity mainActivity =(MainActivity)getActivity();
                sharedPreferences = mainActivity.getApplicationContext().getSharedPreferences("com.example.tema1dawm", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("animal", animals.get(i).getName()).apply();
                sharedPreferences.edit().putString("continent", animals.get(i).getContinent()).apply();
                replaceFragment(new Fragment2());
            }
        });
    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();//getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Log.i("change", "ok");
    }
}