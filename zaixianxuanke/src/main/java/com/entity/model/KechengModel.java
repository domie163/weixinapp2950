package com.entity.model;

import com.entity.KechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 课程信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KechengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课程名称
     */
    private String kechengName;


    /**
     * 课程类型
     */
    private Integer kechengTypes;


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
     * 详情
     */
    private String kechengContent;


    /**
     * 假删
     */
    private Integer kechengDelete;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：课程名称
	 */
    public String getKechengName() {
        return kechengName;
    }


    /**
	 * 设置：课程名称
	 */
    public void setKechengName(String kechengName) {
        this.kechengName = kechengName;
    }
    /**
	 * 获取：课程类型
	 */
    public Integer getKechengTypes() {
        return kechengTypes;
    }


    /**
	 * 设置：课程类型
	 */
    public void setKechengTypes(Integer kechengTypes) {
        this.kechengTypes = kechengTypes;
    }
    /**
	 * 获取：课程封面
	 */
    public String getKechengPhoto() {
        return kechengPhoto;
    }


    /**
	 * 设置：课程封面
	 */
    public void setKechengPhoto(String kechengPhoto) {
        this.kechengPhoto = kechengPhoto;
    }
    /**
	 * 获取：课程学时
	 */
    public String getKechengXueshi() {
        return kechengXueshi;
    }


    /**
	 * 设置：课程学时
	 */
    public void setKechengXueshi(String kechengXueshi) {
        this.kechengXueshi = kechengXueshi;
    }
    /**
	 * 获取：上课时间
	 */
    public Date getKechengTime() {
        return kechengTime;
    }


    /**
	 * 设置：上课时间
	 */
    public void setKechengTime(Date kechengTime) {
        this.kechengTime = kechengTime;
    }
    /**
	 * 获取：上课地点
	 */
    public String getKechengAddress() {
        return kechengAddress;
    }


    /**
	 * 设置：上课地点
	 */
    public void setKechengAddress(String kechengAddress) {
        this.kechengAddress = kechengAddress;
    }
    /**
	 * 获取：学分
	 */
    public Integer getKechengXuefen() {
        return kechengXuefen;
    }


    /**
	 * 设置：学分
	 */
    public void setKechengXuefen(Integer kechengXuefen) {
        this.kechengXuefen = kechengXuefen;
    }
    /**
	 * 获取：课程状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 设置：课程状态
	 */
    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 获取：详情
	 */
    public String getKechengContent() {
        return kechengContent;
    }


    /**
	 * 设置：详情
	 */
    public void setKechengContent(String kechengContent) {
        this.kechengContent = kechengContent;
    }
    /**
	 * 获取：假删
	 */
    public Integer getKechengDelete() {
        return kechengDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setKechengDelete(Integer kechengDelete) {
        this.kechengDelete = kechengDelete;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
