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

import com.entity.ZhifujiluEntity;
import com.entity.view.ZhifujiluView;

import com.service.ZhifujiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 支付记录
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 20:50:58
 */
@RestController
@RequestMapping("/zhifujilu")
public class ZhifujiluController {
    @Autowired
    private ZhifujiluService zhifujiluService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhifujiluEntity zhifujilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zhifujilu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhifujiluEntity> ew = new EntityWrapper<ZhifujiluEntity>();

		PageUtils page = zhifujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhifujilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhifujiluEntity zhifujilu, 
		HttpServletRequest request){
        EntityWrapper<ZhifujiluEntity> ew = new EntityWrapper<ZhifujiluEntity>();

		PageUtils page = zhifujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhifujilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhifujiluEntity zhifujilu){
       	EntityWrapper<ZhifujiluEntity> ew = new EntityWrapper<ZhifujiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhifujilu, "zhifujilu")); 
        return R.ok().put("data", zhifujiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhifujiluEntity zhifujilu){
        EntityWrapper< ZhifujiluEntity> ew = new EntityWrapper< ZhifujiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhifujilu, "zhifujilu")); 
		ZhifujiluView zhifujiluView =  zhifujiluService.selectView(ew);
		return R.ok("查询支付记录成功").put("data", zhifujiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhifujiluEntity zhifujilu = zhifujiluService.selectById(id);
        return R.ok().put("data", zhifujilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhifujiluEntity zhifujilu = zhifujiluService.selectById(id);
        return R.ok().put("data", zhifujilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhifujiluEntity zhifujilu, HttpServletRequest request){
    	zhifujilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhifujilu);
        zhifujiluService.insert(zhifujilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhifujiluEntity zhifujilu, HttpServletRequest request){
    	zhifujilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhifujilu);
        zhifujiluService.insert(zhifujilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhifujiluEntity zhifujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhifujilu);
        zhifujiluService.updateById(zhifujilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhifujiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
