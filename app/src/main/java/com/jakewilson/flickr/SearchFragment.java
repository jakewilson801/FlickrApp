package com.jakewilson.flickr;

/**
 * Created by jakewilson on 3/12/14.*/

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.util.List;

public class SearchFragment extends Fragment {
    private final HttpClient Client = new DefaultHttpClient();
    public String searchQuery;
    public ListView listView;
    public SearchAdapter adapter;
    public ProgressBar pBar;
    public List<Item> items;
    public SearchFragment sf;
    public SearchFragment(String s) {
        this.searchQuery = s;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        pBar = (ProgressBar) view.findViewById(R.id.progressBar);
         sf = this;
        new AsyncTask<Void, Void, String>() {
            @Override
            public String doInBackground(Void... params) {
                String result = new String();
                try {
                    HttpGet httpget = new HttpGet(Util.searchEndpont(searchQuery));
                    ResponseHandler<String> responseHandler = new BasicResponseHandler();
                    result = Client.execute(httpget, responseHandler);
                } catch (Exception e) {
                    Util.say(e.toString(), getActivity());
                }
                return result;
            }

            @Override
            public void onPostExecute(String response) {

                pBar.setVisibility(View.INVISIBLE);
                //This would be too expensive normally on the UI thread BUT with 25 items i think it would be fine for now

                try{
                items = Factory.getItems(new JSONObject(response));
                adapter = new SearchAdapter(items, getActivity());
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Item i = items.get(position);
                        getFragmentManager().beginTransaction()
                                .add(R.id.container, new DetailsFragment(i.getName(), i.getUrl(), i.getDate()))
                                .commit();

                    }
                });
                }catch(Exception e){

                }
            }
        }.execute();

        ((Button) view.findViewById(R.id.backbutton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .remove(sf)
                        .commit();
            }
        });

        return view;
    }

}