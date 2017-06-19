package com.example.kale.finalproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Class used for Adapting the view of my Events
 */

public class EventListAdapter extends BaseAdapter
{

    private Context mContext;
    private List<Event> mEventList;

    //Constructor
    public EventListAdapter(Context mContext, List<Event> mEventList)
    {
        this.mContext = mContext;
        this.mEventList = mEventList;
    }

    @Override
    public int getCount() {
        return mEventList.size();
    }

    @Override
    public Object getItem(int position) {
        return mEventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = View.inflate(mContext, R.layout.events_list, null);
        TextView eventName = (TextView)v.findViewById(R.id.event_name);
        TextView eventDate = (TextView)v.findViewById(R.id.due_date);
        TextView eventDescription = (TextView)v.findViewById(R.id.event_description);

        //Set text for TextView
        eventName.setText(mEventList.get(position).getEventName());
        eventDate.setText(mEventList.get(position).getEventDate());
        eventDescription.setText(mEventList.get(position).getEventDescription());

        //Save event id to tag
        v.setTag(mEventList.get(position).getId());

        return v;
    }
}
