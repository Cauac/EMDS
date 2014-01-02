package by.vsu.emdsproject.common;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;
import java.security.ProtectionDomain;

/**
 * EMDS Launcher
 *
 * Author: Max Vasileusky
 * Date: 02.01.14
 */
public class Launcher {

    public static void main(String[] args) throws Exception {

        Server server = new Server();

        HttpConfiguration httpConfig = new HttpConfiguration();
        httpConfig.setSecureScheme("http");
        httpConfig.setSecurePort(8080);
        httpConfig.setOutputBufferSize(32768);

        ServerConnector connector = new ServerConnector(server, new HttpConnectionFactory(httpConfig));
        connector.setPort(8080);
        connector.setIdleTimeout(30000);
        server.addConnector(connector);

        WebAppContext context = new WebAppContext("src/main/webapp", "/EMDS");

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            // fix for Windows, so Jetty doesn't lock files
            context.getInitParams().put("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
        }

        server.setHandler(context);
        server.start();
        server.join();
    }

}
