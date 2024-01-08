
public class MonAnChauAu extends NhaHang {
	private float thoigian;

	MonAnChauAu() {
		super();
	}

	MonAnChauAu(String mm, String tm, String lm, float sl, float dg, float tg) {
		super(mm, tm, lm, sl, dg);
		setThoigian(tg);
	}

	@Override
	float Tinhtien() {
		return (getThoigian() > 3) ? ((getSoluong() * getDongia()) + (getThoigian() * 5000) * 1.3f) : (getSoluong() * getDongia()) + (getThoigian() * 5000);
	}

	public float getThoigian() {
		return thoigian;
	}

	public void setThoigian(float thoigian) {
		this.thoigian = thoigian;
	}

}
