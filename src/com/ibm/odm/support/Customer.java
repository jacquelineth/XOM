package  com.ibm.odm.support;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    public Euro purse;

    public Customer() {
        super();
        name=new java.util.Date().toString();
        System.out.println("Customer.Customer()");
    }

    public Customer(String id) {
        this();
        name=id;
    }
    public String getName(){
        return name;
    }

	public Euro getPurse() {
		return purse;
	}

	public void setPurse(Euro purse) {
		this.purse = purse;
	}

	public void addToPurse(Euro plus) {
		this.purse.increase(plus);
	}
	
	public boolean  substractFromPurse(Euro moins) {
		return this.purse.decrease(moins);
	}
}