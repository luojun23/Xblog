package com.njtech.blog.entity.dao;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName : FileDao
 * @Description :
 * @Author : 罗君
 * @Date: 2026/4/18
 */
@Data
public class FileDao {

    private String type;

    private String storeType;

    private String relativePath;

    private String absolutePath;

    private String visitPath;

    private MultipartFile file;

    private String originalName;
}
