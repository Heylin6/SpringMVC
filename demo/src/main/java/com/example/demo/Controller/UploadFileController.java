package com.example.demo.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.example.demo.Model.Result;
import com.example.demo.Service.uploadfileService;


@Controller
@RequestMapping("/UploadFile")
public class UploadFileController extends baseContoller {	
	
	private uploadfileService _uploadfileB = new uploadfileService();
	
	 @GetMapping("/")
	 public String UploadFileIndex() {
		 		 
	     return "uploadFilePage";
	 }
	
	
	// 多個檔案上傳的接口
    @PostMapping("/api/upload/multi")
    @ResponseBody
    public ResponseEntity<?> uploadFileMulti(@RequestParam("files") MultipartFile[] uploadfiles){
    	
    	// 取得檔案名稱
        String uploadedFileName = 
        		Arrays.stream(uploadfiles)
        		.map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
        
        if (StringUtils.isEmpty(uploadedFileName)) {
            return new ResponseEntity("請選擇檔案!", HttpStatus.OK);
        }

        try {

        	_uploadfileB.saveUploadedFiles(Arrays.asList(uploadfiles));

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("成功上傳 - "
                + uploadedFileName, HttpStatus.OK);
    }
}
