package by.vsu.emdsproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "document_info")
public class DocumentInfo extends AbstractEntity {

    private Boolean isBrought;
    private String commentary;

    public DocumentInfo() {
    }

    public DocumentInfo(Boolean brought, String commentary) {
        isBrought = brought;
        this.commentary = commentary;
    }

    @NotNull(message = "Обязательное поле")
    @Column(name = "brought")
    public Boolean getBrought() {
        return isBrought;
    }

    public void setBrought(Boolean brought) {
        isBrought = brought;
    }

    @Size(max = 500, message = "Не более 500 символов")
    @Column(name = "commentary", length = 500)
    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentInfo)) return false;

        DocumentInfo that = (DocumentInfo) o;

        if (commentary != null ? !commentary.equals(that.commentary) : that.commentary != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!isBrought.equals(that.isBrought)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + isBrought.hashCode();
        result = 31 * result + (commentary != null ? commentary.hashCode() : 0);
        return result;
    }
}
