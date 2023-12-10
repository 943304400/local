package com.dao;

import com.entity.CheliangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CheliangxinxiVO;
import com.entity.view.CheliangxinxiView;


/**
 * 车辆信息
 * 
 * @author 
 * @email 
 * @date 2023-05-04 20:50:58
 */
public interface CheliangxinxiDao extends BaseMapper<CheliangxinxiEntity> {
	
	List<CheliangxinxiVO> selectListVO(@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);
	
	CheliangxinxiVO selectVO(@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);
	
	List<CheliangxinxiView> selectListView(@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);

	List<CheliangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);
	
	CheliangxinxiView selectView(@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);



}
