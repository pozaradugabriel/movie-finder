package rrt.mf.model;

import jakarta.persistence.*;

@Entity
@Table(name ="movies")
public class Movie {
    @Id
    @SequenceGenerator(name="movie_sequence", allocationSize = 1)
    @GeneratedValue(
            generator = "movie_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String title;
    private String genres;
    private float avgRating;
    private String mainActor;
    private String creator;
    private int year;

    public Movie(){

    }
    public Movie(String title, String genres, float avgRating, String mainActor, String creator) {
        this.title = title;
        this.genres = genres;
        this.avgRating = avgRating;
        this.mainActor = mainActor;
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public Long getID() {
        return id;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                ", avgRating=" + avgRating +
                ", mainActor=" + mainActor +
                ", creator=" + creator +
                '}';
    }
}
