package com.ssafit.global.dto;

import com.ssafit.global.util.PaginationHelper;
import com.ssafit.infra.PageNavigationForPageHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse {

    private PaginationHelper page;

    public static PageResponse from(final PageNavigationForPageHelper page) {
        return new PageResponse(page);
    }
}
