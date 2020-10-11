package com.app.appbook;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private GridLayoutManager gridLayoutManager;
    private RecyclerView recyclerView;
    private ArrayList<Book> mBooks = new ArrayList<>();

    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        bookAdapter = new BookAdapter(getApplicationContext(), mBooks);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(bookAdapter);

        String jsonFileString = getJsonFromAssets(getApplicationContext(), "data.json");
        Log.i("data", jsonFileString);

        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<Book>>() {
        }.getType();

        List<Book> books = gson.fromJson(jsonFileString, listUserType);
        for (int i = 0; i < books.size(); i++) {
            mBooks.add(new Book(books.get(i).getTitle(), books.get(i).getCover()));
        }
        bookAdapter.notifyDataSetChanged();

    }

    static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }

}