package com.gnanavad.utils;

public class ReportEntry {
	private Long itemNumber;
	private Long wamasOnHand;
	private Long wamasOnHold;
	private Long hostOnHand;
	private Long hostOnHold;
	private Long matching;

	public ReportEntry(long itemNumber, long wamasOnHand, long wamasOnHold, long hostOnHand, long hostOnHold,
			long matching) {
		this.itemNumber = itemNumber;
		this.wamasOnHand = wamasOnHand;
		this.wamasOnHold = wamasOnHold;
		this.hostOnHand = hostOnHand;
		this.hostOnHold = hostOnHold;
		this.matching = matching;
	}

	public Long getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Long itemNumber) {
		this.itemNumber = itemNumber;
	}

	public Long getWamasOnHand() {
		return wamasOnHand;
	}

	public void setWamasOnHand(Long wamasOnHand) {
		this.wamasOnHand = wamasOnHand;
	}

	public Long getWamasOnHold() {
		return wamasOnHold;
	}

	public void setWamasOnHold(Long wamasOnHold) {
		this.wamasOnHold = wamasOnHold;
	}

	public Long getHostOnHand() {
		return hostOnHand;
	}

	public void setHostOnHand(Long hostOnHand) {
		this.hostOnHand = hostOnHand;
	}

	public Long getHostOnHold() {
		return hostOnHold;
	}

	public void setHostOnHold(Long hostOnHold) {
		this.hostOnHold = hostOnHold;
	}

	public Long getMatching() {
		return matching;
	}

	public void setMatching(Long matching) {
		this.matching = matching;
	}

	@Override
	public String toString() {
		return String.format(
				"ReportEntry [itemNumber=%s, wamasOnHand=%s, wamasOnHold=%s, hostOnHand=%s, hostOnHold=%s, matching=%s]",
				itemNumber,
				wamasOnHand,
				wamasOnHold,
				hostOnHand,
				hostOnHold,
				matching);
	}

}
