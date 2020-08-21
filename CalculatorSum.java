
public class CalculatorSum{
	public final int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	public static String firstNum = "";
	public static String secondNum = "";
	public static int sign = 0;
	public static int total = 0;
	
	public static boolean ET = false;
	
	public void addToFirstNum(String i)
	{
		this.firstNum += i;
	}
	public void addToSecondNum(String i)
	{
		this.secondNum += i;
	}
	public void calculate()
	{
		int num1 = Integer.parseInt(this.firstNum);
		int num2 = Integer.parseInt(this.secondNum);
		if(this.sign == 1) {
			this.total = num1 + num2;
		}
		else if(this.sign == 2) {
			this.total = num1 - num2;
		}
		else if(this.sign == 3) {
			this.total = num1 * num2;
		}
		else if(this.sign == 4) {
			this.total = num1 / num2;
		}
	}
	public int firstNum_AsInteger()
	{
		return Integer.parseInt(this.firstNum);
	}
	public int secondNum_AsInteger()
	{
		return Integer.parseInt(this.secondNum);
	}
	public void clear()
	{
		this.firstNum = "";
		this.secondNum = "";
		this.sign = 0;
		this.total = 0;
	}

	
	

}
