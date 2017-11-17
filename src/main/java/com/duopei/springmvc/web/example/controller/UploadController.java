package com.duopei.springmvc.web.example.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.duopei.springmvc.config.property.Const;
import com.duopei.util.TranCharset;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

	@Autowired
	private Environment environment;

	@RequestMapping(value = "/file", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public @ResponseBody String upload(MultipartFile file, HttpServletRequest request) {
		try {
			String outputFilePath = environment.getProperty(Const.UPLOAD_FILE_PATH)
					+ new String(file.getOriginalFilename().getBytes(TranCharset.getEncoding(file.getOriginalFilename())), "utf-8");
			FileUtils.writeByteArrayToFile(new File(outputFilePath), file.getBytes());
			return "成功上传文件："+ outputFilePath;
		} catch (IOException e) {
			e.printStackTrace();
			return "wrong";
		}
	}

}
