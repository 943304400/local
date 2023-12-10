package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZuyongfeiyongDao;
import com.entity.ZuyongfeiyongEntity;
import com.service.ZuyongfeiyongService;
import com.entity.vo.ZuyongfeiyongVO;
import com.entity.view.ZuyongfeiyongView;

@Service("zuyongfeiyongService")
public class ZuyongfeiyongServiceImpl extends ServiceImpl<ZuyongfeiyongDao, ZuyongfeiyongEntity> implements ZuyongfeiyongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuyongfeiyongEntity> page = this.selectPage(
                new Query<ZuyongfeiyongEntity>(params).getPage(),
                new EntityWrapper<ZuyongfeiyongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuyongfeiyongEntity> wrapper) {
		  Page<ZuyongfeiyongView> page =new Query<ZuyongfeiyongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuyongfeiyongVO> selectListVO(Wrapper<ZuyongfeiyongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuyongfeiyongVO selectVO(Wrapper<ZuyongfeiyongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuyongfeiyongView> selectListView(Wrapper<ZuyongfeiyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuyongfeiyongView selectView(Wrapper<ZuyongfeiyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ZuyongfeiyongEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ZuyongfeiyongEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ZuyongfeiyongEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
