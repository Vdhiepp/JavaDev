
public class MonAnChayA extends NhaHang {
	private int docay;

	MonAnChayA() {
		super();
	}

	MonAnChayA(String mm, String tm, String lm, float sl, float dg, int dc) {
		super(mm, tm, lm, sl, dg);
		setDocay(dc);

	}

	@Override
	float Tinhtien() {
		if (getSoluong() > 10) {
			return getSoluong() * getDongia() + (getDocay() * 0.9f) * 0.9f;
		} else if (getSoluong() > 20) {
			return getSoluong() * getDongia() + (getDocay() * 0.9f) * 0.8f;
		}
		return getSoluong() * getDongia() + (getDocay() * 0.9f);
	}

	public int getDocay() {
		return docay;
	}

	public void setDocay(int docay) {
		this.docay = docay;
	}

}
