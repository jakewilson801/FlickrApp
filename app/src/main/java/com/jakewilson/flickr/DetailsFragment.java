package com.jakewilson.flickr;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.SimpleDateFormat;

/**
 * Created by jakewilson on 3/12/14.
 */
public class DetailsFragment extends Fragment {
    public String name;
    public String url;
    public Long date;
    public DetailsFragment detailsFragment;
    public DetailsFragment(String name, String url, Long date){
        this.name = name;
        this.url = url;
        this.date = date;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details, container, false);
        detailsFragment = this;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);
        ((TextView)view.findViewById(R.id.name)).setText("Username: " + name);
        ImageLoader.getInstance().displayImage(url, ((ImageView) view.findViewById(R.id.picture)));
        (view.findViewById(R.id.backDetail)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .remove(detailsFragment)
                        .commit();
            }
        });
        return view;

    }
}
