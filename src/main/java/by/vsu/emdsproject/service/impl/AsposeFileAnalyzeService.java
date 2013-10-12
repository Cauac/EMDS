package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.service.FileAnalyzeService;
import com.aspose.words.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class AsposeFileAnalyzeService implements FileAnalyzeService {

    @Override
    public Map<String, String> extractStudentProgress(InputStream file) throws Exception {
        Map<String, String> result = new HashMap<>();
        Document document = new Document(file);
        Table table = (Table) document.getChild(NodeType.TABLE, 1, true);
        table.getRows().removeAt(0);
        for (Row row : table.getRows()) {
            NodeCollection<Cell> cells = row.getCells();
            String fio = cells.get(1).getFirstParagraph().getText().trim();
            String value = cells.get(2).getFirstParagraph().getText();
            result.put(fio, value);
        }
        return result;
    }
}
