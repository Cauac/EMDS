package by.vsu.emdsproject.report.aspose;

import com.aspose.words.SaveFormat;

public class AsposeDocxReportGenerator extends AsposeReportGenerator {

    public static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final String CONTENT_HEADER = "inline; filename=\"file.docx\"";;
    public static final String CONTENT_DISCRIPTION = "Content-Disposition";

    @Override
    protected String getContentType() {
        return CONTENT_TYPE;
    }

    @Override
    protected String getContentHeader() {
        return CONTENT_HEADER;
    }

    @Override
    protected String getContentDiscription() {
        return CONTENT_DISCRIPTION;
    }

    @Override
    protected int getSaveFormat() {
        return SaveFormat.DOCX;
    }
}
