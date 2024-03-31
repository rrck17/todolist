package org.example.todolist.Util;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PageConvert {
    public static Map<String, Integer> Pagination(Page<?> page) {
        int curPage = page.getNumber() + 1;
        int totPage = page.getTotalPages();
        int blockLimit = 5;

        Map<String, Integer> pageInfo = new HashMap<>();
        int s = Math.max(1, curPage-blockLimit/2);  // 시작 페이지 번호
        int e = Math.min(s+blockLimit-1, totPage);  // 끝 페이지 번호
        int p = Math.max(1, curPage-1);  // 앞 페이지 번호
        int n = Math.min(curPage+1, totPage);  // 뒤 페이지 번호
        int l = totPage;  // 전체 페이지 번호

        // 보낼값을 map에 저장
        pageInfo.put("startPage", s);
        pageInfo.put("endPage", e);
        pageInfo.put("prevPage", p);
        pageInfo.put("nextPage", n);
        pageInfo.put("currentPage", curPage);
        pageInfo.put("lastPage", l);

        return pageInfo;
    }
}