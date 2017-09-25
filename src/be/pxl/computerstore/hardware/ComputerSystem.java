package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Computable;
import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystem implements Computable {

	public static final int MAX_PERIPHERAL = 3;
	private Processor processor;
	private ComputerCase computerCase;
	private Peripheral[] peripherals = new Peripheral[MAX_PERIPHERAL];
	private int peripheralCounter = 0;
	
	public ComputerSystem() {
		
	}
	
	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public ComputerCase getComputerCase() {
		return computerCase;
	}

	public void setComputerCase(ComputerCase computerCase) {
		this.computerCase = computerCase;
	}

	public void addPeripheral(Peripheral peripheral) throws TooManyPeripheralsException {
		try {
			peripherals[getNumberOfPeripherals() ] = peripheral;
			peripheralCounter++;
		} catch(ArrayIndexOutOfBoundsException ex) {
			throw new TooManyPeripheralsException();
		}
		
	}
	
	public void removePeripheral(String articleNumber) {
		for(int i = 0; i < peripherals.length; i++) {
			try{
				if(!peripherals[i].equals(null)) {
					if(peripherals[i].getArticleNumber().equals(articleNumber)) {
						peripherals[i] = null;
						peripheralCounter -= 1;
						i = 10;
					}
			}
			}catch(NullPointerException ex) {
				
					if(peripheralCounter == 0) {
						
					}else {
						peripheralCounter -= 1;
					}
					
					i = 10;
				
			}
		
		}
	}
	
	public int getNumberOfPeripherals() {
		return peripheralCounter;
	}
	
	public Peripheral[] getPeripherals() {
		return peripherals;
	}

	public int getPeripheralCounter() {
		return peripheralCounter;
	}

	public void setPeripheralCounter(int peripheralCounter) {
		this.peripheralCounter = peripheralCounter;
	}


	@Override
	public double totalPriceExcl() {
		double peripheralPrice = 0;
		for(int i = 0; i < peripheralCounter; i++) {
			peripheralPrice += peripherals[i].getPrice();
		}
		double totalPrice = processor.getPrice() + computerCase.getPrice() + peripheralPrice;	
		return totalPrice;
	}
} 
