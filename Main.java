package Dados;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

 	
    public static void main(String[] args) {
       	Carregar c=new Carregar();
        c.PegarValores();
          String resposta="";
         // System.out.println(c.Ano);
        while(!resposta.equals("sair")){
		resposta=JOptionPane.showInputDialog("Escolha a filtragem que deseja fazer"
				+ "\n1.Para filtrar os melhores de um ano"
				+ "\n2.Para Pesquisar Pais"
				+ "\n3.Faculadade com certo predominio de mulheres(Igual ou acima que sera dado por voce)"
				+ "\n4.Media de pontuacao de uma certa quantidade do Rank"
				+ "\n5.Contar e lista paises que estao inclusos no dataset");
		
		if(resposta.equals("1")){

	           FiltrarPelaPosiçaoMelhoresDeUmAno(c.Rank,c.Nome,c.Ano);
	 
		
		}if(resposta.equals("2")){
			FiltrarPorPais(c.Nome,c.Pais);
		}if(resposta.equals("3")){
			UmaMaiorPredominanciaDeMulheres(c.Nome,c.Rank,c.Sexo,c.Ano);
		}if(resposta.equals("4")){
			MediaDePotuançoesDeUmAnoERank(c.Rank,c.PontuacaoTotal,c.Ano,c.Nome);
		}if(resposta.equals("5")){
			ContarQuantosPaises(c.Rank,c.Pais);
		}
        }
		
	}
	public static void FiltrarPelaPosiçaoMelhoresDeUmAno(ArrayList rank,ArrayList nome,ArrayList<String> ano){
		String Texto="";
		int Quant=Integer.parseInt(JOptionPane.showInputDialog("Diga quantas posiçoes deseja ver do ranking"));
		String Data=JOptionPane.showInputDialog("Diga o ano:");
          int count=0,QuebraDeLinha=0;
		for(int i2=0;i2<rank.size();i2++){
	      if(ano.get(i2).equals(Data) && count<Quant){
	
          count++;
  		Texto+="Posiçao: "+rank.get(i2)+" Nome: "+nome.get(i2)+" Ano:"+ano.get(i2)+",";
  		QuebraDeLinha++;
		if(QuebraDeLinha==5){
			QuebraDeLinha=0;
			Texto+="\n";
		}
          }  		
		}
          	 JOptionPane.showMessageDialog(null, Texto); 
          
	}
  		public static void FiltrarPorPais(ArrayList Nome,ArrayList Pais){
  			String Pesq="",Texto="";
  			  Pesq=JOptionPane.showInputDialog("Digite o nome do pais");
  			         
  			for(int i=0;i<Nome.size();i++){
  			if(((String) Pais.get(i)).contains(Pesq)){
  				Texto+="Pais: "+Pais.get(i)+"    Nome: "+Nome.get(i)+"\n";
  			}}
  			JOptionPane.showMessageDialog(null,Texto);
  		}


	
	public static void UmaMaiorPredominanciaDeMulheres(ArrayList Nome,ArrayList Rank,ArrayList Sexo,ArrayList Ano){
		String Epoca=JOptionPane.showInputDialog("Digite o Ano");
		 int porcent=Integer.parseInt(JOptionPane.showInputDialog("Digite a porcentajem toleravel"));
		 String Texto="";
		 int QuebraDeLinha=0;
		for(int i=0;i<Rank.size();i++){
			         String Feminino[];
			          Feminino=((String) Sexo.get(i)).split(":");
					
			         if(((String) Sexo.get(i)).contains(":") && Integer.parseInt(Feminino[0].replaceAll(" ",""))>=porcent 
			        		 && Ano.get(i).equals(Epoca)){
					Texto+="|Nome: "+Nome.get(i)+"  -  Sexo: "+Sexo.get(i);
					QuebraDeLinha++;
					if(QuebraDeLinha==10){
						QuebraDeLinha=0;
						Texto+="\n";
					}
		}
			}JOptionPane.showMessageDialog(null,Texto);
	}
	public static void MediaDePotuançoesDeUmAnoERank(ArrayList Rank,ArrayList<String> Pontuaçao,ArrayList Ano,ArrayList Nome){
		String Texto="";
		Double soma=0.00;
		int Quant=Integer.parseInt(JOptionPane.showInputDialog("Diga quantas posiçoes deseja ver do ranking"));
		String Data=JOptionPane.showInputDialog("Diga o ano:");
          int count=0;
		for(int i=0;i<Quant;i++){
	      if(Ano.get(i).equals(Data) && count<Quant){
	    	  
	       soma=soma+Double.parseDouble(Pontuaçao.get(i));
                
  		Texto+="Posiçao: "+Rank.get(i)+" Nome: "+Nome.get(i)+" Ano:"+Ano.get(i)+"\n\n";
  		
          count++;
          }  		
		}
		Double Resultado=soma/count;
          	 JOptionPane.showMessageDialog(null,"Resultado é: "+Resultado+"\n"+ Texto); 
	}
	public static void ContarQuantosPaises(ArrayList Rank,ArrayList <String> Pais){
		ArrayList <String> PaisesNaoRepitidos=new <String>ArrayList();
		String Texto="";
		int count=0,QuebraDeLinha=0;
		for(int i=0;i<Rank.size();i++){
			if(!PaisesNaoRepitidos.contains(Pais.get(i))){
				PaisesNaoRepitidos.add(Pais.get(i));
				Texto+=Pais.get(i)+",";
				count++;
				QuebraDeLinha++;
				if(QuebraDeLinha==10){
					QuebraDeLinha=0;
					Texto+="\n";
				}
			}
		}
		 JOptionPane.showMessageDialog(null,"Numero Total de paises no dataset é "+count+"\n"+Texto.replace("\"", "")); 
	}


}
