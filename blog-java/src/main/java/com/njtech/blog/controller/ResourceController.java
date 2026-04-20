package com.njtech.blog.controller;

import com.njtech.blog.entity.dao.FileDao;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.exception.BusinessException;
import com.njtech.blog.service.ResourceService;
import com.njtech.blog.utils.storage.FileStorageService;
import com.njtech.blog.utils.storage.StoreService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 资源信息 Controller
 */
@RestController("resourceController")
@RequestMapping("/resource")
public class ResourceController extends ABaseController{
	@Resource
	private ResourceService resourceService;

	@Resource
	private FileStorageService fileStorageService;
	
	/**
	* @Description : 上传文件
	* @Param :  * @param file
 	* @param fileDao
	* @Author : luojun
	* @Date : 2026/4/18 0:32 
	* @return com.njtech.blog.entity.vo.ResponseVO<java.lang.String> 
	*/
	@RequestMapping("/upload")
	public ResponseVO<String> upload(@RequestParam("file") MultipartFile file, FileDao fileDao) {
		if (file == null || !StringUtils.hasText(fileDao.getType()) || !StringUtils.hasText(fileDao.getRelativePath())){
			throw new BusinessException("文件和资源类型和资源路径不能为空！");
		}
		fileDao.setFile(file);
		StoreService storeService = fileStorageService.getFileStorage(fileDao.getStoreType());

		return null;
	}
}