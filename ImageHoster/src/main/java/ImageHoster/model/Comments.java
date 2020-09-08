package ImageHoster.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'images'. Hence the table named 'images' will be created in the database with all the columns mapped to all the attributes in 'Image' class
@Table(name = "comments")
public class Comments {

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

    @Column(name = "createdDate")
    private Date createdDate;

    //The 'comment' table is mapped to 'users' table with Many:One mapping
    //One comment can have only one user (owner) but one user can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'comment' table referring the primary key in 'users' table will be 'user'
    @JoinColumn(name = "user")
    private User user;

    //The 'comment' table is mapped to 'images' table with Many:One mapping
    //One comment can have only one user (owner) but one image can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'comment' table referring the primary key in 'images' table will be 'Image'
    @JoinColumn(name = "Image")
    private Image Image;

    public Comments() {
    }

    public Comments(String description)
    {
        this.text =  description;
    }

    public Comments(int id, String text, Date date) {
        this.id = id;
        this.text = text;
        this.createdDate = date;
    }

    public Comments(int id, String text, Date date, User user, Image image) {
        this.id = id;
        this.text = text;
        this.createdDate = date;
        this.user = user;
        this.Image = image;
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
        return Image;
    }

    public void setImage(Image image) {
        this.Image = image;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDateDate(Date date) {
        this.createdDate = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}