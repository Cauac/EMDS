package by.vsu.emdsproject.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.text.SimpleDateFormat;

@Configuration
@PropertySource("classpath:application.properties")
public class EMDSGlobal {

    public final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

}
