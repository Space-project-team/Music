package com.music.manager.service;

import com.music.common.result.FileResult;
import com.music.manager.pojo.User;

import java.io.InputStream;

/**
 * 上传service
 */
public interface UploadService {
	/**
	 * 上传
	 * @return
	 */
	FileResult upload(InputStream inputStream, String fileName, User user);
}
