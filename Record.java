/* Jamey Dogom
   Comp. 282
   Project 4 */   

import java.io.DataInput;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;

public class Record
{
   public Record() {}

   public Record(String value,long id)
   {  
      this.value = value;
      this.id = id;
      
   }

   public String getValue()
   {
      return value;
   }

   public long getID()
   {
      return id;
   }


   public String toString()
   {  
      return getClass().getName()
         + "[value=" + value
         + ",id=" + id
         + "]";
   }

 
   public void writeData(RandomAccessFile out) throws IOException
   {
	   out.seek(out.length());
      DataIO.writeValue(value, SIZE, out);
      out.writeLong(id);
   }


   public void readData(DataInput in) throws IOException
   {
      value = DataIO.readValue(SIZE, in);
      id = in.readInt();      
     
   }

   public static final int SIZE = 100;
   public static final int RECORD_SIZE = 2 * SIZE + 4;

   private String value;
   private long id;
  
}
