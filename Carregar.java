package Dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Carregar {
	public ArrayList<String> Rank=new <String>ArrayList();
	public ArrayList FaculdadesBrasileiras=new ArrayList();
	public ArrayList <String>Nome=new <String> ArrayList();
	public ArrayList <String>Pais=new <String> ArrayList();
	public ArrayList <String>Ano=new <String> ArrayList();
	public ArrayList <String>PontuacaoTotal=new <String> ArrayList();
	public ArrayList <String>Income=new <String> ArrayList();
	public ArrayList <String>Sexo=new <String> ArrayList();
	public ArrayList <String>Fim=new <String> ArrayList();
	public void PegarValores(){

		// TODO Auto-generated method stub
		//Link: https://pt.stackoverflow.com/questions/27013/como-ler-arquivos-csv-em-java
	    String arquivoCSV = "C:\\Users\\PC CASA\\Desktop\\timesData.csv";
	    BufferedReader br = null;
	    String linha = "";
	    String csvDivisor = ",";
	    
	    try {
             int i=0;
	        br = new BufferedReader(new FileReader(arquivoCSV));
	        while ((linha = br.readLine()) != null) {        
	        	
//	        	linha=linha.replaceAll(",,", "");
//	        	linha=linha.replaceAll(",,,", "");
	            String[] Tabela = linha.split(csvDivisor);
                
//	            System.out.println("Faculdade [Rank= " + Tabela[0] 
//	                                 + " , Nome da Faculdade=" + Tabela[1] + "]");
	            if(!Tabela[0].contains("world_rank")){
	            	//Tabela[12]=Tabela[12].replaceAll(".",",");
	            	String posiçao=Tabela[0].replaceAll("\"", "");
	            
	            Rank.add(posiçao);
	            Nome.add(Tabela[1]);
	            Pais.add(Tabela[2].toLowerCase());
	            Income.add(Tabela[7].replaceAll("-", "Nulo"));
	            PontuacaoTotal.add(Tabela[8]);
	            Ano.add(Tabela[Tabela.length-1].replaceAll("\"","").replaceAll(";",""));
	        //    Fim.add(Tabela[15]);
                Sexo.add(Tabela[Tabela.length-2]);
                
	     // System.out.println(Tabela[8]);
//	                if(Tabela[13].contains("%")){
//	                	Sexo.add("Nulo");
//	                }else{
//	                	Sexo.add(Tabela[13]);
//                    } 
	             
//	                	if(!Tabela[14].contains(":")){
//	                	Ano.add(Tabela[14].replaceAll("\"",""));
//	                }else{
//	                    Ano.add(Tabela[15].replaceAll("\"",""));
//	                }
	                }
	       	         		
              
	        }
          
	    }catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
	
