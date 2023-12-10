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

import com.entity.ChongzhijiluEntity;
import com.entity.view.ChongzhijiluView;

import com.service.ChongzhijiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 充值记录
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 20:50:58
 */
@RestController
@RequestMapping("/chongzhijilu")
public class ChongzhijiluController {
    @Autowired
    private ChongzhijiluService chongzhijiluService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChongzhijiluEntity chongzhijilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			chongzhijilu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChongzhijiluEntity> ew = new EntityWrapper<ChongzhijiluEntity>();

		PageUtils page = chongzhijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongzhijilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChongzhijiluEntity chongzhijilu, 
		HttpServletRequest request){
        EntityWrapper<ChongzhijiluEntity> ew = new EntityWrapper<ChongzhijiluEntity>();

		PageUtils page = chongzhijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongzhijilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChongzhijiluEntity chongzhijilu){
       	EntityWrapper<ChongzhijiluEntity> ew = new EntityWrapper<ChongzhijiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chongzhijilu, "chongzhijilu")); 
        return R.ok().put("data", chongzhijiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChongzhijiluEntity chongzhijilu){
        EntityWrapper< ChongzhijiluEntity> ew = new EntityWrapper< ChongzhijiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chongzhijilu, "chongzhijilu")); 
		ChongzhijiluView chongzhijiluView =  chongzhijiluService.selectView(ew);
		return R.ok("查询充值记录成功").put("data", chongzhijiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChongzhijiluEntity chongzhijilu = chongzhijiluService.selectById(id);
        return R.ok().put("data", chongzhijilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChongzhijiluEntity chongzhijilu = chongzhijiluService.selectById(id);
        return R.ok().put("data", chongzhijilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChongzhijiluEntity chongzhijilu, HttpServletRequest request){
    	chongzhijilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongzhijilu);
        chongzhijiluService.insert(chongzhijilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChongzhijiluEntity chongzhijilu, HttpServletRequest request){
    	chongzhijilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongzhijilu);
        chongzhijiluService.insert(chongzhijilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChongzhijiluEntity chongzhijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chongzhijilu);
        chongzhijiluService.updateById(chongzhijilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chongzhijiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
