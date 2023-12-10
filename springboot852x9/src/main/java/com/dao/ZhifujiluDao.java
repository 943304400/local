package com.dao;

import com.entity.ZhifujiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhifujiluVO;
import com.entity.view.ZhifujiluView;


/**
 * 支付记录
 * 
 * @author 
 * @email 
 * @date 2023-05-04 20:50:58
 */
public interface ZhifujiluDao extends BaseMapper<ZhifujiluEntity> {
	
	List<ZhifujiluVO> selectListVO(@Param("ew") Wrapper<ZhifujiluEntity> wrapper);
	
	ZhifujiluVO selectVO(@Param("ew") Wrapper<ZhifujiluEntity> wrapper);
	
	List<ZhifujiluView> selectListView(@Param("ew") Wrapper<ZhifujiluEntity> wrapper);

	List<ZhifujiluView> selectListView(Pagination page,@Param("ew") Wrapper<ZhifujiluEntity> wrapper);
	
	ZhifujiluView selectView(@Param("ew") Wrapper<ZhifujiluEntity> wrapper);
	

}
