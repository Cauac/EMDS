package by.vsu.emdsproject.model;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
