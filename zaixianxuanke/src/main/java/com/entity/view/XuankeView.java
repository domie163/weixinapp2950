package com.entity.view;

import com.entity.XuankeEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 选课信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xuanke")
public class XuankeView extends XuankeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 审核的值
		*/
		private String xuankeYesnoValue;



		//级联表 kecheng
			/**
			* 课程名称
			*/
			private String kechengName;
			/**
			* 课程类型
			*/
			private Integer kechengTypes;
				/**
				* 课程类型的值
				*/
				private String kechengValue;
			/**
			* 课程封面
			*/
			private String kechengPhoto;
			/**
			* 课程学时
			*/
			private String kechengXueshi;
			/**
			* 上课时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date kechengTime;
			/**
			* 上课地点
			*/
			private String kechengAddress;
			/**
			* 学分
			*/
			private Integer kechengXuefen;
			/**
			* 课程状态
			*/
			private Integer statusTypes;
				/**
				* 课程状态的值
				*/
				private String statusValue;
			/**
			* 详情
			*/
			private String kechengContent;
			/**
			* 假删
			*/
			private Integer kechengDelete;

		//级联表 xuesheng
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 手机号
			*/
			private String xueshengPhone;
			/**
			* 照片
			*/
			private String xueshengPhoto;
			/**
			* 已修学分
			*/
			private Integer xueshengYixiu;
			/**
			* 应修学分
			*/
			private Integer xueshengYingxiu;
			/**
			* 假删
			*/
			private Integer xueshengDelete;

	public XuankeView() {

	}

	public XuankeView(XuankeEntity xuankeEntity) {
		try {
			BeanUtils.copyProperties(this, xuankeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核的值
			*/
			public String getXuankeYesnoValue() {
				return xuankeYesnoValue;
			}
			/**
			* 设置： 审核的值
			*/
			public void setXuankeYesnoValue(String xuankeYesnoValue) {
				this.xuankeYesnoValue = xuankeYesnoValue;
			}













				//级联表的get和set kecheng
					/**
					* 获取： 课程名称
					*/
					public String getKechengName() {
						return kechengName;
					}
					/**
					* 设置： 课程名称
					*/
					public void setKechengName(String kechengName) {
						this.kechengName = kechengName;
					}
					/**
					* 获取： 课程类型
					*/
					public Integer getKechengTypes() {
						return kechengTypes;
					}
					/**
					* 设置： 课程类型
					*/
					public void setKechengTypes(Integer kechengTypes) {
						this.kechengTypes = kechengTypes;
					}


						/**
						* 获取： 课程类型的值
						*/
						public String getKechengValue() {
							return kechengValue;
						}
						/**
						* 设置： 课程类型的值
						*/
						public void setKechengValue(String kechengValue) {
							this.kechengValue = kechengValue;
						}
					/**
					* 获取： 课程封面
					*/
					public String getKechengPhoto() {
						return kechengPhoto;
					}
					/**
					* 设置： 课程封面
					*/
					public void setKechengPhoto(String kechengPhoto) {
						this.kechengPhoto = kechengPhoto;
					}
					/**
					* 获取： 课程学时
					*/
					public String getKechengXueshi() {
						return kechengXueshi;
					}
					/**
					* 设置： 课程学时
					*/
					public void setKechengXueshi(String kechengXueshi) {
						this.kechengXueshi = kechengXueshi;
					}
					/**
					* 获取： 上课时间
					*/
					public Date getKechengTime() {
						return kechengTime;
					}
					/**
					* 设置： 上课时间
					*/
					public void setKechengTime(Date kechengTime) {
						this.kechengTime = kechengTime;
					}
					/**
					* 获取： 上课地点
					*/
					public String getKechengAddress() {
						return kechengAddress;
					}
					/**
					* 设置： 上课地点
					*/
					public void setKechengAddress(String kechengAddress) {
						this.kechengAddress = kechengAddress;
					}
					/**
					* 获取： 学分
					*/
					public Integer getKechengXuefen() {
						return kechengXuefen;
					}
					/**
					* 设置： 学分
					*/
					public void setKechengXuefen(Integer kechengXuefen) {
						this.kechengXuefen = kechengXuefen;
					}
					/**
					* 获取： 课程状态
					*/
					public Integer getStatusTypes() {
						return statusTypes;
					}
					/**
					* 设置： 课程状态
					*/
					public void setStatusTypes(Integer statusTypes) {
						this.statusTypes = statusTypes;
					}


						/**
						* 获取： 课程状态的值
						*/
						public String getStatusValue() {
							return statusValue;
						}
						/**
						* 设置： 课程状态的值
						*/
						public void setStatusValue(String statusValue) {
							this.statusValue = statusValue;
						}
					/**
					* 获取： 详情
					*/
					public String getKechengContent() {
						return kechengContent;
					}
					/**
					* 设置： 详情
					*/
					public void setKechengContent(String kechengContent) {
						this.kechengContent = kechengContent;
					}
					/**
					* 获取： 假删
					*/
					public Integer getKechengDelete() {
						return kechengDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setKechengDelete(Integer kechengDelete) {
						this.kechengDelete = kechengDelete;
					}










				//级联表的get和set xuesheng
					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}
					/**
					* 获取： 已修学分
					*/
					public Integer getXueshengYixiu() {
						return xueshengYixiu;
					}
					/**
					* 设置： 已修学分
					*/
					public void setXueshengYixiu(Integer xueshengYixiu) {
						this.xueshengYixiu = xueshengYixiu;
					}
					/**
					* 获取： 应修学分
					*/
					public Integer getXueshengYingxiu() {
						return xueshengYingxiu;
					}
					/**
					* 设置： 应修学分
					*/
					public void setXueshengYingxiu(Integer xueshengYingxiu) {
						this.xueshengYingxiu = xueshengYingxiu;
					}
					/**
					* 获取： 假删
					*/
					public Integer getXueshengDelete() {
						return xueshengDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setXueshengDelete(Integer xueshengDelete) {
						this.xueshengDelete = xueshengDelete;
					}



}
