package cc.mrbird.febs.others.service;

import cc.mrbird.febs.others.dto.AddNewsDTO;
import cc.mrbird.febs.others.entity.News;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface INewsService {

    /**
     * 新增新闻
     *
     * @param addNewsDTO
     * @return
     */
    Integer add(AddNewsDTO addNewsDTO);

    /**
     * 逻辑删除新闻
     *
     * @param newsId
     * @return
     */
    Integer del(String newsId);

    IPage<News> list(Integer pageNum, Integer pageSize);

}
