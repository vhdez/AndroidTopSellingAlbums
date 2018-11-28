package sla.org.androidtopsellingalbums;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Controller {

    private Button prevButton;
    private TextView countText;
    private Button nextButton;
    private TextView titleText;
    private TextView descriptionText;

    private Albums topSellingAlbums;

    Controller(Button p, TextView c, Button n, TextView tt, TextView dt, Context ctxt) {
        prevButton = p;
        countText = c;
        nextButton = n;
        titleText = tt;
        descriptionText = dt;

        topSellingAlbums = new Albums(ctxt);
        displayCurrent();

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPrev();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNext();
            }
        });
    }

    private void displayCurrent() {
        countText.setText("Top Selling Album #" + (topSellingAlbums.currentIndex()+1) + " of " + topSellingAlbums.count());
        titleText.setText(topSellingAlbums.current().title());
        descriptionText.setText(topSellingAlbums.current().description());
    }

    private void displayNext() {
        topSellingAlbums.next();
        displayCurrent();
    }

    private void displayPrev() {
        topSellingAlbums.previous();
        displayCurrent();
    }


}
