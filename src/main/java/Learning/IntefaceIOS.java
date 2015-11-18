
package Learning;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class IntefaceIOS {
    
    private static String path = Paths.get(".").toAbsolutePath().normalize().toString();
    private static String ImputFileName = "/input.txt";
    private static String OutputFileName = "/output.txt";
    static FileOutputStream outputstream = null;
    static FileInputStream inputstream = null;
    static final Logger logger = Logger.getLogger(Class.class.getName());
    static int BasicNumber;
    static{
        try {
            inputstream = new FileInputStream(path+ImputFileName);
        } catch (FileNotFoundException ex) {
            logger.log(Level.WARNING, null, ex);
        }
    }
     
    public static void main(String[] args) {
        byte[] BitsOfFile = new byte[100];
        try {
            inputstream.read(BitsOfFile);
                    
        } catch (IOException ex) {
            logger.log(Level.WARNING, "file is not readeble");
            System.exit(1);
        }
        String content = new String(BitsOfFile).trim();
        BasicNumber = Integer.valueOf(content);
        File checkfile = new File(path + OutputFileName);
        if (checkfile.exists() && checkfile.length() !=0){
            checkfile.delete();
            
        }else if(!checkfile.exists()){
           try {
                checkfile.createNewFile();
            } catch (IOException ex) {
                logger.log(Level.WARNING, null, ex);
            }
        }
        try {
            outputstream = new FileOutputStream(path+OutputFileName);
        } catch (FileNotFoundException ex) {
            logger.log(Level.WARNING, null, ex);
        }    
        PrintWriter writer = new PrintWriter(outputstream);
        for (int i=0;i<= AllNumbers(BasicNumber).length-1;i++){
            if(AllNumbers(BasicNumber)[i] !=0)
                writer.append(String.valueOf(AllNumbers(BasicNumber)[i])+";");
        }
        writer.close();
        
        try {
            outputstream.close();
            inputstream.close();
        } catch (IOException ex) {
            Logger.getLogger(IntefaceIOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
   
    public static int MaxNumber(int number){
        int tmp = number;
        while(String.valueOf(tmp).length() == String.valueOf(number).length()){
            tmp++;
        }
        return tmp-1;
    }
    public static int MinNumber(int number){
        int tmp = number;
        while(String.valueOf(tmp).length() == String.valueOf(number).length()){
            tmp--;
        }
        return tmp+1;
    }
    public static int[] AllNumbers(int number){
        int[] result  = new int[MaxNumber(number)+1];
        for (int i = MaxNumber(number); i>=MinNumber(BasicNumber);i-- ){
            if(i%2 !=0){
                result[i] = i;
            }
        }
        return result;
    }
    
    
            
}
