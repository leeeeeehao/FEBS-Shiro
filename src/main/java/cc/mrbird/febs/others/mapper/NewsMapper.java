package cc.mrbird.febs.others.mapper;

import cc.mrbird.febs.others.entity.News;
import cc.mrbird.febs.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper extends BaseMapper<News> {

    /**
     * 逻辑删除新闻
     *
     * @param newsId
     * @return
     */
    Integer delNews(String newsId);

    /**
     * 查询新闻数量
     * @return
     */
    Long queryNewsCount();

    <T> IPage<News> queryNews(Page<T> page);

}
