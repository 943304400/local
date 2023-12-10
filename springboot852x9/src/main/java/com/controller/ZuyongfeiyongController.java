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

import com.entity.ZuyongfeiyongEntity;
import com.entity.view.ZuyongfeiyongView;

import com.service.ZuyongfeiyongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 租用费用
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 20:50:59
 */
@RestController
@RequestMapping("/zuyongfeiyong")
public class ZuyongfeiyongController {
    @Autowired
    private ZuyongfeiyongService zuyongfeiyongService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuyongfeiyongEntity zuyongfeiyong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuhu")) {
			zuyongfeiyong.setZuhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			zuyongfeiyong.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuyongfeiyongEntity> ew = new EntityWrapper<ZuyongfeiyongEntity>();

		PageUtils page = zuyongfeiyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuyongfeiyong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuyongfeiyongEntity zuyongfeiyong, 
		HttpServletRequest request){
        EntityWrapper<ZuyongfeiyongEntity> ew = new EntityWrapper<ZuyongfeiyongEntity>();

		PageUtils page = zuyongfeiyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuyongfeiyong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuyongfeiyongEntity zuyongfeiyong){
       	EntityWrapper<ZuyongfeiyongEntity> ew = new EntityWrapper<ZuyongfeiyongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuyongfeiyong, "zuyongfeiyong")); 
        return R.ok().put("data", zuyongfeiyongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuyongfeiyongEntity zuyongfeiyong){
        EntityWrapper< ZuyongfeiyongEntity> ew = new EntityWrapper< ZuyongfeiyongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuyongfeiyong, "zuyongfeiyong")); 
		ZuyongfeiyongView zuyongfeiyongView =  zuyongfeiyongService.selectView(ew);
		return R.ok("查询租用费用成功").put("data", zuyongfeiyongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuyongfeiyongEntity zuyongfeiyong = zuyongfeiyongService.selectById(id);
        return R.ok().put("data", zuyongfeiyong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuyongfeiyongEntity zuyongfeiyong = zuyongfeiyongService.selectById(id);
        return R.ok().put("data", zuyongfeiyong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuyongfeiyongEntity zuyongfeiyong, HttpServletRequest request){
    	zuyongfeiyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuyongfeiyong);
        zuyongfeiyongService.insert(zuyongfeiyong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuyongfeiyongEntity zuyongfeiyong, HttpServletRequest request){
    	zuyongfeiyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuyongfeiyong);
        zuyongfeiyongService.insert(zuyongfeiyong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuyongfeiyongEntity zuyongfeiyong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuyongfeiyong);
        zuyongfeiyongService.updateById(zuyongfeiyong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuyongfeiyongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ZuyongfeiyongEntity> ew = new EntityWrapper<ZuyongfeiyongEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuhu")) {
            ew.eq("zuhuzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = zuyongfeiyongService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZuyongfeiyongEntity> ew = new EntityWrapper<ZuyongfeiyongEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("zuhu")) {
            ew.eq("zuhuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zuyongfeiyongService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ZuyongfeiyongEntity> ew = new EntityWrapper<ZuyongfeiyongEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("zuhu")) {
            ew.eq("zuhuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = zuyongfeiyongService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZuyongfeiyongEntity> ew = new EntityWrapper<ZuyongfeiyongEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("zuhu")) {
            ew.eq("zuhuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zuyongfeiyongService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ZuyongfeiyongEntity> ew = new EntityWrapper<ZuyongfeiyongEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("zuhu")) {
            ew.eq("zuhuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = zuyongfeiyongService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ZuyongfeiyongEntity zuyongfeiyong, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("zuhu")) {
            zuyongfeiyong.setZuhuzhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            zuyongfeiyong.setZhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ZuyongfeiyongEntity> ew = new EntityWrapper<ZuyongfeiyongEntity>();
        int count = zuyongfeiyongService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuyongfeiyong), params), params));
        return R.ok().put("data", count);
    }


}
