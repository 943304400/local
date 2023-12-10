package com.dao;

import com.entity.ZuyongfeiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuyongfeiyongVO;
import com.entity.view.ZuyongfeiyongView;


/**
 * 租用费用
 * 
 * @author 
 * @email 
 * @date 2023-05-04 20:50:59
 */
public interface ZuyongfeiyongDao extends BaseMapper<ZuyongfeiyongEntity> {
	
	List<ZuyongfeiyongVO> selectListVO(@Param("ew") Wrapper<ZuyongfeiyongEntity> wrapper);
	
	ZuyongfeiyongVO selectVO(@Param("ew") Wrapper<ZuyongfeiyongEntity> wrapper);
	
	List<ZuyongfeiyongView> selectListView(@Param("ew") Wrapper<ZuyongfeiyongEntity> wrapper);

	List<ZuyongfeiyongView> selectListView(Pagination page,@Param("ew") Wrapper<ZuyongfeiyongEntity> wrapper);
	
	ZuyongfeiyongView selectView(@Param("ew") Wrapper<ZuyongfeiyongEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZuyongfeiyongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZuyongfeiyongEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZuyongfeiyongEntity> wrapper);



}
