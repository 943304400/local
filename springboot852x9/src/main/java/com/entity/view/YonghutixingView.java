package com.entity.view;

import com.entity.YonghutixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 用户提醒
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-04 20:50:59
 */
@TableName("yonghutixing")
public class YonghutixingView  extends YonghutixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YonghutixingView(){
	}
 
 	public YonghutixingView(YonghutixingEntity yonghutixingEntity){
 	try {
			BeanUtils.copyProperties(this, yonghutixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
