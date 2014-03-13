package com.jakewilson.flickr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by jakewilson on 3/12/14.
 */
public class SearchAdapter extends BaseAdapter {

    public List<Item> searchResults;
    public Context context;

    public SearchAdapter(List<Item> searchResults, Context context) {
        this.searchResults = searchResults;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.thumb = (ImageView) convertView.findViewById(R.id.thumb);
            holder.title = (TextView) convertView.findViewById(R.id.title);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
       ImageLoader.getInstance().displayImage(searchResults.get(position).getUrl(), holder.thumb);
        holder.title.setText(searchResults.get(position).getTitle());
        return convertView;
    }

    @Override
    public int getCount() {
        return searchResults.size();
    }

    @Override
    public Item getItem(int position) {
        return searchResults.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder{
        ImageView thumb;
        TextView title;
    }

}
