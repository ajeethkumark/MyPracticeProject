package solartis_automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DeviationMergeProcess {
	 String deviationFilelistPath="//home//ajeeth//drl_file//deviation_list";	
	 String oldFilepath="//home//ajeeth//drl_file//CommercialAutoVehicleCollisionCoverage_98_CollCov__101_CollCov_TX_04012018_V01.drl";
	 String newFilepath="//home//ajeeth//drl_file//CommercialAutoVehicleCollisionCoverage_98_CollCov__101_CollCov_TX_13012022_V01.drl";
	 
	 String coverageName="CommercialAutoVehicleCollisionCoverage";
	 
	 //enter the new Algorithm number
	 String newAlgorithmNumber="ajeeth";
	 
	 //enter the effective date with required format exactly
	 String newDate="11-11-11";
	 
	 String mergeFilepath="";
	 String extractOldversionDate="";
	 String extractOldversioonAlgorithmnumber="";
	 //make the algorithmNumberflag = 1 if you want to add algorithm number below when condition
	 int algorithmNumberflag=1;
	 int deviationMatchflag=0;
	 
	 
	public static void main(String[] arg) throws IOException
	{
		System.out.println("Make it");
		DeviationMergeProcess deviationMergeprocess=new DeviationMergeProcess();
		deviationMergeprocess.makeDirectory(deviationMergeprocess.oldFilepath,deviationMergeprocess.newFilepath);
		deviationMergeprocess.coverageName=deviationMergeprocess.coverageName.trim();
		//FileWriter fileWriter=new FileWriter(deviationMergeprocess.mergeFilepath);
		
		
		ArrayList<String> deviationList=deviationMergeprocess.getDeviationList();
		
		for(int i=0;i<deviationList.size();i++)
		{
			System.out.println(deviationList.get(i));
		}
		
		deviationMergeprocess.getMergeData(deviationList);
		System.out.println("over");
		
	}

	private void makeDirectory(String oldFilePath,String newFilepath) throws IOException {
		// TODO Auto-generated method stub
		
		String[] directoryPathsplit=oldFilepath.split("//");
		String[] fileNamesplit=newFilepath.split("//");
		String directoryPath="";
		String fileFullpath="";
		for(int i=0;i<directoryPathsplit.length-1;i++)
		{
			//System.out.println(directoryPathsplit[i]);
			directoryPath=directoryPath+directoryPathsplit[i]+"//";
		}
				directoryPath=directoryPath+this.coverageName;
		System.out.println("Directory path:"+directoryPath);
		
		File file=new File(directoryPath);
		if(!file.exists())
			file.mkdir();
		fileFullpath=directoryPath+"//"+fileNamesplit[fileNamesplit.length-1];
		this.mergeFilepath=fileFullpath;
		System.out.println("path Test:"+mergeFilepath);
		
		
		
	}

	private void getMergeData(ArrayList<String> deviationList) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("enter");
	
		StringBuffer importDatabuffer=importDatatoFile();
		System.out.println("import file over");
		StringBuffer nonDeviatadruleBuffer=getNondeviatedRule(deviationList);
		System.out.println("nonDeviationfile over");
		System.out.println("hello");
		StringBuffer deviatedRulebuffer=getDeviatedrule(deviationList);
		System.out.println("deviation file over");
		StringBuffer mergedDatabuffer=new StringBuffer();
		mergedDatabuffer.append(importDatabuffer);
		mergedDatabuffer.append(nonDeviatadruleBuffer);
		mergedDatabuffer.append(deviatedRulebuffer);
		//System.out.println(mergedDatabuffer);
		System.out.println("Date:"+extractOldversionDate);
		System.out.println("AlgorithmNumber:"+extractOldversioonAlgorithmnumber);
		
		getOldversionDate(extractOldversionDate);
		getOldversionAlgNo(extractOldversioonAlgorithmnumber);
		String data=mergedDatabuffer.toString();
		
		data=data.replaceAll(this.extractOldversionDate, newDate);
		data=data.replaceAll(this.extractOldversioonAlgorithmnumber, this.newAlgorithmNumber);
		
		System.out.println("....date:"+this.extractOldversionDate);
		System.out.println("...number:"+this.extractOldversioonAlgorithmnumber);
		System.out.println("file path:"+this.mergeFilepath);
		FileWriter fileWriter=new FileWriter(this.mergeFilepath);
		fileWriter.write(data+"\n");
		fileWriter.close();
		System.out.println(data);
		
		
		
	}

	private void getOldversionAlgNo(String extractOldversioonAlgorithmnumber2) {
		// TODO Auto-generated method stub
		String[] split=extractOldversioonAlgorithmnumber2.split("equals");
		System.out.println(split[split.length-1]);
		extractOldversioonAlgorithmnumber2=split[split.length-1];
		removeUnwantedcharacter(extractOldversioonAlgorithmnumber2);
		
		
	}

	private void removeUnwantedcharacter(String extractOldversioonAlgorithmnumber2) {
		// TODO Auto-generated method stub
		char[] array= {'(','"',')',';'};
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<array.length;i++)
		{
			extractOldversioonAlgorithmnumber2=extractOldversioonAlgorithmnumber2.replace(array[i], ' ');
		}
		System.out.println("algno:"+extractOldversioonAlgorithmnumber2.trim());
		this.extractOldversioonAlgorithmnumber=extractOldversioonAlgorithmnumber2.trim();
		
	}

	private void getOldversionDate(String extractOldversionDate) {
		// TODO Auto-generated method stub
		String[] split=extractOldversionDate.split("-");
		System.out.println(split[split.length-2]);
		this.extractOldversionDate=split[split.length-2];
		
	}

	private StringBuffer getDeviatedrule(ArrayList<String> deviationList) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("****"+"deviated list:");
		String ruleName;
		
		FileInputStream fis=new FileInputStream(newFilepath);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		int count=0;
		deviationMatchflag=1;
		StringBuffer stringBuffer=getDatafromFile(br,deviationList,algorithmNumberflag,deviationMatchflag);
					
		//System.out.println("deviated list:"+stringBuffer);
		br.close();
		return stringBuffer;
		
		
		
	}

	private StringBuffer getDatafromFile(BufferedReader bufferedReader,ArrayList<String> deviationList,int algorithmNumberflag,int deviationMatchflag) throws IOException {
		// TODO Auto-generated method stub
		String data=null;		
		StringBuffer stringBuffer=new StringBuffer();
		String algorithmNumber=
		data=bufferedReader.readLine();
		
		while(data!=null)
		{
			if(data.startsWith("rule") && !data.contains("ruleflow"))
			{
				if(deviatedruleCheck(deviationList,data,deviationMatchflag))
				{
					while(data!=null)
					{
						if(!data.startsWith("end"))
						{
							
							stringBuffer.append(data+"\n");
							if(data.startsWith("when"))
							{
								if(algorithmNumberflag==1)
									stringBuffer.append(algorithmNumber()+"\n");
							}
						}
						else
						{
							stringBuffer.append("\n");
							break;
						}
						data=bufferedReader.readLine();
					}
				}
			}
			data=bufferedReader.readLine();
		}
		
		return stringBuffer;
		
	}

	private String algorithmNumber() {
		// TODO Auto-generated method stub
		 //rateMap1:QuestionHashMap(rateMap1.getString("ISO::CommercialAutoVehicleCollisionCoverage::AlgorithmNumber").equals("ALG_CA_2019_03_01_Type62"));
		String tmp="rateMap1:QuestionHashMap(rateMap1.getString(\"ISO::"+coverageName+"::AlgorithmNumber\").equals(\""+newAlgorithmNumber+"\"));";
		return tmp;
	}

	private StringBuffer getNondeviatedRule(ArrayList<String> deviationList) throws IOException {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer;
		File oldFile= new File(oldFilepath);
		BufferedReader oldFilereader=new BufferedReader(new FileReader(oldFile));
		deviationMatchflag=0;
		stringBuffer=getDatafromFile(oldFilereader,deviationList,0,deviationMatchflag);
		//System.out.println("nonDeviatedData:\n"+stringBuffer);
		
		//System.out.println("Non deviated List:"+stringBuffer);
	
		oldFilereader.close();
		/*FileWriter fileWriter=new FileWriter(mergeFilepath);
		fileWriter.write(stringBuffer+"\n");
		fileWriter.close();*/
		
		return stringBuffer;
	}

	private boolean deviatedruleCheck(ArrayList<String> deviationList,String data,int deviationMatchflag) {
		// TODO Auto-generated method stub
		String ruleName;
		int flag=0;
		for(int i=0;i<deviationList.size();i++)
		{
			ruleName=coverageName+deviationList.get(i);
			if(data.contains(ruleName))
			{
				flag=1;
				break;
			}
				
		}
		if(deviationMatchflag==1)
			if(flag==1)
				return true;
			else
				return false;
		else
			if(flag==1)
				return false;
			else
				return true;
	}

	private StringBuffer importDatatoFile() throws IOException {
		// TODO Auto-generated method stub
		int flag=1;
		
		StringBuffer sb=new StringBuffer();
		File oldFile= new File(oldFilepath);
		BufferedReader oldFilereader=new BufferedReader(new FileReader(oldFile));
		//FileWriter fileWriter=new FileWriter(mergeFilepath);
		String data=null;
		data=oldFilereader.readLine();
		System.out.println("import enter");
		while(data!=null)
		{
			if(!data.contains("rule") && flag==1)
			{
				//fileWriter.write(data+"\n");
				sb.append(data);
				sb.append("\n");
			}
			else
			{
				if(flag==1)
					extractOldversionDate=data;
				flag=0;
				if(data.contains("rateMap1:QuestionHashMap"))
				{
					extractOldversioonAlgorithmnumber=data;
					flag=2;
					break;
				}
			}
			data=oldFilereader.readLine();
			if(flag==2)
				break;
		}
		//fileWriter.close();
		oldFilereader.close();
		//System.out.println("....."+sb+"\n import over");
		return sb;
		
	}

	private  ArrayList<String> getDeviationList() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String> deviationList=new ArrayList<String>();		
		File deviationListfile=new File(deviationFilelistPath);		
		BufferedReader deviationListfileReader=new BufferedReader(new FileReader(deviationListfile));
		String data=null;
		 data=deviationListfileReader.readLine();
		while(data!=null)
		{
			deviationList.add(data);
			data=deviationListfileReader.readLine();			
		}
		deviationListfileReader.close();
		
		return deviationList;
		
	}

}
