package by.vsu.emdsproject.service;

import java.io.InputStream;
import java.util.Map;

public interface FileAnalyzeService {

      public Map<String, String> extractStudentProgress(InputStream file) throws Exception;

}
