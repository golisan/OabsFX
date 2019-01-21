package application;

public class Parameter {
	private boolean ok = false;
	private String[] outData = null;
	private Ids inId  = null;

	
	
	public Ids getInId() {
		return inId;
	}
	public void setInId(Ids inId) {
		this.inId = inId;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String[] getOutData() {
		return outData;
	}
	public void setOutData(String[] outData) {
		this.outData = outData;
	}

}
