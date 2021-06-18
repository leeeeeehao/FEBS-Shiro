package cc.mrbird.febs.others.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("PD_NEWS")
public class News implements Serializable {

    private static final long serialVersionUID = -4204557889200022135L;

    /**
     * id
     */
    @TableField("NEWS_ID")
    private String newsId;

    /**
     * 新闻标题
     */
    @TableField("NEWS_TITLE")
    private String newsTitle;

    /**
     * 新闻内容
     */
    @TableField("NEWS_CONTENT")
    private String newsContent;

    /**
     * 新闻类型 0-行业状态 1-公司咨询
     */
    @TableField("NEWS_TYPE")
    private Integer newsType;

    /**
     * 新闻状态 0-正常 1-下架
     */
    @TableField("NEWS_STATE")
    private Integer newsState;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 删除标识 0-未删除  1-已删除
     */
    @TableField("DEL_FLAG")
    private Integer delFlag;

    /**
     * 浏览量
     */
    @TableField("NEWS_PV")
    private Integer newsPv;
}
