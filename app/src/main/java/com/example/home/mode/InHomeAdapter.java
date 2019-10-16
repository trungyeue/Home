package com.example.home.mode;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.home.Page.Revenue;
import com.example.home.R;
import com.example.home.mode.InHomea;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class InHomeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<InHomea> inHomes;
    private ArrayList<InHomea> arraylist;
    ListView listView;
    public static String folioNo1;
    public static String arrival;
    public static String departure1;
    public static String roomType1;
    public static int balance;
    public  static String roomName1;
    public  static  int totcharge1;

    public InHomeAdapter(Context context, int layout, List<InHomea> inHomes, ListView listView) {
        this.context = context;
        this.layout = layout;
        this.inHomes = inHomes;
        this.listView = listView;
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(inHomes);
    }

    @Override
    public int getCount() {
        return inHomes.size();
    }

    @Override
    public Object getItem(int i) {
        return inHomes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder {
        TextView roomType, romName, guestName, roomRate, arrival, departure, nights, folioNo, source, adult, child, balance;
        ImageView img1, img2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.roomType = view.findViewById(R.id.roomType);
            holder.romName = view.findViewById(R.id.romName);
            holder.guestName = view.findViewById(R.id.guestName);
            holder.roomRate = view.findViewById(R.id.roomRate);
            holder.arrival = view.findViewById(R.id.arrival);
            holder.departure = view.findViewById(R.id.departure);
            holder.folioNo = view.findViewById(R.id.folioNo);
            holder.nights = view.findViewById(R.id.night);
            holder.source = view.findViewById(R.id.source);
            holder.child = view.findViewById(R.id.child);
            holder.adult = view.findViewById(R.id.child);
            holder.img1 = view.findViewById(R.id.imageView);
            holder.img2 = view.findViewById(R.id.imageView1);
            holder.balance = view.findViewById(R.id.banlce);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final InHomea inHome = inHomes.get(i);
        holder.roomType.setText(inHome.getRoomType() + "");
        holder.romName.setText(inHome.getRomName() + "  ");
        holder.guestName.setText(inHome.getGuestName());
        holder.roomRate.setText(inHome.getRoomRate() + "");
        holder.arrival.setText(inHome.getArrival());
        holder.balance.setText(""+inHome.getBalance());
        holder.departure.setText(inHome.getDeparture());
        holder.folioNo.setText("Res :" + inHome.getfolioNo());
        holder.nights.setText("(" + inHome.getNights() + "nights)");

        if (inHome.getNights() <= 1) {
            holder.nights.setText("(" + inHome.getNights() + "night)");
        }
        holder.source.setText(inHome.getSource());
        Picasso.with(context).load(R.drawable.per1).placeholder(R.drawable.per1).into(holder.img2);
        int a = inHome.getChild();
        int b = inHome.getAdult();
        int ab = a + b;
        holder.child.setText(ab + " guests");
        holder.adult.setText(ab + " guests");

        if (ab <= 1) {
            holder.child.setText(ab + " guest");
            holder.adult.setText(ab + " guest");

        }


        if (ab > 1) {
            Picasso.with(context).load(R.drawable.per1).placeholder(R.drawable.per1).into(holder.img1);
            Picasso.with(context).load(R.drawable.per1).placeholder(R.drawable.per1).into(holder.img2);


        }

        Date date = new Date();
        java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
        holder.arrival.setText(dateFormat.format(date));
        holder.departure.setText(dateFormat.format(date));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                folioNo1 = inHomes.get(i).getfolioNo();
                arrival = inHomes.get(i).getArrival();
                departure1 = inHomes.get(i).getDeparture();
                roomType1 = inHomes.get(i).getRoomType();
                balance = inHomes.get(i).getBalance();
                roomName1=inHomes.get(i).getRomName();
                totcharge1=inHomes.get(i).getRoomRate();
                Intent intent = new Intent(context, Chitiet.class);
                intent.putExtra("idd", inHomes.get(i).getSource());
                context.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        inHomes.clear();
        if (charText.length() == 0) {
            inHomes.addAll(arraylist);
        } else {
            for (InHomea wp : arraylist) {
                if (wp.guestName.toLowerCase(Locale.getDefault()).contains(charText)) {
                    inHomes.add(wp);
                } else if (wp.romName.toLowerCase(Locale.getDefault()).contains(charText)) {
                    inHomes.add(wp);
                    {
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
}
