package com.example.hackathon2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchFunctionActivity extends AppCompatActivity {

    private ListView listSearch;
    private EditText editSearch;
    private ArrayAdapter<String> tempArrayAdapter;
    private ArrayList<String> temp = new ArrayList<>();

    // inside of each of these, we pull information from each website about which plants they have.
    String [] homeDepotPlantsList = {
            "Rose", "Blueberry plant", "Tulip", "Lily", "Carnation", "Peach", "Cherry",
            "Cherry Blossom", "Nightshade", "Lavender", "Lilac", "Magnolia"
    };
    String [] lowesPlantsList = {
            "Rose", "Tulip", "Carnation", "Sweet Pea", "Sweet William", "Pine", "Apricot", "Peach"
    };
    String [] amazonPlantsList = {
            "Rhododendron", "Chamomile", "Parsley", "Thyme", "Sage", "Rosemary", "Sweet Pea",
            "Peach", "Rose", "Pear", "Apple"
    };

    String [] namesOfStores = {
            "Home Depot", "Lowes", "Amazon"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_function);

        // connecting activity to xml components
        listSearch = findViewById(R.id.listSearch);
        editSearch = findViewById(R.id.editSearch);

        // adding each plant into temp:
        for (String plant : homeDepotPlantsList) {
            temp.add("Home Depot: " + plant);
        }
        for (String plant : lowesPlantsList) {
            temp.add("Lowes: " + plant);
        }
        for (String plant : amazonPlantsList) {
            temp.add("Amazon: " + plant);
        }

        // setting array adapter, which sets the information displayed in the searchview
        tempArrayAdapter = new ArrayAdapter<>
                (this, R.layout.list_item, R.id.textViewListItem, temp);
        listSearch.setAdapter(tempArrayAdapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            // as user types, plants are deleted if they don't contain correct letters
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                SearchFunctionActivity.this.tempArrayAdapter.getFilter().filter(charSequence);
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}