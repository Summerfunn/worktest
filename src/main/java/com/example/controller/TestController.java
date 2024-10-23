package com.example.controller;

import cn.zhxu.bs.BeanSearcher;
import cn.zhxu.bs.MapSearcher;
import cn.zhxu.bs.SearchResult;
import cn.zhxu.bs.util.MapUtils;
import com.example.pojo.dept;
import com.example.repo.deptRepository;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@RestController
@RequestMapping("/dept")
public class TestController {
    @Autowired
    private MapSearcher mapSearcher;


    @Autowired
    private deptRepository deptRepository;

    @Autowired
    private BeanSearcher beanSearcher;


    @GetMapping("/index")
    public SearchResult<Map<String, Object>> index(HttpServletRequest request) {
        // 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）
//        SearchResult<dept> search = beanSearcher.search(dept.class);
//        List<dept> dataList = search.getDataList();
//        dataList.stream().forEach(new Consumer<dept>() {
//            @Override
//            public void accept(dept dept) {
//                System.out.println(dept.toString());
//            }
//        });
        Map<String, Object> flat = MapUtils.flat(request.getParameterMap());
        Set<Map.Entry<String, Object>> entries = flat.entrySet();
      //  Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        for (Iterator<Map.Entry<String, Object>> iterator = entries.iterator();iterator.hasNext();)
        {
            Map.Entry<String, Object> next = iterator.next();
            System.out.println("String:"+next.getKey()+", Object:"+next.getValue());
        }

        return mapSearcher.search(dept.class, MapUtils.flat(request.getParameterMap()));
    }


    @GetMapping("/{id}")
    public List<dept> getDept(@PathVariable("id") Integer id)
    {
        List<dept> byIdEquals = deptRepository.findByIdEquals(id);
        return byIdEquals;
    }
}
