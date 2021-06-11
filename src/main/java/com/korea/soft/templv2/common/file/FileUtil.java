package com.korea.soft.templv2.common.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	public static Atchmnfl uploadFile(MultipartFile multipartFile, String streFlpth) throws Exception {
		Atchmnfl result = new Atchmnfl();
		try {
			if (multipartFile.isEmpty()) {
				return null;
			}
			result = uploadFile(multipartFile, streFlpth, getUnixTimeStamp());
		} catch (Exception e) {
			logger.error("{}", e);
		}
		return result;
	}
	
	public static Atchmnfl uploadFile(MultipartFile multipartFile, String streFlpth, String streFilenm) throws Exception {
		
		Atchmnfl result = new Atchmnfl();
		
		try {
			
			if (multipartFile.isEmpty()) {
				return null;
			}
			
			File path = new File(streFlpth);
			if (!path.exists() || path.isFile()) {
				path.mkdirs();
			}
			
			result.setOrginlFilenm(multipartFile.getOriginalFilename());
			result.setStreFlpth(path.getAbsolutePath());
			result.setStreFilenm(streFilenm);
			result.setFileExtsn(
					multipartFile.getOriginalFilename().substring(
							multipartFile.getOriginalFilename().lastIndexOf(".") + 1));
			result.setFileSize(multipartFile.getSize());
			
			logger.debug("orginlFilenm : {}", result.getOrginlFilenm());
			logger.debug("streFlpth : {}", result.getStreFlpth());
			logger.debug("streFilenm : {}", result.getStreFilenm());
			logger.debug("fileExtsn : {}", result.getFileExtsn());
			logger.debug("fileSize : {}", result.getFileSize());
			
			multipartFile.transferTo(new File(path.getAbsoluteFile() + File.separator + streFilenm + "." + result.getFileExtsn()));
			Thread.sleep(100);
			
		} catch (Exception e) {
			logger.error("{}", e);
		}
		
		return result;
		
	}
	
	public static List<Atchmnfl> uploadFiles(MultipartFile[] multipartFiles, String streFlpth) throws Exception {
		List<Atchmnfl> result = new ArrayList<Atchmnfl>();
		try {
			for (int i = 0; i < multipartFiles.length; i++) {
				MultipartFile multipartFile = multipartFiles[i];
				if (!multipartFile.isEmpty()) {
					Atchmnfl atchmnfl = uploadFile(multipartFile, streFlpth);
					result.add(atchmnfl);
				}
			}
		} catch (Exception e) {
			logger.error("{}", e);
		}
		return result;
	}
	
	public static List<Atchmnfl> uploadFiles(List<MultipartFile> multipartFiles, String streFlpth) throws Exception {
		List<Atchmnfl> result = new ArrayList<Atchmnfl>();
		try {
			for (int i = 0; i < multipartFiles.size(); i++) {
				MultipartFile multipartFile = multipartFiles.get(i);
				if (!multipartFile.isEmpty()) {
					Atchmnfl atchmnfl = uploadFile(multipartFile, streFlpth);
					result.add(atchmnfl);
				}
			}
		} catch (Exception e) {
			logger.error("{}", e);
		}
		return result;
	}
	
	public static boolean removeFile(String streFlpth, String streFilenm) throws Exception {
		boolean result = false;
		try {
			File file = new File(streFlpth + File.separator + streFilenm);
			if (file.exists()) {
				file.delete();
			}
			result = true;
		} catch (Exception e) {
			logger.error("{}", e);
		}
		return result;
	}
	
	public static boolean removeDirectory(File path) {
		if(!path.exists()) {
			return false;
		}
		File[] files = path.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				removeDirectory(file);
			} else {
				file.delete();
			}
		}
	    return path.delete();
	}
	
	public static void setDisposition(String fileName,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String browser = getClientBrowser(request);
		
		String dispositionPrefix = "attachment; filename=";
		String encodedFileName = null;
		
		if (browser.equals("MSIE")) {
			encodedFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20") + ";";
		} else if (browser.equals("Firefox")) {
			encodedFileName = "\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFileName = "\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < fileName.length(); i++) {
				char c = fileName.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFileName = sb.toString();
			
		} else if (browser.equals("Android")) {
			encodedFileName = "\"" + URLEncoder.encode(fileName, "UTF-8") + "\"";
		} else {
			encodedFileName = URLEncoder.encode(fileName, "UTF-8");
		}
		
		response.addHeader("Content-Disposition", dispositionPrefix + encodedFileName);
		
		if (browser.equals("Opera")) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
		
	}
	
	public static String getClientBrowser(HttpServletRequest request) {
		
		String result = "Firefox";
		String userAgent = request.getHeader("User-Agent");
		
		if (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1) {
			result = "MSIE";
		} else if (userAgent.indexOf("Safari") > -1) {
			result = "Safari";
		} else if (userAgent.indexOf("Chrome") > -1) {
			result = "Chrome";
		} else if (userAgent.indexOf("Opera") > -1) {
			result = "Opera";
		} else if (userAgent.indexOf("Android") > -1) {
			result = "Android";
		}
		
		return result;
		
	}
	
	public static String getUnixTimeStamp() {
		return Long.toString(System.currentTimeMillis());
	}
	
	public static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}
	
	public static String getMimeTypeByExt(String ext) {
		
		String mimeType = "application/octet-stream";
		
		if ("apk".equals(ext)) {
			mimeType = "application/vnd.android.package-archive";
		}
		if ("3dm".equals(ext)) {
			mimeType = "x-world/x-3dmf";
		}
		if ("3dmf".equals(ext)) {
			mimeType = "x-world/x-3dmf";
		}
		if ("a".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("aab".equals(ext)) {
			mimeType = "application/x-authorware-bin";
		}
		if ("aam".equals(ext)) {
			mimeType = "application/x-authorware-map";
		}
		if ("aas".equals(ext)) {
			mimeType = "application/x-authorware-seg";
		}
		if ("abc".equals(ext)) {
			mimeType = "text/vnd.abc";
		}
		if ("acgi".equals(ext)) {
			mimeType = "text/html";
		}
		if ("afl".equals(ext)) {
			mimeType = "video/animaflex";
		}
		if ("ai".equals(ext)) {
			mimeType = "application/postscript";
		}
		if ("aif".equals(ext)) {
			mimeType = "audio/aiff";
		}
		if ("aif".equals(ext)) {
			mimeType = "audio/x-aiff";
		}
		if ("aifc".equals(ext)) {
			mimeType = "audio/aiff";
		}
		if ("aifc".equals(ext)) {
			mimeType = "audio/x-aiff";
		}
		if ("aiff".equals(ext)) {
			mimeType = "audio/aiff";
		}
		if ("aiff".equals(ext)) {
			mimeType = "audio/x-aiff";
		}
		if ("aim".equals(ext)) {
			mimeType = "application/x-aim";
		}
		if ("aip".equals(ext)) {
			mimeType = "text/x-audiosoft-intra";
		}
		if ("ani".equals(ext)) {
			mimeType = "application/x-navi-animation";
		}
		if ("aos".equals(ext)) {
			mimeType = "application/x-nokia-9000-communicator-add-on-software";
		}
		if ("aps".equals(ext)) {
			mimeType = "application/mime";
		}
		if ("arc".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("arj".equals(ext)) {
			mimeType = "application/arj";
		}
		if ("arj".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("art".equals(ext)) {
			mimeType = "image/x-jg";
		}
		if ("asf".equals(ext)) {
			mimeType = "video/x-ms-asf";
		}
		if ("asm".equals(ext)) {
			mimeType = "text/x-asm";
		}
		if ("asp".equals(ext)) {
			mimeType = "text/asp";
		}
		if ("asx".equals(ext)) {
			mimeType = "application/x-mplayer2";
		}
		if ("asx".equals(ext)) {
			mimeType = "video/x-ms-asf";
		}
		if ("asx".equals(ext)) {
			mimeType = "video/x-ms-asf-plugin";
		}
		if ("au".equals(ext)) {
			mimeType = "audio/basic";
		}
		if ("au".equals(ext)) {
			mimeType = "audio/x-au";
		}
		if ("avi".equals(ext)) {
			mimeType = "application/x-troff-msvideo";
		}
		if ("avi".equals(ext)) {
			mimeType = "video/avi";
		}
		if ("avi".equals(ext)) {
			mimeType = "video/msvideo";
		}
		if ("avi".equals(ext)) {
			mimeType = "video/x-msvideo";
		}
		if ("avs".equals(ext)) {
			mimeType = "video/avs-video";
		}
		if ("bcpio".equals(ext)) {
			mimeType = "application/x-bcpio";
		}
		if ("bin".equals(ext)) {
			mimeType = "application/mac-binary";
		}
		if ("bin".equals(ext)) {
			mimeType = "application/macbinary";
		}
		if ("bin".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("bin".equals(ext)) {
			mimeType = "application/x-binary";
		}
		if ("bin".equals(ext)) {
			mimeType = "application/x-macbinary";
		}
		if ("bm".equals(ext)) {
			mimeType = "image/bmp";
		}
		if ("bmp".equals(ext)) {
			mimeType = "image/bmp";
		}
		if ("bmp".equals(ext)) {
			mimeType = "image/x-windows-bmp";
		}
		if ("boo".equals(ext)) {
			mimeType = "application/book";
		}
		if ("book".equals(ext)) {
			mimeType = "application/book";
		}
		if ("boz".equals(ext)) {
			mimeType = "application/x-bzip2";
		}
		if ("bsh".equals(ext)) {
			mimeType = "application/x-bsh";
		}
		if ("bz".equals(ext)) {
			mimeType = "application/x-bzip";
		}
		if ("bz2".equals(ext)) {
			mimeType = "application/x-bzip2";
		}
		if ("c".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("c".equals(ext)) {
			mimeType = "text/x-c";
		}
		if ("c++".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("cat".equals(ext)) {
			mimeType = "application/vnd.ms-pki.seccat";
		}
		if ("cc".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("cc".equals(ext)) {
			mimeType = "text/x-c";
		}
		if ("ccad".equals(ext)) {
			mimeType = "application/clariscad";
		}
		if ("cco".equals(ext)) {
			mimeType = "application/x-cocoa";
		}
		if ("cdf".equals(ext)) {
			mimeType = "application/cdf";
		}
		if ("cdf".equals(ext)) {
			mimeType = "application/x-cdf";
		}
		if ("cdf".equals(ext)) {
			mimeType = "application/x-netcdf";
		}
		if ("cer".equals(ext)) {
			mimeType = "application/pkix-cert";
		}
		if ("cer".equals(ext)) {
			mimeType = "application/x-x509-ca-cert";
		}
		if ("cha".equals(ext)) {
			mimeType = "application/x-chat";
		}
		if ("chat".equals(ext)) {
			mimeType = "application/x-chat";
		}
		if ("class".equals(ext)) {
			mimeType = "application/java";
		}
		if ("class".equals(ext)) {
			mimeType = "application/java-byte-code";
		}
		if ("class".equals(ext)) {
			mimeType = "application/x-java-class";
		}
		if ("com".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("com".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("conf".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("cpio".equals(ext)) {
			mimeType = "application/x-cpio";
		}
		if ("cpp".equals(ext)) {
			mimeType = "text/x-c";
		}
		if ("cpt".equals(ext)) {
			mimeType = "application/mac-compactpro";
		}
		if ("cpt".equals(ext)) {
			mimeType = "application/x-compactpro";
		}
		if ("cpt".equals(ext)) {
			mimeType = "application/x-cpt";
		}
		if ("crl".equals(ext)) {
			mimeType = "application/pkcs-crl";
		}
		if ("crl".equals(ext)) {
			mimeType = "application/pkix-crl";
		}
		if ("crt".equals(ext)) {
			mimeType = "application/pkix-cert";
		}
		if ("crt".equals(ext)) {
			mimeType = "application/x-x509-ca-cert";
		}
		if ("crt".equals(ext)) {
			mimeType = "application/x-x509-user-cert";
		}
		if ("csh".equals(ext)) {
			mimeType = "application/x-csh";
		}
		if ("csh".equals(ext)) {
			mimeType = "text/x-script.csh";
		}
		if ("css".equals(ext)) {
			mimeType = "application/x-pointplus";
		}
		if ("css".equals(ext)) {
			mimeType = "text/css";
		}
		if ("cxx".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("dcr".equals(ext)) {
			mimeType = "application/x-director";
		}
		if ("deepv".equals(ext)) {
			mimeType = "application/x-deepv";
		}
		if ("def".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("der".equals(ext)) {
			mimeType = "application/x-x509-ca-cert";
		}
		if ("dif".equals(ext)) {
			mimeType = "video/x-dv";
		}
		if ("dir".equals(ext)) {
			mimeType = "application/x-director";
		}
		if ("dl".equals(ext)) {
			mimeType = "video/dl";
		}
		if ("dl".equals(ext)) {
			mimeType = "video/x-dl";
		}
		if ("doc".equals(ext)) {
			mimeType = "application/msword";
		}
		if ("dot".equals(ext)) {
			mimeType = "application/msword";
		}
		if ("dp".equals(ext)) {
			mimeType = "application/commonground";
		}
		if ("drw".equals(ext)) {
			mimeType = "application/drafting";
		}
		if ("dump".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("dv".equals(ext)) {
			mimeType = "video/x-dv";
		}
		if ("dvi".equals(ext)) {
			mimeType = "application/x-dvi";
		}
		if ("dwf".equals(ext)) {
			mimeType = "drawing/x-dwf (old)";
		}
		if ("dwf".equals(ext)) {
			mimeType = "model/vnd.dwf";
		}
		if ("dwg".equals(ext)) {
			mimeType = "application/acad";
		}
		if ("dwg".equals(ext)) {
			mimeType = "image/vnd.dwg";
		}
		if ("dwg".equals(ext)) {
			mimeType = "image/x-dwg";
		}
		if ("dxf".equals(ext)) {
			mimeType = "application/dxf";
		}
		if ("dxf".equals(ext)) {
			mimeType = "image/vnd.dwg";
		}
		if ("dxf".equals(ext)) {
			mimeType = "image/x-dwg";
		}
		if ("dxr".equals(ext)) {
			mimeType = "application/x-director";
		}
		if ("el".equals(ext)) {
			mimeType = "text/x-script.elisp";
		}
		if ("elc".equals(ext)) {
			mimeType = "application/x-bytecode.elisp (compiled elisp)";
		}
		if ("elc".equals(ext)) {
			mimeType = "application/x-elc";
		}
		if ("env".equals(ext)) {
			mimeType = "application/x-envoy";
		}
		if ("eps".equals(ext)) {
			mimeType = "application/postscript";
		}
		if ("es".equals(ext)) {
			mimeType = "application/x-esrehber";
		}
		if ("etx".equals(ext)) {
			mimeType = "text/x-setext";
		}
		if ("evy".equals(ext)) {
			mimeType = "application/envoy";
		}
		if ("evy".equals(ext)) {
			mimeType = "application/x-envoy";
		}
		if ("exe".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("f".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("f".equals(ext)) {
			mimeType = "text/x-fortran";
		}
		if ("f77".equals(ext)) {
			mimeType = "text/x-fortran";
		}
		if ("f90".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("f90".equals(ext)) {
			mimeType = "text/x-fortran";
		}
		if ("fdf".equals(ext)) {
			mimeType = "application/vnd.fdf";
		}
		if ("fif".equals(ext)) {
			mimeType = "application/fractals";
		}
		if ("fif".equals(ext)) {
			mimeType = "image/fif";
		}
		if ("fli".equals(ext)) {
			mimeType = "video/fli";
		}
		if ("fli".equals(ext)) {
			mimeType = "video/x-fli";
		}
		if ("flo".equals(ext)) {
			mimeType = "image/florian";
		}
		if ("flx".equals(ext)) {
			mimeType = "text/vnd.fmi.flexstor";
		}
		if ("fmf".equals(ext)) {
			mimeType = "video/x-atomic3d-feature";
		}
		if ("for".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("for".equals(ext)) {
			mimeType = "text/x-fortran";
		}
		if ("fpx".equals(ext)) {
			mimeType = "image/vnd.fpx";
		}
		if ("fpx".equals(ext)) {
			mimeType = "image/vnd.net-fpx";
		}
		if ("frl".equals(ext)) {
			mimeType = "application/freeloader";
		}
		if ("funk".equals(ext)) {
			mimeType = "audio/make";
		}
		if ("g".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("g3".equals(ext)) {
			mimeType = "image/g3fax";
		}
		if ("gif".equals(ext)) {
			mimeType = "image/gif";
		}
		if ("gl".equals(ext)) {
			mimeType = "video/gl";
		}
		if ("gl".equals(ext)) {
			mimeType = "video/x-gl";
		}
		if ("gsd".equals(ext)) {
			mimeType = "audio/x-gsm";
		}
		if ("gsm".equals(ext)) {
			mimeType = "audio/x-gsm";
		}
		if ("gsp".equals(ext)) {
			mimeType = "application/x-gsp";
		}
		if ("gss".equals(ext)) {
			mimeType = "application/x-gss";
		}
		if ("gtar".equals(ext)) {
			mimeType = "application/x-gtar";
		}
		if ("gz".equals(ext)) {
			mimeType = "application/x-compressed";
		}
		if ("gz".equals(ext)) {
			mimeType = "application/x-gzip";
		}
		if ("gzip".equals(ext)) {
			mimeType = "application/x-gzip";
		}
		if ("gzip".equals(ext)) {
			mimeType = "multipart/x-gzip";
		}
		if ("h".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("h".equals(ext)) {
			mimeType = "text/x-h";
		}
		if ("hdf".equals(ext)) {
			mimeType = "application/x-hdf";
		}
		if ("help".equals(ext)) {
			mimeType = "application/x-helpfile";
		}
		if ("hgl".equals(ext)) {
			mimeType = "application/vnd.hp-hpgl";
		}
		if ("hh".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("hh".equals(ext)) {
			mimeType = "text/x-h";
		}
		if ("hlb".equals(ext)) {
			mimeType = "text/x-script";
		}
		if ("hlp".equals(ext)) {
			mimeType = "application/hlp";
		}
		if ("hlp".equals(ext)) {
			mimeType = "application/x-helpfile";
		}
		if ("hlp".equals(ext)) {
			mimeType = "application/x-winhelp";
		}
		if ("hpg".equals(ext)) {
			mimeType = "application/vnd.hp-hpgl";
		}
		if ("hpgl".equals(ext)) {
			mimeType = "application/vnd.hp-hpgl";
		}
		if ("hqx".equals(ext)) {
			mimeType = "application/binhex";
		}
		if ("hqx".equals(ext)) {
			mimeType = "application/binhex4";
		}
		if ("hqx".equals(ext)) {
			mimeType = "application/mac-binhex";
		}
		if ("hqx".equals(ext)) {
			mimeType = "application/mac-binhex40";
		}
		if ("hqx".equals(ext)) {
			mimeType = "application/x-binhex40";
		}
		if ("hqx".equals(ext)) {
			mimeType = "application/x-mac-binhex40";
		}
		if ("hta".equals(ext)) {
			mimeType = "application/hta";
		}
		if ("htc".equals(ext)) {
			mimeType = "text/x-component";
		}
		if ("htm".equals(ext)) {
			mimeType = "text/html";
		}
		if ("html".equals(ext)) {
			mimeType = "text/html";
		}
		if ("htmls".equals(ext)) {
			mimeType = "text/html";
		}
		if ("htt".equals(ext)) {
			mimeType = "text/webviewhtml";
		}
		if ("htx".equals(ext)) {
			mimeType = "text/html";
		}
		if ("ice".equals(ext)) {
			mimeType = "x-conference/x-cooltalk";
		}
		if ("ico".equals(ext)) {
			mimeType = "image/x-icon";
		}
		if ("idc".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("ief".equals(ext)) {
			mimeType = "image/ief";
		}
		if ("iefs".equals(ext)) {
			mimeType = "image/ief";
		}
		if ("iges".equals(ext)) {
			mimeType = "application/iges";
		}
		if ("iges".equals(ext)) {
			mimeType = "model/iges";
		}
		if ("igs".equals(ext)) {
			mimeType = "application/iges";
		}
		if ("igs".equals(ext)) {
			mimeType = "model/iges";
		}
		if ("ima".equals(ext)) {
			mimeType = "application/x-ima";
		}
		if ("imap".equals(ext)) {
			mimeType = "application/x-httpd-imap";
		}
		if ("inf".equals(ext)) {
			mimeType = "application/inf";
		}
		if ("ins".equals(ext)) {
			mimeType = "application/x-internett-signup";
		}
		if ("ip".equals(ext)) {
			mimeType = "application/x-ip2";
		}
		if ("isu".equals(ext)) {
			mimeType = "video/x-isvideo";
		}
		if ("it".equals(ext)) {
			mimeType = "audio/it";
		}
		if ("iv".equals(ext)) {
			mimeType = "application/x-inventor";
		}
		if ("ivr".equals(ext)) {
			mimeType = "i-world/i-vrml";
		}
		if ("ivy".equals(ext)) {
			mimeType = "application/x-livescreen";
		}
		if ("jam".equals(ext)) {
			mimeType = "audio/x-jam";
		}
		if ("jav".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("jav".equals(ext)) {
			mimeType = "text/x-java-source";
		}
		if ("java".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("java".equals(ext)) {
			mimeType = "text/x-java-source";
		}
		if ("jcm".equals(ext)) {
			mimeType = "application/x-java-commerce";
		}
		if ("jfif".equals(ext)) {
			mimeType = "image/jpeg";
		}
		if ("jfif".equals(ext)) {
			mimeType = "image/pjpeg";
		}
		if ("jfif-tbnl".equals(ext)) {
			mimeType = "image/jpeg";
		}
		if ("jpe".equals(ext)) {
			mimeType = "image/jpeg";
		}
		if ("jpe".equals(ext)) {
			mimeType = "image/pjpeg";
		}
		if ("jpeg".equals(ext)) {
			mimeType = "image/jpeg";
		}
		if ("jpeg".equals(ext)) {
			mimeType = "image/pjpeg";
		}
		if ("jpg".equals(ext)) {
			mimeType = "image/jpeg";
		}
		if ("jpg".equals(ext)) {
			mimeType = "image/pjpeg";
		}
		if ("jps".equals(ext)) {
			mimeType = "image/x-jps";
		}
		if ("js".equals(ext)) {
			mimeType = "application/x-javascript";
		}
		if ("js".equals(ext)) {
			mimeType = "application/javascript";
		}
		if ("js".equals(ext)) {
			mimeType = "application/ecmascript";
		}
		if ("js".equals(ext)) {
			mimeType = "text/javascript";
		}
		if ("js".equals(ext)) {
			mimeType = "text/ecmascript";
		}
		if ("jut".equals(ext)) {
			mimeType = "image/jutvision";
		}
		if ("kar".equals(ext)) {
			mimeType = "audio/midi";
		}
		if ("kar".equals(ext)) {
			mimeType = "music/x-karaoke";
		}
		if ("ksh".equals(ext)) {
			mimeType = "application/x-ksh";
		}
		if ("ksh".equals(ext)) {
			mimeType = "text/x-script.ksh";
		}
		if ("la".equals(ext)) {
			mimeType = "audio/nspaudio";
		}
		if ("la".equals(ext)) {
			mimeType = "audio/x-nspaudio";
		}
		if ("lam".equals(ext)) {
			mimeType = "audio/x-liveaudio";
		}
		if ("latex".equals(ext)) {
			mimeType = "application/x-latex";
		}
		if ("lha".equals(ext)) {
			mimeType = "application/lha";
		}
		if ("lha".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("lha".equals(ext)) {
			mimeType = "application/x-lha";
		}
		if ("lhx".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("list".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("lma".equals(ext)) {
			mimeType = "audio/nspaudio";
		}
		if ("lma".equals(ext)) {
			mimeType = "audio/x-nspaudio";
		}
		if ("log".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("lsp".equals(ext)) {
			mimeType = "application/x-lisp";
		}
		if ("lsp".equals(ext)) {
			mimeType = "text/x-script.lisp";
		}
		if ("lst".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("lsx".equals(ext)) {
			mimeType = "text/x-la-asf";
		}
		if ("ltx".equals(ext)) {
			mimeType = "application/x-latex";
		}
		if ("lzh".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("lzh".equals(ext)) {
			mimeType = "application/x-lzh";
		}
		if ("lzx".equals(ext)) {
			mimeType = "application/lzx";
		}
		if ("lzx".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("lzx".equals(ext)) {
			mimeType = "application/x-lzx";
		}
		if ("m".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("m".equals(ext)) {
			mimeType = "text/x-m";
		}
		if ("m1v".equals(ext)) {
			mimeType = "video/mpeg";
		}
		if ("m2a".equals(ext)) {
			mimeType = "audio/mpeg";
		}
		if ("m2v".equals(ext)) {
			mimeType = "video/mpeg";
		}
		if ("m3u".equals(ext)) {
			mimeType = "audio/x-mpequrl";
		}
		if ("man".equals(ext)) {
			mimeType = "application/x-troff-man";
		}
		if ("map".equals(ext)) {
			mimeType = "application/x-navimap";
		}
		if ("mar".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("mbd".equals(ext)) {
			mimeType = "application/mbedlet";
		}
		if ("mc$".equals(ext)) {
			mimeType = "application/x-magic-cap-package-1.0";
		}
		if ("mcd".equals(ext)) {
			mimeType = "application/mcad";
		}
		if ("mcd".equals(ext)) {
			mimeType = "application/x-mathcad";
		}
		if ("mcf".equals(ext)) {
			mimeType = "image/vasa";
		}
		if ("mcf".equals(ext)) {
			mimeType = "text/mcf";
		}
		if ("mcp".equals(ext)) {
			mimeType = "application/netmc";
		}
		if ("me".equals(ext)) {
			mimeType = "application/x-troff-me";
		}
		if ("mht".equals(ext)) {
			mimeType = "message/rfc822";
		}
		if ("mhtml".equals(ext)) {
			mimeType = "message/rfc822";
		}
		if ("mid".equals(ext)) {
			mimeType = "application/x-midi";
		}
		if ("mid".equals(ext)) {
			mimeType = "audio/midi";
		}
		if ("mid".equals(ext)) {
			mimeType = "audio/x-mid";
		}
		if ("mid".equals(ext)) {
			mimeType = "audio/x-midi";
		}
		if ("mid".equals(ext)) {
			mimeType = "music/crescendo";
		}
		if ("mid".equals(ext)) {
			mimeType = "x-music/x-midi";
		}
		if ("midi".equals(ext)) {
			mimeType = "application/x-midi";
		}
		if ("midi".equals(ext)) {
			mimeType = "audio/midi";
		}
		if ("midi".equals(ext)) {
			mimeType = "audio/x-mid";
		}
		if ("midi".equals(ext)) {
			mimeType = "audio/x-midi";
		}
		if ("midi".equals(ext)) {
			mimeType = "music/crescendo";
		}
		if ("midi".equals(ext)) {
			mimeType = "x-music/x-midi";
		}
		if ("mif".equals(ext)) {
			mimeType = "application/x-frame";
		}
		if ("mif".equals(ext)) {
			mimeType = "application/x-mif";
		}
		if ("mime".equals(ext)) {
			mimeType = "message/rfc822";
		}
		if ("mime".equals(ext)) {
			mimeType = "www/mime";
		}
		if ("mjf".equals(ext)) {
			mimeType = "audio/x-vnd.audioexplosion.mjuicemediafile";
		}
		if ("mjpg".equals(ext)) {
			mimeType = "video/x-motion-jpeg";
		}
		if ("mm".equals(ext)) {
			mimeType = "application/base64";
		}
		if ("mm".equals(ext)) {
			mimeType = "application/x-meme";
		}
		if ("mme".equals(ext)) {
			mimeType = "application/base64";
		}
		if ("mod".equals(ext)) {
			mimeType = "audio/mod";
		}
		if ("mod".equals(ext)) {
			mimeType = "audio/x-mod";
		}
		if ("moov".equals(ext)) {
			mimeType = "video/quicktime";
		}
		if ("mov".equals(ext)) {
			mimeType = "video/quicktime";
		}
		if ("movie".equals(ext)) {
			mimeType = "video/x-sgi-movie";
		}
		if ("mp2".equals(ext)) {
			mimeType = "audio/mpeg";
		}
		if ("mp2".equals(ext)) {
			mimeType = "audio/x-mpeg";
		}
		if ("mp2".equals(ext)) {
			mimeType = "video/mpeg";
		}
		if ("mp2".equals(ext)) {
			mimeType = "video/x-mpeg";
		}
		if ("mp2".equals(ext)) {
			mimeType = "video/x-mpeq2a";
		}
		if ("mp3".equals(ext)) {
			mimeType = "audio/mpeg3";
		}
		if ("mp3".equals(ext)) {
			mimeType = "audio/x-mpeg-3";
		}
		if ("mp3".equals(ext)) {
			mimeType = "video/mpeg";
		}
		if ("mp3".equals(ext)) {
			mimeType = "video/x-mpeg";
		}
		if ("mpa".equals(ext)) {
			mimeType = "audio/mpeg";
		}
		if ("mpa".equals(ext)) {
			mimeType = "video/mpeg";
		}
		if ("mpc".equals(ext)) {
			mimeType = "application/x-project";
		}
		if ("mpe".equals(ext)) {
			mimeType = "video/mpeg";
		}
		if ("mpeg".equals(ext)) {
			mimeType = "video/mpeg";
		}
		if ("mpg".equals(ext)) {
			mimeType = "audio/mpeg";
		}
		if ("mpg".equals(ext)) {
			mimeType = "video/mpeg";
		}
		if ("mpga".equals(ext)) {
			mimeType = "audio/mpeg";
		}
		if ("mpp".equals(ext)) {
			mimeType = "application/vnd.ms-project";
		}
		if ("mpt".equals(ext)) {
			mimeType = "application/x-project";
		}
		if ("mpv".equals(ext)) {
			mimeType = "application/x-project";
		}
		if ("mpx".equals(ext)) {
			mimeType = "application/x-project";
		}
		if ("mrc".equals(ext)) {
			mimeType = "application/marc";
		}
		if ("ms".equals(ext)) {
			mimeType = "application/x-troff-ms";
		}
		if ("mv".equals(ext)) {
			mimeType = "video/x-sgi-movie";
		}
		if ("my".equals(ext)) {
			mimeType = "audio/make";
		}
		if ("mzz".equals(ext)) {
			mimeType = "application/x-vnd.audioexplosion.mzz";
		}
		if ("nap".equals(ext)) {
			mimeType = "image/naplps";
		}
		if ("naplps".equals(ext)) {
			mimeType = "image/naplps";
		}
		if ("nc".equals(ext)) {
			mimeType = "application/x-netcdf";
		}
		if ("ncm".equals(ext)) {
			mimeType = "application/vnd.nokia.configuration-message";
		}
		if ("nif".equals(ext)) {
			mimeType = "image/x-niff";
		}
		if ("niff".equals(ext)) {
			mimeType = "image/x-niff";
		}
		if ("nix".equals(ext)) {
			mimeType = "application/x-mix-transfer";
		}
		if ("nsc".equals(ext)) {
			mimeType = "application/x-conference";
		}
		if ("nvd".equals(ext)) {
			mimeType = "application/x-navidoc";
		}
		if ("o".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("oda".equals(ext)) {
			mimeType = "application/oda";
		}
		if ("omc".equals(ext)) {
			mimeType = "application/x-omc";
		}
		if ("omcd".equals(ext)) {
			mimeType = "application/x-omcdatamaker";
		}
		if ("omcr".equals(ext)) {
			mimeType = "application/x-omcregerator";
		}
		if ("p".equals(ext)) {
			mimeType = "text/x-pascal";
		}
		if ("p10".equals(ext)) {
			mimeType = "application/pkcs10";
		}
		if ("p10".equals(ext)) {
			mimeType = "application/x-pkcs10";
		}
		if ("p12".equals(ext)) {
			mimeType = "application/pkcs-12";
		}
		if ("p12".equals(ext)) {
			mimeType = "application/x-pkcs12";
		}
		if ("p7a".equals(ext)) {
			mimeType = "application/x-pkcs7-signature";
		}
		if ("p7c".equals(ext)) {
			mimeType = "application/pkcs7-mime";
		}
		if ("p7c".equals(ext)) {
			mimeType = "application/x-pkcs7-mime";
		}
		if ("p7m".equals(ext)) {
			mimeType = "application/pkcs7-mime";
		}
		if ("p7m".equals(ext)) {
			mimeType = "application/x-pkcs7-mime";
		}
		if ("p7r".equals(ext)) {
			mimeType = "application/x-pkcs7-certreqresp";
		}
		if ("p7s".equals(ext)) {
			mimeType = "application/pkcs7-signature";
		}
		if ("part".equals(ext)) {
			mimeType = "application/pro_eng";
		}
		if ("pas".equals(ext)) {
			mimeType = "text/pascal";
		}
		if ("pbm".equals(ext)) {
			mimeType = "image/x-portable-bitmap";
		}
		if ("pcl".equals(ext)) {
			mimeType = "application/vnd.hp-pcl";
		}
		if ("pcl".equals(ext)) {
			mimeType = "application/x-pcl";
		}
		if ("pct".equals(ext)) {
			mimeType = "image/x-pict";
		}
		if ("pcx".equals(ext)) {
			mimeType = "image/x-pcx";
		}
		if ("pdb".equals(ext)) {
			mimeType = "chemical/x-pdb";
		}
		if ("pdf".equals(ext)) {
			mimeType = "application/pdf";
		}
		if ("pfunk".equals(ext)) {
			mimeType = "audio/make";
		}
		if ("pfunk".equals(ext)) {
			mimeType = "audio/make.my.funk";
		}
		if ("pgm".equals(ext)) {
			mimeType = "image/x-portable-graymap";
		}
		if ("pgm".equals(ext)) {
			mimeType = "image/x-portable-greymap";
		}
		if ("pic".equals(ext)) {
			mimeType = "image/pict";
		}
		if ("pict".equals(ext)) {
			mimeType = "image/pict";
		}
		if ("pkg".equals(ext)) {
			mimeType = "application/x-newton-compatible-pkg";
		}
		if ("pko".equals(ext)) {
			mimeType = "application/vnd.ms-pki.pko";
		}
		if ("pl".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("pl".equals(ext)) {
			mimeType = "text/x-script.perl";
		}
		if ("plx".equals(ext)) {
			mimeType = "application/x-pixclscript";
		}
		if ("pm".equals(ext)) {
			mimeType = "image/x-xpixmap";
		}
		if ("pm".equals(ext)) {
			mimeType = "text/x-script.perl-module";
		}
		if ("pm4".equals(ext)) {
			mimeType = "application/x-pagemaker";
		}
		if ("pm5".equals(ext)) {
			mimeType = "application/x-pagemaker";
		}
		if ("png".equals(ext)) {
			mimeType = "image/png";
		}
		if ("pnm".equals(ext)) {
			mimeType = "application/x-portable-anymap";
		}
		if ("pnm".equals(ext)) {
			mimeType = "image/x-portable-anymap";
		}
		if ("pot".equals(ext)) {
			mimeType = "application/mspowerpoint";
		}
		if ("pot".equals(ext)) {
			mimeType = "application/vnd.ms-powerpoint";
		}
		if ("pov".equals(ext)) {
			mimeType = "model/x-pov";
		}
		if ("ppa".equals(ext)) {
			mimeType = "application/vnd.ms-powerpoint";
		}
		if ("ppm".equals(ext)) {
			mimeType = "image/x-portable-pixmap";
		}
		if ("pps".equals(ext)) {
			mimeType = "application/mspowerpoint";
		}
		if ("pps".equals(ext)) {
			mimeType = "application/vnd.ms-powerpoint";
		}
		if ("ppt".equals(ext)) {
			mimeType = "application/mspowerpoint";
		}
		if ("ppt".equals(ext)) {
			mimeType = "application/powerpoint";
		}
		if ("ppt".equals(ext)) {
			mimeType = "application/vnd.ms-powerpoint";
		}
		if ("ppt".equals(ext)) {
			mimeType = "application/x-mspowerpoint";
		}
		if ("ppz".equals(ext)) {
			mimeType = "application/mspowerpoint";
		}
		if ("pre".equals(ext)) {
			mimeType = "application/x-freelance";
		}
		if ("prt".equals(ext)) {
			mimeType = "application/pro_eng";
		}
		if ("ps".equals(ext)) {
			mimeType = "application/postscript";
		}
		if ("psd".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("pvu".equals(ext)) {
			mimeType = "paleovu/x-pv";
		}
		if ("pwz".equals(ext)) {
			mimeType = "application/vnd.ms-powerpoint";
		}
		if ("py".equals(ext)) {
			mimeType = "text/x-script.phyton";
		}
		if ("pyc".equals(ext)) {
			mimeType = "applicaiton/x-bytecode.python";
		}
		if ("qcp".equals(ext)) {
			mimeType = "audio/vnd.qcelp";
		}
		if ("qd3".equals(ext)) {
			mimeType = "x-world/x-3dmf";
		}
		if ("qd3d".equals(ext)) {
			mimeType = "x-world/x-3dmf";
		}
		if ("qif".equals(ext)) {
			mimeType = "image/x-quicktime";
		}
		if ("qt".equals(ext)) {
			mimeType = "video/quicktime";
		}
		if ("qtc".equals(ext)) {
			mimeType = "video/x-qtc";
		}
		if ("qti".equals(ext)) {
			mimeType = "image/x-quicktime";
		}
		if ("qtif".equals(ext)) {
			mimeType = "image/x-quicktime";
		}
		if ("ra".equals(ext)) {
			mimeType = "audio/x-pn-realaudio";
		}
		if ("ra".equals(ext)) {
			mimeType = "audio/x-pn-realaudio-plugin";
		}
		if ("ra".equals(ext)) {
			mimeType = "audio/x-realaudio";
		}
		if ("ram".equals(ext)) {
			mimeType = "audio/x-pn-realaudio";
		}
		if ("ras".equals(ext)) {
			mimeType = "application/x-cmu-raster";
		}
		if ("ras".equals(ext)) {
			mimeType = "image/cmu-raster";
		}
		if ("ras".equals(ext)) {
			mimeType = "image/x-cmu-raster";
		}
		if ("rast".equals(ext)) {
			mimeType = "image/cmu-raster";
		}
		if ("rexx".equals(ext)) {
			mimeType = "text/x-script.rexx";
		}
		if ("rf".equals(ext)) {
			mimeType = "image/vnd.rn-realflash";
		}
		if ("rgb".equals(ext)) {
			mimeType = "image/x-rgb";
		}
		if ("rm".equals(ext)) {
			mimeType = "application/vnd.rn-realmedia";
		}
		if ("rm".equals(ext)) {
			mimeType = "audio/x-pn-realaudio";
		}
		if ("rmi".equals(ext)) {
			mimeType = "audio/mid";
		}
		if ("rmm".equals(ext)) {
			mimeType = "audio/x-pn-realaudio";
		}
		if ("rmp".equals(ext)) {
			mimeType = "audio/x-pn-realaudio";
		}
		if ("rmp".equals(ext)) {
			mimeType = "audio/x-pn-realaudio-plugin";
		}
		if ("rng".equals(ext)) {
			mimeType = "application/ringing-tones";
		}
		if ("rng".equals(ext)) {
			mimeType = "application/vnd.nokia.ringing-tone";
		}
		if ("rnx".equals(ext)) {
			mimeType = "application/vnd.rn-realplayer";
		}
		if ("roff".equals(ext)) {
			mimeType = "application/x-troff";
		}
		if ("rp".equals(ext)) {
			mimeType = "image/vnd.rn-realpix";
		}
		if ("rpm".equals(ext)) {
			mimeType = "audio/x-pn-realaudio-plugin";
		}
		if ("rt".equals(ext)) {
			mimeType = "text/richtext";
		}
		if ("rt".equals(ext)) {
			mimeType = "text/vnd.rn-realtext";
		}
		if ("rtf".equals(ext)) {
			mimeType = "application/rtf";
		}
		if ("rtf".equals(ext)) {
			mimeType = "application/x-rtf";
		}
		if ("rtf".equals(ext)) {
			mimeType = "text/richtext";
		}
		if ("rtx".equals(ext)) {
			mimeType = "application/rtf";
		}
		if ("rtx".equals(ext)) {
			mimeType = "text/richtext";
		}
		if ("rv".equals(ext)) {
			mimeType = "video/vnd.rn-realvideo";
		}
		if ("s".equals(ext)) {
			mimeType = "text/x-asm";
		}
		if ("s3m".equals(ext)) {
			mimeType = "audio/s3m";
		}
		if ("saveme".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("sbk".equals(ext)) {
			mimeType = "application/x-tbook";
		}
		if ("scm".equals(ext)) {
			mimeType = "application/x-lotusscreencam";
		}
		if ("scm".equals(ext)) {
			mimeType = "text/x-script.guile";
		}
		if ("scm".equals(ext)) {
			mimeType = "text/x-script.scheme";
		}
		if ("scm".equals(ext)) {
			mimeType = "video/x-scm";
		}
		if ("sdml".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("sdp".equals(ext)) {
			mimeType = "application/sdp";
		}
		if ("sdp".equals(ext)) {
			mimeType = "application/x-sdp";
		}
		if ("sdr".equals(ext)) {
			mimeType = "application/sounder";
		}
		if ("sea".equals(ext)) {
			mimeType = "application/sea";
		}
		if ("sea".equals(ext)) {
			mimeType = "application/x-sea";
		}
		if ("set".equals(ext)) {
			mimeType = "application/set";
		}
		if ("sgm".equals(ext)) {
			mimeType = "text/sgml";
		}
		if ("sgm".equals(ext)) {
			mimeType = "text/x-sgml";
		}
		if ("sgml".equals(ext)) {
			mimeType = "text/sgml";
		}
		if ("sgml".equals(ext)) {
			mimeType = "text/x-sgml";
		}
		if ("sh".equals(ext)) {
			mimeType = "application/x-bsh";
		}
		if ("sh".equals(ext)) {
			mimeType = "application/x-sh";
		}
		if ("sh".equals(ext)) {
			mimeType = "application/x-shar";
		}
		if ("sh".equals(ext)) {
			mimeType = "text/x-script.sh";
		}
		if ("shar".equals(ext)) {
			mimeType = "application/x-bsh";
		}
		if ("shar".equals(ext)) {
			mimeType = "application/x-shar";
		}
		if ("shtml".equals(ext)) {
			mimeType = "text/html";
		}
		if ("shtml".equals(ext)) {
			mimeType = "text/x-server-parsed-html";
		}
		if ("sid".equals(ext)) {
			mimeType = "audio/x-psid";
		}
		if ("sit".equals(ext)) {
			mimeType = "application/x-sit";
		}
		if ("sit".equals(ext)) {
			mimeType = "application/x-stuffit";
		}
		if ("skd".equals(ext)) {
			mimeType = "application/x-koan";
		}
		if ("skm".equals(ext)) {
			mimeType = "application/x-koan";
		}
		if ("skp".equals(ext)) {
			mimeType = "application/x-koan";
		}
		if ("skt".equals(ext)) {
			mimeType = "application/x-koan";
		}
		if ("sl".equals(ext)) {
			mimeType = "application/x-seelogo";
		}
		if ("smi".equals(ext)) {
			mimeType = "application/smil";
		}
		if ("smil".equals(ext)) {
			mimeType = "application/smil";
		}
		if ("snd".equals(ext)) {
			mimeType = "audio/basic";
		}
		if ("snd".equals(ext)) {
			mimeType = "audio/x-adpcm";
		}
		if ("sol".equals(ext)) {
			mimeType = "application/solids";
		}
		if ("spc".equals(ext)) {
			mimeType = "application/x-pkcs7-certificates";
		}
		if ("spc".equals(ext)) {
			mimeType = "text/x-speech";
		}
		if ("spl".equals(ext)) {
			mimeType = "application/futuresplash";
		}
		if ("spr".equals(ext)) {
			mimeType = "application/x-sprite";
		}
		if ("sprite".equals(ext)) {
			mimeType = "application/x-sprite";
		}
		if ("src".equals(ext)) {
			mimeType = "application/x-wais-source";
		}
		if ("ssi".equals(ext)) {
			mimeType = "text/x-server-parsed-html";
		}
		if ("ssm".equals(ext)) {
			mimeType = "application/streamingmedia";
		}
		if ("sst".equals(ext)) {
			mimeType = "application/vnd.ms-pki.certstore";
		}
		if ("step".equals(ext)) {
			mimeType = "application/step";
		}
		if ("stl".equals(ext)) {
			mimeType = "application/sla";
		}
		if ("stl".equals(ext)) {
			mimeType = "application/vnd.ms-pki.stl";
		}
		if ("stl".equals(ext)) {
			mimeType = "application/x-navistyle";
		}
		if ("stp".equals(ext)) {
			mimeType = "application/step";
		}
		if ("sv4cpio".equals(ext)) {
			mimeType = "application/x-sv4cpio";
		}
		if ("sv4crc".equals(ext)) {
			mimeType = "application/x-sv4crc";
		}
		if ("svf".equals(ext)) {
			mimeType = "image/vnd.dwg";
		}
		if ("svf".equals(ext)) {
			mimeType = "image/x-dwg";
		}
		if ("svr".equals(ext)) {
			mimeType = "application/x-world";
		}
		if ("svr".equals(ext)) {
			mimeType = "x-world/x-svr";
		}
		if ("swf".equals(ext)) {
			mimeType = "application/x-shockwave-flash";
		}
		if ("t".equals(ext)) {
			mimeType = "application/x-troff";
		}
		if ("talk".equals(ext)) {
			mimeType = "text/x-speech";
		}
		if ("tar".equals(ext)) {
			mimeType = "application/x-tar";
		}
		if ("tbk".equals(ext)) {
			mimeType = "application/toolbook";
		}
		if ("tbk".equals(ext)) {
			mimeType = "application/x-tbook";
		}
		if ("tcl".equals(ext)) {
			mimeType = "application/x-tcl";
		}
		if ("tcl".equals(ext)) {
			mimeType = "text/x-script.tcl";
		}
		if ("tcsh".equals(ext)) {
			mimeType = "text/x-script.tcsh";
		}
		if ("tex".equals(ext)) {
			mimeType = "application/x-tex";
		}
		if ("texi".equals(ext)) {
			mimeType = "application/x-texinfo";
		}
		if ("texinfo".equals(ext)) {
			mimeType = "application/x-texinfo";
		}
		if ("text".equals(ext)) {
			mimeType = "application/plain";
		}
		if ("text".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("tgz".equals(ext)) {
			mimeType = "application/gnutar";
		}
		if ("tgz".equals(ext)) {
			mimeType = "application/x-compressed";
		}
		if ("tif".equals(ext)) {
			mimeType = "image/tiff";
		}
		if ("tif".equals(ext)) {
			mimeType = "image/x-tiff";
		}
		if ("tiff".equals(ext)) {
			mimeType = "image/tiff";
		}
		if ("tiff".equals(ext)) {
			mimeType = "image/x-tiff";
		}
		if ("tr".equals(ext)) {
			mimeType = "application/x-troff";
		}
		if ("tsi".equals(ext)) {
			mimeType = "audio/tsp-audio";
		}
		if ("tsp".equals(ext)) {
			mimeType = "application/dsptype";
		}
		if ("tsp".equals(ext)) {
			mimeType = "audio/tsplayer";
		}
		if ("tsv".equals(ext)) {
			mimeType = "text/tab-separated-values";
		}
		if ("turbot".equals(ext)) {
			mimeType = "image/florian";
		}
		if ("txt".equals(ext)) {
			mimeType = "text/plain";
		}
		if ("uil".equals(ext)) {
			mimeType = "text/x-uil";
		}
		if ("uni".equals(ext)) {
			mimeType = "text/uri-list";
		}
		if ("unis".equals(ext)) {
			mimeType = "text/uri-list";
		}
		if ("unv".equals(ext)) {
			mimeType = "application/i-deas";
		}
		if ("uri".equals(ext)) {
			mimeType = "text/uri-list";
		}
		if ("uris".equals(ext)) {
			mimeType = "text/uri-list";
		}
		if ("ustar".equals(ext)) {
			mimeType = "application/x-ustar";
		}
		if ("ustar".equals(ext)) {
			mimeType = "multipart/x-ustar";
		}
		if ("uu".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("uu".equals(ext)) {
			mimeType = "text/x-uuencode";
		}
		if ("uue".equals(ext)) {
			mimeType = "text/x-uuencode";
		}
		if ("vcd".equals(ext)) {
			mimeType = "application/x-cdlink";
		}
		if ("vcs".equals(ext)) {
			mimeType = "text/x-vcalendar";
		}
		if ("vda".equals(ext)) {
			mimeType = "application/vda";
		}
		if ("vdo".equals(ext)) {
			mimeType = "video/vdo";
		}
		if ("vew".equals(ext)) {
			mimeType = "application/groupwise";
		}
		if ("viv".equals(ext)) {
			mimeType = "video/vivo";
		}
		if ("viv".equals(ext)) {
			mimeType = "video/vnd.vivo";
		}
		if ("vivo".equals(ext)) {
			mimeType = "video/vivo";
		}
		if ("vivo".equals(ext)) {
			mimeType = "video/vnd.vivo";
		}
		if ("vmd".equals(ext)) {
			mimeType = "application/vocaltec-media-desc";
		}
		if ("vmf".equals(ext)) {
			mimeType = "application/vocaltec-media-file";
		}
		if ("voc".equals(ext)) {
			mimeType = "audio/voc";
		}
		if ("voc".equals(ext)) {
			mimeType = "audio/x-voc";
		}
		if ("vos".equals(ext)) {
			mimeType = "video/vosaic";
		}
		if ("vox".equals(ext)) {
			mimeType = "audio/voxware";
		}
		if ("vqe".equals(ext)) {
			mimeType = "audio/x-twinvq-plugin";
		}
		if ("vqf".equals(ext)) {
			mimeType = "audio/x-twinvq";
		}
		if ("vql".equals(ext)) {
			mimeType = "audio/x-twinvq-plugin";
		}
		if ("vrml".equals(ext)) {
			mimeType = "application/x-vrml";
		}
		if ("vrml".equals(ext)) {
			mimeType = "model/vrml";
		}
		if ("vrml".equals(ext)) {
			mimeType = "x-world/x-vrml";
		}
		if ("vrt".equals(ext)) {
			mimeType = "x-world/x-vrt";
		}
		if ("vsd".equals(ext)) {
			mimeType = "application/x-visio";
		}
		if ("vst".equals(ext)) {
			mimeType = "application/x-visio";
		}
		if ("vsw".equals(ext)) {
			mimeType = "application/x-visio";
		}
		if ("w60".equals(ext)) {
			mimeType = "application/wordperfect6.0";
		}
		if ("w61".equals(ext)) {
			mimeType = "application/wordperfect6.1";
		}
		if ("w6w".equals(ext)) {
			mimeType = "application/msword";
		}
		if ("wav".equals(ext)) {
			mimeType = "audio/wav";
		}
		if ("wav".equals(ext)) {
			mimeType = "audio/x-wav";
		}
		if ("wb1".equals(ext)) {
			mimeType = "application/x-qpro";
		}
		if ("wbmp".equals(ext)) {
			mimeType = "image/vnd.wap.wbmp";
		}
		if ("web".equals(ext)) {
			mimeType = "application/vnd.xara";
		}
		if ("wiz".equals(ext)) {
			mimeType = "application/msword";
		}
		if ("wk1".equals(ext)) {
			mimeType = "application/x-123";
		}
		if ("wmf".equals(ext)) {
			mimeType = "windows/metafile";
		}
		if ("wml".equals(ext)) {
			mimeType = "text/vnd.wap.wml";
		}
		if ("wmlc".equals(ext)) {
			mimeType = "application/vnd.wap.wmlc";
		}
		if ("wmls".equals(ext)) {
			mimeType = "text/vnd.wap.wmlscript";
		}
		if ("wmlsc".equals(ext)) {
			mimeType = "application/vnd.wap.wmlscriptc";
		}
		if ("word".equals(ext)) {
			mimeType = "application/msword";
		}
		if ("wp".equals(ext)) {
			mimeType = "application/wordperfect";
		}
		if ("wp5".equals(ext)) {
			mimeType = "application/wordperfect";
		}
		if ("wp5".equals(ext)) {
			mimeType = "application/wordperfect6.0";
		}
		if ("wp6".equals(ext)) {
			mimeType = "application/wordperfect";
		}
		if ("wpd".equals(ext)) {
			mimeType = "application/wordperfect";
		}
		if ("wpd".equals(ext)) {
			mimeType = "application/x-wpwin";
		}
		if ("wq1".equals(ext)) {
			mimeType = "application/x-lotus";
		}
		if ("wri".equals(ext)) {
			mimeType = "application/mswrite";
		}
		if ("wri".equals(ext)) {
			mimeType = "application/x-wri";
		}
		if ("wrl".equals(ext)) {
			mimeType = "application/x-world";
		}
		if ("wrl".equals(ext)) {
			mimeType = "model/vrml";
		}
		if ("wrl".equals(ext)) {
			mimeType = "x-world/x-vrml";
		}
		if ("wrz".equals(ext)) {
			mimeType = "model/vrml";
		}
		if ("wrz".equals(ext)) {
			mimeType = "x-world/x-vrml";
		}
		if ("wsc".equals(ext)) {
			mimeType = "text/scriplet";
		}
		if ("wsrc".equals(ext)) {
			mimeType = "application/x-wais-source";
		}
		if ("wtk".equals(ext)) {
			mimeType = "application/x-wintalk";
		}
		if ("xbm".equals(ext)) {
			mimeType = "image/x-xbitmap";
		}
		if ("xbm".equals(ext)) {
			mimeType = "image/x-xbm";
		}
		if ("xbm".equals(ext)) {
			mimeType = "image/xbm";
		}
		if ("xdr".equals(ext)) {
			mimeType = "video/x-amt-demorun";
		}
		if ("xgz".equals(ext)) {
			mimeType = "xgl/drawing";
		}
		if ("xif".equals(ext)) {
			mimeType = "image/vnd.xiff";
		}
		if ("xl".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xla".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xla".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xla".equals(ext)) {
			mimeType = "application/x-msexcel";
		}
		if ("xlb".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xlb".equals(ext)) {
			mimeType = "application/vnd.ms-excel";
		}
		if ("xlb".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xlc".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xlc".equals(ext)) {
			mimeType = "application/vnd.ms-excel";
		}
		if ("xlc".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xld".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xld".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xlk".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xlk".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xll".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xll".equals(ext)) {
			mimeType = "application/vnd.ms-excel";
		}
		if ("xll".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xlm".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xlm".equals(ext)) {
			mimeType = "application/vnd.ms-excel";
		}
		if ("xlm".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xls".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xls".equals(ext)) {
			mimeType = "application/vnd.ms-excel";
		}
		if ("xls".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xls".equals(ext)) {
			mimeType = "application/x-msexcel";
		}
		if ("xlt".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xlt".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xlv".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xlv".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xlw".equals(ext)) {
			mimeType = "application/excel";
		}
		if ("xlw".equals(ext)) {
			mimeType = "application/vnd.ms-excel";
		}
		if ("xlw".equals(ext)) {
			mimeType = "application/x-excel";
		}
		if ("xlw".equals(ext)) {
			mimeType = "application/x-msexcel";
		}
		if ("xm".equals(ext)) {
			mimeType = "audio/xm";
		}
		if ("xml".equals(ext)) {
			mimeType = "application/xml";
		}
		if ("xml".equals(ext)) {
			mimeType = "text/xml";
		}
		if ("xmz".equals(ext)) {
			mimeType = "xgl/movie";
		}
		if ("xpix".equals(ext)) {
			mimeType = "application/x-vnd.ls-xpix";
		}
		if ("xpm".equals(ext)) {
			mimeType = "image/x-xpixmap";
		}
		if ("xpm".equals(ext)) {
			mimeType = "image/xpm";
		}
		if ("x-png".equals(ext)) {
			mimeType = "image/png";
		}
		if ("xsr".equals(ext)) {
			mimeType = "video/x-amt-showrun";
		}
		if ("xwd".equals(ext)) {
			mimeType = "image/x-xwd";
		}
		if ("xwd".equals(ext)) {
			mimeType = "image/x-xwindowdump";
		}
		if ("xyz".equals(ext)) {
			mimeType = "chemical/x-pdb";
		}
		if ("z".equals(ext)) {
			mimeType = "application/x-compress";
		}
		if ("z".equals(ext)) {
			mimeType = "application/x-compressed";
		}
		if ("zip".equals(ext)) {
			mimeType = "application/x-compressed";
		}
		if ("zip".equals(ext)) {
			mimeType = "application/x-zip-compressed";
		}
		if ("zip".equals(ext)) {
			mimeType = "application/zip";
		}
		if ("zip".equals(ext)) {
			mimeType = "multipart/x-zip";
		}
		if ("zoo".equals(ext)) {
			mimeType = "application/octet-stream";
		}
		if ("zsh".equals(ext)) {
			mimeType = "text/x-script.zsh";
		}
		
		return mimeType;
		
	}
	
}
