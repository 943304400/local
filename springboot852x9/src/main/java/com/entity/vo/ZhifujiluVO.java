package com.entity.vo;

import com.entity.ZhifujiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 支付记录
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-04 20:50:58
 */
public class ZhifujiluVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
