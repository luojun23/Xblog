package com.njtech.blog.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * 资源信息 数据库操作接口
 */
public interface ResourceMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据Id更新
	 */
	 Integer updateById(@Param("bean") T t,@Param("id") Integer id);


	/**
	 * 根据Id删除
	 */
	 Integer deleteById(@Param("id") Integer id);


	/**
	 * 根据Id获取对象
	 */
	 T selectById(@Param("id") Integer id);


	/**
	 * 根据Path更新
	 */
	 Integer updateByPath(@Param("bean") T t,@Param("path") String path);


	/**
	 * 根据Path删除
	 */
	 Integer deleteByPath(@Param("path") String path);


	/**
	 * 根据Path获取对象
	 */
	 T selectByPath(@Param("path") String path);


}
