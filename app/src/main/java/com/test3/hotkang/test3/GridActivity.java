package com.test3.hotkang.test3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridActivity extends AppCompatActivity {
    private Context mContext;
    private GridView grid_app;
    private String[] appNames = new String[]{"camera", "contacts", "game", "setting", "weather"};
    private int[] imgIds = new int[]{R.drawable.camera, R.drawable.contacts, R.drawable.game, R.drawable.setting1, R.drawable.weather};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        mContext = GridActivity.this;
        grid_app = (GridView) findViewById(R.id.grid_app);
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < appNames.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("appImage", imgIds[i]);
            showitem.put("appName", appNames[i]);
            listitem.add(showitem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(mContext, listitem, R.layout.item_grid_icon,
                new String[]{"appImage", "appName"}, new int[]{R.id.app_image, R.id.app_name});
        grid_app.setAdapter(simpleAdapter);

        grid_app.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                    {
                        Intent intent = new Intent(mContext, Contacts.class);
                        startActivity(intent);
                    }break;
                    case 2:
                    {
                        Intent intent = new Intent(mContext, Relative.class);
                        startActivity(intent);
                    }break;
                    default:
                    {
                        Toast.makeText(mContext, ((HashMap<String, Object>) parent.getItemAtPosition(position)).get("appName").toString(), Toast.LENGTH_SHORT).show();
                    }break;
                }
            }
        });
    }
}
