package dto;

public class Purchase
{
	int userid;
	int purchaseid;
	@Override
	public String toString() {
		return "Purchase [ purchaseid=" + purchaseid + "]";
	}
	 
	public Purchase(){}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}
}