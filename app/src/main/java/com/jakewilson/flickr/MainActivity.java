package com.jakewilson.flickr;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public ImageView searchIcon;
        public Button searchBtn;
        public EditText searchQuery;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            searchBtn = (Button)rootView.findViewById(R.id.searchBtn);
            searchIcon = (ImageView) rootView.findViewById(R.id.searchIcon);
            searchQuery = (EditText) rootView.findViewById(R.id.editText);

            searchBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String value = searchQuery.getText().toString();
                    searchQuery.setText("");
                    if(Util.isNullOrEmpty(value))
                        Util.say("Please enter a search value", getActivity());
                    else
                        getFragmentManager().beginTransaction()
                                .add(R.id.container, new SearchFragment(value))
                                .commit();
                }
            });

            searchIcon.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    String value = searchQuery.getText().toString();
                    searchQuery.setText("");
                    if(Util.isNullOrEmpty(value))
                        Util.say("Please enter a search value", getActivity());
                    else
                        getFragmentManager().beginTransaction()
                                .add(R.id.container, new SearchFragment(value))
                                .commit();
                }
            });

            return rootView;
        }
    }

}
