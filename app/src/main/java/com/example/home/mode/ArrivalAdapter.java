package com.example.home.mode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ArrivalAdapter  extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Arricala> inHomes;
    private ArrayList<Arricala> arraylist;

    public ArrivalAdapter(Context context, int layout, List<Arricala> ari) {
        this.context = context;
        this.layout = layout;
        this.inHomes = ari;
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(inHomes);
    }

    @Override
    public int getCount() {
        return inHomes.size();
    }


    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public  class ViewHolder{
        TextView guestName1,roomType1,arrival1,departure1,roomName1,departureTime1,source1,folioNo1,adult1,child1,nights1,roomCharge1;
        ImageView img11,img21;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.guestName1=view.findViewById(R.id.guestName1);
            holder.roomType1=view.findViewById(R.id.roomType1);
            holder.arrival1=view.findViewById(R.id.arrival1);
            holder.departure1=view.findViewById(R.id.departure1);
            holder.roomName1=view.findViewById(R.id.romName1);
            holder.departureTime1=view.findViewById(R.id.departureTime1);
            holder.source1=view.findViewById(R.id.source1);
            holder.folioNo1=view.findViewById(R.id.folioNo1);
            holder.adult1=view.findViewById(R.id.child1);
            holder.child1=view.findViewById(R.id.child1);
            holder.nights1=view.findViewById(R.id.night1);
            holder.roomCharge1=view.findViewById(R.id.roomcharge1);
            holder.img11=view.findViewById(R.id.imageView1);
            holder.img21=view.findViewById(R.id.imageView2);
            view.setTag(holder);
        }else {
            holder=(ViewHolder)view.getTag();
        }
        final Arricala departurea = inHomes.get(i);
        holder.guestName1.setText(departurea.getGuestName1());
        holder.arrival1.setText(" " + departurea.getArrival1() + " ");
        holder.roomName1.setText( departurea.getRoomName1() + " ");
        holder.departure1.setText( " " + departurea.getDeparture1() + " ");
        holder.departureTime1.setText("( " + departurea.getDepartureTime1() + " )");
        holder.source1.setText(departurea.getSource1());
        holder.folioNo1.setText("Folo : " + departurea.getFolioNo1());
        holder.roomType1.setText("" + departurea.getRoomType1()+ " " );
        holder.nights1.setText("(" + departurea.getNights1() +"nights");
        if (departurea.getNights1()<=1){
            holder.nights1.setText("(" +departurea.getNights1()+ " night )");
        }
        Picasso.with(context).load(R.drawable.per1).placeholder(R.drawable.per1).into(holder.img21);
        int a=departurea.getChild1();
        int b=departurea.getAdult1();
        int ab=a+b;
        holder.child1.setText(ab+" guests");
        holder.adult1.setText(ab+ " guests");
//
        if (departurea.getAdult1()<=1){
            holder.child1.setText(ab+ " guest");
            holder.adult1.setText(ab+ " guest");

        }

//
//
        if (departurea.getAdult1()>1){
            Picasso.with(context).load(R.drawable.per1).placeholder(R.drawable.per1).into(holder.img11);
            Picasso.with(context).load(R.drawable.per1).placeholder(R.drawable.per1).into(holder.img21);


        }
        Date date=new Date();
        java.text.DateFormat dateFormat =  android.text.format.DateFormat.getDateFormat(context);
        holder.arrival1.setText(dateFormat.format(date));
        holder.departure1.setText(dateFormat.format(date));
        holder.roomCharge1.setText(""+departurea.getRoomCharge1());
        return view;
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        inHomes.clear();
        if (charText.length() == 0) {
            inHomes.addAll(arraylist);
        } else {
            for (Arricala wp : arraylist) {
                if (wp.guestName1.toLowerCase(Locale.getDefault()).contains(charText)) {
                    inHomes.add(wp);
                }else if (wp.roomName1.toLowerCase(Locale.getDefault()).contains(charText)) {
                    inHomes.add(wp);
                    {
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
}
