package com.example.home.mode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.home.R;

import java.util.List;

public class DemoAdapter extends BaseAdapter {
    private Context context;
    private List<DaTaHome> list;
    private int layout;

    public DemoAdapter(Context context,int layout, List<DaTaHome> list) {
        this.context = context;
        this.layout=layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
        public  class  ViewHolder{
        TextView txt1;
        }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txt1=view.findViewById(R.id.temothungnghiep);
            view.setTag(holder);
        }else {
            holder=(ViewHolder)view.getTag();
        }
        final DaTaHome daTaHome=list.get(i);
        holder.txt1.setText(""+daTaHome.getRoomName());
        return view;
    }
}
