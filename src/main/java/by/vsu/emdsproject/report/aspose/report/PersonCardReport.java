package by.vsu.emdsproject.report.aspose.report;

import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.PersonCardDS;
import com.aspose.words.*;

public class PersonCardReport extends AsposeReport {

    protected String templateNameWithPhoto;

    public void setTemplateNameWithPhoto(String templateNameWithPhoto) {
        this.templateNameWithPhoto = templateNameWithPhoto;
    }

    public PersonCardReport() {
    }

    @Override
    public Document generate() throws Exception {
        AbstractReportDataSource ds = getDataSource();
        Document document;
        if (!ds.isEmpty()) {
            document = new Document(getTemplateFilePath(templateNameWithPhoto));
            NodeCollection shapes = document.getChildNodes(NodeType.SHAPE, true);
            Shape image = (Shape) shapes.get(1);
            if (getDataSource().next()) {
                byte[] photoData = (byte[]) ds.getFieldValue(PersonCardDS.DataSourceParameter.PHOTO_DATA);
                image.getImageData().setImage(photoData);
            }
        } else {
            document = new Document(getTemplateFilePath(templateName));
        }
        replaceParametersInDocument(document);
        return document;
    }
}
