package flow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigInteger;


/*---------InsertAnomaly-----
 * 
 * 插入异常DoS、DDoS、PortScan1、PortScan2
 * 
 * */

public class InsertAnomaly {

	/*----------------insertDos----------
	 * parameter:
	 * 	--number: 插入数量
	 *  --outPath:输出路径
	 * function：直接向一个已有数据文件插入Dos数据。
	 * */
	public static void insertDoS(int number, String outPath){
		
		//Dos数据
		String content = "256, 154.120.7.56, 88.15.13.202, 0, 6, 1974, 8333, 0, 517, 0, 22, 45576, 45576, " +
				"118.229.4.66, 24, 515, 3072, 56, 1391701350030, 1391701350031";
		
		//写文件
		try{
			File file = new File(outPath);
			
			if(!file.exists()){
				file.createNewFile();
			}
			//参数true表示：不覆盖原有内容
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			for(int i=0;i<number;i++){
				bw.write(content);
				bw.newLine();
			}
			bw.close();
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*------------------------insertDDoS-----------
	 * parameter：
	 *   --number:插入条数
	 *   --outPath:输出路径
	 * DDoS攻击：源IP分散，目的IP集中
	 * */
	public static void insertDDoS(int number, String outPath){
		
		//在一个循环里，生成一条数据，写一条数据
		try{
			
			//参数true表示：不覆盖原有内容
			File file = new File(outPath);
			
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			//原始数据
			String data = "256, 154.120.7.56, 88.15.13.202, 0, 6, 1974, 8333, 0, 517, 0, 22, 45576, 45576, " +
			"118.229.4.66, 24, 515, 3072, 56, 1391701350030, 1391701350031";
			//源IP的四个位
			int srcIpBit1 = 0, srcIpBit2 = 0, srcIpBit3 = 0, srcIpBit4 = 0;
			String arr[] = data.split(",");
			String content = "";//存储DDoS数据
			//bw.newLine();
			while(srcIpBit3 * 256 * 256 + srcIpBit2 * 256 + srcIpBit1 < number){	
				content = "";
				//源IP
				arr[1] = srcIpBit4 + "." + srcIpBit3 + "." + srcIpBit2 + "." + srcIpBit1;
				for(int j=0;j<arr.length;j++){
					if(j==19){
						content = content + arr[j];
					}else{
						content = content + arr[j] + ",";
					}
				}
				//写
				
				bw.write(content);
				bw.newLine();//换行
				//IP递增
				srcIpBit1++;
				if(srcIpBit1 == 256){
					srcIpBit1 = 0;
					srcIpBit2++;
					if(srcIpBit2 == 256){
						srcIpBit2 = 0;
						srcIpBit3++;
						if(srcIpBit3 == 256){
							srcIpBit3 = 0;
							srcIpBit4++;
						}
					}
				}
			}

		bw.close();
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*-------------------insertPortScan1----------
	 * parameters:
	 *   --
	 *   --
	 *   源IP集中，目的ip分散，目的端口集中（源IP向不同IP的同一端口发起攻击）
	 * */
	public static void insertPortScan1(int number, String outPath){
		
		//在一个循环里，生成一条数据，写一条数据
		try{
			
			//参数true表示：不覆盖原有内容
			File file = new File(outPath);
			
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			//原始数据
			String data = "256, 154.120.7.56, 88.15.13.202, 0, 6, 1974, 8333, 0, 517, 0, 22, 45576, 45576, " +
			"118.229.4.66, 24, 515, 3072, 56, 1391701350030, 1391701350031";
			//源IP的四个位
			int srcIpBit1 = 0, srcIpBit2 = 0, srcIpBit3 = 0, srcIpBit4 = 0;
			String arr[] = data.split(",");
			String content = "";//存储DDoS数据
			//bw.newLine();
			while(srcIpBit3 * 256 * 256 + srcIpBit2 * 256 + srcIpBit1 < number){	
				content = "";
				//目的IP
				arr[2] = srcIpBit4 + "." + srcIpBit3 + "." + srcIpBit2 + "." + srcIpBit1;
				for(int j=0;j<arr.length;j++){
					if(j==19){
						content = content + arr[j];
					}else{
						content = content + arr[j] + ",";
					}
				}
				//写
				
				bw.write(content);
				bw.newLine();//换行
				//IP递增
				srcIpBit1++;
				if(srcIpBit1 == 256){
					srcIpBit1 = 0;
					srcIpBit2++;
					if(srcIpBit2 == 256){
						srcIpBit2 = 0;
						srcIpBit3++;
						if(srcIpBit3 == 256){
							srcIpBit3 = 0;
							srcIpBit4++;
						}
					}
				}
			}

		bw.close();
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*-------------------insertPortScan2----------
	 * parameters:
	 *   --
	 *   --
	 *   源IP集中，目的ip集中，目的端口分散（源IP向目的IP的不同端口发起扫描）
	 * */
	public static void insertPortScan2(int number, String outPath){
		
		//在一个循环里，生成一条数据，写一条数据
		try{
			
			//参数true表示：不覆盖原有内容
			File file = new File(outPath);
			
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			//原始数据
			String data = "256, 154.120.7.56, 88.15.13.202, 0, 6, 1974, 8333, 0, 517, 0, 22, 45576, 45576, " +
			"118.229.4.66, 24, 515, 3072, 56, 1391701350030, 1391701350031";
			String arr[] = data.split(",");
			String content = "";//存储DDoS数据
			//bw.newLine();
			int dstPort = 0;
			while(dstPort < number){	
				content = "";
				//目的端口
				arr[6] = dstPort + "";
				for(int j=0;j<arr.length;j++){
					if(j==19){
						content = content + arr[j];
					}else{
						content = content + arr[j] + ",";
					}
				}
				//写
				bw.write(content);
				bw.newLine();//换行
			
				dstPort++;
			}

		bw.close();
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/*-----------------expandData-----------
	 * func:扩充数据，将时间延展
	 *   --inPath:  = outPath
	 *   --number:复制几遍
	 *   --outPath:
	 * 
	 * */
//	public static void expandData(String inPath, int number, String outPath){
//		//step1.复制所有数据，并修改时间戳，存到一个变量content中。
//		StringBuilder content = new StringBuilder("");
//		try{
//			File file1 = new File(inPath);
//			if(file1.isFile() && file1.exists()){
//				
//				String lineText = null;
//				
//				InputStreamReader read = new InputStreamReader(new FileInputStream(file1));
//				BufferedReader br = new BufferedReader(read);
//				
//				while((lineText = br.readLine())!=null){
//					
//					String arr[] = lineText.split(", ");
//					//System.out.println(arr[18]);
//					BigInteger tStart = new BigInteger(arr[18]);
//					BigInteger tEnd = new BigInteger(arr[19]);
//					
//					BigInteger tStartNew = new BigInteger("0");
//					BigInteger tEndNew = new BigInteger("0");
//					
//					BigInteger val = new BigInteger("250000");
//					BigInteger val1 = new BigInteger("0");
//					for(int i=1;i<number;i++){
//						
//						val1 = val.multiply(BigInteger.valueOf(i));
//						
//						tStartNew = tStart.add(val1);
//						tEndNew = tEnd.add(val1);
//					
//						arr[18] = tStartNew.toString();
//						arr[19] = tEndNew.toString();
//										
//						String newString = new String("");
//						for(int j=0;j<arr.length;j++){
//							if(j==19){
//								newString += arr[j];
//							}else{
//								newString += arr[j] + ", ";
//							}
//						}
//						
//						content.append(newString);
//						content.append("\r\n");
//					}
//				}
//				read.close();
//			}else{
//				System.out.println("找不到指定的文件！");
//			}
//		}
//		catch(Exception e){
//			System.out.println("读取文件出错！");
//			e.printStackTrace();
//		}
//		
//		//写文件
//		try{
//			
//			File file2 = new File(outPath);
//			if(!file2.exists()){
//				file2.createNewFile();
//			}
//			
//			FileWriter fw = new FileWriter(file2.getAbsoluteFile(), true);
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(content.toString());
//			//bw.newLine();
//			bw.close();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	
	
//	public static void expandData1(String inPath, int number, String outPath){
//		//step1.复制所有数据，并修改时间戳，存到一个变量content中。
//		StringBuilder content = new StringBuilder("");
//		try{
//			File file1 = new File(inPath);
//			if(file1.isFile() && file1.exists()){
//				
//				String lineText = null;
//				
//				InputStreamReader read = new InputStreamReader(new FileInputStream(file1));
//				BufferedReader br = new BufferedReader(read);
//				
//				BigInteger tStartNew = new BigInteger("0");
//				BigInteger tEndNew = new BigInteger("0");
//				
//				BigInteger val = new BigInteger("250000");
//				BigInteger val1 = new BigInteger("0");
//				
//				while((lineText = br.readLine())!=null){
//					
//					String arr[] = lineText.split(", ");
//					//System.out.println(arr[18]);
//					BigInteger tStart = new BigInteger(arr[18]);
//					BigInteger tEnd = new BigInteger(arr[19]);
//					
//					for(int i=0;i<number;i++){
//						
//						val1 = val.multiply(BigInteger.valueOf(i));
//						
//						tStartNew = tStart.add(val1);
//						tEndNew = tEnd.add(val1);
//					
//						arr[18] = tStartNew.toString();
//						arr[19] = tEndNew.toString();
//										
//						String newString = new String("");
//						for(int j=0;j<arr.length;j++){
//							if(j==19){
//								newString += arr[j];
//							}else{
//								newString += arr[j] + ", ";
//							}
//						}
//						
//						content.append(newString);
//						content.append("\r\n");
//						
//						//写文件
//						try{
//							
//							File file2 = new File(outPath);
//							if(!file2.exists()){
//								file2.createNewFile();
//							}
//							
//							FileWriter fw = new FileWriter(file2.getAbsoluteFile(), true);
//							BufferedWriter bw = new BufferedWriter(fw);
//							bw.write(content.toString());
//							bw.close();
//							
//						}catch(Exception e){
//							e.printStackTrace();
//						}
//						
//						content = new StringBuilder("");
//					}
//				}
//				read.close();
//			}else{
//				System.out.println("找不到指定的文件！");
//			}
//		}
//		catch(Exception e){
//			System.out.println("读取文件出错！");
//			e.printStackTrace();
//		}
//	}
	
	
	public static void expandData(String inPath, int number, String outPath){
		//step1.复制所有数据，并修改时间戳，存到一个变量content中。
		StringBuilder content = new StringBuilder("");
		try{
			File file1 = new File(inPath);
			if(file1.isFile() && file1.exists()){
				
				String lineText = null;
				
				InputStreamReader read = new InputStreamReader(new FileInputStream(file1));
				BufferedReader br = new BufferedReader(read);
				
				BigInteger tStartNew = new BigInteger("0");
				BigInteger tEndNew = new BigInteger("0");
				
				BigInteger val = new BigInteger("250000");
				BigInteger val1 = new BigInteger("0");
				
				try{
					
					File file2 = new File(outPath);
					if(!file2.exists()){
						file2.createNewFile();
					}
					
					FileWriter fw = new FileWriter(file2.getAbsoluteFile(), true);
					BufferedWriter bw = new BufferedWriter(fw);
				
					while((lineText = br.readLine())!=null){
					
						String arr[] = lineText.split(", ");
						//System.out.println(arr[18]);
						BigInteger tStart = new BigInteger(arr[18]);
						BigInteger tEnd = new BigInteger(arr[19]);
					
						for(int i=0;i<number;i++){
						
							val1 = val.multiply(BigInteger.valueOf(i));
						
							tStartNew = tStart.add(val1);
							tEndNew = tEnd.add(val1);
					
							arr[18] = tStartNew.toString();
							arr[19] = tEndNew.toString();
										
							String newString = new String("");
							for(int j=0;j<arr.length;j++){
								if(j==19){
									newString += arr[j];
								}else{
									newString += arr[j] + ", ";
								}
							}
						
							content.append(newString);
							content.append("\r\n");
	
							//写文件
							bw.write(content.toString());
						
						content = new StringBuilder("");
						}
					}
					
					bw.close();	
				}catch(Exception e){
					e.printStackTrace();
				}
					
				read.close();
			}else{
				System.out.println("找不到指定的文件！");
			}
		}
		catch(Exception e){
			System.out.println("读取文件出错！");
			e.printStackTrace();
		}
	}
	
	
	public static void genTrainData(String inPath, String outPath){
		
		
	}
	
	public static void main(String[] args){
		
		//InsertAnomaly.insertDoS(10, "C:/Users/jason/Desktop/ProcessData/e.txt");
		//InsertAnomaly.insertDDoS(10, "C:/Users/jason/Desktop/ProcessData/e.txt");
		//InsertAnomaly.insertPortScan1(10, "C:/Users/jason/Desktop/ProcessData/e.txt");
		//InsertAnomaly.insertPortScan2(10, "C:/Users/jason/Desktop/ProcessData/e.txt");
		InsertAnomaly.expandData("C:/Users/jason/Desktop/ProcessData/inner.txt", 10, 
				"C:/Users/jason/Desktop/ProcessData/readyTrain.txt");
		

		
		System.out.println("SUCCESS");
	}
}
