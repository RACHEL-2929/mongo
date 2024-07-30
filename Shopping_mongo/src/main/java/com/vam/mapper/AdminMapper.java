package com.vam.mapper;

import org.springframework.stereotype.Repository;

import com.vam.model.BookVO;

@Repository("oracle")
public interface AdminMapper{
	/* 상품 등록 */
	public void bookEnroll(BookVO book);
}
