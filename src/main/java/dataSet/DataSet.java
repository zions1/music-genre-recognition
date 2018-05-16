package dataSet;

public abstract class DataSet {
    protected double[][] trainingSet;
    protected double[][] idealTrainingSet;
    protected int samplePerGenre;
    protected int totalGenres;
    protected String[] genreNames;

    public double[][] getTrainingSet() {
        return trainingSet;
    }

    public void setTrainingSet(double[][] trainingSet) {
        this.trainingSet = trainingSet;
    }

    public double[][] getIdealTrainingSet() {
        return idealTrainingSet;
    }

    public void setIdealTrainingSet(double[][] idealTrainingSet) {
        this.idealTrainingSet = idealTrainingSet;
    }

    public int getSamplePerGenre() {
        return samplePerGenre;
    }

    public void setSamplePerGenre(int samplePerGenre) {
        this.samplePerGenre = samplePerGenre;
    }

    public String[] getGenreNames() {
        return genreNames;
    }

    public void setGenreNames(String[] genreNames) {
        this.genreNames = genreNames;
    }

    public int getTotalGenres() {
        return totalGenres;
    }

    public void setTotalGenres(int totalGenres) {
        this.totalGenres = totalGenres;
    }
}
