package br.com.bossini.previsaodotempofatecipitarde;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rodrigo on 11/10/17.
 */

public class WeatherArrayAdapter extends ArrayAdapter <Weather> {

    private Map <String, Bitmap> bitmaps = new HashMap<>();
    public WeatherArrayAdapter (Context context, List <Weather> data){
        super(context, -1, data);
    }
    private static class ViewHolder{
        ImageView conditionImageView;
        TextView dayTextView;
        TextView lowTextView;
        TextView highTextView;
        TextView humidityTextView;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        Weather day = getItem (position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.list_item, parent, false);
        TextView dayTextView = (TextView) linearLayout.findViewById(R.id.dayTextView);
        TextView highTextView = (TextView) linearLayout.findViewById(R.id.highTextView);
        TextView lowTextView = (TextView) linearLayout.findViewById(R.id.lowTextView);
        TextView humidityTextView = (TextView) linearLayout.findViewById(R.id.humidityTextView);
        dayTextView.setText(getContext().getString(R.string.day_description, day.dayOfWeek, day.description));
        highTextView.setText(getContext().getString(R.string.high_temp, day.maxTemp));
        lowTextView.setText(getContext().getString(R.string.low_temp, day.minTemp));
        humidityTextView.setText(getContext().getString(R.string.humidity, day.humidity));
        ImageView conditionImageView = (ImageView) linearLayout.findViewById(R.id.conditionImageView);
        if (bitmaps.containsKey(day.iconURL)){
            conditionImageView.setImageBitmap(bitmaps.get(day.iconURL));
        }
        else{
            new LoadImageTask (conditionImageView).execute (day.iconURL);
        }
        //ViewHolder viewHolder;
        /*if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder.conditionImageView = (ImageView) convertView.findViewById(R.id.conditionImageView);
            viewHolder.dayTextView = (TextView) convertView.findViewById(R.id.dayTextView);
            viewHolder.lowTextView = (TextView) convertView.findViewById(R.id.lowTextView);
            viewHolder.highTextView = (TextView) convertView.findViewById(R.id.highTextView);
            viewHolder.humidityTextView = (TextView) convertView.findViewById(R.id.humidityTextView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        if (bitmaps.containsKey(day.iconURL)){
            viewHolder.conditionImageView.setImageBitmap(bitmaps.get(day.iconURL));
        }
        else{
            new LoadImageTask (viewHolder.conditionImageView).execute (day.iconURL);
        }
        Context context = getContext();
        viewHolder.dayTextView.setText(context.getString(R.string.day_description, day.dayOfWeek,
                day.description));
        viewHolder.lowTextView.setText(context.getString(R.string.low_temp, day.minTemp));
        viewHolder.highTextView.setText(context.getString(R.string.high_temp, day.maxTemp));
        viewHolder.humidityTextView.setText(context.getString(R.string.humidity,day.humidity));
        return convertView;*/
    }
}
