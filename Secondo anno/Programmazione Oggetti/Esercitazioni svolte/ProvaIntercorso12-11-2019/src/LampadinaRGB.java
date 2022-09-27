import java.time.LocalTime;

public class LampadinaRGB extends DispositivoIoT {
	private String ColoreRGB;

	public LampadinaRGB(String RGB) {
		super(0.1);
		ColoreRGB = RGB;
		// TODO Auto-generated constructor stub
	}

	public LampadinaRGB(LocalTime orarioA, String RGB) {
		super(orarioA, 0.1);
		ColoreRGB = RGB;
		// TODO Auto-generated constructor stub
	}

	public LampadinaRGB(LocalTime orarioA, LocalTime orarioS, boolean stato, String RGB) {
		super(orarioA, orarioS, 0.1, stato);
		ColoreRGB = RGB;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LampadinaRGB: \nColoreRGB=" + ColoreRGB + " " + super.toString();
	}

	public boolean equals(DispositivoIoT d) {
		if (d instanceof LampadinaRGB) {
			LampadinaRGB x = (LampadinaRGB) d;
			return x.getColoreRGB().equals(this.ColoreRGB) && super.equals(d);
		} else
			return false;
	}

	public String getColoreRGB() {
		return ColoreRGB;
	}

	public void setColoreRGB(String coloreRGB) {
		ColoreRGB = coloreRGB;
	}

}
