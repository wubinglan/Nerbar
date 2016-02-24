/**
 * 
 * @author 王泽振
 *2016年2月24日 下午3:22:41
 */
public class FamilyAccount {

	private static  int balance = 10000;
	private static String state = "没有记录";
	private static String state1 = "没有记录";
	private static int money = 0;
	private static int money1 = 0;
	private static String details = "收支\t账户金额\t\t收支金额\t\t说明";
	static String details1 = "收入\t"+balance+
			"\t\t"+money+"\t\t"+state;;
	static String details2 = "支出\t"+balance+
			"\t\t"+money1+"\t\t"+state1 ;;

	/**
	 * 收支明细
	 */
	public static void showInOf() {
		System.out.println("---------------当前收支明细记录------------");
		System.out.println(details );
		System.out.println(details1);
		System.out.println(details2);
		System.out.println();
		System.out.println("---------------------------------------");
	}
	
	/**
	 * 登记记录
	 */
	public static void record() {
		System.out.println("本次收入金额：");
		money =  Utility.readNumber();
		System.out.println("本次收入说明：");
		state = Utility.readString();
		balance += money;
		
	}
	
	/**
	 * 登记支出
	 */
	public static void expend() {
		System.out.println("本次支出金额：");
		money1 =  Utility.readNumber();
		System.out.println("本次支出说明：");
		state1 = Utility.readString();
		balance -= money1;
		
	}
	/**
	 * 退出
	 */
	public static void exit() {
		System.out.println("确认是否退出（Y/N）：");
		char cr = Utility.readConfirmSelection();
		if(cr == 'Y' || cr == 'y'){
			System.out.println("退出成功，欢迎再来");
			System.exit(0);
		}
	}
	
	
	/**
	 * 主方法
	 * @param args
	 */
		public static void main(String[] args) {
			boolean flag = true;
			do{
				System.out.println("------------家庭收支记账软件------------");
				System.out.println();
				System.out.println("               1 收支明细                                  ");
				System.out.println("               2 登记收入                                  ");
				System.out.println("               3 登记支出                                  ");
				System.out.println("               4 退出                                          ");
				System.out.println();
				System.out.println("            请选择（1-4）：                               ");
				
				char cr = Utility.readMenuSelection();
				switch (cr) {
				case '1':
					showInOf();
					break;
				case '2':
					record();
					break;
				case '3':
					expend();
					break;
				case '4':
					exit();
					flag = false;
					break;
				
				}
				}while(flag);
		}
}
