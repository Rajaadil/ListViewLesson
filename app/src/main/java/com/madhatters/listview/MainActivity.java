package com.madhatters.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.listitem);
        this.context=this;
        OurAdapter adapter=new OurAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
    private class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder>{
       private String[]name={"yasmine","CAMEL","GOAT","kinza"};
       private String[]discryption={"This is a yasmine from bhimber","This is a camel","This is goat","This is kinza from bhimber"};
        Integer[]imageViews={R.drawable.ali_j,R.drawable.camel,R.drawable.goat,R.drawable.unnamed};

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new ViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.list_view,parent,false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String names=name[position];
            holder.namess.setText(names);
            String desscryption=discryption[position];
            holder.discryption.setText(desscryption);
            holder.imageView.setImageResource(imageViews[position]);

        }

        @Override
        public int getItemCount() {

            return name.length;
        }
        class ViewHolder extends RecyclerView.ViewHolder {
            TextView namess;
            TextView discryption;
            ImageView imageView;
            public ViewHolder(View itemView) {
                super(itemView);
                namess=itemView.findViewById(R.id.nameview);
                discryption=itemView.findViewById(R.id.descryption);
                imageView=itemView.findViewById(R.id.imageview);


            }
        }
    }
}
