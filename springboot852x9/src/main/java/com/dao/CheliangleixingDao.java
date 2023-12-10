package com.dao;

import com.entity.CheliangleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CheliangleixingVO;
import com.entity.view.CheliangleixingView;


/**
 * 车辆类型
 * 
 * @author 
 * @email 
 * @date 2023-05-04 20:50:58
 */
public interface CheliangleixingDao extends BaseMapper<CheliangleixingEntity> {
	
	List<CheliangleixingVO> selectListVO(@Param("ew") Wrapper<CheliangleixingEntity> wrapper);
	
	CheliangleixingVO selectVO(@Param("ew") Wrapper<CheliangleixingEntity> wrapper);
	
	List<CheliangleixingView> selectListView(@Param("ew") Wrapper<CheliangleixingEntity> wrapper);

	List<CheliangleixingView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangleixingEntity> wrapper);
	
	CheliangleixingView selectView(@Param("ew") Wrapper<CheliangleixingEntity> wrapper);
	

}
