

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* This class can store information about a conversion, including
fromUnit, fromValue, toUnit, toValue, and conversionRatio. 
This class also contain the methods that perform the conversion 
calculations and return the results as a formatted string. */
public class Conversion {
	private String fromUnit, toUnit; 
	private double conversionRatio, fromValue, toValue;

	Conversion () {
		this ("","", 0);
	}
	
	Conversion(String fromUnit, String toUnit, double conversionRatio) {
		this.fromUnit = fromUnit;
		this.toUnit = toUnit;
		this.conversionRatio = conversionRatio;
	}
	
	void setFromUnit(String fromUnit) {
		this.fromUnit = fromUnit;
	}
	
	String getFromUnit() {
		return fromUnit;
	}
	
	void setToUnit(String toUnit) {
		this.toUnit = toUnit;
	}
	
	String getToUnit() {
		return toUnit;
	}
	
	void setRatio(double conversionRatio) {
		this.conversionRatio = conversionRatio;
	}
	
	double getRatio() {
		return conversionRatio;
	}
	
	String calcFormattedConversionToValue (double unit, double conversionRatio) {
		
		toValue = unit *  conversionRatio; 
		/*
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		currency.setRoundingMode(RoundingMode.HALF_UP);
		return currency.format(toValue);
		*/
		DecimalFormat df = new DecimalFormat("0.000");
		String format = df.format(toValue);
		return format;
	}
	
	public String toString() {
		return  getFromUnit() + "\t" + getToUnit() + "\t" + getRatio() +"\n";
	}
}
