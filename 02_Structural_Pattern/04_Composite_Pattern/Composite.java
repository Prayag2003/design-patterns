import java.util.ArrayList;
import java.util.List;

abstract class Component {
    abstract public void displaySongInfo();

    abstract public void displaySongSize();

    abstract public void displaySongDuration();

    abstract public int getSongSize();

    abstract public int getSongDuration();
}

class Song extends Component {
    private String name;
    private int size;
    private int duration;

    public Song(String name, int size, int duration) {
        this.name = name;
        this.size = size;
        this.duration = duration;
    }

    public void displaySongInfo() {
        System.out.println("🎶 " + this.name + " (" + this.size + "kB) ⌚: " + this.duration + " sec");
    }

    public void displaySongSize() {
        System.out.println("Size of 🎶 " + this.name + " is " + this.getSongSize() + "kB.");
    }

    public void displaySongDuration() {
        System.out.println("Duration of 🎶 " + this.name + " is " + this.getSongDuration() + "sec.");
    }

    public int getSongSize() {
        return this.size;
    }

    public int getSongDuration() {
        return this.duration;
    }
}

class Playlist extends Component {
    private String name;
    private List<Component> components = new ArrayList<Component>();

    public Playlist(String name) {
        this.name = name;
    }

    public void addComponenet(Component c) {
        components.add(c);
    }

    public void removeComponenet(Component c) {
        components.remove(c);
    }

    public void displaySongInfo() {
        System.out.println("📂 " + this.name + " (" + this.getSongSize() + "kB) ⌚: " + this.getSongDuration()
                + " sec.\nContains:\n");

        for (Component c : components) {
            c.displaySongInfo();
        }
        System.out.println("-------------");
    }

    public void displaySongSize() {
        System.out.println("Size of 📂 " + this.name + " is " + this.getSongSize() + "kB.");
    }

    public void displaySongDuration() {
        System.out.println("Duration of 📂 " + this.name + " is " + this.getSongDuration() + "sec.");
    }

    public int getSongSize() {
        int size = 0;
        for (Component c : components) {
            size += c.getSongSize();
        }
        return size;
    }

    public int getSongDuration() {
        int duration = 0;
        for (Component c : components) {
            duration += c.getSongDuration();
        }
        return duration;
    }

}

class MusicDemo {
    public static void main(String[] args) {
        Song song1 = new Song("BSong 1", 15, 160);
        Song song2 = new Song("BSong 2", 10, 280);
        Song song3 = new Song("BSong 3", 12, 120);

        Playlist p1 = new Playlist("Bollywood songs");
        p1.addComponenet(song1);
        p1.addComponenet(song2);
        p1.addComponenet(song3);

        Song prayer1 = new Song("Prayer 1", 15, 160);
        Song prayer2 = new Song("Prayer 2", 10, 280);
        Song prayer3 = new Song("Prayer 3", 12, 120);

        Playlist p2 = new Playlist("Prayer songs");
        p2.addComponenet(prayer1);
        p2.addComponenet(prayer2);
        p2.addComponenet(prayer3);

        Playlist favouriteSongs = new Playlist("Favourite Songs");
        favouriteSongs.addComponenet(p1);
        favouriteSongs.addComponenet(p2);

        favouriteSongs.displaySongInfo();
    }
}
