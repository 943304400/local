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


import com.dao.ZhifujiluDao;
import com.entity.ZhifujiluEntity;
import com.service.ZhifujiluService;
import com.entity.vo.ZhifujiluVO;
import com.entity.view.ZhifujiluView;

@Service("zhifujiluService")
public class ZhifujiluServiceImpl extends ServiceImpl<ZhifujiluDao, ZhifujiluEntity> implements ZhifujiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhifujiluEntity> page = this.selectPage(
                new Query<ZhifujiluEntity>(params).getPage(),
                new EntityWrapper<ZhifujiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhifujiluEntity> wrapper) {
		  Page<ZhifujiluView> page =new Query<ZhifujiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhifujiluVO> selectListVO(Wrapper<ZhifujiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhifujiluVO selectVO(Wrapper<ZhifujiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhifujiluView> selectListView(Wrapper<ZhifujiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhifujiluView selectView(Wrapper<ZhifujiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
