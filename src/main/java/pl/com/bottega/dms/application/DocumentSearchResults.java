package pl.com.bottega.dms.application;

import java.util.List;

/**
 * Created by anna on 12.02.2017.
 */
public class DocumentSearchResults {

    private List<DocumentDto> documents;
    private Long pagesCount;
    private Integer pageNumber;
    private Integer perPage;

    public List<DocumentDto> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentDto> documents) {
        this.documents = documents;
    }

    public Long getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Long pagesCount) {
        this.pagesCount = pagesCount;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }
}
