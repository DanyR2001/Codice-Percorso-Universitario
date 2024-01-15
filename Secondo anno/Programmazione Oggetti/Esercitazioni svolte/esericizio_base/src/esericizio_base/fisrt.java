package esericizio_base;

public class fisrt {
	
	 public static void main (String args[]){
		 	int c=4;
		 	String x="casa";
             System.out.println(x.charAt(x.length()/2));
             String r="ab",y="cd",z="ef";
             String s=r+y+z;
             if(x.length()>=2) {
             char mom=x.charAt(0);
             char str[]=x.toCharArray();
             str[0]=str[x.length()-1];
             str[x.length()-1]=mom;
             String h=x.copyValueOf(str);
             System.out.println(h);
             String finale="";
             finale=finale+x.charAt(x.length()-1)+x.subSequence(1,x.length()-1)+finale+x.charAt(0);
             System.out.println(finale);
             String nano=x.substring(x.length()/2, x.length())+x.substring(0,x.length()/2);
             System.out.println(nano);
             }
             System.out.print(s);
     }
}
