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

    public static final Long STATEMENT = 0L;
    public static final Long QUESTIONNAIRE = 1L;
    public static final Long PASSPORT_COPY = 2L;
    public static final Long REGISTRATION_SERTIFICATE_COPY = 3L;
    public static final Long CHARACTERISTIC = 4L;
    public static final Long COMISSION_SERTIFICATE = 5L;

    private Long id;
    private String title;
    private String systemTitle;

    public Document() {
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

    @Column(name = "system_title", length = 50)
    public String getSystemTitle() {
        return systemTitle;
    }

    public void setSystemTitle(String systemTitle) {
        this.systemTitle = systemTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;

        Document document = (Document) o;

        if (id != null ? !id.equals(document.id) : document.id != null) return false;
        if (title != null ? !title.equals(document.title) : document.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
