package com.fastcampus.ch2;


public class PageHandlerEx {


    int totalCnt;       //전체 게시물의 개수
    int pageSize = 20;  //한 페이지의 크기
    int totalPage;        //전체 페이지의 개수

    int curPage; //현재 페이지

    int naviSize = 10;  //navi한 페이지의 크기
    int naviStart = 1;  //navi의 시작 페이지
    int naviEnd;        //navi의 끝 페이지

    boolean showPrev = false;   //이전 페이지로 이동할것인가 보여주는 여부
    boolean showNext = false;   //다음 페이지로 이동할것인가 보여주는 여부


    public PageHandlerEx(int totalCnt, int curPage, int pageSize){
        this.totalCnt = totalCnt;
        this.curPage = curPage;
        this.pageSize = pageSize;

        //계산
        this.totalPage = totalCnt/pageSize + (totalCnt%pageSize==0 ? 0: 1);
        this.naviStart = curPage/ naviSize * naviSize +1;
        naviEnd = (naviStart + naviSize -1);
        naviEnd = naviEnd > totalPage ? totalPage : naviEnd;
        showPrev = naviStart != 1;
        showNext = naviEnd != totalPage;
    }

    public void print(){
        System.out.println("page=" + curPage);

        System.out.print(showPrev?"[PREV]" : "");
        for (int i = naviStart; i <= naviEnd; i++) {
            System.out.print(i +" ");
        }
        System.out.println(showNext?"[NEXT]":"");
    }
    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", naviSize=" + naviSize +
                ", naviStart=" + naviStart +
                ", naviEnd=" + naviEnd +
                ", curPage=" + curPage +
                '}';
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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
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

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }


}

