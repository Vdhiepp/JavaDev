
public abstract class NhaHang {
	private String mamon;
	private String tenmon;
	private String loaimon;
	private float soluong;
	private float dongia;

	NhaHang() {
	}

	NhaHang(String mm, String tm, String lm, float sl, float dg) {
		setMamon(mm);
		setTenmon(tm);
		setLoaimon(lm);
		setSoluong(sl);
		setDongia(dg);
	}
	
	abstract float Tinhtien(); 

	public String getMamon() {
		return mamon;
	}

	public void setMamon(String mamon) {
		this.mamon = mamon;
	}

	public String getTenmon() {
		return tenmon;
	}

	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}

	public String getLoaimon() {
		return loaimon;
	}

	public void setLoaimon(String loaimon) {
		this.loaimon = loaimon;
	}

	public float getSoluong() {
		return soluong;
	}

	public void setSoluong(float soluong) {
		this.soluong = soluong;
	}

	public float getDongia() {
		return dongia;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

}
