package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuyongfeiyongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuyongfeiyongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuyongfeiyongView;


/**
 * 租用费用
 *
 * @author 
 * @email 
 * @date 2023-05-04 20:50:59
 */
public interface ZuyongfeiyongService extends IService<ZuyongfeiyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuyongfeiyongVO> selectListVO(Wrapper<ZuyongfeiyongEntity> wrapper);
   	
   	ZuyongfeiyongVO selectVO(@Param("ew") Wrapper<ZuyongfeiyongEntity> wrapper);
   	
   	List<ZuyongfeiyongView> selectListView(Wrapper<ZuyongfeiyongEntity> wrapper);
   	
   	ZuyongfeiyongView selectView(@Param("ew") Wrapper<ZuyongfeiyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuyongfeiyongEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ZuyongfeiyongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ZuyongfeiyongEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ZuyongfeiyongEntity> wrapper);



}

