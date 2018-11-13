package readResultsFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadGLPKResults1 {

	//ALTERAR O CAMINHO PARA O FOLDER QUE SE DESEJA TRABALHAR
	//private static final String PATHNAME = "D:\\MAScode\\TestDataJournal\\Test";
	private static final String PATHNAME = "C:\\Users\\garce\\Documents\\FaculdadeExtra\\Integradora\\Tentativa1New\\Test";
	//private static final String PATHNAME = "D:\\MAScode\\TestDataJournal\\TestData2\\Test";
	//private static final String PATHNAME = "D:\\MAScode\\TestDataJournal\\tkR60\\Test";
	private static final String FILENAME = "\\tbGLPK.sol";
	
	//static String mainFolder="D:\\MAScode\\TestDataJournal\\";
	static String mainFolder = "C:\\Users\\garce\\Documents\\FaculdadeExtra\\Integradora\\Tentativa1New\\";
	//static String mainFolder="D:\\MAScode\\TestDataJournal\\TestData2\\";
	//static String mainFolder="D:\\MAScode\\TestDataJournal\\tkR60\\";

	public static void main(String[] args) {

		System.out.println("Starting..");
		AppendToFile rfile2;
		rfile2= new AppendToFile(mainFolder+"GLPKResults.txt",false);
		
		BufferedReader br = null;
		FileReader fr = null;

	//MUDAR OS VALORES DE X PARA OUTROS NOMES DE FOLDERS QUE NÃO SEJAM DE 1 A 100	
	for (int x=1;x<=3;x++){
	
		String finalFileName=PATHNAME+x+FILENAME;
		try {
			fr = new FileReader(finalFileName);
			br = new BufferedReader(fr);
			String sCurrentLine;

			br = new BufferedReader(new FileReader(finalFileName));

			while ((sCurrentLine = br.readLine()) != null) {
				
				if (sCurrentLine.startsWith("Objective:  objective"))
				//Objective:  objective = 122 (MAXimum)
					{
					//System.out.println(sCurrentLine);
					sCurrentLine=sCurrentLine.substring(sCurrentLine.indexOf("=")+2);
					sCurrentLine=sCurrentLine.substring(0,sCurrentLine.indexOf("(")-1);
					rfile2.appendLine("Test"+x+"|"+sCurrentLine);
					System.out.println(sCurrentLine);
					}
				
				
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}//end for
	rfile2.closeFile();
	}//end main
}