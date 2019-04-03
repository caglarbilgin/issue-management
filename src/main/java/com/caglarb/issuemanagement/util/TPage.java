package com.caglarb.issuemanagement.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class TPage<T> {

    private int number; // kaçıncı sayfa gösteriyior
    private int size; // kaçarlı kaçarlı sayfalansın
    private Sort sort; // kolonda sıralama yapacak
    private int totalPages; // sayfalama yapıldığında toplamda kaç sayfa oluştu
    private Long totalElements; // toplamda kaç kayıt olduğunu  gösterecek
    private List<T> content; // o page'lerdeki içerikler

    public void setStat(Page page, List<T> list) {
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = list;
    }
}
