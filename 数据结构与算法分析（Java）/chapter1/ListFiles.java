import java.io.*;

public class ListFiles{
	public static void main(String[] args){
		if(args.length != 0){
			for(int i = 0;i < args.length;i++){
				listFile(args[i]);
			}
		}
	}
	
	public static void listFile(String fileName){
		FileReader theFile;
		BufferedReader fileIn = null;
		String oneLine;
		
		System.out.println("FILE:" + fileName);
		try{
			theFile = new FileReader(fileName);
			fileIn = new BufferedReader(theFile);
			while((oneLine = fileIn.readLine()) != null){
				System.out.println(oneLine);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		//Close the stream
		try{
			if(fileIn != null){
				fileIn.close();
			}
		}catch(IOException e){
			
		}
	}
}