package helper;

public enum FormatExtension {
    CSV("csv"),
    AUDIO_AU("au");

    String extension;

    FormatExtension(String s){
        extension = s;
    }


    @Override
    public String toString() {
        return extension;
    }
}
