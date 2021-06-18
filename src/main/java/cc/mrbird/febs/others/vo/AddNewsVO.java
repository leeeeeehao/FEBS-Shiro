package cc.mrbird.febs.others.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddNewsVO implements Serializable {

    private static final long serialVersionUID = -3402303096173016023L;

    /**
     * 新闻标题
     */
    @ApiModelProperty("新闻标题")
    @NotBlank(message = "新闻标题不能为空")
    private String newsTitle;

    /**
     * 新闻类型
     */
    @NotNull(message = "新闻类型不能为空")
    @ApiModelProperty("新闻类型")
    private Integer newsType;

}
