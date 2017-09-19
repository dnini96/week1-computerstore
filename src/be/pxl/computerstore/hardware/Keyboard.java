package be.pxl.computerstore.hardware;

public class Keyboard extends Peripheral {
	
	private String keyboardLayout;

	public Keyboard(String vendor, String name, double price, String keyboardLayout) {
		super(vendor, name, price);
		setKeyboardLayout(keyboardLayout);
	}
	
	public void setKeyboardLayout(String keyboardLayout) {
		if(keyboardLayout.equals("QWERTY") || keyboardLayout.equals("AZERTY") ) {
			this.keyboardLayout = keyboardLayout;
		}	
		
	}
	
	public String getKeyboardLayout() {
		return keyboardLayout;
	}
}
