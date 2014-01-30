package by.vsu.emdsproject.report.aspose.report;

import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.PersonCardDS;
import com.aspose.words.*;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

public class PersonCardReport extends AsposeReport {

    protected String templateNameWithPhoto;

    public PersonCardReport(AbstractReportDataSource dataSource) {
        super(dataSource);
        templateName = "PersonCard.docx";
        templateNameWithPhoto = "PersonCardWithPhoto.docx";
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
                String s = (String) ds.getFieldValue(PersonCardDS.DataSourceParameter.PHOTO_DATA);
                image.getImageData().setImage(decodeToImage(s.substring(s.indexOf(",") + 1)));
            }
        } else {
            document = new Document(getTemplateFilePath(templateName));
        }
        replaceParametersInDocument(document);
        return document;
    }

    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
