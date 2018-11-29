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

    private Displayable topSellingAlbums;

    Controller(Button p, TextView c, Button n, TextView tt, TextView dt, Context ctxt) {
        prevButton = p;
        countText = c;
        nextButton = n;
        titleText = tt;
        descriptionText = dt;

        topSellingAlbums = new Albums(ctxt);
        updateText();

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
                updateText();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                updateText();
            }
        });
    }

    private void updateText() {
        countText.setText(topSellingAlbums.countText());
        titleText.setText(topSellingAlbums.titleText());
        descriptionText.setText(topSellingAlbums.descriptionText());
    }

    private void previous() {
        topSellingAlbums.previous();
    }

    private void next() {
        topSellingAlbums.next();
    }
}
