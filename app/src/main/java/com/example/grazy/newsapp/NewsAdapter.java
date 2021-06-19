package com.example.grazy.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news
 * in the data source (a list of {@link News} objects).
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news    is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the list of news
        News currentNews = getItem(position);

        // Find the TextView with view ID web title
        TextView webTitleView = listItemView.findViewById(R.id.webTitle);
        // Display the web title of the current news in that TextView
        webTitleView.setText(currentNews.getWebTitle());

        // Find the TextView with view ID section name
        TextView sectionNameView = listItemView.findViewById(R.id.sectionName);
        // Display the section name of the current news in that TextView
        sectionNameView.setText(currentNews.getSectionName());

        // Find the TextView with view ID author name
        TextView authorNameView = listItemView.findViewById(R.id.authorName);
        // Display the author name of the current news in that TextView
        if (currentNews.getAuthorName() != "") {
            authorNameView.setText(currentNews.getAuthorName());

            //Set author name view as visible
            authorNameView.setVisibility(View.VISIBLE);
        } else {
            //Set author name view as gone
            authorNameView.setVisibility(View.GONE);
        }

        // Find the TextView with view ID date
        TextView dateView = null;
        TextView timeView = null;
        if (currentNews.getPublicationDate() != null) {
            dateView = listItemView.findViewById(R.id.date);
            // Format the date string (i.e. "May 5, 2000")
            String formattedDate = formatDate(currentNews.getPublicationDate());
            // Display the date of the current news in that TextView
            dateView.setText(formattedDate);

            // Find the TextView with view ID time
            timeView = listItemView.findViewById(R.id.time);
            // Format the time string (i.e. "7:45PM")
            String formattedTime = formatTime(currentNews.getPublicationDate());
            // Display the time of the current news in that TextView
            timeView.setText(formattedTime);

            //Set date and time views as visible
            dateView.setVisibility(View.VISIBLE);
            timeView.setVisibility(View.VISIBLE);
        } else {
            //Set date and time views as gone
            dateView.setVisibility(View.GONE);
            timeView.setVisibility(View.GONE);
        }

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "May 5, 2000") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "7:45 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}