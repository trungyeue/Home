package com.example.home.mode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.Departure;
import com.example.home.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DepartureAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Departurea> departureas;
    private ArrayList<Departurea> arrayList;

    public DepartureAdapter(Context context, int layout, List<Departurea> departureas) {
        this.context = context;
        this.layout = layout;
        this.departureas = departureas;
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(departureas);
    }

    @Override
    public int getCount() {
        return departureas.size();
    }

    @Override
    public Object getItem(int i) {
        return departureas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public  class ViewHolder{
        TextView guestName,roomType,arrival,departure,roomName,departureTime,source,folioNo,adult,child,nights,roomCharge;
        ImageView img1,img2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.guestName=view.findViewById(R.id.guestName);
            holder.roomType=view.findViewById(R.id.roomType);
            holder.arrival=view.findViewById(R.id.arrival);
            holder.departure=view.findViewById(R.id.departure);
            holder.roomName=view.findViewById(R.id.romName);
            holder.departureTime=view.findViewById(R.id.departureTime);
            holder.source=view.findViewById(R.id.source);
            holder.folioNo=view.findViewById(R.id.folioNo);
            holder.adult=view.findViewById(R.id.child);
            holder.child=view.findViewById(R.id.child);
            holder.nights=view.findViewById(R.id.night);
            holder.roomCharge=view.findViewById(R.id.roomcharge);
            holder.img1=view.findViewById(R.id.imageView);
            holder.img2=view.findViewById(R.id.imageView1);
            view.setTag(holder);
        }else {
            holder=(ViewHolder)view.getTag();
        }
        final Departurea departurea = departureas.get(i);
        holder.guestName.setText(departurea.getGuestName());
        holder.arrival.setText(" " + departurea.getArrival() + " ");
        holder.roomName.setText( departurea.getRoomName() + " ");
        holder.departure.setText( " " + departurea.getDeparture() + " ");
        holder.departureTime.setText("( " + departurea.getDepartureTime() + " )");
        holder.source.setText(departurea.getSource());
        holder.folioNo.setText("Folo : " + departurea.getFolioNo());
        holder.roomType.setText("" + departurea.getRoomType()+ " " );
        holder.nights.setText("( " + departurea.getNights() + " nights )");
        if (departurea.getNights()<=1){
            holder.nights.setText("(" +departurea.getNights()+ " night )");
        }
        Picasso.with(context).load(R.drawable.per1).placeholder(R.drawable.per1).into(holder.img2);
        int a=departurea.getChild();
        int b=departurea.getAdult();
        int ab=a+b;
        holder.child.setText(ab+" guests");
        holder.adult.setText(ab+ " guests");

        if (departurea.getAdult()<=1){
            holder.child.setText(ab+ " guest");
            holder.adult.setText(ab+ " guest");

        }



        if (departurea.getAdult()>1){
            Picasso.with(context).load(R.drawable.per1).placeholder(R.drawable.per1).into(holder.img1);
            Picasso.with(context).load(R.drawable.per1).placeholder(R.drawable.per1).into(holder.img2);


        }
        Date date=new Date();
        java.text.DateFormat dateFormat =  android.text.format.DateFormat.getDateFormat(context);
        holder.arrival.setText(dateFormat.format(date));
        holder.departure.setText(dateFormat.format(date));
        holder.roomCharge.setText(""+departurea.getRoomCharge());
        return view;
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        departureas.clear();
        if (charText.length() == 0) {
            departureas.addAll(arrayList);
        } else {
            for (Departurea wp : arrayList) {
                if (wp.guestName.toLowerCase(Locale.getDefault()).contains(charText)) {
                    departureas.add(wp);
                }else if (wp.roomName.toLowerCase(Locale.getDefault()).contains(charText)) {
                    departureas.add(wp);
                    {
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
}
