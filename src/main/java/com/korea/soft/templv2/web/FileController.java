package com.korea.soft.templv2.web;

import com.korea.soft.templv2.common.file.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Controller
public class FileController {
    @RequestMapping(value = "/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            String orginlFilenm = URLDecoder.decode(request.getParameter("orginlFilenm"), Charset.forName("UTF-8").name());
            String streFlpth = request.getParameter("streFlpth");
            String streFilenm = request.getParameter("streFilenm");
            String fileExtsn = request.getParameter("fileExtsn");

            File file = new File(streFlpth, streFilenm + fileExtsn);
            long fileSize = file.length();

            if (fileSize > 0) {

                String mimeType = FileUtil.getMimeTypeByExt(fileExtsn);
                log.error("MIME type of downloading file: {}", mimeType);

                response.setContentType(mimeType);
                FileUtil.setDisposition(orginlFilenm, request, response);
                response.setContentLength((int) fileSize);

                BufferedInputStream in = null;
                BufferedOutputStream out = null;

                try {

                    in = new BufferedInputStream(new FileInputStream(file));
                    out = new BufferedOutputStream(response.getOutputStream());

                    FileCopyUtils.copy(in, out);
                    out.flush();

                } catch (Exception ex) {
                    log.debug("IGNORED: {}", ex.getMessage());
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Exception ignore) {
                            log.debug("IGNORED: {}", ignore.getMessage());
                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (Exception ignore) {
                            log.debug("IGNORED: {}", ignore.getMessage());
                        }
                    }
                }

            } else {
                response.setContentType("text/html");
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().append("<script>");
                response.getWriter().append("alert('요청하신 파일을 찾을수 없습니다.');");
                response.getWriter().append("history.back();");
                response.getWriter().append("</script>");

            }

        } catch (Exception e) {
            log.error("{}", e);
        }
    }
    @RequestMapping(value = "/download/outer")
    public void downloadOuter(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            String orginlFilenm = URLDecoder.decode(request.getParameter("orginlFilenm"), Charset.forName("UTF-8").name());
            String streFlpth = request.getParameter("streFlpth");
            String fileExtsn = request.getParameter("fileExtsn");

            File outerfile = File.createTempFile(orginlFilenm,fileExtsn);

            String FILE_URL = streFlpth;
            try(InputStream in = new URL(FILE_URL).openStream()){
                IOUtils.copy(in, new FileOutputStream(outerfile));

            }

            long fileSize = outerfile.length();

            if (fileSize > 0) {

                String mimeType = FileUtil.getMimeTypeByExt(fileExtsn);
                log.error("MIME type of downloading file: {}", mimeType);

                response.setContentType(mimeType);
                FileUtil.setDisposition(orginlFilenm, request, response);
                response.setContentLength((int) fileSize);

                BufferedInputStream in = null;
                BufferedOutputStream out = null;

                try {

                    in = new BufferedInputStream(new FileInputStream(outerfile));
                    out = new BufferedOutputStream(response.getOutputStream());

                    FileCopyUtils.copy(in, out);
                    out.flush();

                } catch (Exception ex) {
                    log.debug("IGNORED: {}", ex.getMessage());
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Exception ignore) {
                            log.debug("IGNORED: {}", ignore.getMessage());
                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (Exception ignore) {
                            log.debug("IGNORED: {}", ignore.getMessage());
                        }
                    }
                }

            } else {
                response.setContentType("text/html");
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().append("<script>");
                response.getWriter().append("alert('요청하신 파일을 찾을수 없습니다.');");
                response.getWriter().append("history.back();");
                response.getWriter().append("</script>");

            }

        } catch (Exception e) {
            response.setContentType("text/html");
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().append("<script>");
            response.getWriter().append("alert('요청하신 파일을 찾을수 없습니다.');");
            response.getWriter().append("history.back();");
            response.getWriter().append("</script>");
            log.error("{}", e);
        }
    }
}
