package sla.org.androidtopsellingalbums;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Albums {
    private ArrayList<Displayable> albums;
    private int current;

    Albums(Context context) {
        current = 0;
        albums = new ArrayList();

        // Read album data from text file.
        try {
            InputStream inputStream = context.getAssets().open("AlbumData");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line1 = bufferedReader.readLine();
            System.out.println("Albums() line1:" + line1);
            int numOfAlbums = Integer.parseInt(line1);
            System.out.println("Albums() numOfAlbums:" + numOfAlbums);
            bufferedReader.readLine(); // skip column titles
            for (int i = 1; i <= numOfAlbums; i++) {
                String nextLine = bufferedReader.readLine();
                System.out.println("Albums() nextLine:" + nextLine);
                albums.add(new Album(nextLine));
            }
        } catch (Exception e) {
            System.out.println("Albums() reading data threw exception:");
            e.printStackTrace();
        }
    }

    int count() {
        return albums.size();
    }

    int currentIndex() {
        return current;
    }

    Displayable current() {
        return albums.get(current);
    }

    void next() {
        // increment current to point to next pet
        if (current < albums.size() - 1) {
            current = current + 1;
        } else {
            current = 0;
        }
    }

    void previous() {
        // increment current to point to previous pet
        if (current > 0) {
            current = current - 1;
        } else {
            current = albums.size() - 1;
        }
    }
}
