package com.company;

public class Main {

    public static void main(String[] args) {
	ITeliphone tarunsPhone;
	tarunsPhone = new DeskPhone(123456);
	tarunsPhone.powerOn();
	tarunsPhone.callPhone(123456);
	tarunsPhone.answer();

	tarunsPhone = new MobilePhone(654321);
		tarunsPhone.powerOn();
		tarunsPhone.callPhone(654321);
		tarunsPhone.answer();
    }
}
