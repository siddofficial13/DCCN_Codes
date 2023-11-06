import java.net.*;
import java.util.*;
import java.io.*;
public class HostNetworkID{
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();

        Scanner hi=new Scanner(System.in);
        String s=localHost.getHostAddress();
        System.out.println("LocalHost is: "+s);
        s+='.';
        int num[]=new int[4];
        int k=0;
        int m=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='.')
            {
                num[k]=Integer.parseInt(s.substring(m,i));
                m=i+1;
                k++;
            }
        }
        System.out.println();
        int a=num[0],b=num[1],c=num[2],d=num[3];
        char t=' ';
        if(a>=1&&a<=127)
            t='A';
        else if(a>=128 && a<=191)
            t='B';
        else if(a>=192 && a<=223)
            t='C';
        else if(a>=224 && a<=239)
            t='D';
        else if(a>=240 && a<=255)
            t='E';
        System.out.println();
        System.out.println("IP Address Belongs to Class: "+(char)t);
        if(t!='D'||t!='E')
            System.out.print("Network ID is: ");

        if(t=='A')
            System.out.println(a);
        if(t=='B')
            System.out.println(a+"."+b);
        if(t=='C')
            System.out.println(a+"."+b+"."+c);

        if (t != 'D' || t != 'E') {
            System.out.print("Host ID is: ");
            if (t == 'A')
                System.out.println(b + "." + c + "." + d);
            else if (t == 'B')
                System.out.println(c + "." + d);
            else if (t == 'C')
                System.out.println(d);
        }


        if(t=='D'||t=='E')
            System.out.println("Class "+(char)t+" does not have Network ID and Host ID");
        
    }
}
