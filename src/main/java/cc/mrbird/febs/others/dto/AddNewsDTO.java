package cc.mrbird.febs.others.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddNewsDTO implements Serializable {

    private static final long serialVersionUID = 304580854704030635L;
    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 新闻类型
     */
    private Integer newsType;

}
