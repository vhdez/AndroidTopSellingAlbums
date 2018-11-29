package sla.org.androidtopsellingalbums;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Albums implements Displayable {
    private ArrayList<Album> albums;
    private int current;

    // Constructor
    Albums(Context context) {
        current = 0;
        albums = new ArrayList();

        // Read album data from text file.
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open("AlbumData")));
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                albums.add(new Album(nextLine));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Albums() reading data threw exception:");
            e.printStackTrace();
        }
    }

    // Interface methods
    public void next() {
        // increment current to point to next pet
        if (current < albums.size() - 1) {
            current = current + 1;
        } else {
            current = 0;
        }
    }

    public void previous() {
        // increment current to point to previous pet
        if (current > 0) {
            current = current - 1;
        } else {
            current = albums.size() - 1;
        }
    }

    public String countText() {
        return "Top Selling Album #" + (current+1) + " of " + albums.size();
    }

    public String titleText() {
        return albums.get(current).title();
    }

    public String descriptionText() {
        return albums.get(current).description();
    }

}
