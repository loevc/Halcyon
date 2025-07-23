package org.loevc.cloud.halcyon.admin.example.download;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class CaptureFile {

    @GetMapping("/download/a_b_png")
    public void downloadFile(HttpServletResponse response) throws IOException {

        String fileName = "a.b.png";

        ClassPathResource resource = new ClassPathResource(fileName);

        if (!resource.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
            return;
        }

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=\"" + fileName + "\""
        );


        try (InputStream is = resource.getInputStream();
             OutputStream os = response.getOutputStream()) {
            StreamUtils.copy(is, os);
        }
    }
}
