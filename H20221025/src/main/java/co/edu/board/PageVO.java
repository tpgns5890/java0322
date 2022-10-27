package co.edu.board;

public class PageVO {
	int totalCnt; //전체건수
	int pageNum; //현재페이지.
	int startPage, endPage, totalPage; //시작,마지막페이지,전체페이지
	boolean prev, next; //이전, 마지막페이지 유무
	
	public PageVO(int totalCnt, int pageNum) {
		this.totalCnt = totalCnt;
		this.pageNum = pageNum;
	
		
		totalPage = (int)Math.ceil(totalCnt / 10.0); //51.6 => 51p
		// startPage, endPage 계산
		this.endPage = (int)Math.ceil(this.pageNum/10.0)*10; // 60page.
		this.startPage = this.endPage - 9; // 51page.(10p보여줄것이기 때문에)
		
		// 마지막페이지 > 게시글 전체페이지  
		if(this.endPage>totalPage) {
			this.endPage = totalPage;
		}
		
		prev = this.startPage >= 11; //이전페이지 true
		next = this.endPage < totalPage; //다음페이지 true

	}

	@Override
	public String toString() {
		return "PageVO [totalCnt=" + totalCnt + ", pageNum=" + pageNum + ", startPage=" + startPage + ", endPage="
				+ endPage + ", totalPage=" + totalPage + ", prev=" + prev + ", next=" + next + "]";
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}
}