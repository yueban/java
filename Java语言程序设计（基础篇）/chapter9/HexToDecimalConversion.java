//16进制转10进制
public class HexToDecimalConversion{
	public static void main(String[] args){
		String hex = "111";
		System.out.println(hexToDecimal(hex));
	}

	public static int hexToDecimal(String hex){
		int decimalValue = 0;
		for(int i = 0;i < hex.length();i++){
			decimalValue = decimalValue * 16 + hexCharToDecimal(hex.charAt(i));
		}
		return decimalValue;
	}

	public static int hexCharToDecimal(char c){
		return (c >= 'A' && c <= 'F') ? 10 + c - 'A' : c - '0';
	}
}