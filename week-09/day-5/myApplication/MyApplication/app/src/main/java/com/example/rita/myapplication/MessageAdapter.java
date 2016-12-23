package com.example.rita.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rita on 2016-12-23.
 */

public class MessageAdapter extends ArrayAdapter<Message> {
    public MessageAdapter(Context context) {
        super(context, 0);
    }

    public MessageAdapter(Context context, List<Message> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView time = (TextView) convertView.findViewById(R.id.textView);
        TextView name = (TextView) convertView.findViewById(R.id.textView2);
        TextView text = (TextView) convertView.findViewById(R.id.textView3);
        time.setText(message.getTime());
        name.setText(message.getName());
        text.setText(message.getText());
        return convertView;
    }
}
