package sla.org.androidtopsellingalbums;

import java.util.Scanner;

public class Album implements Displayable {
    private String artist;
    private String album;
    private int year;
    private String genre;
    private float copies;
    private int sales;

    Album(String allData) {
        Scanner s = new Scanner(allData).useDelimiter("\\s*\\|\\s*");
        artist = s.next();
        album = s.next();
        year = s.nextInt();
        genre = s.next();
        copies = s.nextFloat();
        sales = s.nextInt();
    }

    // Interface
    public String title() {
        return artist + " - " + album;
    }
    public String description() {
        return "Year: " + year + "\nGenre: " + genre + "\nTotal Certified Copies: " + copies + " million\nClaimed sales: " + sales + " million";
    }
}
