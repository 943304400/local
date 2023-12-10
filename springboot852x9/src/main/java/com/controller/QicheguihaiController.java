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

import com.entity.QicheguihaiEntity;
import com.entity.view.QicheguihaiView;

import com.service.QicheguihaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 汽车归还
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 20:50:59
 */
@RestController
@RequestMapping("/qicheguihai")
public class QicheguihaiController {
    @Autowired
    private QicheguihaiService qicheguihaiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QicheguihaiEntity qicheguihai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuhu")) {
			qicheguihai.setZuhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			qicheguihai.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QicheguihaiEntity> ew = new EntityWrapper<QicheguihaiEntity>();

		PageUtils page = qicheguihaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicheguihai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QicheguihaiEntity qicheguihai, 
		HttpServletRequest request){
        EntityWrapper<QicheguihaiEntity> ew = new EntityWrapper<QicheguihaiEntity>();

		PageUtils page = qicheguihaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicheguihai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QicheguihaiEntity qicheguihai){
       	EntityWrapper<QicheguihaiEntity> ew = new EntityWrapper<QicheguihaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qicheguihai, "qicheguihai")); 
        return R.ok().put("data", qicheguihaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QicheguihaiEntity qicheguihai){
        EntityWrapper< QicheguihaiEntity> ew = new EntityWrapper< QicheguihaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qicheguihai, "qicheguihai")); 
		QicheguihaiView qicheguihaiView =  qicheguihaiService.selectView(ew);
		return R.ok("查询汽车归还成功").put("data", qicheguihaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QicheguihaiEntity qicheguihai = qicheguihaiService.selectById(id);
        return R.ok().put("data", qicheguihai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QicheguihaiEntity qicheguihai = qicheguihaiService.selectById(id);
        return R.ok().put("data", qicheguihai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QicheguihaiEntity qicheguihai, HttpServletRequest request){
    	qicheguihai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qicheguihai);
        qicheguihaiService.insert(qicheguihai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QicheguihaiEntity qicheguihai, HttpServletRequest request){
    	qicheguihai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qicheguihai);
        qicheguihaiService.insert(qicheguihai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QicheguihaiEntity qicheguihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qicheguihai);
        qicheguihaiService.updateById(qicheguihai);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<QicheguihaiEntity> list = new ArrayList<QicheguihaiEntity>();
        for(Long id : ids) {
            QicheguihaiEntity qicheguihai = qicheguihaiService.selectById(id);
            qicheguihai.setSfsh(sfsh);
            qicheguihai.setShhf(shhf);
            list.add(qicheguihai);
        }
        qicheguihaiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qicheguihaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
