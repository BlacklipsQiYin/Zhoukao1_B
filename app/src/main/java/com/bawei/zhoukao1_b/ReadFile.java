package com.bawei.zhoukao1_b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {

public static String readFromFile(InputStream is){


try {
ByteArrayOutputStream bos = new ByteArrayOutputStream();
byte[] b = new byte[1024];
int len = 0;
while ((len = is.read(b)) != -1){
bos.write(b, 0, len);
}

return bos.toString();
} catch (IOException e) {
e.printStackTrace();
}

return null;

}


}