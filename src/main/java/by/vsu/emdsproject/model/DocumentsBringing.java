package by.vsu.emdsproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documents_bringing")
public class DocumentsBringing extends AbstractEntity {

    private boolean statement;
    private String statementComment;
    private Student student;

    public DocumentsBringing() {
    }

    public DocumentsBringing(boolean statement, String statementComment) {
        this.statement = statement;
        this.statementComment = statementComment;
    }

    @Id
    @Column(name = "id_documents_bringing")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "statement_to_dep", nullable = false)
    public boolean isStatement() {
        return statement;
    }

    @OneToOne(mappedBy = "documents", fetch = FetchType.LAZY)
    public Student getStudent() {
        return student;
    }

    @Column(name = "statement_commentary", nullable = false)
    public String getStatementComment() {
        return statementComment;
    }

    public void setStatement(boolean statement) {
        this.statement = statement;
    }

    public void setStatementComment(String statementComment) {
        this.statementComment = statementComment;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
