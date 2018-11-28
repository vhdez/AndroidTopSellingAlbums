package sla.org.androidtopsellingalbums;

public class Album implements Displayable {
    private String artist;
    private String album;
    private int year;
    private String genre;
    private float copies;
    private int sales;

    Album(String allData) {
        String[] data = allData.split("\\s+");
        artist = data[0];
        album = data[1];
        year = Integer.parseInt(data[2]);
        genre = data[3];
        copies = Float.parseFloat(data[4]);
        sales = Integer.parseInt(data[5]);
    }

    // Interface
    public String title() {
        return artist + " - " + album;
    }
    public String description() {
        return "Year: " + year + "\nGenre: " + genre + "\nTotal Certified Copies: " + copies + "Claimed sales: " + sales;
    }
}
