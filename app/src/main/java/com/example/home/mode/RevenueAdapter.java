package com.example.home.mode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.R;
import com.example.home.mode.Revenuea;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RevenueAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Revenuea> revenueaList;
private ArrayList<Revenuea> arraylist;
    public RevenueAdapter(Context context, int layout, List<Revenuea> revenueaList) {
        this.context = context;
        this.layout = layout;
        this.revenueaList = revenueaList;
        this.arraylist = new ArrayList<Revenuea>();
        this.arraylist.addAll(revenueaList);
    }

    @Override
    public int getCount() {
        return revenueaList.size();
    }

    @Override
    public Object getItem(int i) {
        return revenueaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder {
        TextView romName, roomRate, nights, source;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.romName = view.findViewById(R.id.name);
            holder.roomRate = view.findViewById(R.id.rate);
            holder.nights = view.findViewById(R.id.night1);
            holder.source = view.findViewById(R.id.gia);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final Revenuea revenuea = revenueaList.get(i);
        holder.romName.setText(revenuea.getName());
        holder.roomRate.setText("Rate : " + revenuea.getRate()+" đ");
        holder.nights.setText("Nights : " + revenuea.getNight() + "   |  ");
        holder.source.setText(revenuea.getChange() + " đ" + "   |  ");
        if (revenuea.getNight()<=1){
            holder.nights.setText("Night : " + revenuea.getNight() + "   |  ");
        }
        return view;
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        revenueaList.clear();
        if (charText.length() == 0) {
            revenueaList.addAll(arraylist);
        } else {
            for (Revenuea wp : arraylist) {
                if (wp.Name.toLowerCase(Locale.getDefault()).contains(charText)) {
                    arraylist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
