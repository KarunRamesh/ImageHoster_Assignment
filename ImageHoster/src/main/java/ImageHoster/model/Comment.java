package ImageHoster.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.util.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;


//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'comments'. Hence the table named 'comments' will be created in the database with all the columns mapped to all the attributes in 'comments' class
@Table(name = "comments")
public class Comment {

    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    private Integer id;

    // Text is a Postgres specific column type that allows you to save
    // text based data that will be longer than 256 characters
    // this is a base64 encoded version of the image
    @Column(columnDefinition = "text")
    private String text;

    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'createdDate'
    @Column(name = "createdDate")
    private LocalDate createdDate;

    //The 'comment' table is mapped to 'users' table with Many:One mapping
    //One comment can have only one user (owner) but one user can post multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
    @JoinColumn(name = "user_id")
    private User user;

    //The 'comment' table is mapped to 'images' table with Many:One mapping
    //One comment can only belong to only one image but one image can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
    @JoinColumn(name = "image_id")
    private Image image;

    public Comment() {
    }

    public Comment(String description)
    {
        this.text =  description;
    }

    public Comment(int id, String text, LocalDate date) {
        this.id = id;
        this.text = text;
        this.createdDate = date;
    }

    public Comment(int id, String text, LocalDate date, User user, Image image) {
        this.id = id;
        this.text = text;
        this.createdDate = date;
        this.user = user;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate date) {
        this.createdDate = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
