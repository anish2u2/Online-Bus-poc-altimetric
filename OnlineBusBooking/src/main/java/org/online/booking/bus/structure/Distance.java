package org.online.booking.bus.structure;

public class Distance {

	public String from;

	public String to;

	public Long km;

	private int hashCode = -1;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Long getKm() {
		return km;
	}

	public void setKm(Long km) {
		this.km = km;
	}

	@Override
	public boolean equals(Object obj) {
		Distance distance = (Distance) obj;
		return (distance.getFrom().equals(this.getFrom()) && distance.getTo().equals(this.getTo()))
				|| (distance.getFrom().equals(this.getTo()) && distance.getTo().equals(this.getFrom()));
	}

	@Override
	public int hashCode() {
		if (hashCode == -1)
			hashCode = (this.getFrom() + this.getTo()).hashCode();
		return hashCode;
	}

}
