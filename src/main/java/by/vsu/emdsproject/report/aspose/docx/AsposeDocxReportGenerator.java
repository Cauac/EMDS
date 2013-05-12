package by.vsu.emdsproject.report.aspose.docx;

import by.vsu.emdsproject.report.aspose.AsposeReportGenerator;
import com.aspose.words.SaveFormat;

public class AsposeDocxReportGenerator extends AsposeReportGenerator {

    public static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final String CONTENT_HEADER = "inline; filename=\"file.docx\"";;
    public static final String CONTENT_DESCRIPTION = "Content-Disposition";

    @Override
    protected String getContentType() {
        return CONTENT_TYPE;
    }

    @Override
    protected String getContentHeader() {
        return CONTENT_HEADER;
    }

    @Override
    protected String getContentDescription() {
        return CONTENT_DESCRIPTION;
    }

    @Override
    protected int getSaveFormat() {
        return SaveFormat.DOCX;
    }
}
