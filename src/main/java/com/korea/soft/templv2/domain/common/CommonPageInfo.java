package com.korea.soft.templv2.domain.common;

import com.korea.soft.templv2.domain.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.LinkedHashMap;
import java.util.Map;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonPageInfo {
	private int pageNumber;
	private int totalPages;
	private int pageBlock;
	private int startBlockPage;
	private int endBlockPage;
	private boolean first;
	private boolean last;


	public CommonPageInfo(Page<?> entity) {
		int pageNumber=entity.getPageable().getPageNumber(); //현재페이지
		int totalPages=entity.getTotalPages(); //총 페이지 수. 검색에따라 10개면 10개..
		int pageBlock = 5; //블럭의 수 1, 2, 3, 4, 5
		int startBlockPage = ((pageNumber)/pageBlock)*pageBlock+1; //현재 페이지가 7이라면 1*5+1=6
		int endBlockPage = startBlockPage+pageBlock-1; //6+5-1=10. 6,7,8,9,10해서 10.
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;
		boolean first = entity.isFirst();
		boolean last = entity.isLast();

		this.pageNumber = pageNumber;
		this.totalPages = totalPages;
		this.pageBlock = pageBlock;
		this.startBlockPage = startBlockPage;
		this.endBlockPage = endBlockPage;
		this.first = first;
		this.last = last;
	}
}