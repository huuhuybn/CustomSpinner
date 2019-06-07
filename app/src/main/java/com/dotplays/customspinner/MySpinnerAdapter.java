package com.dotplays.customspinner;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class MySpinnerAdapter implements SpinnerAdapter {


    private Context context;
    private List<Part> partList;

    public MySpinnerAdapter(Context context, List<Part> partList) {
        this.context = context;
        this.partList = partList;
    }


    // giao dien cho hang khi hien thi spinner
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

        TextView tvInfo;

        tvInfo = convertView.findViewById(R.id.tvInfo);

        tvInfo.setText(partList.get(position).name);

        return convertView;

    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return partList.size();
    }

    @Override
    public Part getItem(int position) {
        return partList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    // giao dien cho hang duoc chon
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

        TextView tvInfo;

        tvInfo = convertView.findViewById(R.id.tvInfo);

        tvInfo.setText(partList.get(position).name);

        tvInfo.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
