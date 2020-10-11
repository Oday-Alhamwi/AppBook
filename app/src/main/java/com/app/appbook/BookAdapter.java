package com.app.appbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    public Context context;
    public List<Book> mBooks;

    public BookAdapter(Context context, List<Book> mBooks) {
        this.context = context;
        this.mBooks = mBooks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, viewGroup, false);
        return new BookAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        Book book = mBooks.get(i);

        String cover = book.getCover();

        if(cover.equals("cover1.png")){
            viewHolder.image.setBackgroundResource(R.drawable.cover1);
        }else if(cover.equals("cover2.png")){
            viewHolder.image.setBackgroundResource(R.drawable.cover2);
        }else if(cover.equals("cover3.png")){
            viewHolder.image.setBackgroundResource(R.drawable.cover3);
        }else if(cover.equals("cover4.png")){
            viewHolder.image.setBackgroundResource(R.drawable.cover4);
        }else{
            viewHolder.image.setBackgroundResource(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView image;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BookDetailActivity.class);
                    intent.putExtra("title", mBooks.get(getAdapterPosition()).getTitle());
                    intent.putExtra("cover", mBooks.get(getAdapterPosition()).getCover());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

            image= itemView.findViewById(R.id.item_container);


        }
    }

}