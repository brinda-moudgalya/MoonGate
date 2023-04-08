package com.example.hackathon2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SearchFunctionActivity extends AppCompatActivity {

    private ListView listSearch;
    private EditText editSearch;
    private ArrayAdapter<String> adapter;

    // inside of here, we pull information from each website about which plants they have.
    String [] listsOfPlants = {

    };

    String [] namesOfStores = {
            "Home Depot", "Lowes", "Plant Something Else", "Hello this is a Test."
            // change the above to:
            // listOfPlants for Home Depot
            // listOfPlants for Lowes
            // ...
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_function);

        listSearch = findViewById(R.id.listSearch);
        editSearch = findViewById(R.id.editSearch);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textViewListItem, namesOfStores);
        listSearch.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                SearchFunctionActivity.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}