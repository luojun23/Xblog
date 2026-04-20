package com.njtech.blog.utils.storage;

import com.njtech.blog.entity.dao.FileDao;

import java.util.List;

/**
 * 储存服务
 */
public interface StoreService {

    void deleteFile(List<String> files);

    FileDao saveFile(FileDao fileDao);

    String getStoreName();
}
