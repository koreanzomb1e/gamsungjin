package com.gamsungjin.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 컴퓨터에 저장될 경로
	public final static String FILE_UPLOAD_PATH = "C:\\Users\\ganjinam\\Desktop\\class\\7_project\\workspace\\gamsungjin\\images/";
	
	// 파일을 컴퓨터에 저장 -> url path 리턴
	public String saveFile(int userId, MultipartFile file) throws IOException {
		// 파일 디렉토리 경로 만들기
		// ex) 1_1620995857660/sun.jpg
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";	// ex) 1_1620995857660/
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) {	// 업로드할 경로에 폴더 생성
			// 디렉토리 생성 실패
			logger.error("[파일업로드] 디렉토리 생성 실패 " + userId + ", " + filePath);
			return null;
		}
		
		// 파일 업로드 -> byte 단위로 업로드
		byte[] bytes = file.getBytes();
		Path path = Paths.get(filePath + file.getOriginalFilename()); // getOriginalFilename() => input에서 올린 파일명
		Files.write(path, bytes);
		
		// 이미지 url 만들어 리턴
		// ex) http://localhost/images/1_1620995857660/sun.jpg
		return "/images/" + directoryName + file.getOriginalFilename();
	}
	
	// 이미지 파일 삭제
	public void deleteFile(String imagePath) throws IOException {
		// C:\Users\ganjinam\Desktop\class\7_project\workspace\gamsungjin\images/
		Path path = Paths.get(FILE_UPLOAD_PATH + imagePath.replace("/images/", ""));
		
		// 이미지 삭제
		if (Files.exists(path)) {
			Files.delete(path);
		}
		
		// 디렉토리 삭제
		path = path.getParent();
		if (Files.exists(path)) {
			Files.delete(path);
		}
	}
}
