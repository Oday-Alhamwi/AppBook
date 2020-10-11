package com.app.appbook;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class BookDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView item_container;
    private TextView txt_title, txt_read, txt_share, txt_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        item_container = findViewById(R.id.item_container);
        txt_title = findViewById(R.id.txt_title);
        txt_read = findViewById(R.id.txt_read);
        txt_share = findViewById(R.id.txt_share);
        txt_delete = findViewById(R.id.txt_delete);


        String title = getIntent().getExtras().getString("title");
        String cover = getIntent().getExtras().getString("cover");
        txt_title.setText(title);

        if (cover.equals("cover1.png")) {
            item_container.setBackgroundResource(R.drawable.cover1);
        } else if (cover.equals("cover2.png")) {
            item_container.setBackgroundResource(R.drawable.cover2);
        } else if (cover.equals("cover3.png")) {
            item_container.setBackgroundResource(R.drawable.cover3);
        } else if (cover.equals("cover4.png")) {
            item_container.setBackgroundResource(R.drawable.cover4);
        } else {
            item_container.setBackgroundResource(R.drawable.ic_launcher_background);
        }
        txt_share.setOnClickListener(this);
        txt_read.setOnClickListener(this);
        txt_delete.setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.txt_read:
                Toast.makeText(getApplicationContext(), "Read", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_share:
                Toast.makeText(getApplicationContext(), "Book had Shared", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_delete:
                Toast.makeText(getApplicationContext(), "Book had Deleted", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}