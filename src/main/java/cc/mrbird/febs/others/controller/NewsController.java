package cc.mrbird.febs.others.controller;

import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.others.dto.AddNewsDTO;
import cc.mrbird.febs.others.entity.News;
import cc.mrbird.febs.others.service.INewsService;
import cc.mrbird.febs.others.vo.AddNewsVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Slf4j
@RestController
@RequestMapping("news")
@Api("新闻控制中心")
public class NewsController {

    @Autowired
    private INewsService iNewsService;

    @ApiOperation("新增新闻")
    @PostMapping("add")
    public FebsResponse addNews(@RequestBody @Validated AddNewsVO addNewsVO) throws InvocationTargetException, IllegalAccessException {
        AddNewsDTO addNewsDTO = new AddNewsDTO();
        BeanUtils.copyProperties(addNewsVO, addNewsDTO);
        Integer result = iNewsService.add(addNewsDTO);
        if (0 == result) {
            log.warn("新增新闻失败");
            return new FebsResponse().fail();
        }
        return new FebsResponse().success();
    }

    @ApiOperation("删除新闻")
    @PostMapping("del")
    public FebsResponse delNews(@Param("newsId") String newsId) {
        Integer result = iNewsService.del(newsId);
        if (0 == result) {
            log.warn("删除新闻失败");
            return new FebsResponse().fail();
        }
        return new FebsResponse().success();
    }

    @ApiOperation("分页查询新闻列表")
    @GetMapping("list")
    public FebsResponse queryNews(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize) {
        IPage<News> result = iNewsService.list(pageNum, pageSize);
        if (null == result) {
            log.warn("查询新闻列表失败");
            return new FebsResponse().fail();
        }
        return new FebsResponse().success().data(result);
    }

}
