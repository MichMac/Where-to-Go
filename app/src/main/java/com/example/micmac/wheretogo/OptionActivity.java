package com.example.micmac.wheretogo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class OptionActivity extends AppCompatActivity {

    private Button Clear_button;
    private Button Selected_button;
    private Button Option_button;
    private ListView Category_list;
    public static final String TAG = "ListViewExample";
    public static final String ELEMENT = "Item cleared: ";

    private ArrayAdapter<String> adapter ;
    String[] Categories =
            {
                    "Bar",
                    "Szpital",
                    "Mechanik",
                    "Stacja benzynowa",
                    "Sklep z elektroniką",
                    "Fryzjer",
                    "Sklep monopolowy",
                    "Kino",
                    "Klub nocny",
                    "Parking",
                    "Restauracja",
                    "Centrum handlowe",
                    "Sklep spożywczy",
                    "Supermarket"

            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        Clear_button = (Button)findViewById(R.id.clear_button);
        Selected_button = (Button)findViewById(R.id.selected_button);
        Option_button = (Button)findViewById(R.id.map_button);

        Option_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
            }
        });

        /*
        Category_list = (ListView)findViewById(R.id.category_list);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                Categories);

        Category_list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        Category_list.setAdapter(adapter);

        Selected_button.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {


                String selected = "";

                int cntChoice = Category_list.getCount();

                SparseBooleanArray sparseBooleanArray = Category_list.getCheckedItemPositions();

                for(int i = 0; i < cntChoice; i++){

                    if(sparseBooleanArray.get(i)) {

                        selected += Category_list.getItemAtPosition(i).toString() + "\n";
                    }

                }
                Toast.makeText(OptionActivity.this, selected, Toast.LENGTH_LONG).show();
            }});
        */

        Category_list = (ListView)findViewById(R.id.category_list);

        Category_list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        Category_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "OnItemClick"+position);
                CheckedTextView v = (CheckedTextView) view;
                boolean currentCheck = v.isChecked();
                Category category = (Category)Category_list.getItemAtPosition(position);
                category.setActive(!currentCheck);
            }
        });

        Category bar = new Category("Bar","bar");
        Category hospital = new Category("Szpital","hospital");
        Category car_repair = new Category("Mechanik","car_repair");
        Category gas_station = new Category("Stacja benzynowa","gas_station");
        Category electronic_store = new Category("Sklep z elektroniką","eletronic_store");
        Category hair_care = new Category("Fryzjer","hair_care");
        Category liquir_store = new Category("Sklep monopolowy","liquir_store");
        Category movie_theater = new Category("Kino","movie_theater");
        Category night_club = new Category("Klub nocny","night_club");
        Category parking = new Category("Parking","parking");
        Category restaurant = new Category("Restauracja","restaurant");
        Category shopping_mall = new Category("Cetrum handlowe","shopping_mall");
        Category store = new Category("Sklep spożywczy","store");
        Category supermarket = new Category("Supermarket","supermarket");

        Category[] categories = new Category[]{
                bar,
                hospital,
                car_repair,
                gas_station,
                electronic_store,
                hair_care,
                liquir_store,
                movie_theater,
                night_club,
                parking,
                restaurant,
                shopping_mall,
                store,
                supermarket
        };

        ArrayAdapter<Category> arrayAdapter
                = new ArrayAdapter<Category>(this,android.R.layout.simple_list_item_checked,categories);

        Category_list.setAdapter(arrayAdapter);

        Selected_button.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                String selected = "";

                int itemCount = Category_list.getCount();

                SparseBooleanArray sparseBooleanArray = Category_list.getCheckedItemPositions();

                for(int i = 0; i < itemCount; i++){

                    if(sparseBooleanArray.get(i)) {

                        selected += Category_list.getItemAtPosition(i).toString() + "\n";
                    }
                }
                if(selected == "")
                {
                    Toast.makeText(OptionActivity.this, "Nie wybrano kategorii", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(OptionActivity.this, selected, Toast.LENGTH_LONG).show();
                }

            }});

        Clear_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SparseBooleanArray sparseBooleanArray = Category_list.getCheckedItemPositions();

                int itemCount = Category_list.getCount();

                for(int i=0; i < itemCount; i++){
                    if(Category_list.isItemChecked(i)){
                        Category_list.setItemChecked(i,false);
                    }
                }

            }
        });

    }
}
