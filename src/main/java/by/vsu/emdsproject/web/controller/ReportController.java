package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.report.ReportGenerator;
import by.vsu.emdsproject.report.ReportGeneratorFactory;
import by.vsu.emdsproject.report.aspose.generator.AsposeReportGenerator;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.PersonCardDS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "report")
public class ReportController {

    @Autowired
    StudentDAO studentDAO;

    @RequestMapping(value = "/personCard", method = RequestMethod.POST)
    public
    @ResponseBody
    String personCard(@RequestBody String studentId, HttpServletResponse response) {
        ReportGenerator generator = ReportGeneratorFactory.getDocxReportGenerator();
        AbstractReportDataSource dataSource = new PersonCardDS();
        Map map = new HashMap();
        map.put(PersonCardDS.DataSourceParameter.STUDENT, studentDAO.read(studentId));
        map.put(PersonCardDS.ReportParameter.WITH_PHOTO, false);
        dataSource.init(map);
        return generator.generate(dataSource, response);
    }

    @RequestMapping(value = "/get{file}", method = RequestMethod.GET)
    public void getFile(@PathVariable String file, HttpServletResponse response) throws Exception {
        System.out.println(file);
        AsposeReportGenerator generator = (AsposeReportGenerator) ReportGeneratorFactory.getDocxReportGenerator();
        generator.fetchReport(file,response);
    }

}