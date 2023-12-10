package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhifujiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhifujiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhifujiluView;


/**
 * 支付记录
 *
 * @author 
 * @email 
 * @date 2023-05-04 20:50:58
 */
public interface ZhifujiluService extends IService<ZhifujiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhifujiluVO> selectListVO(Wrapper<ZhifujiluEntity> wrapper);
   	
   	ZhifujiluVO selectVO(@Param("ew") Wrapper<ZhifujiluEntity> wrapper);
   	
   	List<ZhifujiluView> selectListView(Wrapper<ZhifujiluEntity> wrapper);
   	
   	ZhifujiluView selectView(@Param("ew") Wrapper<ZhifujiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhifujiluEntity> wrapper);
   	

}

