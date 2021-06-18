package cc.mrbird.febs.others.service.impl;

import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.common.utils.StringUtils;
import cc.mrbird.febs.others.dto.AddNewsDTO;
import cc.mrbird.febs.others.entity.News;
import cc.mrbird.febs.others.mapper.NewsMapper;
import cc.mrbird.febs.others.service.INewsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class INewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Integer add(AddNewsDTO addNewsDTO) {
        try {
            News news = News
                    .builder()
                    .newsId(StringUtils.getGUID())
                    .newsTitle(addNewsDTO.getNewsTitle())
                    .newsType(addNewsDTO.getNewsType())
                    .newsState(0)
                    .newsPv(0)
                    .createTime(new Date())
                    .build();
            Integer result = newsMapper.insert(news);
            return result;
        } catch (Exception e) {
            log.error("新增新闻失败原因{}", e.toString());
            return 0;
        }

    }

    @Override
    public Integer del(String newsId) {
        try {
            Integer result = newsMapper.delNews(newsId);
            return result;
        } catch (Exception e) {
            log.error("删除新闻失败原因{}", e.toString());
            return 0;
        }
    }

    @Override
    public IPage<News> list(Integer pageNum, Integer pageSize) {
        try {
            if (ObjectUtils.isEmpty(pageNum) || ObjectUtils.isEmpty(pageSize)) {
                log.error("参数为空");
                return null;
            }
            Page<News> page = new Page<>(pageNum, pageSize);
            page.setSearchCount(false);
            page.setTotal(newsMapper.queryNewsCount());
            QueryRequest queryRequest = new QueryRequest();
            queryRequest.setPageNum(pageNum);
            queryRequest.setPageSize(pageSize);
            SortUtil.handlePageSort(queryRequest, page, "CREATE_TIME", FebsConstant.ORDER_ASC, false);
            return newsMapper.queryNews(page);
        } catch (Exception e) {
            log.error("分页获取新闻列表失败原因:{}", e.toString());
            return null;
        }
    }

}
