package by.vsu.emdsproject.model;

import javax.persistence.*;

/**
 * @author Max
 *         Date: 30.03.13
 *         Time: 20:53
 */
@Entity
@Table(name = "document_info")
public class DocumentInfo implements AbstractEntity {

    private Long id;
    private Boolean isBrought;
    private String commentary;

    public DocumentInfo() {
    }

    public DocumentInfo(Boolean brought, String commentary) {
        isBrought = brought;
        this.commentary = commentary;
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

    @Column(name = "is_brought")
    public Boolean getBrought() {
        return isBrought;
    }

    public void setBrought(Boolean brought) {
        isBrought = brought;
    }

    @Column(name = "commentary", length = 500)
    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

}
