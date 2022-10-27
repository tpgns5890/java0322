package co.edu.board;

public class PageVO {
	int totalCnt;
	int pageNum;
	int startPage, totalPage;
	int endPage;
	boolean prev, next;
	
	public PageVO(int totalCnt, int pageNum) {
		this.totalCnt = totalCnt;
		this.pageNum = pageNum;
		
		totalPage = (int) Math.ceil(totalCnt/10.0);
		this.endPage = (int) Math.ceil(this.pageNum/10.0)*10;
		this.startPage = this.endPage - 9;
		if(this.endPage==0) {}
		
		prev=  this.startPage > 10;
		
		
		
		
	}
}
