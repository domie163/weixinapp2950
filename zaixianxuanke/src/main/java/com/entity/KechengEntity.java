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
 * 课程信息
 *
 * @author 
 * @email
 */
@TableName("kecheng")
public class KechengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KechengEntity() {

	}

	public KechengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 课程名称
     */
    @TableField(value = "kecheng_name")

    private String kechengName;


    /**
     * 课程类型
     */
    @TableField(value = "kecheng_types")

    private Integer kechengTypes;


    /**
     * 课程封面
     */
    @TableField(value = "kecheng_photo")

    private String kechengPhoto;


    /**
     * 课程学时
     */
    @TableField(value = "kecheng_xueshi")

    private String kechengXueshi;


    /**
     * 上课时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "kecheng_time")

    private Date kechengTime;


    /**
     * 上课地点
     */
    @TableField(value = "kecheng_address")

    private String kechengAddress;


    /**
     * 学分
     */
    @TableField(value = "kecheng_xuefen")

    private Integer kechengXuefen;


    /**
     * 课程状态
     */
    @TableField(value = "status_types")

    private Integer statusTypes;


    /**
     * 详情
     */
    @TableField(value = "kecheng_content")

    private String kechengContent;


    /**
     * 假删
     */
    @TableField(value = "kecheng_delete")

    private Integer kechengDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：课程名称
	 */
    public String getKechengName() {
        return kechengName;
    }


    /**
	 * 获取：课程名称
	 */

    public void setKechengName(String kechengName) {
        this.kechengName = kechengName;
    }
    /**
	 * 设置：课程类型
	 */
    public Integer getKechengTypes() {
        return kechengTypes;
    }


    /**
	 * 获取：课程类型
	 */

    public void setKechengTypes(Integer kechengTypes) {
        this.kechengTypes = kechengTypes;
    }
    /**
	 * 设置：课程封面
	 */
    public String getKechengPhoto() {
        return kechengPhoto;
    }


    /**
	 * 获取：课程封面
	 */

    public void setKechengPhoto(String kechengPhoto) {
        this.kechengPhoto = kechengPhoto;
    }
    /**
	 * 设置：课程学时
	 */
    public String getKechengXueshi() {
        return kechengXueshi;
    }


    /**
	 * 获取：课程学时
	 */

    public void setKechengXueshi(String kechengXueshi) {
        this.kechengXueshi = kechengXueshi;
    }
    /**
	 * 设置：上课时间
	 */
    public Date getKechengTime() {
        return kechengTime;
    }


    /**
	 * 获取：上课时间
	 */

    public void setKechengTime(Date kechengTime) {
        this.kechengTime = kechengTime;
    }
    /**
	 * 设置：上课地点
	 */
    public String getKechengAddress() {
        return kechengAddress;
    }


    /**
	 * 获取：上课地点
	 */

    public void setKechengAddress(String kechengAddress) {
        this.kechengAddress = kechengAddress;
    }
    /**
	 * 设置：学分
	 */
    public Integer getKechengXuefen() {
        return kechengXuefen;
    }


    /**
	 * 获取：学分
	 */

    public void setKechengXuefen(Integer kechengXuefen) {
        this.kechengXuefen = kechengXuefen;
    }
    /**
	 * 设置：课程状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 获取：课程状态
	 */

    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 设置：详情
	 */
    public String getKechengContent() {
        return kechengContent;
    }


    /**
	 * 获取：详情
	 */

    public void setKechengContent(String kechengContent) {
        this.kechengContent = kechengContent;
    }
    /**
	 * 设置：假删
	 */
    public Integer getKechengDelete() {
        return kechengDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setKechengDelete(Integer kechengDelete) {
        this.kechengDelete = kechengDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Kecheng{" +
            "id=" + id +
            ", kechengName=" + kechengName +
            ", kechengTypes=" + kechengTypes +
            ", kechengPhoto=" + kechengPhoto +
            ", kechengXueshi=" + kechengXueshi +
            ", kechengTime=" + kechengTime +
            ", kechengAddress=" + kechengAddress +
            ", kechengXuefen=" + kechengXuefen +
            ", statusTypes=" + statusTypes +
            ", kechengContent=" + kechengContent +
            ", kechengDelete=" + kechengDelete +
            ", createTime=" + createTime +
        "}";
    }
}
