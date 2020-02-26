package wl.onelei.test.tolk.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.dto
 * @ClassName: PaginationDTO
 * @Author: Administrator
 * @Description:
 * @Date: 2020/2/23 17:27
 * @Version: 1.0
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questionDTOs;
    private boolean showPreious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer currentPage;
    private List<Integer> pages = new ArrayList<Integer>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        // 总页数
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if(page < 1){
            page = 1;
        }

        if (page > totalPage){
            page = totalPage;
        }

        this.currentPage = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage){
                pages.add(page + i);
            }
        }

        // 是否显示上一页
        if (page == 1) {
            showPreious = false;
        } else {
            showPreious = true;
        }

        // 是否显示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        // 是否显示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        // 是否展示最后一页
        showEndPage = pages.contains(totalPage) ? false : true;
    }
}
