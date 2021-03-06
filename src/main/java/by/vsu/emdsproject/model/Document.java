package by.vsu.emdsproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "document")
public class Document extends AbstractEntity {

    public static final Long STATEMENT = 0L;
    public static final Long QUESTIONNAIRE = 1L;
    public static final Long PASSPORT_COPY = 2L;
    public static final Long REGISTRATION_CERTIFICATE_COPY = 3L;
    public static final Long CHARACTERISTIC = 4L;
    public static final Long COMMISSION_DIRECTION = 5L;
    public static final Long COMMISSION_CERTIFICATE = 6L;
    public static final Long AVERAGE_SCORE = 7L;

    private String title;
    private String systemTitle;

    public Document() {
    }

    @NotEmpty(message = "Обязательное поле")
    @Size(max = 50, message = "Не более 50 символов")
    @Column(name = "title", length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotEmpty(message = "Обязательное поле")
    @Size(max = 50, message = "Не более 50 символов")
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
