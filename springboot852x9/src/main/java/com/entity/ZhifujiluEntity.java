package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 支付记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-04 20:50:58
 */
@TableName("zhifujilu")
public class ZhifujiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhifujiluEntity() {
		
	}
	
	public ZhifujiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 出租单号
	 */
					
	private String chuzudanhao;
	
	/**
	 * 钱包金额
	 */
					
	private Integer qianbaojine;
	
	/**
	 * 支付时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date zhifushijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：出租单号
	 */
	public void setChuzudanhao(String chuzudanhao) {
		this.chuzudanhao = chuzudanhao;
	}
	/**
	 * 获取：出租单号
	 */
	public String getChuzudanhao() {
		return chuzudanhao;
	}
	/**
	 * 设置：钱包金额
	 */
	public void setQianbaojine(Integer qianbaojine) {
		this.qianbaojine = qianbaojine;
	}
	/**
	 * 获取：钱包金额
	 */
	public Integer getQianbaojine() {
		return qianbaojine;
	}
	/**
	 * 设置：支付时间
	 */
	public void setZhifushijian(Date zhifushijian) {
		this.zhifushijian = zhifushijian;
	}
	/**
	 * 获取：支付时间
	 */
	public Date getZhifushijian() {
		return zhifushijian;
	}

}
