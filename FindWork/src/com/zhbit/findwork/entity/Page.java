package com.zhbit.findwork.entity;
/**
 * ��ҳʵ����
 * 
 * @author ������
 *
 */
public class Page {
	private int total;//�ܵ�����
	private int maxSize;//ÿҳ�������
	private int current;//���ѡ���ҳ��
	private boolean haspre;//�Ƿ�����һҳ
	private boolean hasnex;//�Ƿ�����һҳ
	
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public int getTotal() {
		return total;
	}
	public boolean isHaspre() {
		return haspre;
	}
	public void setHaspre(boolean haspre) {
		this.haspre = haspre;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public boolean isHasnex() {
		return hasnex;
	}
	public void setHasnex(boolean hasnex) {
		this.hasnex = hasnex;
	}
	
}
