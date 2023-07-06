
// STOCK DATA Provier and Application which is relied by the Client ( He gices info in form of XML file ... he is interested in more reports of the Application  , but there is already available library for client , only problem is Format Difference( JSON ) ,  intoduce the adapter class or interface  , adaptee is the intermediate )

// Doing JSON to XML takes time
// Introduce Adapter Functionality
// Converting XML to JSON
// Works for Functionality Matches 
// Adapter works in case of Incompatability  ( works same as a translator )

// Target/ Adapter InterFace ( Base )

interface MediaPlayer {
    public void play(String type, String filename);
}

class MediaAdapter implements MediaPlayer {
    // contains reference of adaptee
    AdvancedMediaPlayer amp = new AdvancedMediaPlayer();

    public void play(String type, String filename) {
        if (type.equalsIgnoreCase("vlc")) {
            amp.playVLC("Perfect.vlc");
        }

        else if (type.equalsIgnoreCase("mp3")) {
            amp.playMP3("Attention.mp3");
        }

        else if (type.equalsIgnoreCase("mp4")) {
            amp.playMP4("What Makes You Beautiful?.mp4");
        }

        else
            amp.playAVI("Tose Naina Jabse Mile.avi");
    }
}

// SERVICE ( ADAPTEE ) ( whose we need to adapt )
class AdvancedMediaPlayer {
    // non static methods
    public void playVLC(String fileName) {
        System.out.println("Playing " + "VLC" + " type " + fileName);
    }

    public void playMP4(String fileName) {
        System.out.println("Playing " + "MP4" + " type " + fileName);
    }

    public void playMP3(String fileName) {
        System.out.println("Playing " + "MP3" + " type " + fileName);
    }

    public void playAVI(String fileName) {
        System.out.println("Playing " + "AVI" + " type " + fileName);
    }
}

class AudioPlayer implements MediaPlayer {
    public void play(String type, String fileName) {

        // if (type.equalsIgnoreCase("vlc")) {
        // System.out.println("Playing " + type + " type " + fileName);
        // }

        MediaPlayer md = new MediaAdapter();
        md.play(type, fileName);
    }
}

// CLIENT
public class Adapter {
    public static void main(String[] args) {
        MediaPlayer m = new AudioPlayer();

        m.play("vlc", "Perfect.vlc");

        // another requirement comes in
        m.play("mp3", "Attention.mp3");
        m.play("mp4", "What Makes You Beautiful?.mp4");
        m.play("avi", "Tose Naina Jabse Mile.avi");
    }
}

// Client interface MATHDATAPROCESSING , method name
// void processData(String type , Integer[] arr)
// MATHCALCULATELIBRARY ( Adaptee ) , public int calculate AVG, minimum ,
// maximum public void sort data , adaptable system
//