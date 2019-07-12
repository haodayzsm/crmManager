package top.haodayzsm.utils;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public class PageBean {
	private int currentPage;	//��ǰҳ��
	private int pageSize;		//ҳ����������	
	private int total;			//�ܼ�¼��
	private List row;			//���ݼ���
	private DetachedCriteria detachedCriteria;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRow() {
		return row;
	}
	public void setRow(List row) {
		this.row = row;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
}
