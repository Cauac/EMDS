package by.vsu.emdsproject.report.aspose.generator;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

public class AsposeDocxReportGenerator extends AsposeReportGenerator {

    public static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final String CONTENT_HEADER = "inline; filename=\"отчет.docx\"";
    public static final String CONTENT_DESCRIPTION = "Content-Disposition";


    public void exportDocumentInServlet(Document document, HttpServletResponse response) throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        document.save(stream, SaveFormat.DOCX);

        response.setContentLength(stream.size());
        response.setContentType(CONTENT_TYPE);
        response.setHeader(CONTENT_DESCRIPTION, CONTENT_HEADER);

        ServletOutputStream servletStream = response.getOutputStream();
        stream.writeTo(servletStream);
        servletStream.flush();
        servletStream.close();
    }
}
