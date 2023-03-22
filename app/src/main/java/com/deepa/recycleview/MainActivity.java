package com.deepa.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ExampleItem> exampleItems;
    private Button buttonAdd,buttonDelete;
    private EditText editTextAdd, editTextDelete;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonadd);
        buttonDelete = findViewById(R.id.buttondelete);
        editTextAdd = findViewById(R.id.edittextadd);
        editTextDelete = findViewById(R.id.edittextdelete);

        generatedata();
        recyclerViewConfig();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextAdd.getText().toString());
                addCard(position);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextDelete.getText().toString());
                deleteCard(position);
            }
        });

    }
    private void generatedata() {
        exampleItems = new ArrayList<>();
        exampleItems.add(new ExampleItem(R.drawable.one,"Colors are the smiles of nature."));
        exampleItems.add(new ExampleItem(R.drawable.two,"The earth laughs in flowers."));
        exampleItems.add(new ExampleItem(R.drawable.three,"Stars can't shine without darkness."));
        exampleItems.add(new ExampleItem(R.drawable.four,"There is always a reason to smile FIND IT."));
        exampleItems.add(new ExampleItem(R.drawable.five,"The bird is powered by its own life and by its motivation."));
    }

    private void recyclerViewConfig() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter= new ExampleAdapter(exampleItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void addCard(int position) {
        exampleItems.add(position,new ExampleItem(R.drawable.one,"Colors are the smiles of nature."));
        adapter.notifyItemInserted(position);
    }
    private void deleteCard(int position) {
        exampleItems.remove(position);
        adapter.notifyItemRemoved(position);
    }



}