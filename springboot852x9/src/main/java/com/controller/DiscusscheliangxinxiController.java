package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusscheliangxinxiEntity;
import com.entity.view.DiscusscheliangxinxiView;

import com.service.DiscusscheliangxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 车辆信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 20:50:59
 */
@RestController
@RequestMapping("/discusscheliangxinxi")
public class DiscusscheliangxinxiController {
    @Autowired
    private DiscusscheliangxinxiService discusscheliangxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusscheliangxinxiEntity discusscheliangxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscusscheliangxinxiEntity> ew = new EntityWrapper<DiscusscheliangxinxiEntity>();

		PageUtils page = discusscheliangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusscheliangxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusscheliangxinxiEntity discusscheliangxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscusscheliangxinxiEntity> ew = new EntityWrapper<DiscusscheliangxinxiEntity>();

		PageUtils page = discusscheliangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusscheliangxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusscheliangxinxiEntity discusscheliangxinxi){
       	EntityWrapper<DiscusscheliangxinxiEntity> ew = new EntityWrapper<DiscusscheliangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusscheliangxinxi, "discusscheliangxinxi")); 
        return R.ok().put("data", discusscheliangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusscheliangxinxiEntity discusscheliangxinxi){
        EntityWrapper< DiscusscheliangxinxiEntity> ew = new EntityWrapper< DiscusscheliangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusscheliangxinxi, "discusscheliangxinxi")); 
		DiscusscheliangxinxiView discusscheliangxinxiView =  discusscheliangxinxiService.selectView(ew);
		return R.ok("查询车辆信息评论表成功").put("data", discusscheliangxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusscheliangxinxiEntity discusscheliangxinxi = discusscheliangxinxiService.selectById(id);
        return R.ok().put("data", discusscheliangxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusscheliangxinxiEntity discusscheliangxinxi = discusscheliangxinxiService.selectById(id);
        return R.ok().put("data", discusscheliangxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusscheliangxinxiEntity discusscheliangxinxi, HttpServletRequest request){
    	discusscheliangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusscheliangxinxi);
        discusscheliangxinxiService.insert(discusscheliangxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusscheliangxinxiEntity discusscheliangxinxi, HttpServletRequest request){
    	discusscheliangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusscheliangxinxi);
        discusscheliangxinxiService.insert(discusscheliangxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusscheliangxinxiEntity discusscheliangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusscheliangxinxi);
        discusscheliangxinxiService.updateById(discusscheliangxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusscheliangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
