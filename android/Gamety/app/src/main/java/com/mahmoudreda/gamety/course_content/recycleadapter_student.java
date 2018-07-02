package com.mahmoudreda.gamety.course_content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahmoudreda.gamety.R;

import java.util.ArrayList;

/**
 * Created by mahmoud reda on 01/06/2018.
 */

public class recycleadapter_student extends RecyclerView.Adapter<recycleadapter_student.ViewHolder> {
    private ArrayList<list_item_course_student> list = new ArrayList<>();
    public Context context;

    recycleadapter_student(ArrayList<list_item_course_student> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view1 = inflater.inflate(R.layout.customer_list_course_link_student, null);

        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(final recycleadapter_student.ViewHolder holder, final int position) {
        // - replace the contents of the view with that element
        holder.coure_name.setText(list.get(position).getCourse_name_student());
        holder.link.setText(list.get(position).getLink_student());

        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context.getApplicationContext(),list.get(position).getLink_student().toString(),Toast.LENGTH_LONG).show();
//                Intent kareem=new Intent(Intent.ACTION_SEND);
//                kareem.putExtra(Intent.EXTRA_EMAIL,list.get(position).getLink_student().toString());
//                kareem.setType("message/rfc822");

                Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);




                // context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(position).getLink_student())));
            }
        });

    }


    // Return the size of your database (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView coure_name, link;

        ViewHolder(View itemView) {
            super(itemView);
            link = itemView.findViewById(R.id.link_student);
            coure_name = itemView.findViewById(R.id.course_name_student);




        }
    }
}
