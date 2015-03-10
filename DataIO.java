/* Jamey Dogom
   Comp. 282
   Project 4 */  
   
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.RandomAccessFile;


class DataIO
{
   public static String readValue(int size, DataInput in) 
      throws IOException
   {  
      StringBuilder string = new StringBuilder(size);
      int i = 0;
      boolean more = true;
      while (more && i < size)
      {  
         char ch = in.readChar();
         i++;
         if (ch == 0) more = false;
         else string.append(ch);
      }
      in.skipBytes(2 * (size - i));
      return string.toString();
   }

   public static void writeValue(String string, int size, DataOutput out) 
      throws IOException
   {
      for (int i = 0; i < size; i++)
      {  
         char ch = 0;
         if (i < string.length()) ch = string.charAt(i);
         out.writeChar(ch);
      }
   }


}

   
  