package com.music.manager.controller;

import com.music.common.result.FileResult;
import com.music.manager.pojo.User;
import com.music.manager.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 文件上传Controller
 *
 * @author zhoubin
 * @create 2019/12/26
 * @since 1.0.0
 */
@Controller
@RequestMapping("fileUpload")
public class UploadController {

	@Autowired
	private UploadService uploadService;

	@RequestMapping("save")
	@ResponseBody
	private FileResult upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// System.out.println(file.getName());
		// System.out.println(file.getOriginalFilename());
		String filename = file.getOriginalFilename();
		//格式化时间
		String date = DateTimeFormatter.ofPattern("yyyy/MM/dd/").format(LocalDateTime.now());
		filename = date + System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
		User user=(User)request.getSession().getAttribute("user");
		return uploadService.upload(file.getInputStream(), filename,user,request,response);
	}


}