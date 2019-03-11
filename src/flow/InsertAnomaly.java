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
 * �����쳣DoS��DDoS��PortScan1��PortScan2
 * 
 * */

public class InsertAnomaly {

	/*----------------insertDos----------
	 * parameter:
	 * 	--number: ��������
	 *  --outPath:���·��
	 * function��ֱ����һ�����������ļ�����Dos���ݡ�
	 * */
	public static void insertDoS(int number, String outPath){
		
		//Dos����
		String content = "256, 154.120.7.56, 88.15.13.202, 0, 6, 1974, 8333, 0, 517, 0, 22, 45576, 45576, " +
				"118.229.4.66, 24, 515, 3072, 56, 1391701350030, 1391701350031";
		
		//д�ļ�
		try{
			File file = new File(outPath);
			
			if(!file.exists()){
				file.createNewFile();
			}
			//����true��ʾ��������ԭ������
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
	 * parameter��
	 *   --number:��������
	 *   --outPath:���·��
	 * DDoS������ԴIP��ɢ��Ŀ��IP����
	 * */
	public static void insertDDoS(int number, String outPath){
		
		//��һ��ѭ�������һ�����ݣ�дһ������
		try{
			
			//����true��ʾ��������ԭ������
			File file = new File(outPath);
			
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			//ԭʼ����
			String data = "256, 154.120.7.56, 88.15.13.202, 0, 6, 1974, 8333, 0, 517, 0, 22, 45576, 45576, " +
			"118.229.4.66, 24, 515, 3072, 56, 1391701350030, 1391701350031";
			//ԴIP���ĸ�λ
			int srcIpBit1 = 0, srcIpBit2 = 0, srcIpBit3 = 0, srcIpBit4 = 0;
			String arr[] = data.split(",");
			String content = "";//�洢DDoS����
			//bw.newLine();
			while(srcIpBit3 * 256 * 256 + srcIpBit2 * 256 + srcIpBit1 < number){	
				content = "";
				//ԴIP
				arr[1] = srcIpBit4 + "." + srcIpBit3 + "." + srcIpBit2 + "." + srcIpBit1;
				for(int j=0;j<arr.length;j++){
					if(j==19){
						content = content + arr[j];
					}else{
						content = content + arr[j] + ",";
					}
				}
				//д
				
				bw.write(content);
				bw.newLine();//����
				//IP����
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
	 *   ԴIP���У�Ŀ��ip��ɢ��Ŀ�Ķ˿ڼ��У�ԴIP��ͬIP��ͬһ�˿ڷ��𹥻���
	 * */
	public static void insertPortScan1(int number, String outPath){
		
		//��һ��ѭ�������һ�����ݣ�дһ������
		try{
			
			//����true��ʾ��������ԭ������
			File file = new File(outPath);
			
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			//ԭʼ����
			String data = "256, 154.120.7.56, 88.15.13.202, 0, 6, 1974, 8333, 0, 517, 0, 22, 45576, 45576, " +
			"118.229.4.66, 24, 515, 3072, 56, 1391701350030, 1391701350031";
			//ԴIP���ĸ�λ
			int srcIpBit1 = 0, srcIpBit2 = 0, srcIpBit3 = 0, srcIpBit4 = 0;
			String arr[] = data.split(",");
			String content = "";//�洢DDoS����
			//bw.newLine();
			while(srcIpBit3 * 256 * 256 + srcIpBit2 * 256 + srcIpBit1 < number){	
				content = "";
				//Ŀ��IP
				arr[2] = srcIpBit4 + "." + srcIpBit3 + "." + srcIpBit2 + "." + srcIpBit1;
				for(int j=0;j<arr.length;j++){
					if(j==19){
						content = content + arr[j];
					}else{
						content = content + arr[j] + ",";
					}
				}
				//д
				
				bw.write(content);
				bw.newLine();//����
				//IP����
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
	 *   ԴIP���У�Ŀ��ip���У�Ŀ�Ķ˿ڷ�ɢ��ԴIP��Ŀ��IP�Ĳ�ͬ�˿ڷ���ɨ�裩
	 * */
	public static void insertPortScan2(int number, String outPath){
		
		//��һ��ѭ�������һ�����ݣ�дһ������
		try{
			
			//����true��ʾ��������ԭ������
			File file = new File(outPath);
			
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			//ԭʼ����
			String data = "256, 154.120.7.56, 88.15.13.202, 0, 6, 1974, 8333, 0, 517, 0, 22, 45576, 45576, " +
			"118.229.4.66, 24, 515, 3072, 56, 1391701350030, 1391701350031";
			String arr[] = data.split(",");
			String content = "";//�洢DDoS����
			//bw.newLine();
			int dstPort = 0;
			while(dstPort < number){	
				content = "";
				//Ŀ�Ķ˿�
				arr[6] = dstPort + "";
				for(int j=0;j<arr.length;j++){
					if(j==19){
						content = content + arr[j];
					}else{
						content = content + arr[j] + ",";
					}
				}
				//д
				bw.write(content);
				bw.newLine();//����
			
				dstPort++;
			}

		bw.close();
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/*-----------------expandData-----------
	 * func:�������ݣ���ʱ����չ
	 *   --inPath:  = outPath
	 *   --number:���Ƽ���
	 *   --outPath:
	 * 
	 * */
//	public static void expandData(String inPath, int number, String outPath){
//		//step1.�����������ݣ����޸�ʱ������浽һ������content�С�
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
//				System.out.println("�Ҳ���ָ�����ļ���");
//			}
//		}
//		catch(Exception e){
//			System.out.println("��ȡ�ļ�����");
//			e.printStackTrace();
//		}
//		
//		//д�ļ�
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
//		//step1.�����������ݣ����޸�ʱ������浽һ������content�С�
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
//						//д�ļ�
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
//				System.out.println("�Ҳ���ָ�����ļ���");
//			}
//		}
//		catch(Exception e){
//			System.out.println("��ȡ�ļ�����");
//			e.printStackTrace();
//		}
//	}
	
	
	public static void expandData(String inPath, int number, String outPath){
		//step1.�����������ݣ����޸�ʱ������浽һ������content�С�
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
	
							//д�ļ�
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
				System.out.println("�Ҳ���ָ�����ļ���");
			}
		}
		catch(Exception e){
			System.out.println("��ȡ�ļ�����");
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
