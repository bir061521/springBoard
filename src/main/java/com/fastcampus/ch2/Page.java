package com.fastcampus.ch2;

public class Page {
    private int totalCnt;//전체 게시물
    private int pageSize = 10;//한 페이지당 보여 줄 슬 수
    private int pageCnt;    //페이지의 개수

    public final int NAV_SIZE=10;  //navi의 크기

    private int naviStart;
    private int naviEnd;
    public int page;

    public boolean showPrev = false;   //이전 페이지로 이동할것인가 보여주는 여부
    public boolean showNext = false;   //다음 페이지로 이동할것인가 보여주는 여부
    public Page() {

    }

    public Page(int totalCnt, int pageSize,  int page) {
        this.totalCnt = totalCnt;
        this.pageSize = pageSize;
        this.pageCnt = totalCnt/pageSize + (totalCnt%pageSize==0?0:1);
        this.naviStart = (page-1)/NAV_SIZE*NAV_SIZE+1;
        this.naviEnd = Math.min(naviStart + NAV_SIZE -1,pageCnt);
        this.page = page;
        this.showPrev = naviStart!=1;
        this.showNext = naviEnd != pageCnt;

    }


    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCnt() {
        return pageCnt;
    }

    public void setPageCnt(int pageCnt) {
        this.pageCnt = pageCnt;
    }

    public int getNAV_SIZE() {
        return NAV_SIZE;
    }


    public int getNaviStart() {
        return naviStart;
    }

    public void setNaviStart(int naviStart) {
        this.naviStart = naviStart;
    }

    public int getNaviEnd() {
        return naviEnd;
    }

    public void setNaviEnd(int naviEnd) {
        this.naviEnd = naviEnd;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", pageCnt=" + pageCnt +
                ", NAV_SIZE=" + NAV_SIZE+
                ", naviStart=" + naviStart +
                ", naviEnd=" + naviEnd +
                ", page=" + page +
                '}';
    }


}
