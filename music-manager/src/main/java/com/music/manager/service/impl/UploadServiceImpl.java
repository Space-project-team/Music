package com.music.manager.service.impl;

import com.music.common.result.FileResult;
import com.music.manager.mapper.UserMapper;
import com.music.manager.pojo.User;
import com.music.manager.service.UploadService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * 上传service实现类
 *
 * @author zhoubin
 * @create 2019/12/26
 * @since 1.0.0
 */
@Service
public class UploadServiceImpl implements UploadService {
	@Autowired
	private UserMapper userMapper;
	/**
	 * 上传
	 * @param inputStream
	 * @param fileName
	 * @return
	 */
	@Override
	public FileResult upload(InputStream inputStream, String fileName, User user, HttpServletRequest request, HttpServletResponse response) {
		FileResult fileResult = new FileResult();
		//构造一个带指定 Region 对象的配置类
		Configuration cfg = new Configuration(Region.region0());
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		//...生成上传凭证，然后准备上传
		String accessKey = "gpWL7rHISpMzq7yWddEN_WRUk8UnubuupNthcC3Q";
		String secretKey = "jez1pZYt-5hO1QwRIb9E4VcwqG3GtJSIfgx4IoAr";
		String bucket = "music-head-img";
		//默认不指定key的情况下，以文件内容的hash值作为文件名
		String key = fileName;
		try {
			Auth auth = Auth.create(accessKey, secretKey);
			String upToken = auth.uploadToken(bucket);
			try {
				Response res = uploadManager.put(inputStream,key,upToken,null, null);
				//解析上传成功的结果
				// DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
				// System.out.println(putRet.key);
				// System.out.println(putRet.hash);
				if (res.statusCode==200){
					if(user==null||user.equals("")){
						fileResult.setError("error");
						fileResult.setMessage("用户未登录");
						return fileResult;
					}
					fileResult.setSuccess("success");
					fileResult.setMessage("上传成功");
					fileResult.setFileUrl("http://qafbatitv.bkt.clouddn.com/"+fileName);
					user.setHeadImage("http://qafbatitv.bkt.clouddn.com/"+fileName);
					userMapper.updateByPrimaryKey(user);
					//将user信息更新到session中
					request.getSession().setAttribute("user",user);
					System.out.println(request.getSession().getAttribute("user"));
					return fileResult;
				}else {
					fileResult.setError("error");
					fileResult.setMessage("上传失败");
					return fileResult;
				}
			} catch (QiniuException ex) {
				Response r = ex.response;
				System.err.println(r.toString());
				fileResult.setError("error");
				fileResult.setMessage("上传失败");
				try {
					System.err.println(r.bodyString());
				} catch (QiniuException ex2) {
					//ignore
				}
			}
		} catch (Exception ex) {
			//ignore
		}
		return fileResult;
	}
}