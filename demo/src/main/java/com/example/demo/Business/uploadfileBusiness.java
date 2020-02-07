package com.example.demo.Business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Utilitylib.*;

public class uploadfileBusiness extends baseBusiness {

	public void saveUploadedFiles(List<MultipartFile> files) throws IOException {
		

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //繼續下一個檔案
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + 
            						Directionarylib.Upload_type + 
            						DateLib.DateToTimestampStr()+
            						StringLib.getExtension(file.getOriginalFilename()));
            
            Files.write(path.toAbsolutePath(), bytes);
    	}
	} 

}
