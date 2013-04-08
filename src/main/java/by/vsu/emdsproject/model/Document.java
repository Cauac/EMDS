package by.vsu.emdsproject.model;

import javax.persistence.*;

/**
 * @author Max
 *         Date: 30.03.13
 *         Time: 20:24
 */
@Entity
@Table(name = "document")
public class Document implements AbstractEntity {

    private Long id;
    private String title;

    /*
     todo: something else..
     */

    public Document() {
    }

    public Document(String title) {
        this.title = title;
    }

    @Id
    @Override
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
